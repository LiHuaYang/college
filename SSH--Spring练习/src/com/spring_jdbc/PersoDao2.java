package com.spring_jdbc;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


/**
 * 
 * 方法二：继承 JdbcDaoSupport
 *
 * 要求：xml配置时的属性名字，必须是dataSource，否则无法注入
 * 
 * 作者：ariclee		时间：2016年9月19日下午12:35:45
 */
public class PersoDao2 extends JdbcDaoSupport {

	public void updatePerson() {
		super.getJdbcTemplate().execute("update person set name='lisi2' where id='12'");
	}
	

	
	
}
