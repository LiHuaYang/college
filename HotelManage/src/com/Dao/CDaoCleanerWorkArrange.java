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
	 * 往数据库的CleanerWorkArrange表中 添加一条工作人员安排记录
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
	 * 通过工作安排记录号(WorkId) 查询数据库的CleanerWorkArrange表中的工作安排记录
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
	 * 通过清洁员工号(CleanerId) 查询数据库的CleanerWorkArrange表中的工作安排记录
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
	 * 修改数据库的CleanerWorkArrange表中的一条安排记录
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
	 * 查询数据库的CleanerWorkArrange表中的所有清洁记录
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

	// 查看清洁工作安排表总数
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

	// 通过页数查找工作安排
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
