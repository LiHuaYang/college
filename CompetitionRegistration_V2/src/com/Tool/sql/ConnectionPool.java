package com.Tool.sql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;

public class ConnectionPool {
	
	private String dbDriver = "";           //数据库驱动
	private String dbUrl = "";              //数据URL
	private String dbUsername = "";         //数据库用户名
	private String dbPassword = "";         //数据库用户密码
	
	private String testTable = "";          //测试连接是否可用的测试表名，默认没有测试表
	
	private int initialConnection = 0;      //连接池的初始大小
//	private int incrementalConnection = 0;  //连接池自动增加的大小
	private int maxConnections = 0;         //连接池的最大的大小
	
	private int inUsedConnection = 0;       //已使用的连接数
	
	static private long m_lastClearClosedConnection = System.currentTimeMillis();
	private static long CHECK_CLOSED_CONNECTION_TIME = 3 * 60 * 60 * 1000/*250*/; //3 hours  
	
	
    //使用LinkedList集合来存放数据库链接，
	private static LinkedList<Connection> listConnections = new LinkedList<Connection>();       

	private static ConnectionPool connectionPool = new ConnectionPool();
	
	/**
	 * 构造函数
	 * 功能：获取数据库配置文件数据，
	 *       并创建初始数量大小的数据库连接放在连接池中
	 */
	private ConnectionPool() {
		
		InputStream in = JdbcConnectionPool.class.getClassLoader().getResourceAsStream("ds.config.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dbDriver = prop.getProperty("driver");
		dbUrl = prop.getProperty("url");
		dbUsername = prop.getProperty("username");
		dbPassword = prop.getProperty("password");
		initialConnection = Integer.parseInt(prop.getProperty("initialConnection"));
		maxConnections = Integer.parseInt(prop.getProperty("maxConnection"));
		
		initConnectionPool();
	}
	
	//单例
	public static ConnectionPool getIntense(){
		return connectionPool;
	}
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-3-31 下午08:14:56
	 * 函数名：initConnectionPool
	 * 功能：初始化数据库连接池listConnections
	 * 参数：
	 * 返回值：void
	 */
	private void initConnectionPool(){
		
		try {
			//加载数据库驱动
			Class.forName(dbDriver);

			for(int i=0; i<initialConnection; i++){
				Connection conn = newConnection();
//				System.out.println("获取到了连接---" + conn);
				//将获取到的数据库连接加入到listConnections集合中，
				//listConnections集合此时就是一个存放了数据库连接的连接池
				listConnections.add(conn);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-3-31 下午07:26:08
	 * 函数名：getConnection
	 * 功能：得到连接
	 * 参数：@return
	 * 返回值：Connection
	 * @throws SQLException 
	 */
	public synchronized Connection getConnection() throws SQLException{
		
		clearClosedConnection();  
		
		if(listConnections == null){
			System.out.println("连接池没创建");
			throw new SQLException("连接池没创建");
		}
		Connection conn = null;
		
		// 1.获得一个可用的数据库连接
		conn = getFreeConnection();
		
		// 2.如果连接为空，等待一会，重新再试
		if(conn == null){
			wait(5000);       //等待5秒
			conn = getFreeConnection();      // 重新再试
			if(conn == null){
				throw new SQLException("连接超时，没有可用连接");
			}
		}
		
//		while(conn == null){
//			wait(250);       //等待250毫秒
//			conn = getFreeConnection();      // 重新再试
//		}
		
		//3.如果获得可用连接，使用连接数量变量加1
		if(conn != null){
			inUsedConnection++;
			System.out.println("现有" +inUsedConnection+ "个连接在使用");
			System.out.println("数据库连接池大小是---" + listConnections.size());
		}
		
		return conn;
		
	}
	
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-1 下午06:00:38
	 * 函数名：getFreeConnection
	 * 功能：得到可用的连接
	 * 参数：@return
	 * 返回值：Connection
	 */
	private Connection getFreeConnection(){
		
		Connection conn = null;
		
		//如果数据库连接池中有连接对象，取出连接返回
		if(listConnections.size() > 0){
			
			//从connections集合中获取一个数据库连接，并删除数据库中的这个连接
			conn = listConnections.removeFirst(); 
			
		}else{
			
			//1.如果已创建连接数已达到数据库最大连接数
			if(inUsedConnection>=maxConnections){
				conn = null;
			}else{
				//2.否则，新建连接
			    conn = newConnection();  
			}
			
		}
		
		return conn;
	}
	
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-2 下午06:41:09
	 * 函数名：returnConnection
	 * 功能：用完，返回连接，放回到连接池中
	 * 参数：@param conn
	 * 参数：@param st
	 * 参数：@param rs
	 * 返回值：void
	 */
	public synchronized void returnConnection(Connection con,PreparedStatement ps,ResultSet res){
		
		//1.确保连接池存在，如果连接池不存在，则关闭相关连接，然后直接返回
		if(listConnections == null){
			System.out.println("连接池不存在，无法返回到此连接池中！");
//			throw new MyException("连接池不存在，无法返回到此连接池中！");
			if(con != null){
				closeConnection(con);
			}
			
			try {
				if(ps != null){
					ps.close();
				}
				if(res != null){
					res.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return;
		}
		
		//2.将连接返回到连接池中并关闭相关连接
		listConnections.add(con);
		
		try {
			if(ps != null){
				ps.close();
			}
			if(res != null){
				res.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		inUsedConnection--;
		
		System.out.println("返回连接");
	}
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-4 下午06:00:20
	 * 函数名：returnConnection
	 * 功能：用完，返回连接，放回到连接池中
	 * 参数：@param con
	 * 参数：@param cs
	 * 参数：@param res
	 * 返回值：void
	 */
	public synchronized void returnConnection(Connection con,CallableStatement cs,ResultSet res){
		
		//1.确保连接池存在，如果连接池不存在，则关闭相关连接，然后直接返回
		if(listConnections == null){
			System.out.println("连接池不存在，无法返回到此连接池中！");
//			throw new MyException("连接池不存在，无法返回到此连接池中！");
			if(con != null){
				closeConnection(con);
			}
			
			try {
				if(cs != null){
					cs.close();
				}
				if(res != null){
					res.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return;
		}
		
		//2.将连接返回到连接池中并关闭相关连接
		listConnections.add(con);
		
		try {
			if(cs != null){
				cs.close();
			}
			if(res != null){
				res.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		inUsedConnection--;
		
		System.out.println("返回连接");
	}

	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-4 下午05:52:35
	 * 函数名：用完，返回连接，放回到连接池中
	 * 功能：TODO
	 * 参数：@param conn
	 * 参数：@param st
	 * 返回值：void
	 */
	public synchronized void returnConnection(Connection conn,PreparedStatement st){
		
		//1.确保连接池存在，如果连接池不存在，则关闭相关连接，然后直接返回
		if(listConnections == null){
			System.out.println("连接池不存在，无法返回到此连接池中！");
//			throw new MyException("连接池不存在，无法返回到此连接池中！");
			if(conn != null){
				closeConnection(conn);
			}
			
			try {
				if(st != null){
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return;
		}
		
		//2.将连接返回到连接池中并关闭相关连接
		listConnections.add(conn);
		
		try {
			if(st != null){
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		inUsedConnection--;
		
		System.out.println("返回连接");
	}
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-3-31 下午08:51:57
	 * 函数名：returnConnection
	 * 功能：用完，返回连接，放回到连接池中
	 * 参数：@param conn
	 * 返回值：void
	 */
	public synchronized void returnConnection(Connection conn){
		
		//1.确保连接池存在，如果连接池不存在，则关闭相关连接，然后直接返回
		if(listConnections == null){
			System.out.println("连接池不存在，无法返回到此连接池中！");
//			throw new MyException("连接池不存在，无法返回到此连接池中！");
			if(conn != null){
				closeConnection(conn);
			}
			return;
		}
		
		//2.将连接返回到连接池中并关闭相关连接
		listConnections.add(conn);
		inUsedConnection--;
		
		System.out.println("返回连接");
	}
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-3-31 下午03:06:10
	 * 函数名：newConnection
	 * 功能：创建一个新的数据库连接并返回
	 * 参数：@return
	 * 参数：@throws SQLException
	 * 返回值：Connection
	 */
	private Connection newConnection(){
		
		//创建一个数据库连接
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
//			System.out.println("创建连接");
			//如果是第一次创建连接，检查数据库，获得此数据库允许支持的最大客户连接数目
			//connections.size()==0&&inUsedConnection==0表示目前没有连接已被创建
			if(listConnections.size()==0 && inUsedConnection==0){
				
				DatabaseMetaData metaData = conn.getMetaData();
				int driverMaxConnections = metaData.getMaxConnections();
				//数据库返回的driverMaxConnection若为0，表示此数据库没有最大连接限制
				//或数据库的最大连接限制不知道
				//driverMaxConnection为返回的一个整数，表示此数据库允许客户连接的数目
				//如果连接池中设置的最大连接数量大于数据库允许的连接数目，则连接池的最大
				//连接数目为数据库允许的最大数目
				
				if(driverMaxConnections>0 && this.maxConnections>driverMaxConnections){
					this.maxConnections = driverMaxConnections;
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-3-31 下午10:20:00
	 * 函数名：releaseConnection
	 * 功能：释放所有连接
	 * 参数：
	 * 返回值：void
	 */
	public synchronized void releaseConnection(){
		
		Iterator allConns = listConnections.iterator();
		
		while(allConns.hasNext()){
			Connection conn = (Connection) allConns.next();
			
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		listConnections.clear();
	}
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-1 下午04:26:12
	 * 函数名：closeConnection
	 * 功能：关闭一个数据库连接
	 * 参数：@param conn
	 * 返回值：void
	 */
	private void closeConnection(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("关闭数据库连接出错" + e.getMessage());
		}
	}

	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-1 下午04:30:15
	 * 函数名：testConnection
	 * 功能：测试连接是否可用
	 * 参数：@param conn
	 * 参数：@return
	 * 返回值：boolean
	 */
	private boolean testConnection(Connection conn){
		
		try {
			//判断测试表是否存在
			if(testTable.equals("")){
				conn.setAutoCommit(true);
			}else{
				Statement stmt = conn.createStatement();
				stmt.execute("select count(*) from " + testTable);
			}
			
		} catch (SQLException e) {
			closeConnection(conn);
			return false;
		}
		return true;
	}
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-1 下午04:31:15
	 * 函数名：wait
	 * 功能：使程序等待给定的毫秒数
	 * 参数：@param mSeconds
	 * 返回值：void
	 */
	private void wait(int mSeconds){
		
		try {
			Thread.sleep(mSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-2 下午03:18:18
	 * 函数名：clearClosedConnection
	 * 功能：关闭多余的连接
	 * 参数：
	 * 返回值：void
	 */
	private void clearClosedConnection(){
		
		long time = System.currentTimeMillis();  
		
		//1.时间不合理，没有必要检查
		if(time < m_lastClearClosedConnection){
			time = m_lastClearClosedConnection;
			return;
		}
		
		//2.时间太短，没有必要检查
		if(time - m_lastClearClosedConnection < CHECK_CLOSED_CONNECTION_TIME){
			return;
		}
		
		m_lastClearClosedConnection = time;
		
		//3.开始检测连接池中是否有已关闭的连接
		Iterator iterator = listConnections.iterator();
		while(iterator.hasNext()){
			Connection conn = (Connection) iterator.next();
			
			try {
				if(conn.isClosed()){
					iterator.remove();  
				}
			} catch (SQLException e) {
				iterator.remove();  
				e.printStackTrace();
			}
		}
		
		//4.清除多余的Connection
		int decrease = getDecreasingConnectionCount();
		
		while (decrease > 0 && listConnections.size() > 0) {
		
			Connection conn = listConnections.removeFirst();
			closeConnection(conn);
			
			decrease--;
		}
	}
	
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-2 下午03:16:00
	 * 函数名：getDecreasingConnectionCount
	 * 功能：得到需要减少的连接数
	 * 参数：@return
	 * 返回值：int
	 */
	private int getDecreasingConnectionCount(){
		int count = 0;
		int current = listConnections.size() + inUsedConnection;
		
		if(current > initialConnection){
			count = current-initialConnection;
		}
		
		return count;
	}
	
	
}
