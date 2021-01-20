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
	 *作者：movie
	 *时间：2015-10-15上午09:37:57
	 *函数名：QueryEquipmentrecordsByEquipmentId
	 *功能：根据器材ID查询器材记录
	 *参数：@param equipmentId
	 *参数：@return 
	 *返回值：List<Economicsrecord>
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
	 *作者：movie
	 *时间：2015-10-15上午10:32:19
	 *函数名：DeleteEquipmentrecordByEquipmentId
	 *功能：根据器材ID删除器材记录
	 *参数：@param equipmentId
	 *参数：@return 
	 *返回值：boolean
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
	 *作者：movie
	 *时间：2015-10-15上午10:35:24
	 *函数名：CreateEquipmentrecord
	 *功能：创建器材记录
	 *参数：@param equipmentrecord
	 *参数：@return 
	 *返回值：boolean
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
