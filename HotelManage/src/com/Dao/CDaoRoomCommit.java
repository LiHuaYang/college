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
	
	// ---------1.�½���������---------
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
	//-----------2.�޸ķ�������--------------
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
	//----------3.�鿴�������۱����ͻ��Ų��ң�---------------
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
	//----------4.���ҷ������۱�(������Ų���)---------------
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
	//��ѯ���з�������
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
	
	
	//ͨ��ҳ�����ҷ�������
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
	//�鿴����������
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
