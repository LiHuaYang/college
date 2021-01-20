package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.Equipment;
import com.Tool.HIbernateSessionFactory;


public class DaoEquipment {
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����09:32:22
	 *��������QueryEquipmentByBelong
	 *���ܣ������������ͺ�����Id��ѯ�����б�
	 *������@param equipmentBelongType
	 *������@param equipmentBelongId
	 *������@return 
	 *����ֵ��Equipment
	 */
	public List<Equipment> QueryEquipmentByBelong(int equipmentBelongType,int equipmentBelongId){
		List<Equipment> equipment=new ArrayList<Equipment>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Equipment where equipmentBelongType="+equipmentBelongType+" and equipmentBelongId="+equipmentBelongId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			equipment=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return equipment;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����10:19:55
	 *��������QueryEquipmentById
	 *���ܣ���������Id��ѯ��������
	 *������@param equipmentId
	 *������@return 
	 *����ֵ��Equipment
	 */
	public Equipment QueryEquipmentById(int equipmentId){
		Equipment equipment=null;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			equipment=(Equipment) session.get(Equipment.class, equipmentId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return equipment;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����10:23:12
	 *��������SaveEquipment
	 *���ܣ��½�����
	 *������@param equipment
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean SaveEquipment(Equipment equipment){
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			session.save(result);
			session.getTransaction().commit();
			session.close();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����10:23:12
	 *��������SaveEquipment
	 *���ܣ��޸�����
	 *������@param equipment
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean UpdateEquipment(Equipment equipment){
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			session.update(result);
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
	 *ʱ�䣺2015-10-15����10:28:13
	 *��������DeleteEquipment
	 *���ܣ���������ɾ������
	 *������@param equipmentId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean DeleteEquipment(int equipmentId){
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="delete Equipment where equipmentId="+equipmentId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			query.executeUpdate();
			session.getTransaction().commit();
			
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
