package com.nbut.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JdbcUtils_DBCP {

	private static DataSource ds = null;

	/**
	 * 静态代码块读取配置文件，初始化DBCP连接池
	 */
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
	 * 作者：ariclee		时间：2016年5月26日下午5:41:49
	 */
	public static Connection getConnection() {

		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("JdbcUtils_DBCP--getConnection ERROR!!");
		}
	}
	/**
	 * 函数名称：release
	 * 功能描述：
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月26日下午5:41:55
	 */
	public static void release(Connection conn, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/******************************************************************************************************/
	
	/**
	 * 函数名称：resultSet2JsonArray
	 * 功能描述：
	 * 参数说明：
	 * 返回值：JSONArray
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月26日下午5:55:32
	 */
	public static final JSONArray resultSet2JsonArray(ResultSet res) {
		JSONObject element = null;
		JSONArray array = new JSONArray();
		ResultSetMetaData rsmd = null;
		String columnName  = null;
		Object columnValue = null;
		
		try {
			rsmd = res.getMetaData();
			
			while (res.next()) {
				int columnNumber = rsmd.getColumnCount();
				element = new JSONObject();
				for (int i=0; i<columnNumber; i++) {
					columnName = rsmd.getColumnName(i+1);
					columnValue = res.getObject(columnName);
					element.put(columnName, columnValue);
				}
				array.add(element);
			}
		} catch (SQLException e) {
			throw new RuntimeException("JdbcUtils_DBCP--resultSet2JsonArray ERROR!!");
		}
		return array;
	}

//	public static final JsonObject ResultSetToJsonObject(ResultSet rs) {
//		JsonObject element = null;
//		JsonArray ja = new JsonArray();
//		JsonObject jo = new JsonObject();
//		ResultSetMetaData rsmd = null;
//		String columnName, columnValue = null;
//		try {
//			rsmd = rs.getMetaData();
//			while (rs.next()) {
//				element = new JsonObject();
//				for (int i = 0; i < rsmd.getColumnCount(); i++) {
//					columnName = rsmd.getColumnName(i + 1);
//					columnValue = rs.getString(columnName);
//					element.addProperty(columnName, columnValue);
//				}
//				ja.add(element);
//			}
//			jo.add("result", ja);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return jo;
//	}
//
//	public static final String ResultSetToJsonString(ResultSet rs) {
//		return ResultSetToJsonObject(rs).toString();
//	}
}
