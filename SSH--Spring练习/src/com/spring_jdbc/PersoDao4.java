package com.spring_jdbc;

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
public class PersoDao4  {

	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void updatePerson() {
		this.template.execute("update person set name='lisi4' where id='12'");
	}

	public Person query() {
		String sql = "select name, id from person where id='12'";
		return (Person) this.template.queryForObject(sql, new PersonRowMapper());
	}
}
