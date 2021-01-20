package com.Dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.UserCommit;
import com.Test.HibernateUtil;

public class CDaoUserCommit {
	private List<UserCommit> usercommits = new ArrayList<UserCommit>();

	// ---------------1.���ӿͻ�����---------------
	public boolean UserCommentRoom(UserCommit usercommit) {
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			s.save(usercommit);
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// --------------2.��ѯĳ�ͻ�������-----------
	@SuppressWarnings("unchecked")
	public List<UserCommit> QueryUserCommits(int userid) {
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			Query query = s.createQuery("from UserCommit  where UserId=?")
					.setParameter(0, userid);
			usercommits = (List<UserCommit>) query.list();
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// for(UserCommit usercommit:usercommits){
		// System.out.println(usercommit.toString());
		// }
		return usercommits;
	}

	// --------------3.��ѯȫ������-----------
	@SuppressWarnings("unchecked")
	public List<UserCommit> QueryAllCommit() {
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			Query query = s.createQuery("from UserCommit ");
			usercommits = (List<UserCommit>) query.list();
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// for(UserCommit usercommit:usercommits){
		// System.out.println(usercommit.toString());
		// }
		return usercommits;
	}

	// --------------4.ͨ������id��������--------
	@SuppressWarnings("unchecked")
	public List<UserCommit> QueryUserCommitsByRoomid(int roomid) {
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			Query query = s.createQuery("from UserCommit  where RoomId=?")
					.setParameter(0, roomid);
			usercommits = (List<UserCommit>) query.list();
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// for(UserCommit usercommit:usercommits){
		// System.out.println(usercommit.toString());
		// }
		return usercommits;
	}

	// ͨ��ҳ�����ҿͻ�����
	public List<UserCommit> QueryUserCommintByPage(int page) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "from UserCommit order by UserCommitId asc";
		Query query = session.createQuery(sql);
		query.setFirstResult((page - 1) * 10);
		query.setMaxResults(10);
		List<UserCommit> findResult = query.list();
		session.getTransaction().commit();
		session.close();
		return findResult;
	}

	// �鿴�ͻ���
	public int GetUserCommintNumber() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int count = 0;
		try {
			count = ((Long) session.createQuery(
					"select count(UserCommitId) from UserCommit ").iterate()
					.next()).intValue();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (Integer) count;
	}

	// ͨ��usercommitId�鿴��������
	public UserCommit queryUserCommitById(int UserCommitId) {
		UserCommit userCommit = null;
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			userCommit = (UserCommit) session.createQuery(
					"from UserCommit where UserCommitId = ?").setParameter(0,
					UserCommitId).uniqueResult();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userCommit;
	}
}
