package com.yingteman.test;


import java.sql.SQLException;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.yingteman.database.JdbcUtils;

public class DataBaseTest {

	private static QueryRunner runerUpdate = new QueryRunner();
	private static QueryRunner runerQuery = new QueryRunner(JdbcUtils.getDataSource());
	
	@org.junit.Test
	public void test1() {
		String sql = "select activate from box;";
		try {
			Map<String, Object> map = runerQuery.query(sql, new MapHandler());
			System.out.println("盒子的激活状态为---" + map.get("activate"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static final int ACTIVED  = 1; 
	private static final int NOACTIVE = 0; 
	
	@org.junit.Test
	public void test2() {
		String sql = "select activate , box_id from box where sn_num = '969490001316'";
		try {
			Map<String, Object> map = runerQuery.query(sql, new MapHandler());
			Integer actived = (Integer) map.get("activate");
			System.out.println(actived.equals(ACTIVED));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
