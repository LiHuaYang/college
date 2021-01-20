package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.Corporation;
import com.Tool.HIbernateSessionFactory;
import com.Tool.MyConstant.HotNum;

public class DaoCorporation {
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午12:48:34
	 *函数名：QueryCorporationById
	 *功能：根据ID查询社团详情
	 *参数：@param Corporationid
	 *返回值：Organization
	 */
	public Corporation QueryCorporationById(int corporationid){
		Corporation corporation =null;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			corporation= (Corporation) session.get(Corporation.class, corporationid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return corporation;
		
	}
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryHotCorporation
	  *功能：查询热门社团
	  *参数：
	  *返回值：List<Corporation>
	  */
	public List<Corporation> QueryHotCorporation(){
		List<Corporation> corporation=new ArrayList<Corporation>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Corporation ";
			Query query=session.createQuery(hql);query.setCacheable(false);
			query.setFirstResult(0);
			query.setMaxResults(HotNum.HOTCORPORATION);
			corporation=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return corporation;
	} 
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryAllCorporation
	  *功能：查询所有社团
	  *参数：
	  *返回值：List<Corporation>
	  */
	public List<Corporation>  QueryAllCorporation(){
		List<Corporation> corporation=new ArrayList<Corporation>();
		try {
		
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Corporation ";
			Query query=session.createQuery(hql);query.setCacheable(false);
			corporation=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return corporation;
	}
	
	
	/**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：SearchCorporation
	  *功能：搜索社团
	  *参数：
	  *返回值：List<Corporation>
	  */
	public List<Corporation> SearchCorporation(String corporationname){
		List<Corporation> corporation=new ArrayList<Corporation>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Corporation where corporationName like '%"+corporationname+"%'";
			Query query=session.createQuery(hql);query.setCacheable(false);
			corporation=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return corporation;
	}

}
