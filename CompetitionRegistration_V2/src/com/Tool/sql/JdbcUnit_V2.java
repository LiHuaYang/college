package com.Tool.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * JDBC框架第二版
 *
 */
public class JdbcUnit_V2 {

//	private static JdbcConnectionPool connectionPool = null;
//	
//	private volatile static JdbcUnit_V2 jdbcUnit;
//	private JdbcUnit_V2(){};
//	
//	public static JdbcUnit_V2 getInstance(){
//		if(jdbcUnit==null){
//			synchronized (JdbcUnit_V2.class) {
//				if (jdbcUnit==null) {
//					jdbcUnit = new JdbcUnit_V2();
//				}
//			}
//		}
//		return jdbcUnit;
//	}
//	
//	/**
//	 * 
//	 *作者：LiHuaYang
//	 *时间：2016-4-22下午03:43:47
//	 *函数名：getConntection
//	 *功能：TODO
//	 *参数：
//	 *返回值：Connection
//	 */
//	public Connection getConntection() {
//		return connectionPool.getConnection();
//	}
//	
//
//	/**
//	 * 
//	 *作者：LiHuaYang
//	 *时间：2016-4-22下午03:44:01
//	 *函数名：close
//	 *功能：TODO
//	 *参数：
//	 *返回值：void
//	 */
//	public  void close(Connection conn,PreparedStatement ps,ResultSet rs) {
//		try {
//			if(conn!=null){
//				conn.close();
//				conn = null;	
//			}
//			if(ps!=null){
//				ps.close();
//				ps = null;
//			}
//			if (rs!= null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
