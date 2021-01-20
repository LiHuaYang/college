package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import com.Entity.Department;
import com.Entity.Mission;
import com.Tool.HIbernateSessionFactory;

public class DaoMission {
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午03:24:20
	 *函数名：CreateMission
	 *功能：批量增加子任务
	 *参数：@param missions
	 *返回值：boolean
	 */
	public boolean CreateMission(List<Mission> missions){
		boolean result=false;
		 try {
			
				Session session= HIbernateSessionFactory.beforeClass().openSession();
				session.beginTransaction();
				session.clear();
				String sql="insert into Mission(planId,missionExecutorId,missionContent,missionPromoterId,missionType,missionTime) values";
				for (int i = 0; i < missions.size(); i++) {
					sql+="("+missions.get(i).getPlanId()+","+missions.get(i).getMissionExecutorId()+",'"+missions.get(i).getMissionContent()+"',"+missions.get(i).getMissionPromoterId()+","+missions.get(i).getMissionType()+",'"+missions.get(i).getMissionTime()+"'),";
				}
				sql=sql.substring(0, sql.length()-1); 
				SQLQuery sqlQuery=session.createSQLQuery(sql);
				sqlQuery.executeUpdate();
				session.getTransaction().commit();
				session.close();
				result=true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午06:21:35
	 *函数名：DeleteMissionByPlanId
	 *功能：根据任务方案id删除子任务
	 *参数：@param PlanId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteMissionByPlanId(int PlanId){
		boolean result=false;
		try {
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			
			String hql="delete Mission where planId="+PlanId;
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
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午06:21:35
	 *函数名：DeleteMission
	 *功能：根据主键id删除子任务
	 *参数：@param missionid
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteMission(int missionid){
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			String hql="delete Mission where missionId="+missionid;
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
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午03:53:11
	 *函数名：queryMissionsByPlanId
	 *功能：根据任务方案ID查询子任务列表
	 *参数：@param planId 
	 *返回值：Plan
	 */
	public List<Mission> queryMissionsByPlanId(int planId){
		List<Mission> mission=new ArrayList<Mission>();
		try {
		
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Mission where planId="+planId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			mission=query.list();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mission;
	}
	
	 /**作者：movie
	 *时间：2015-10-14下午01:48:04
	 *函数名：QueryMissionById
	 *功能：根据ID查找子任务详情
	 *参数：@param missionId
	 *返回值：Mission
	 */
	public Mission QueryMissionById(int missionId){
		Mission mission=null;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			mission=(Mission) session.get(Department.class, missionId);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mission;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午06:42:29
	 *函数名：SubmitMissionResult
	 *功能：提交任务总结
	 *参数：@param missionId
	 *参数：@param missionResult
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SubmitMissionResult(int missionId,String missionResult){
		boolean result = false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			Mission mission=(Mission) session.load(Mission.class, missionId);
			mission.setMissionResult(missionResult);
			session.getTransaction().commit();
			session.close();
			
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-22下午03:23:56
	 *函数名：QueryMissionBymissionExecutorId
	 *功能：根据用户查询他收到的子任务
	 *参数：@param missionExecutorId
	 *参数：@return 
	 *返回值：List<Mission>
	 */
	public List<Mission> QueryMissionBymissionExecutorId(int missionExecutorId){
		List<Mission> missions=new ArrayList<Mission>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Mission where missionExecutorId="+missionExecutorId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			missions=query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return missions;
	}
}
