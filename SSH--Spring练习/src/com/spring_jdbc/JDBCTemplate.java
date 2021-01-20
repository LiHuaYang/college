package com.spring_jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 * ������
 * 
 * - �½��� ��e.g.��JDBCTemplate��
 * 		1. ����ע��
 * 		2. ���캯��ע��
 * - �̳��½��ࣨe.g.��PersoDao extends JDBCTemplate��
 * 
 * ���ߣ�ariclee		ʱ�䣺2016��9��19������12:36:40
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
