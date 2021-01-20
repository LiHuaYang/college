package com.jiqiren.dao.impl;

import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.jiqiren.utils.JdbcUtils;

public class BasicDaoImpl {
	
	private static final QueryRunner runerUpdate = new QueryRunner();
	private static final QueryRunner runerQuery  = new QueryRunner(JdbcUtils.getDataSource());
	
	public String getAdnministraterPswd(String email) {
		String sql = "select pswd from administrators where email=?";
		Object paras[] = {
			email
		};
		String pswd = "";
		try {
			Map stus = runerQuery.query(sql, new MapHandler(), paras);
			pswd = (String) stus.get("pswd");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pswd;
	}
	
	
	public static void main(String[] args) {
		String email = "1072211375@qq.com";
		String pswd = new BasicDaoImpl().getAdnministraterPswd(email);
		System.out.println(pswd);
	}
}
