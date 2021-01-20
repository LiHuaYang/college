package com.Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.Economics;
import com.Tool.HIbernateSessionFactory;


public class DaoEconomics {
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午09:32:22
	 *函数名：QueryEconomicsByBelong
	 *功能：根据所属类型和所属Id查询资金总量
	 *参数：@param economicsBelongType
	 *参数：@param economicsBelongId
	 *参数：@return 
	 *返回值：Economics
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
	 *作者：movie
	 *时间：2015-10-15上午09:59:32
	 *函数名：UpdateEconomicsSum
	 *功能：更新资金总数
	 *参数：@param economicsId
	 *参数：@param economicsSum
	 *参数：@return 
	 *返回值：boolean
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
