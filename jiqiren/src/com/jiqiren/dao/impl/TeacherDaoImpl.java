package com.jiqiren.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.jiqiren.entity.Student;
import com.jiqiren.entity.Teacher;
import com.jiqiren.utils.JdbcUtils;

/**
 * ¿œ ¶
 * 
 * @author ariclee
 */
public class TeacherDaoImpl {

	private static final QueryRunner runerUpdate = new QueryRunner();
	private static final QueryRunner runerQuery  = new QueryRunner(JdbcUtils.getDataSource());
	
	public List<Teacher> getPage(int firtResult, int maxResult) {
		String sql = "select * from teacher limit ?,?";
		Object[] paras = {firtResult, maxResult};
		List<Teacher> teachers = null;
		
		try {
			teachers = runerQuery.query(sql, new BeanListHandler<>(Teacher.class), paras);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return teachers;
	}
	
	public int getTotalNum() {
		String sql = "select count(*) as total from teacher";
		Map<String, Object> mapRes = null;
		Long result = null;
		int totalNum = 0;
		
		try {
			mapRes = runerQuery.query(sql, new MapHandler());
			result = (Long) mapRes.get("total");
			
			totalNum = result.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalNum;
	}
	
	public Teacher get(String condition) {
		String sql = "select * from teacher where id=?";
		Object[] paras = {condition};
		Teacher teacher = null;
		
		try {
			teacher = runerQuery.query(sql, new BeanHandler<>(Teacher.class), paras);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
}
