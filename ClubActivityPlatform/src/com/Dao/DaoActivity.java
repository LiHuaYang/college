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
	 *���ߣ�movie
	 *ʱ�䣺2015-12-14����03:29:59
	 *��������QueryActivityNotFinished
	 *���ܣ���ѯδ���Ļ
	 *������@return 
	 *����ֵ��List<Activity>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����04:26:48
	 *��������CreateActivity
	 *���ܣ������
	 *������@param activity
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����04:32:50
	 *��������UpdateActivity
	 *���ܣ����»
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����01:43:23
	 *��������DeleteActivity
	 *���ܣ�ɾ���
	 *������@param activityId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����05:09:39
	 *��������CreateScheme
	 *���ܣ�������߻�
	 *������@param activityId
	 *������@param activityName
	 *������@param activityStartTime
	 *������@param activityEndTime
	 *������@param activityAddress
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����05:13:11
	 *��������UpdateActivityState
	 *���ܣ����»״̬
	 *������@param activityId
	 *������@param activityState
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����05:13:11
	 *��������UpdatePlotter
	 *���ܣ��޸Ļ�߻���
	 *������@param activityId
	 *������@param plotterId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����05:13:11
	 *��������UpdatePlanner
	 *���ܣ��޸����񷽰��ƶ���
	 *������@param activityId
	 *������@param plotterId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����05:13:11
	 *��������SubmitActivityResult
	 *���ܣ��ύ��ܽ�
	 *������@param activityId
	 *������@param activityResult
	 *����ֵ��boolean
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
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryHotActivity
	  *���ܣ���ѯ���ŵĻ
	  *������
	  *����ֵ��List<Activity>
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
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryAllActivityBulletin
	  *���ܣ���ѯ���л����
	  *������
	  *����ֵ��List<HashMap<String, Object>>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-12-21����11:16:01
	 *��������QueryActivityByUserparts
	 *���ܣ���ѯ�û��μӵ����л
	 *������@param userId
	 *������@return 
	 *����ֵ��List<HashMap<String,Object>>
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
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������SearchActivityBulletin
	  *���ܣ����������
	  *������
	  *����ֵ��List<HashMap<String, Object>>
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
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryActivityBulletinByOrganizationId
	  *���ܣ���ѯ��֯�����
	  *������
	  *����ֵ��List<HashMap<String, Object>>
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
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryActivityByOrganizationId
	  *���ܣ���ѯ��֯���л
	  *������
	  *����ֵ��List<Activity>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����03:42:02
	 *��������QueryActivityById
	 *���ܣ����ݻID��ѯ�
	 *������@param activityId
	 *������@return 
	 *����ֵ��Activity
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
