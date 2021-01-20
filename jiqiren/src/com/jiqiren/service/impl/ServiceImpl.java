package com.jiqiren.service.impl;

import java.util.List;

import com.jiqiren.dao.impl.BasicDaoImpl;
import com.jiqiren.dao.impl.StudentDaoImpl;
import com.jiqiren.dao.impl.TeacherDaoImpl;
import com.jiqiren.entity.QueryResult;
import com.jiqiren.entity.Student;
import com.jiqiren.entity.Teacher;

//public class ServiceImpl implements Service {
	
public class ServiceImpl {
	
	private static final StudentDaoImpl studentDao = new StudentDaoImpl();
	private static final TeacherDaoImpl teacherDao = new TeacherDaoImpl();
	private static final BasicDaoImpl basicDao = new BasicDaoImpl();
	
	public List<Student> getAllStudent() {
		return studentDao.getAll();
	}

	/**
	 * 获取指定页数的学生信息
	 * 
	 * @param page：目标页数
	 * @return
	 * @author ariclee
	 */
	public QueryResult getPageStudent(String page) {
		QueryResult result = null;
		List<Student> pageData = null;
		int totalRecord = studentDao.getTotalNum();

		if (page == null) {
			result = new QueryResult(0, totalRecord);
			pageData = studentDao.getPage(0, result.getPageSize());
			result.setPageData(pageData);
			return result;
		}
		if (Integer.valueOf(page) < 0) {
			result = new QueryResult(0, totalRecord);
			pageData = studentDao.getPage(0, result.getPageSize());
			result.setPageData(pageData);
			return result;
		}
		
		result = new QueryResult(Integer.valueOf(page), totalRecord);
		pageData = studentDao.getPage(result.getStartIndex(), result.getPageSize());
		result.setPageData(pageData);
		return result;
	}

	/**
	 * 根据条件获取一个学生信息
	 * @param id
	 * @return
	 * @author ariclee
	 */
	public Student getAStudent(String id) {
		return studentDao.get(id);
	}
	
	
	/**
	 * 获取指定页数的老师信息
	 * 
	 * @param page：目标页数
	 * @return
	 * @author ariclee
	 */
	public QueryResult getPageTeacher(String page) {
		QueryResult result = null;
		List<Teacher> pageData = null;
		int totalRecord = teacherDao.getTotalNum();

		if (page == null) {
			result = new QueryResult(0, totalRecord);
			pageData = teacherDao.getPage(0, result.getPageSize());
			result.setPageData(pageData);
			return result;
		}
		if (Integer.valueOf(page) < 0) {
			result = new QueryResult(0, totalRecord);
			pageData = teacherDao.getPage(0, result.getPageSize());
			result.setPageData(pageData);
			return result;
		}
		
		result = new QueryResult(Integer.valueOf(page), totalRecord);
		pageData = teacherDao.getPage(result.getStartIndex(), result.getPageSize());
		result.setPageData(pageData);
		return result;
	}
	/**
	 * 根据条件获取一个学生信息
	 * @param id
	 * @return
	 * @author ariclee
	 */
	public Teacher getATeacher(String id) {
		return teacherDao.get(id);
	}
	
	/**
	 * 管理员登陆
	 * 
	 * @return
	 * @author ariclee
	 */
	public boolean login(String email, String pswd) {
		String dbPwd = basicDao.getAdnministraterPswd(email);
		return dbPwd.equals(pswd);
	}
}
