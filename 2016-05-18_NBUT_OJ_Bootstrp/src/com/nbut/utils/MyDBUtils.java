package com.nbut.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
 * 
 * 1. 连接池
 * 
 * 2. 事务
 * 
 * 3. 
 * 
 * 作者：ariclee		时间：2016年6月12日下午2:31:35
 */
public class MyDBUtils {
	
	private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static DataSource ds = null;
	
	static {
		try {
			InputStream in = JdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties prop = new Properties();
			prop.load(in);

			BasicDataSourceFactory factory = new BasicDataSourceFactory();

			ds = factory.createDataSource(prop);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	
	
	/**
	 * 函数名称：getDataSource
	 * 功能描述：
	 * 参数说明：
	 * 返回值：DataSource
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月12日下午1:23:39
	 */
	public static DataSource getDataSource() {
		return ds;
	}

	/**
	 * 函数名称：getConnection
	 * 功能描述：
	 * 参数说明：
	 * 返回值：Connection
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月12日下午2:35:31
	 */
	public static Connection getConnection() {
		Connection conn = (Connection)tl.get(); // 1. 在当前线程上获取数据库连接
		if (conn==null) {
			try {
				conn = ds.getConnection();  // 2. 当前线程上无数据库连接，则向DBCP连接池中取出新的连接
				tl.set(conn);
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
		return conn;
	}
	
	/**
	 * 函数名称：startTransaction
	 * 功能描述：开启事务
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月11日下午9:52:37
	 */
	public static void startTransaction() {
		Connection conn = (Connection) tl.get();
		if(conn==null){
			conn = getConnection();
		}
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 函数名称：roolback
	 * 功能描述：出错回滚
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月11日下午9:52:52
	 */
	public static void roolback() {
		Connection conn = (Connection) tl.get();
		if(conn==null){
			conn = getConnection();
		}
		try {
			conn.rollback();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		}
	}
	
	/**
	 * 函数名称：commit
	 * 功能描述：事务结束提交
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月11日下午9:53:03
	 */
	public static void commit() {
		Connection conn = (Connection) tl.get();
		if(conn==null){
			conn = getConnection();
		}
		try {
			conn.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 函数名称：release
	 * 功能描述：释放连接
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月11日下午9:53:11
	 */
	public static void release() {
		try {
			Connection conn = (Connection) tl.get();
			if(conn!=null){
				conn.close();
				tl.remove();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
