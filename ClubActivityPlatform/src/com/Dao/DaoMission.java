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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����03:24:20
	 *��������CreateMission
	 *���ܣ���������������
	 *������@param missions
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����06:21:35
	 *��������DeleteMissionByPlanId
	 *���ܣ��������񷽰�idɾ��������
	 *������@param PlanId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����06:21:35
	 *��������DeleteMission
	 *���ܣ���������idɾ��������
	 *������@param missionid
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����03:53:11
	 *��������queryMissionsByPlanId
	 *���ܣ��������񷽰�ID��ѯ�������б�
	 *������@param planId 
	 *����ֵ��Plan
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
	
	 /**���ߣ�movie
	 *ʱ�䣺2015-10-14����01:48:04
	 *��������QueryMissionById
	 *���ܣ�����ID��������������
	 *������@param missionId
	 *����ֵ��Mission
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����06:42:29
	 *��������SubmitMissionResult
	 *���ܣ��ύ�����ܽ�
	 *������@param missionId
	 *������@param missionResult
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-22����03:23:56
	 *��������QueryMissionBymissionExecutorId
	 *���ܣ������û���ѯ���յ���������
	 *������@param missionExecutorId
	 *������@return 
	 *����ֵ��List<Mission>
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
