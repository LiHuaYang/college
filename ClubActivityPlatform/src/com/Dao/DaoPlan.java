package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.Plan;
import com.Tool.HIbernateSessionFactory;


public class DaoPlan {
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-16����08:33:14
	 *��������QueryPlanById
	 *���ܣ�����ID��ѯ���񷽰�
	 *������@param planId
	 *������@return 
	 *����ֵ��Plan
	 */
	public Plan QueryPlanById(int planId){
		Plan plan=null;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Plan where planId="+planId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			List<Plan> plans= query.list();
			if (plans.size()!=0) {
				plan=plans.get(0);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plan;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����03:53:11
	 *��������QueryPlanByActivityId
	 *���ܣ����ݻID��ѯ���񷽰�
	 *������@param activityId
	 *������@return 
	 *����ֵ��Plan
	 */
	public Plan QueryPlanByActivityId(int activityId){
		Plan plan=null;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Plan where activityId="+activityId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			List<Plan> plans= query.list();
			if (plans.size()!=0) {
				plan=plans.get(0);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plan;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����03:53:11
	 *��������QueryPlanByPlanCreatorId
	 *���ܣ�������������ID��ѯ���񷽰�
	 *������@param activityId
	 *������@return 
	 *����ֵ��Plan
	 */
	public List<Plan> QueryPlanByPlanCreatorId(int planCreatorId){
		List<Plan> plans=new ArrayList<Plan>();
		try {
			
			Session  session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Plan where planCreatorId="+planCreatorId+" order by planId desc";
			Query query=session.createQuery(hql);query.setCacheable(false);
			 plans= query.list();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  plans;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����06:08:11
	 *��������CreatePlan
	 *���ܣ��½����񷽰�
	 *������@param plan
	 *������@return 
	 *����ֵ��boolean
	 */
	public int CreatePlan(Plan plan){
		int planId=0;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			session.save(plan);
			planId=plan.getPlanId();
			session.beginTransaction().commit();
			
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return planId;
	}

	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����06:17:37
	 *��������DeletePlan
	 *���ܣ�ɾ�����񷽰�
	 *������@param PlanId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean DeletePlan(int PlanId){
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			String hql="delete Plan where planId="+PlanId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			query.executeUpdate();
			session.getTransaction().commit();
			result=true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
