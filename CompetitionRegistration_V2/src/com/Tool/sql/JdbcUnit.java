package com.Tool.sql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.Tool.sql.JdbcConnectionPool;

public class JdbcUnit {
	private volatile static JdbcUnit jdbcUnit;
	private JdbcUnit(){};
	
	private static String driver = null;	// 驱动名
	private static String url = null;		// 数据库地址
	private static String username = null;  // 数据库用户名
	private static String password = null;	// 数据库密码
	
	
	static {
		InputStream in = JdbcConnectionPool.class.getClassLoader().getResourceAsStream("ds.config.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
	}
	public static JdbcUnit getInstance(){
		if(jdbcUnit==null){
			synchronized (JdbcUnit.class) {
				if (jdbcUnit==null) {
					jdbcUnit=new JdbcUnit();
				}
			}
		}
		return jdbcUnit;
	}
	
	public Connection createConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public  PreparedStatement prepare(Connection conn, String sql) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	public  void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(conn!=null){
				conn.close();
				conn = null;	
			}
			if(ps!=null){
				ps.close();
				ps = null;
			}
			if (rs!= null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}   
}

