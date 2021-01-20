package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.RechargeRecord;
import com.Test.HibernateUtil;

public class CDaoRechargeRecord {

	// �½���ֵ��¼��
	public boolean CreateRecode(RechargeRecord rechargeRecord) {

		boolean result = false;

		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(rechargeRecord);
			session.getTransaction().commit();
			HibernateUtil.closeSession();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// ��ѯ��ֵ��¼
	@SuppressWarnings("unchecked")
	public List<RechargeRecord> SearchRecode(int UserId) {
		List<RechargeRecord> rechargeRecord = new ArrayList<RechargeRecord>();

		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			String hql = "from RechargeRecord where UserId=" + UserId;
			Query query = session.createQuery(hql);
			rechargeRecord = query.list();
			session.getTransaction().commit();
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rechargeRecord;
	}

	// ��ѯ���г�ֵ��¼
	public List<RechargeRecord> queryRechargeRecords() {
		List<RechargeRecord> rechargeRecords = new ArrayList<RechargeRecord>();
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			rechargeRecords = session.createQuery("from RechargeRecord").list();
			session.getTransaction().commit();
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rechargeRecords;
	}

	// ͨ��ҳ�����ҳ�ֵ��¼
	public List<RechargeRecord> getRecordRecordByPage(int page) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "from RechargeRecord order by RechargeId asc";
		Query query = session.createQuery(sql);
		query.setFirstResult((page - 1) * 10);
		query.setMaxResults(10);
		List<RechargeRecord> findResult = query.list();
		session.getTransaction().commit();
		session.close();
		return findResult;
	}

	// �鿴��ֵ��¼����
	public int getRechargeRecordNumber() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int count = 0;
		try {
			count = ((Long) session.createQuery(
					"select count(RechargeId) from RechargeRecord ").iterate()
					.next()).intValue();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (Integer) count;
	}

}
