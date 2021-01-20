package com.fenye.service;

import java.util.List;

import com.fenye.dao.StudentDao;
import com.fenye.domain.Page;
import com.fenye.domain.Student;

public class StudentService {
	
	private static final StudentDao dao = new StudentDao();
	
	/**
	 * 分页读取学生信息
	 * 
	 * @param currentPage 目标页数
	 * @return
	 * @author ariclee
	 */
	public Page getPage(int currentPage) {
		int recodeNum = dao.getNum(); // 获取学生总数
		
		Page result = new Page(currentPage, recodeNum); // 构造分页结果
		
		List<Student> list = dao.getPage(result.getStartIndex(), result.getPageSize()); // 获取对应页数的学生信息
		result.setPageData(list);

		return result;
	}
}




