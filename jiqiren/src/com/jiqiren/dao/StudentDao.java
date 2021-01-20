//package com.jiqiren.dao;
//
//import java.util.List;
//
//import com.jiqiren.entity.QueryResult;
//import com.jiqiren.entity.Student;
//
///**
// * 学生 dao 层
// * 
// * @author ariclee
// */
//public interface StudentDao {
//
//	/**
//	 * 获取所有的学生
//	 * @return
//	 * @author ariclee
//	 */
//	public List<Student> getAll();
//
//	/**
//	 * 
//	 * 增加一个学生
//	 * @param student
//	 * @return
//	 * @author ariclee
//	 */
//	public int add(Student student);
//	
//	/**
//	 * 删除一个指定条件下的学生
//	 * @param condition
//	 * @return
//	 * @author ariclee
//	 */
//	public Student delete(String condition);
//	
//	/**
//	 * 更新一个学生信息
//	 * @param student
//	 * @return
//	 * @author ariclee
//	 */
//	public int update(Student student);
//	
//	/**
//	 * 
//	 * @param firtResult : 数据库记录起始位置
//	 * @param maxResult: 一页数据大小
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
