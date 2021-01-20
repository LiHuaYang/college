package junit.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.nbut.utils.JdbcUtils_DBCP;

public class testJunit {

	
	/**
	 * 函数名称：testMyJDBCConnectionPool
	 * 功能描述：测试我的连接池
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月19日下午9:09:40
	 */
	public void testMyJDBCConnectionPool () throws SQLException {
//		Connection conn = JdbcConnectionPool.getConnection();
//		Statement st = conn.createStatement();
//		st.executeQuery("select * from users");
//		ResultSet set = st.getResultSet();
//		while (set.next()) {
//			System.out.println(set.getObject("user_id"));
//		}
//		set.close();
//		st.close();
//		conn.close();
	}
	
	/**
	 * 函数名称：testC3P0
	 * 功能描述：测试C3P0连接池
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月19日下午9:09:17
	 */
	@Test
	public void testC3P0 () throws SQLException {
//		Connection conn = JdbcUtils_C3P0.getConnection();
//		Statement st = conn.createStatement();
//		st.executeQuery("Select * from problem");
//		ResultSet set = st.getResultSet();
//		while (set.next()) {
//			System.out.println(set.getObject("user_id"));
//		}
//		JdbcUtils_C3P0.release(conn, st, set);
	}
	
	/**
	 * 函数名称：testDBCP
	 * 功能描述：测试DBCP连接池
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月19日下午9:04:07
	 */
	@Test
	public void testDBCP () throws SQLException {
		Connection conn = JdbcUtils_DBCP.getConnection();
		Statement st = conn.createStatement();
		st.executeQuery("Select * from users");
		ResultSet set = st.getResultSet();
		while (set.next()) {
			System.out.println(set.getObject("user_id"));
		}
		JdbcUtils_DBCP.release(conn, st, set);
	}
}
