package com.Dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.CleaningRecord;
import com.Test.HibernateUtil;

/**
 * ����¼�����ݿ����
 * 
 * @author AricLee
 * 
 */
public class CDaoCleaningRecord {
	List<CleaningRecord> activitybulletin = new ArrayList<CleaningRecord>();

	/**
	 * �����ݿ��CleaningRecord���� ���һ������¼
	 * 
	 * @author ariclee @time 2015-12-13
	 */
	public boolean addCleaningRecord(CleaningRecord cr) {
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
	 * ��ѯ���ݿ��CleaningRecord���е���������¼
	 * 
	 * @author ariclee @time 2015-12-13
	 */
	public List<CleaningRecord> queryAllCleaningRecord() {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Query query = s.createQuery("from CleaningRecord");
		List<CleaningRecord> CleaningRecordBulletin = query.list();

		s.getTransaction().commit();
		s.close();

		return CleaningRecordBulletin;
	}

	/**
	 * ͨ������¼��(CleaningId) ��ѯ���ݿ��CleaningRecord���е�����¼
	 * 
	 * @author ariclee @time 2015-12-13
	 */
	@SuppressWarnings("unchecked")
	public List<CleaningRecord> queryCleaningRecordByCleaningId(int cleaning_id) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();

		Query query = s.createQuery("from CleaningRecord where CleaningId=?")
				.setParameter(0, cleaning_id);

		activitybulletin = (List<CleaningRecord>) query.list();

		s.getTransaction().commit();
		s.close();

		return activitybulletin;
	}

	/**
	 * ͨ�������(RoomId) ��ѯ���ݿ��CleaningRecord���е�����¼
	 * 
	 * @author ariclee @time 2015-12-13
	 */
	@SuppressWarnings("unchecked")
	public List<CleaningRecord> queryCleaningRecordByRoomId(int room_id) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();

		Query query = s.createQuery("from CleaningRecord where RoomId=?")
				.setParameter(0, room_id);

		// record = (CleaningRecord)query.uniqueResult();
		activitybulletin = (List<CleaningRecord>) query.list();
		s.getTransaction().commit();
		s.close();

		return activitybulletin;
	}

	/**
	 * ͨ�����ԱԱ����(CleanerId) ��ѯ���ݿ��CleaningRecord���е�����¼
	 * 
	 * @author ariclee @time 2015-12-13
	 */
	@SuppressWarnings("unchecked")
	public List<CleaningRecord> queryCleaningRecordByCleanerId(int cleaner_id) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();

		Query query = s.createQuery("from CleaningRecord where CleanerId=?")
				.setParameter(0, cleaner_id);

		// record = (CleaningRecord)query.uniqueResult();
		activitybulletin = (List<CleaningRecord>) query.list();
		s.getTransaction().commit();
		s.close();

		// System.out.println(record.toString());
		return activitybulletin;
	}

	/**
	 * �޸����ݿ��CleaningRecord���е�һ������¼
	 * 
	 * @author ariclee @time 2015-12-13
	 */
	public boolean modifyCleaningRecord(CleaningRecord cr) {
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

	// ͨ��ҳ����������¼
	public List<CleaningRecord> getCleanRecordPage(int page) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "from CleaningRecord order by CleaningId asc";
		Query query = session.createQuery(sql);
		query.setFirstResult((page - 1) * 10);
		query.setMaxResults(10);
		List<CleaningRecord> findResult = query.list();
		session.getTransaction().commit();
		session.close();
		return findResult;
	}

	// �鿴����¼��
	public int getCleanRecordNumber() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int count = 0;
		try {
			count = ((Long) session.createQuery(
					"select count(CleaningId) from CleaningRecord ").iterate()
					.next()).intValue();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (Integer) count;
	}

}
