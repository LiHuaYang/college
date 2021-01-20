package com.Tool.sql;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

public class JdbcConnectionPool {
	
//	private JdbcConnectionPool(){};
//	// 1. 存放数据库连接池的数据结构
//	private static LinkedList<Connection> pool = new LinkedList<Connection>();
//	
//	private static int inUsedConnection = 0;       // 已使用的连接数
//	private static int inFreeConnection = 0;       // 已使用的连接数
//	private static int initConnectionNumber = 0;   // 连接池初始化连接数目
//	private static int maxConnectionNumber = 0;	   // 连接池最大连接数目
//	
//	private static String driver = null;	// 驱动名
//	private static String url = null;		// 数据库地址
//	private static String username = null;  // 数据库用户名
//	private static String password = null;	// 数据库密码
//	
//	
//	public static int getSize() {
//		return pool.size();
//	}
//	
//	// 2. 静态代码块，类加载时，获取一批连接
//	static {
//		try {
//			InputStream in = JdbcConnectionPool.class.getClassLoader().getResourceAsStream("ds.config.properties");
//			Properties prop = new Properties();
//			prop.load(in);
//			
//			driver = prop.getProperty("driver");
//			url = prop.getProperty("url");
//			username = prop.getProperty("username");
//			password = prop.getProperty("password");
//			initConnectionNumber = Integer.parseInt(prop.getProperty("initialConnection"));
//			maxConnectionNumber = Integer.parseInt(prop.getProperty("maxConnection"));
//			inFreeConnection = initConnectionNumber;
//			
//			// 加载mySql驱动
//			Class.forName(driver);
//			
//			for (int i=0; i<initConnectionNumber; i++) {
//				Connection conn = DriverManager.getConnection(url, username, password);
//				System.out.println("拿到--"+conn);
//				pool.add(conn);
//			}
//		
//		} catch (IOException e) {
//			throw new ExceptionInInitializerError("JdbcConnectionPool--IOException--错误");
//		} catch (SQLException e) {
//			throw new ExceptionInInitializerError("JdbcConnectionPool--SQLException--错误");
//		} catch (ClassNotFoundException e) {
//			throw new ExceptionInInitializerError("JdbcConnectionPool--ClassNotFoundException--错误");
//		} 
//	}
//	
//	// 3. 返回一个可用的连接
//	public static Connection getConnection() {
//
//		if (pool.size()>0) { // 1. 当连接池中有连接时
//			final Connection conn = pool.removeFirst(); // 
//			
//			inFreeConnection--; // get连接后，将空闲中的连接数，减1
//			inUsedConnection ++;    // get连接后，将已使用的连接数，加1
//			
//			return (Connection) Proxy.newProxyInstance(JdbcConnectionPool.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
//				@Override
//				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//					if (!method.getName().equals("close")){
//						return method.invoke(conn, args);
//					} else {
//							if (pool.size() < 10) {
//								pool.add(conn);
//								inFreeConnection++; // close连接后，将空闲中的连接数，加1
//								inUsedConnection--; // close连接后，将已使用的连接数，减1
//							}
//						return null;
//					}
//				}
//			});
//		} else { // 2. 当连接池中没有连接时
//			wait(2000); // 2.1 等待2秒
//			
//			// 2.2 当连接数小于连接池最大连接数，且连接池中没有空闲的连接
//			if (pool.size()==0 && inUsedConnection<maxConnectionNumber) { 
//				inFreeConnection--; // get连接后，将空闲中的连接数，减1
//				inUsedConnection ++;    // get连接后，将已使用的连接数，加1
//				return getAConnectionFromDb();
//			}
//			// 2.3当连接数大于连接池最大连接数，且连接池中没有空闲的连接
//			else {
//				throw new RuntimeException("JdbcConnectionPool--没有可用连接--错误");
//			}
//		}
//	}
//	
//	private static Connection getAConnectionFromDb() {
//		try {
//			return DriverManager.getConnection(url, username, password);
//		} catch (SQLException e) {
//			throw new RuntimeException("JdbcConnectionPool--SQLException--错误");
//		}
//	}
//	//
//	private static void wait(int mSeconds){
//		try {
//			Thread.sleep(mSeconds);
//		} catch (InterruptedException e) {
//			throw new RuntimeException("JdbcConnectionPool--InterruptedException--错误");
//		}
//	}
//	
	
}
