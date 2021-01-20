package com.Dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

import com.Entity.Cleaner;
import com.Test.HibernateUtil;

public class CDaoCleaner {
	private Cleaner cleaner = new Cleaner();

	private List<Cleaner> cleaners = new ArrayList<Cleaner>();

	// ---------------1.注册清洁员工---------------
	public boolean CleanerRegister(Cleaner cleaner) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		try {
			s.save(cleaner);
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// -------------2.查询某清洁员工信息--------------
	public Cleaner QuerySingelCleaner(int CleanerId) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Query query = s.createQuery("from Cleaner where CleanerId=?")
				.setParameter(0, CleanerId);
		cleaner = (Cleaner) query.uniqueResult();
		s.getTransaction().commit();
		s.close();
		System.out.println(cleaner.toString());
		return cleaner;
	}

	// --------------3.查询全部清洁员工-----------
	@SuppressWarnings("unchecked")
	public List<Cleaner> QueryAllCleaner() {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Query query = s.createQuery("from Cleaner ");
		cleaners = (List<Cleaner>) query.list();
		s.getTransaction().commit();
		s.close();
		for (Cleaner cleaner : cleaners) {
			System.out.println(cleaner.toString());
		}
		return cleaners;
	}

	// -------------4.通过手机号码，查询某清洁员工信息--------------
	@SuppressWarnings("unchecked")
	public List<Cleaner> QueryCleanerByPhone(String phoneInfo) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Query query = s.createQuery("from Cleaner where CleanerPhoneNumber=?")
				.setParameter(0, phoneInfo);
		cleaners = (List<Cleaner>) query.list();
		s.getTransaction().commit();
		s.close();
		for (Cleaner cleaner : cleaners) {
			System.out.println(cleaner.toString());
		}
		return cleaners;
	}

	// --------------5.修改保洁员状态-------------------------
	public boolean UpdateCleanerState(int CleanerId, int CleanerState) {
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			Query query = s.createQuery(
					"update Cleaner set CleanerState = ? where CleanerId=?")
					.setParameter(0, CleanerState).setParameter(1, CleanerId);
			query.executeUpdate();
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// --------------6.通过页数查找清洁工
	public List<Cleaner> getCleanerByPage(int page) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "from Cleaner order by CleanerId asc";
		Query query = session.createQuery(sql);
		query.setFirstResult((page - 1) * 10);
		query.setMaxResults(10);
		List<Cleaner> findResult = query.list();
		session.getTransaction().commit();
		session.close();
		return findResult;
	}

	// 查看清洁工数量
	public int getCleannerNumber() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int count = 0;
		try {
			count = ((Long) session.createQuery(
					"select count(CleanerId) from Cleaner ").iterate().next())
					.intValue();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (Integer) count;
	}

	// 修改清洁员信息
	public boolean UptateCleanerById(Cleaner cleaner) {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(cleaner);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}