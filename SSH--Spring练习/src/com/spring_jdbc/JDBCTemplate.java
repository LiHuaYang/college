package com.spring_jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 * 方法：
 * 
 * - 新建类 （e.g.：JDBCTemplate）
 * 		1. 属性注入
 * 		2. 构造函数注入
 * - 继承新建类（e.g.：PersoDao extends JDBCTemplate）
 * 
 * 作者：ariclee		时间：2016年9月19日下午12:36:40
 */
public class JDBCTemplate  {

	private DataSource datasource;

	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public void update(String sql) {
		try {
			Connection conn = datasource.getConnection();
			Statement state = conn.createStatement();;
			state.execute(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
