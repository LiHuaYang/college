package com.Dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.CleanerWorkArrange;
import com.Test.HibernateUtil;

public class CDaoCleanerWorkArrange {

	List<CleanerWorkArrange> activitybulletin = new ArrayList<CleanerWorkArrange>();

	private CleanerWorkArrange record = new CleanerWorkArrange();

	/**
	 * �����ݿ��CleanerWorkArrange���� ���һ��������Ա���ż�¼
	 * 
	 * @author ariclee @time 2015-12-13
	 */
	public boolean addCleanerWorkArrange(CleanerWorkArrange cr) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		try {
			s.save(cr);
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ͨ���������ż�¼��(WorkId) ��ѯ���ݿ��CleanerWorkArrange���еĹ������ż�¼
	 * 
	 * @author ariclee @time 2015-12-13
	 */
	@SuppressWarnings("unchecked")
	public List<CleanerWorkArrange> queryCleanerWorkArrangeByWorkId(int work_id) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Query query = s.createQuery(
				"from CleanerWorkArrange where CleanerWorkId=?").setParameter(
				0, work_id);
		activitybulletin = (List<CleanerWorkArrange>) query.list();
		s.getTransaction().commit();
		s.close();
		System.out.println(record.toString());

		return activitybulletin;
	}

	/**
	 * ͨ�����Ա����(CleanerId) ��ѯ���ݿ��CleanerWorkArrange���еĹ������ż�¼
	 * 
	 * @author ariclee @time 2015-12-13
	 */
	@SuppressWarnings("unchecked")
	public List<CleanerWorkArrange> queryCleanerWorkArrangeByCleanerId(
			int cleaner_id) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Query query = s
				.createQuery("from CleanerWorkArrange where CleanerId=?")
				.setParameter(0, cleaner_id);
		activitybulletin = (List<CleanerWorkArrange>) query.list();
		s.getTransaction().commit();
		s.close();
		System.out.println(record.toString());

		return activitybulletin;
	}

	/**
	 * �޸����ݿ��CleanerWorkArrange���е�һ�����ż�¼
	 * 
	 * @author ariclee @time 2015-12-13
	 */
	public boolean modifyCleaningCleanerWorkArrange(CleanerWorkArrange cr) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		try {
			s.update(cr);
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ��ѯ���ݿ��CleanerWorkArrange���е���������¼
	 * 
	 * @author ariclee @time 2015-12-13
	 */
	public List<CleanerWorkArrange> queryAllCleanerWorkArrange() {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Query query = s.createQuery("from CleanerWorkArrange");
		List<CleanerWorkArrange> CleanerWorkArrangBulletin = (List<CleanerWorkArrange>) query
				.list();

		s.getTransaction().commit();
		s.close();

		return CleanerWorkArrangBulletin;
	}

	// �鿴��๤�����ű�����
	public int getCleanerWorkNumber() {
		int count = 0;
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			count = ((Long) session.createQuery(
					"select count(CleanerWorkId) from CleanerWorkArrange ")
					.iterate().next()).intValue();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (Integer) count;
	}

	// ͨ��ҳ�����ҹ�������
	public List<CleanerWorkArrange> queryPageCleanerWorkArranges(int page) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "from CleanerWorkArrange order by CleanerWorkId asc";
		Query query = session.createQuery(sql);
		query.setFirstResult((page - 1) * 10);
		query.setMaxResults(10);
		List<CleanerWorkArrange> findResult = query.list();
		session.getTransaction().commit();
		session.close();
		return findResult;
	}
}
