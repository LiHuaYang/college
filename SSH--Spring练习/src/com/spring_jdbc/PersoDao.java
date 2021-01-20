package com.spring_jdbc;

public class PersoDao extends JDBCTemplate {

	public void updatePerson() {
		super.update("update person set name='lisi' where id='12'");
	}
	
	
}
