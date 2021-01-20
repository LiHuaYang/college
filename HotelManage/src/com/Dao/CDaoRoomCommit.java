package com.Dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.RoomCommit;
import com.Test.HibernateUtil;

public class CDaoRoomCommit {
	private RoomCommit roomCommit = new RoomCommit();
	private List<RoomCommit> roomCommits = new ArrayList<RoomCommit>();
	
	// ---------1.新建房间评价---------
	public boolean CreateRoomCommit(RoomCommit roomCommit){
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(roomCommit);
			session.getTransaction().commit();
		} catch (SecurityException e) {
			e.printStackTrace();
			return false;
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//-----------2.修改房间评价--------------
	public boolean UpdateRoomCommit(RoomCommit roomCommit){
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(roomCommit);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//----------3.查看房间评价表（按客户号查找）---------------
	@SuppressWarnings("unchecked")
	public List<RoomCommit> QueryRoomCommitByUser(int userId){
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			Query query = session.createQuery("from RoomCommit Where UserId = ?");
			roomCommits = query.setParameter(0, userId).list();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomCommits;
	}
	//----------4.查找房间评价表(按房间号查找)---------------
	@SuppressWarnings("unchecked")
	public List<RoomCommit> QueryRoomCommitByRoom(int roomId){
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			Query query = session.createQuery("from RoomCommit Where RoomId = ?");
			roomCommits = query.setParameter(0, roomId).list();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomCommits;
	}
	public RoomCommit QuerySingelRoomCommit(int roomId){
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			Query query = session.createQuery("from RoomCommit Where RoomId = ?");
			roomCommit = (RoomCommit) query.setParameter(0, roomId).uniqueResult();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomCommit;
	}
	//查询所有房间评价
	public List<RoomCommit> QueryAllRoomCommits(){
		List<RoomCommit> roomCommits = null;
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			roomCommits = session.createQuery("from RoomCommit ").list();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomCommits;
	}
	
	
	//通过页数查找房间评价
	public List<RoomCommit> getRoomCommintByPage(int page){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql="from RoomCommit order by RoomCommitId asc";
		Query query=session.createQuery(sql);
		query.setFirstResult((page-1)*10);
		query.setMaxResults(10);
		List<RoomCommit> findResult=query.list();
		session.getTransaction().commit();			
		session.close();
		return findResult;
	}
	//查看房间评价数
	public int getRoomCommunitNumber(){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int count=0;
		try {
			 count=((Long)session.createQuery("select count(RoomCommitId) from RoomCommit ").iterate().next()).intValue(); 
			 session.getTransaction().commit();			
			 session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return (Integer)count;
	}
}
