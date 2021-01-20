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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����12:48:34
	 *��������QueryCorporationById
	 *���ܣ�����ID��ѯ��������
	 *������@param Corporationid
	 *����ֵ��Organization
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
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryHotCorporation
	  *���ܣ���ѯ��������
	  *������
	  *����ֵ��List<Corporation>
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
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryAllCorporation
	  *���ܣ���ѯ��������
	  *������
	  *����ֵ��List<Corporation>
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
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������SearchCorporation
	  *���ܣ���������
	  *������
	  *����ֵ��List<Corporation>
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
