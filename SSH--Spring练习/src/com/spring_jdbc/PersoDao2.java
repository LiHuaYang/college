package com.spring_jdbc;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


/**
 * 
 * ���������̳� JdbcDaoSupport
 *
 * Ҫ��xml����ʱ���������֣�������dataSource�������޷�ע��
 * 
 * ���ߣ�ariclee		ʱ�䣺2016��9��19������12:35:45
 */
public class PersoDao2 extends JdbcDaoSupport {

	public void updatePerson() {
		super.getJdbcTemplate().execute("update person set name='lisi2' where id='12'");
	}
	

	
	
}
