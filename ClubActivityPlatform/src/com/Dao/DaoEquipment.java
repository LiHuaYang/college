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
	 *作者：movie
	 *时间：2015-10-15上午09:32:22
	 *函数名：QueryEquipmentByBelong
	 *功能：根据所属类型和所属Id查询器材列表
	 *参数：@param equipmentBelongType
	 *参数：@param equipmentBelongId
	 *参数：@return 
	 *返回值：Equipment
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
	 *作者：movie
	 *时间：2015-10-15上午10:19:55
	 *函数名：QueryEquipmentById
	 *功能：根据器材Id查询器材详情
	 *参数：@param equipmentId
	 *参数：@return 
	 *返回值：Equipment
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
	 *作者：movie
	 *时间：2015-10-15上午10:23:12
	 *函数名：SaveEquipment
	 *功能：新建器材
	 *参数：@param equipment
	 *参数：@return 
	 *返回值：boolean
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
	 *作者：movie
	 *时间：2015-10-15上午10:23:12
	 *函数名：SaveEquipment
	 *功能：修改器材
	 *参数：@param equipment
	 *参数：@return 
	 *返回值：boolean
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
	 *作者：movie
	 *时间：2015-10-15上午10:28:13
	 *函数名：DeleteEquipment
	 *功能：根据主键删除器材
	 *参数：@param equipmentId
	 *参数：@return 
	 *返回值：boolean
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
