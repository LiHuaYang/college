package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Entity.Transaction;
import com.Entity.User;
import com.Test.HibernateUtil;

public class CDaoTransaction {

	// 新建交易
	public boolean CreateTransaction(Transaction transaction) {
		boolean result = false;
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(transaction);
			session.getTransaction().commit();
			HibernateUtil.closeSession();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 查询交易
	public List<Transaction> QueryTransaction() {
		List<Transaction> transaction = new ArrayList<Transaction>();
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			String hql = "from Transaction";
			Query query = session.createQuery(hql);
			transaction = query.list();
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transaction;
	}
	
	//通过用户id查询交易记录
	public List<Transaction> Querybyuserid(int userid){
	    List<Transaction> transaction=new ArrayList<Transaction>();	
	
	    try {
			 Session session=HibernateUtil.getSession();
			 session.beginTransaction();
			 String hql="from Transaction where Userid= '"+userid+"'";
			 Query query=session.createQuery(hql);
			 transaction=query.list();
			 HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return transaction;
	}
	
}
