package com.fenye.service;

import java.util.List;

import com.fenye.dao.StudentDao;
import com.fenye.domain.Page;
import com.fenye.domain.Student;

public class StudentService {
	
	private static final StudentDao dao = new StudentDao();
	
	/**
	 * ��ҳ��ȡѧ����Ϣ
	 * 
	 * @param currentPage Ŀ��ҳ��
	 * @return
	 * @author ariclee
	 */
	public Page getPage(int currentPage) {
		int recodeNum = dao.getNum(); // ��ȡѧ������
		
		Page result = new Page(currentPage, recodeNum); // �����ҳ���
		
		List<Student> list = dao.getPage(result.getStartIndex(), result.getPageSize()); // ��ȡ��Ӧҳ����ѧ����Ϣ
		result.setPageData(list);

		return result;
	}
}




