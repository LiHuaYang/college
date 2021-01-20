package com.spring_jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate; 


/**
 * 
 * 方法三：继承 JdbcTemplate
 *
 * 要求：提供对应的构造函数，并在构造函数中，调用父类的构造函数
 * 从而，将DataSource注入JDBCTemplate中
 * 	
 * 
 * 作者：ariclee		时间：2016年9月19日下午12:35:45
 */
public class PersoDao3 extends JdbcTemplate {

	PersoDao3(DataSource dataSource) {
		super(dataSource);
	}
	public void updatePerson() {
		super.execute("update person set name='lisi3' where id='12'");
	}
}
