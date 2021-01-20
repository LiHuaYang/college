package com.spring_jdbc;

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
