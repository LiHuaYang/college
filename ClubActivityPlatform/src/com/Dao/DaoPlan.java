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
	 *作者：movie
	 *时间：2015-12-16下午08:33:14
	 *函数名：QueryPlanById
	 *功能：根据ID查询任务方案
	 *参数：@param planId
	 *参数：@return 
	 *返回值：Plan
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
	 *作者：movie
	 *时间：2015-10-14下午03:53:11
	 *函数名：QueryPlanByActivityId
	 *功能：根据活动ID查询任务方案
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：Plan
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
	 *作者：movie
	 *时间：2015-10-14下午03:53:11
	 *函数名：QueryPlanByPlanCreatorId
	 *功能：根据任务发起人ID查询任务方案
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：Plan
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
	 *作者：movie
	 *时间：2015-10-14下午06:08:11
	 *函数名：CreatePlan
	 *功能：新建任务方案
	 *参数：@param plan
	 *参数：@return 
	 *返回值：boolean
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
	 *作者：movie
	 *时间：2015-10-14下午06:17:37
	 *函数名：DeletePlan
	 *功能：删除任务方案
	 *参数：@param PlanId
	 *参数：@return 
	 *返回值：boolean
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
