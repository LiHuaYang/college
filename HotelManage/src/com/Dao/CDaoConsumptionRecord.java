package com.Dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.ConsumptionRecord;
import com.Test.HibernateUtil;

public class CDaoConsumptionRecord {

	
	//�½����Ѽ�¼
	public boolean CreateConsumptionRecord(ConsumptionRecord consumptionRecord){
        boolean result= false;
		try {
			Session session= HibernateUtil.getSession();
			session.beginTransaction();
			session.save(consumptionRecord);
			session.getTransaction().commit();
			HibernateUtil.closeSession();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//��ѯ���Ѽ�¼
	@SuppressWarnings("unchecked")
	public List<ConsumptionRecord> SearchConsumptionRecord(int UserId){
		List<ConsumptionRecord> consumptionRecord=new ArrayList<ConsumptionRecord>();
		try {
			Session session= HibernateUtil.getSession();
			session.beginTransaction();
			String hql="from ConsumptionRecord where UserId="+UserId;
			Query query=session.createQuery(hql);
			consumptionRecord=query.list();
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consumptionRecord;
	}
	//��ѯ�������Ѽ�¼
	public List<ConsumptionRecord> queryAllConsumptionRecords(){
		List<ConsumptionRecord> consumptionRecords = null;
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			consumptionRecords = session.createQuery("from ConsumptionRecord").list();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consumptionRecords;
	}
	
	//ͨ��ҳ���������Ѽ�¼
	public List<ConsumptionRecord> getConsumptionRecordPage(int page){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql="from ConsumptionRecord order by ConsumptionId asc";
		Query query=session.createQuery(sql);
		query.setFirstResult((page-1)*10);
		query.setMaxResults(10);
		List<ConsumptionRecord> findResult=query.list();
		session.getTransaction().commit();			
		session.close();
		return findResult;
		
	}
	
	//�鿴���Ѽ�¼��
	public int getConsumptionRecordNumber(){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int count=0;
		try {
			 count=((Long)session.createQuery("select count(ConsumptionId) from ConsumptionRecord ").iterate().next()).intValue(); 
			 session.getTransaction().commit();			
			 session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return (Integer)count;
	}
	
	
	
	
	
	
	
	
	
}
