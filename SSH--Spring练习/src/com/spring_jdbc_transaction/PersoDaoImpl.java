package com.spring_jdbc_transaction;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersoDaoImpl extends JdbcTemplate implements PersonDao {

	
	/* (non-Javadoc)
	 * @see com.spring_jdbc_transaction.PersonDao#savePerson()
	 */
	public void savePerson() {
		String sql = "insert into person values ('zhangsan', '131')";
		this.execute(sql);
		
		int i = 1 / 0;
	}
	
	/* (non-Javadoc)
	 * @see com.spring_jdbc_transaction.PersonDao#getPersons()
	 */
	public List<Person> getPersons() {
		String sql = "select * from person";
		return this.query(sql, new com.spring_jdbc_transaction.PersonRowMapper());
	}
}
