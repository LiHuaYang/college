package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.Equipmentrecord;
import com.Tool.HIbernateSessionFactory;


public class DaoEquipmentrecord {
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����09:37:57
	 *��������QueryEquipmentrecordsByEquipmentId
	 *���ܣ���������ID��ѯ���ļ�¼
	 *������@param equipmentId
	 *������@return 
	 *����ֵ��List<Economicsrecord>
	 */
	public List<Equipmentrecord> QueryEquipmentrecordsByEquipmentId(int equipmentId){
		 List<Equipmentrecord> equipmentrecords=new ArrayList<Equipmentrecord>();
		 try {
			
			 Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Equipmentrecord where equipmentId="+equipmentId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			equipmentrecords=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return equipmentrecords;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����10:32:19
	 *��������DeleteEquipmentrecordByEquipmentId
	 *���ܣ���������IDɾ�����ļ�¼
	 *������@param equipmentId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean DeleteEquipmentrecordByEquipmentId(int equipmentId){
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="delete Equipmentrecord where equipmentId="+equipmentId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			query.executeUpdate();
			session.getTransaction().commit();
			
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����10:35:24
	 *��������CreateEquipmentrecord
	 *���ܣ��������ļ�¼
	 *������@param equipmentrecord
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateEquipmentrecord(Equipmentrecord equipmentrecord){
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			session.beginTransaction();
			session.save(equipmentrecord);
			session.getTransaction().commit();
			session.close();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	 
}
