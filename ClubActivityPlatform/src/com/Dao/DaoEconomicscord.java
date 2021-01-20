package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.Economicsrecord;
import com.Tool.HIbernateSessionFactory;


public class DaoEconomicscord {
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����09:37:57
	 *��������QueryEconomicsrecordsByEconomicsId
	 *���ܣ������ʽ�ID��ѯ�ʽ��¼
	 *������@param economicsId
	 *������@return 
	 *����ֵ��List<Economicsrecord>
	 */
	public List<Economicsrecord> QueryEconomicsrecordsByEconomicsId(int economicsId){
		 List<Economicsrecord> economicsrecords=new ArrayList<Economicsrecord>();
		 try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Economicsrecord where economicsId="+economicsId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			economicsrecords=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return economicsrecords;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����09:57:17
	 *��������CreateEconomicscord
	 *���ܣ������ʽ��¼
	 *������@param economicsrecord
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateEconomicscord(Economicsrecord economicsrecord){
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			session.save(economicsrecord);
			session.getTransaction().commit();
			session.close();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
