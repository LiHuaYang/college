package com.Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.RoomEquipment;
import com.Test.HibernateUtil;

public class CDaoRoomEquipment {
	//--------------1.查询房间设备信息--------------
	
	RoomEquipment roomEquipment = new RoomEquipment();
	public RoomEquipment QueryRoomEquipment(int roomEquipmentId){
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			Query query = s.createQuery("from RoomEquipment where RoomEquipmentId=?").setParameter(0, roomEquipmentId);
			roomEquipment = (RoomEquipment) query.uniqueResult();
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomEquipment;
	}
	//--------------2.新建房间设备信息--------------
	public boolean CreateRoomEquipment(RoomEquipment roomEquipment){
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			s.save(roomEquipment);
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//--------------3.修改房间设备信息----------------
	public boolean UpdateRoomEquipment(RoomEquipment roomEquipment){
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			s.update(roomEquipment);
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
