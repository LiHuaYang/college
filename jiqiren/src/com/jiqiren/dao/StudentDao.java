//package com.jiqiren.dao;
//
//import java.util.List;
//
//import com.jiqiren.entity.QueryResult;
//import com.jiqiren.entity.Student;
//
///**
// * ѧ�� dao ��
// * 
// * @author ariclee
// */
//public interface StudentDao {
//
//	/**
//	 * ��ȡ���е�ѧ��
//	 * @return
//	 * @author ariclee
//	 */
//	public List<Student> getAll();
//
//	/**
//	 * 
//	 * ����һ��ѧ��
//	 * @param student
//	 * @return
//	 * @author ariclee
//	 */
//	public int add(Student student);
//	
//	/**
//	 * ɾ��һ��ָ�������µ�ѧ��
//	 * @param condition
//	 * @return
//	 * @author ariclee
//	 */
//	public Student delete(String condition);
//	
//	/**
//	 * ����һ��ѧ����Ϣ
//	 * @param student
//	 * @return
//	 * @author ariclee
//	 */
//	public int update(Student student);
//	
//	/**
//	 * 
//	 * @param firtResult : ���ݿ��¼��ʼλ��
//	 * @param maxResult: һҳ���ݴ�С
//	 * @return
//	 * @author ariclee
//	 */
//	public List<Student> getPage(int firtResult, int maxResult);
//	
//	/**
//	 * 
//	 * @return
//	 * @author ariclee
//	 */
//	public int getTotalNum();
//	
//	/**
//	 * 
//	 * @param condition
//	 * @return
//	 * @author ariclee
//	 */
//	public Student get(String condition);
//	
//}
