package com.Dao;

import org.hibernate.Session;
import com.Entity.Organization;
import com.Tool.HIbernateSessionFactory;

public class DaoOrganzation {
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����12:48:34
	 *��������QueryOrganizationById
	 *���ܣ�����ID��ѯ��֯
	 *������@param organizationid
	 *����ֵ��Organization
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����11:20:09
	 *��������UpdateOrganzation
	 *���ܣ��޸���֯����
	 *������@param organization
	 *������@return 
	 *����ֵ��boolean
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
