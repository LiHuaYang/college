package com.spring_jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate; 


/**
 * 
 * ���������̳� JdbcTemplate
 *
 * Ҫ���ṩ��Ӧ�Ĺ��캯�������ڹ��캯���У����ø���Ĺ��캯��
 * �Ӷ�����DataSourceע��JDBCTemplate��
 * 	
 * 
 * ���ߣ�ariclee		ʱ�䣺2016��9��19������12:35:45
 */
public class PersoDao3 extends JdbcTemplate {

	PersoDao3(DataSource dataSource) {
		super(dataSource);
	}
	public void updatePerson() {
		super.execute("update person set name='lisi3' where id='12'");
	}
}
