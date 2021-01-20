package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Entity.Activestage;
import com.Tool.HIbernateSessionFactory;


public class DaoActivestage {
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����07:19:53
	 *��������QueryActivestageByActivityId
	 *���ܣ����ݻId��ѯ��׶�
	 *������@param activityid
	 *����ֵ��List<Activestage>
	 */
	public List<Activestage> QueryActivestageByActivityId(int activityid){
		List<Activestage> activestages=new ArrayList<Activestage>();
		try {
		
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Activestage where activityId="+activityid;
			Query query=session.createQuery(hql);query.setCacheable(false);
			activestages=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return activestages;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����08:58:28
	 *��������CreateActivestage
	 *���ܣ�������׶�
	 *������@param activestage
	 *����ֵ��boolean
	 */
	public boolean CreateActivestage(Activestage activestage){
		boolean result=false;
		try {
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			session.save(activestage);
			session.getTransaction().commit();
			session.close();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
}
