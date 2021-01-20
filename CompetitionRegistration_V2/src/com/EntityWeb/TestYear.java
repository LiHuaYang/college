package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestYear {
	private String TestYear;
	public String getTestYear() {
		return TestYear;
	}
	public void setTestYear(String testYear) {
		TestYear = testYear;
	}
	public TestYear(ResultSet resultSet)throws SQLException{
		this.TestYear = resultSet.getString("YearData");
	}
}
