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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����01:48:04
	 *��������QueryDepartmentById
	 *���ܣ�����ID��ѯ��������
	 *������@param departmentid
	 *����ֵ��Department
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����02:27:08
	 *��������queryDepartmentsByorganizationId
	 *���ܣ�������֯ID��ѯ�����б�
	 *������@param organizationId 
	 *����ֵ��List<Department>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����11:20:09
	 *��������UpdateDepartment
	 *���ܣ��޸Ĳ�����Ϣ
	 *������@param department
	 *������@return 
	 *����ֵ��boolean
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
