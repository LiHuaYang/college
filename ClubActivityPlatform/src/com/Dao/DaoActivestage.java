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
	 *作者：movie
	 *时间：2015-10-13下午07:19:53
	 *函数名：QueryActivestageByActivityId
	 *功能：根据活动Id查询活动阶段
	 *参数：@param activityid
	 *返回值：List<Activestage>
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
	 *作者：movie
	 *时间：2015-10-13下午08:58:28
	 *函数名：CreateActivestage
	 *功能：创建活动阶段
	 *参数：@param activestage
	 *返回值：boolean
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
