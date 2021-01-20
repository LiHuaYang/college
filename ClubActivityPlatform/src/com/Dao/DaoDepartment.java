package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.Department;
import com.Tool.HIbernateSessionFactory;


public class DaoDepartment {

	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午01:48:04
	 *函数名：QueryDepartmentById
	 *功能：根据ID查询部门详情
	 *参数：@param departmentid
	 *返回值：Department
	 */
	public Department QueryDepartmentById(int departmentid){
		Department department=null;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			department=(Department) session.get(Department.class, departmentid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return department;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午02:27:08
	 *函数名：queryDepartmentsByorganizationId
	 *功能：根据组织ID查询部门列表
	 *参数：@param organizationId 
	 *返回值：List<Department>
	 */
	public List<Department> queryDepartmentsByorganizationId(int organizationId){
		List<Department> departments=new ArrayList<Department>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Department where departmentBelongId="+organizationId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			departments=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departments;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午11:20:09
	 *函数名：UpdateDepartment
	 *功能：修改部门信息
	 *参数：@param department
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdateDepartment(int departmentId,String departmentIntroduction,String departmentPic){
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			Department department= (Department) session.load(Department.class, departmentId);
			department.setDepartmentIntroduction(departmentIntroduction);
			department.setDepartmentPic(departmentPic);
			session.close();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
