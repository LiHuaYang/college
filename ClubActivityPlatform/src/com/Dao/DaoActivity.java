package com.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.Activity;
import com.Tool.HIbernateSessionFactory;
import com.Tool.MyConstant.ActivityState;
import com.Tool.MyConstant.ActivityType;
import com.Tool.MyConstant.HotNum;

public class DaoActivity {

	
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-14下午03:29:59
	 *函数名：QueryActivityNotFinished
	 *功能：查询未完结的活动
	 *参数：@return 
	 *返回值：List<Activity>
	 */
	public List<Activity> QueryActivityNotFinished(){
		List<Activity> activities=new ArrayList<Activity>();
		try {
			Session session=HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String sql="from Activity where activityState <"+ActivityState.END_STAGE;
			Query query=session.createQuery(sql);
			activities=query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return activities;
	} 
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午04:26:48
	 *函数名：CreateActivity
	 *功能：创建活动
	 *参数：@param activity
	 *返回值：boolean
	 */
	public int CreateActivity(Activity activity){

		int result = 0;
		try {
		
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			session.save(activity);
			result = activity.getActivityId();
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午04:32:50
	 *函数名：UpdateActivity
	 *功能：更新活动
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdateActivity(Activity activity){
		boolean result = false;
		try {
		
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			session.update(activity);
			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午01:43:23
	 *函数名：DeleteActivity
	 *功能：删除活动
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteActivity(int activityId){
		boolean result = false;
		try {
		
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			String hql="delete Activity where activityId="+activityId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;	
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午05:09:39
	 *函数名：CreateScheme
	 *功能：创建活动策划
	 *参数：@param activityId
	 *参数：@param activityName
	 *参数：@param activityStartTime
	 *参数：@param activityEndTime
	 *参数：@param activityAddress
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreateScheme(int activityId,String activityName,String activityStartTime,String activityEndTime,String activityAddress){
		boolean result = false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			Activity activity=(Activity) session.load(Activity.class, activityId);
			activity.setActivityName(activityName);
			activity.setActivityStartTime(activityStartTime);
			activity.setActivityEndTime(activityEndTime);
			activity.setActivityAddress(activityAddress);
			session.close();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午05:13:11
	 *函数名：UpdateActivityState
	 *功能：跟新活动状态
	 *参数：@param activityId
	 *参数：@param activityState
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdateActivityState(int activityId,int activityState){
		boolean result = false;
		try {
		
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			Activity activity=(Activity) session.load(Activity.class, activityId);
			activity.setActivityState(activityState);
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
	 *时间：2015-10-14下午05:13:11
	 *函数名：UpdatePlotter
	 *功能：修改活动策划人
	 *参数：@param activityId
	 *参数：@param plotterId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdatePlotter(int activityId,int plotterId){
		boolean result = false;
		try {
		
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			Activity activity=(Activity) session.load(Activity.class, activityId);
			activity.setPlotterId(plotterId);
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
	 *时间：2015-10-14下午05:13:11
	 *函数名：UpdatePlanner
	 *功能：修改任务方案制定人
	 *参数：@param activityId
	 *参数：@param plotterId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdatePlanner(int activityId,int plannerId){
		boolean result = false;
		try {
		
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			Activity activity=(Activity) session.load(Activity.class, activityId);
			activity.setPlannerId(plannerId);
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
	 *时间：2015-10-14下午05:13:11
	 *函数名：SubmitActivityResult
	 *功能：提交活动总结
	 *参数：@param activityId
	 *参数：@param activityResult
	 *返回值：boolean
	 */
	public boolean SubmitActivityResult(int activityId,String activityResult){
		boolean result = false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			Activity activity=(Activity) session.load(Activity.class, activityId);
			activity.setActivityResult(activityResult);
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
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryHotActivity
	  *功能：查询热门的活动
	  *参数：
	  *返回值：List<Activity>
	  */
	public List<Activity> QueryHotActivity(){
		List<Activity> activities=new ArrayList<Activity>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Activity where activityState >="+ActivityState.GOING_STAGE+" and activityType!="+ActivityType.IN+" order by activityState";
			Query query=session.createQuery(hql);query.setCacheable(false);
			query.setFirstResult(0);
			query.setMaxResults(HotNum.HOTACTIVITYNUM);
			activities=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return activities;
	}
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryAllActivityBulletin
	  *功能：查询所有活动布告
	  *参数：
	  *返回值：List<HashMap<String, Object>>
	  */
	public List<HashMap<String, Object>> QueryAllActivityBulletin(){
		List<HashMap<String, Object>> activitybulletin=new ArrayList<HashMap<String,Object>>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String sql="select activity.activityId,activity.activityName,activestage.activestagePic,activestage.activestageContent,activity.activityAddress,activity.activityState,activityStartTime,activityEndTime,activity.activityBelongId from activity,activestage where activestage.activestageId=(select min(activestage.activestageId) from activestage where  activity.activityId=activestage.activityId and activityType="+ActivityType.out+" and activityState >="+ActivityState.GOING_STAGE+")";
			Query query=session.createSQLQuery(sql);
			List<Object[]> objects=query.list();
			for(Object[] object : objects){    
				HashMap<String, Object> map=new HashMap<String, Object>();
				int activityId = Integer.parseInt(String.valueOf(object[0]));
				String activityName = (String)object[1];    
				String activestagePic= (String)object[2];  
				String activestageContent=(String)object[3];
				String activityAddress=(String)object[4];
				int activityState=Integer.parseInt(String.valueOf(object[5]));
				String activityStartTime=(String)object[6];
				String activityEndTime=(String)object[7];
				int activityBelongId=Integer.parseInt(String.valueOf(object[8]));
	            map.put("activityId", activityId);
	            map.put("activityName", activityName);
	            map.put("activestagePic", activestagePic);
	            map.put("activestageContent", activestageContent);
	            map.put("activityAddress", activityAddress);
	            map.put("activityState", activityState);
	            map.put("activityStartTime", activityStartTime);
	            map.put("activityEndTime", activityEndTime);
	            map.put("activityBelongId", activityBelongId);
	            activitybulletin.add(map);
	        }    
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return activitybulletin;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-21上午11:16:01
	 *函数名：QueryActivityByUserparts
	 *功能：查询用户参加的所有活动
	 *参数：@param userId
	 *参数：@return 
	 *返回值：List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> QueryActivityByUserparts(int userId){
		List<HashMap<String, Object>> activitybulletin=new ArrayList<HashMap<String,Object>>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String sql="select activity.activityId,activity.activityName,activestage.activestagePic,activestage.activestageContent,activity.activityAddress,activity.activityState,activityStartTime,activityEndTime,activity.activityBelongId from activity,activestage,participants where activestage.activestageId=(select min(activestage.activestageId) from activestage WHERE activity.activityId =  activestage.activityId AND activity.activityType ="+ActivityType.out+" AND activity.activityState >= "+ActivityState.GOING_STAGE+") and activity.activityId = participants.activityId and participants.participantsId="+userId;
			Query query=session.createSQLQuery(sql);
			List<Object[]> objects=query.list();
			for(Object[] object : objects){    
				HashMap<String, Object> map=new HashMap<String, Object>();
				int activityId = Integer.parseInt(String.valueOf(object[0]));
				String activityName = (String)object[1];    
				String activestagePic= (String)object[2];  
				String activestageContent=(String)object[3];
				String activityAddress=(String)object[4];
				int activityState=Integer.parseInt(String.valueOf(object[5]));
				String activityStartTime=(String)object[6];
				String activityEndTime=(String)object[7];
				int activityBelongId=Integer.parseInt(String.valueOf(object[8]));
	            map.put("activityId", activityId);
	            map.put("activityName", activityName);
	            map.put("activestagePic", activestagePic);
	            map.put("activestageContent", activestageContent);
	            map.put("activityAddress", activityAddress);
	            map.put("activityState", activityState);
	            map.put("activityStartTime", activityStartTime);
	            map.put("activityEndTime", activityEndTime);
	            map.put("activityBelongId", activityBelongId);
	            activitybulletin.add(map);
	        }    
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return activitybulletin;
	}
	/**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：SearchActivityBulletin
	  *功能：搜索活动布告
	  *参数：
	  *返回值：List<HashMap<String, Object>>
	  */
	public List<HashMap<String, Object>> SearchActivityBulletin(String activityname,String activityaddress){
		List<HashMap<String, Object>> activitybulletin=new ArrayList<HashMap<String,Object>>();
		try {
		
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String sql="select activity.activityId,activity.activityName,activestage.activestagePic,activestage.activestageContent,activity.activityAddress,activity.activityState,activityStartTime,activityEndTime,activityBelongId from activity,activestage where activestage.activestageId=(select min(activestage.activestageId) from activestage where  activity.activityId=activestage.activityId and activityType="+ActivityType.out+" and activityState >="+ActivityState.GOING_STAGE+" and activityName like '%"+activityname+"%' and activityAddress like '%"+activityaddress+"%')";
			Query query=session.createSQLQuery(sql);
			List<Object[]> objects=query.list();
			for(Object[] object : objects){    
				HashMap<String, Object> map=new HashMap<String, Object>();
				int activityId = Integer.parseInt(String.valueOf(object[0]));
				String activityName = (String)object[1];    
				String activestagePic= (String)object[2];  
				String activestageContent=(String)object[3];
				String activityAddress=(String)object[4];
				int activityState=Integer.parseInt(String.valueOf(object[5]));
				String activityStartTime=(String)object[6];;
				String activityEndTime=(String)object[7];
				int activityBelongId=Integer.parseInt(String.valueOf(object[8]));
	            map.put("activityId", activityId);
	            map.put("activityName", activityName);
	            map.put("activestagePic", activestagePic);
	            map.put("activestageContent", activestageContent);
	            map.put("activityAddress", activityAddress);
	            map.put("activityState", activityState);
	            map.put("activityStartTime", activityStartTime);
	            map.put("activityEndTime", activityEndTime);
	            map.put("activityBelongId", activityBelongId);
	            activitybulletin.add(map);
	        }    
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return activitybulletin;
	}
	
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryActivityBulletinByOrganizationId
	  *功能：查询组织活动布告
	  *参数：
	  *返回值：List<HashMap<String, Object>>
	  */
	public List<HashMap<String, Object>> QueryActivityBulletinByOrganizationId(int organizationid){
		List<HashMap<String, Object>> activitybulletin=new ArrayList<HashMap<String,Object>>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String sql="select activity.activityId,activity.activityName,activestage.activestagePic,activity.activityState from activity,activestage where activestage.activestageId=(select min(activestage.activestageId) from activestage where  activity.activityId=activestage.activityId and activityType="+ActivityType.out+" and activityState >="+ActivityState.GOING_STAGE+" and activity.activityBelongId="+organizationid+" )";
			
			Query query=session.createSQLQuery(sql);
			List<Object[]> objects=query.list();
			for(Object[] object : objects){    
				HashMap<String, Object> map=new HashMap<String, Object>();
				int activityId = Integer.parseInt(String.valueOf(object[0]));
				String activityName = (String)object[1];    
				String activestagePic= (String)object[2];  
				int activityState=Integer.parseInt(String.valueOf(object[3]));
	            map.put("activityId", activityId);
	            map.put("activityName", activityName);
	            map.put("activestagePic", activestagePic);
	            map.put("activityState", activityState);
	            activitybulletin.add(map);
	        }    
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return activitybulletin;
	}
	

	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryActivityByOrganizationId
	  *功能：查询组织所有活动
	  *参数：
	  *返回值：List<Activity>
	  */
	public List<Activity> QueryAllActivityByOrganizationId(int organizationid){
		List<Activity> activities=new ArrayList<Activity>();
		try {
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Activity where activityBelongId="+organizationid;
			Query query=session.createQuery(hql);query.setCacheable(false);
			activities=query.list();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return activities;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午03:42:02
	 *函数名：QueryActivityById
	 *功能：根据活动ID查询活动
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：Activity
	 */
	public Activity QueryActivityById(int activityId){
		Activity activity=null;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			activity=(Activity) session.get(Activity.class, activityId);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activity;
	}
	
	
}
