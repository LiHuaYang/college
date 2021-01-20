package com.Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.Economics;
import com.Tool.HIbernateSessionFactory;


public class DaoEconomics {
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����09:32:22
	 *��������QueryEconomicsByBelong
	 *���ܣ������������ͺ�����Id��ѯ�ʽ�����
	 *������@param economicsBelongType
	 *������@param economicsBelongId
	 *������@return 
	 *����ֵ��Economics
	 */
	public Economics QueryEconomicsByBelong(int economicsBelongType,int economicsBelongId){
		Economics economics=null;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Economics where economicsBelongType="+economicsBelongType+" and economicsBelongId="+economicsBelongId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			economics=(Economics) query.list().get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return economics;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����09:59:32
	 *��������UpdateEconomicsSum
	 *���ܣ������ʽ�����
	 *������@param economicsId
	 *������@param economicsSum
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean UpdateEconomicsSum(int economicsId,float economicsSum){
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			Economics economics=(Economics) session.load(Economics.class, economicsId);
			economics.setEconomicsSum(economicsSum);
			session.close();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
