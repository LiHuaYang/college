package com.jiqiren.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.jiqiren.entity.Student;
import com.jiqiren.utils.JdbcUtils;

/**
 * Ñ§Éú
 * 
 * @author ariclee
 */
//public class StudentDaoImpl implements StudentDao {
public class StudentDaoImpl {
	
	private static final QueryRunner runerUpdate = new QueryRunner();
	private static final QueryRunner runerQuery  = new QueryRunner(JdbcUtils.getDataSource());
	
	public List<Student> getPage(int firtResult, int maxResult) {
		String sql = "select * from student limit ?,?";
		Object[] paras = {firtResult, maxResult};
		List<Student> stus = null;
		
		try {
			stus = runerQuery.query(sql, new BeanListHandler<>(Student.class), paras);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stus;
	}
	
	public int getTotalNum() {
		String sql = "select count(*) as total from student";
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

	public List<Student> getAll() {
		String sql = "select * from student";
		List<Student> stus = null;
		try {
			stus = runerQuery.query(sql, new BeanListHandler<>(Student.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stus;
	}

	public Student get(String condition) {
		String sql = "select * from student where id=?";
		Object[] paras = {condition};
		Student stus = null;
		
		try {
			stus = runerQuery.query(sql, new BeanHandler<>(Student.class), paras);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stus;
	}

	public int add(Student student) {
		return 0;
	}

	public Student delete(String condition) {
		return null;
	}

	public int update(Student student) {
		return 0;
	}
}
