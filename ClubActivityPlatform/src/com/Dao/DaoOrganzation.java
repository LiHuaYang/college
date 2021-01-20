package com.Dao;

import org.hibernate.Session;
import com.Entity.Organization;
import com.Tool.HIbernateSessionFactory;

public class DaoOrganzation {
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午12:48:34
	 *函数名：QueryOrganizationById
	 *功能：根据ID查询组织
	 *参数：@param organizationid
	 *返回值：Organization
	 */
	public Organization QueryOrganizationById(int organizationid){
		Organization organization =null;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			organization= (Organization) session.get(Organization.class, organizationid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return organization;
		
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午11:20:09
	 *函数名：UpdateOrganzation
	 *功能：修改组织资料
	 *参数：@param organization
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdateOrganzation(int organizationId,String organizationIntroduction,String organizationPic){
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			Organization organization=(Organization) session.load(Organization.class, organizationId);
			organization.setOrganizationIntroduction(organizationIntroduction);
			organization.setOrganizationPic(organizationPic);
			session.getTransaction().commit();
			session.close();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
