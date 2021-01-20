package com.fenye.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils  {
	
	private static String url;
	private static String username;
	private static String password;
	
	static {
		try {
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
			Properties pro = new Properties();
		
			pro.load(in);
			
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			
			String drive = pro.getProperty("driver");
			
			Class.forName(drive);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void release(Connection conn, Statement st, ResultSet rs) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
		
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			st = null;
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}
}
