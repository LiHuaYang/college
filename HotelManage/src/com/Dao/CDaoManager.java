package com.Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.Manager;
import com.Test.HibernateUtil;

public class CDaoManager {
	// ���ӹ���Ա
	public boolean AddManager(Manager manager) {
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			s.save(manager);
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// ͨ���ʺ�������ҹ���Ա
	public Manager QueryManagerByMessage(String ManagerAccount,
			String ManagerPassword) {
		Manager manager = null;
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			Query query = s
					.createQuery("from Manager where ManagerAccount = ? and ManagerPassword = ?");
			query.setParameter(0, ManagerAccount);
			query.setParameter(1, ManagerPassword);
			manager = (Manager) query.uniqueResult();
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manager;
	}

	// ͨ������Աid���ҹ���Ա
	public Manager QuerManagerById(int ManagerId) {
		Manager manager = null;
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			Query query = s.createQuery("from Manager where ManagerId = ?")
					.setParameter(0, ManagerId);
			manager = (Manager) query.uniqueResult();
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manager;
	}

	// �޸Ĺ���Ա��Ϣ
	public boolean UpdateManager(Manager manager) {
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			s.update(manager);
			s.getTransaction().commit();
			s.close();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// ɾ������Ա
	public boolean DeleteManager(Manager manager) {
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			manager.setManagerState(-1);
			s.update(manager);
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
