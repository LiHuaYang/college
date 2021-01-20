package com.Dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.CleaningRecord;
import com.Test.HibernateUtil;

/**
 * 清洁记录表数据库操作
 * 
 * @author AricLee
 * 
 */
public class CDaoCleaningRecord {
	List<CleaningRecord> activitybulletin = new ArrayList<CleaningRecord>();

	/**
	 * 往数据库的CleaningRecord表中 添加一条清洁记录
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
	 * 查询数据库的CleaningRecord表中的所有清洁记录
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
	 * 通过清洁记录号(CleaningId) 查询数据库的CleaningRecord表中的清洁记录
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
	 * 通过房间号(RoomId) 查询数据库的CleaningRecord表中的清洁记录
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
	 * 通过清洁员员工号(CleanerId) 查询数据库的CleaningRecord表中的清洁记录
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
	 * 修改数据库的CleaningRecord表中的一条清洁记录
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

	// 通过页数查找清洁记录
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

	// 查看清洁记录数
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
