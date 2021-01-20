package com.spring_jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		
		person.setName(rs.getString("name"));
		person.setAge(rs.getInt("id"));
		
		return person;
	}

}
