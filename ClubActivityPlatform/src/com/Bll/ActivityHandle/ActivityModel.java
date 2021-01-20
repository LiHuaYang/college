package com.Bll.ActivityHandle;

import java.util.ArrayList;
import java.util.List;

import com.Dao.DaoFrame;
import com.Dao.IDaoFrame;
import com.Entity.Activity;

public class ActivityModel {
	private List<ActivityHandle> activityHandles=new ArrayList<ActivityHandle>();
	IDaoFrame daoFrame=new DaoFrame();
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-14����03:38:03
	 *��������
	 *���ܣ������ģ��
	 *������
	 *����ֵ��
	 */
	public void getDateActivityModel(){
		List<Activity> activities=daoFrame.QueryActivityNotFinished();
		for (int i = 0; i < activities.size(); i++) {
			ActivityHandle handle=new ActivityHandle(activities.get(i),1);
			activityHandles.add(handle);
		}
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-14����03:38:32
	 *��������QueryActivityHandleById
	 *���ܣ����ݻID��ѯ�
	 *������@param activityId
	 *������@return 
	 *����ֵ��ActivityHandle
	 */
	public ActivityHandle QueryActivityHandleById(int activityId){
		ActivityHandle activityHandle=null;
		for (int i = 0; i < activityHandles.size(); i++) {
			if (activityId==activityHandles.get(i).getActivityId()) {
				activityHandle=activityHandles.get(i);
				break;
			}
		}
		return activityHandle;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-14����03:39:26
	 *��������QueryActivityHandleByPlanId
	 *���ܣ��������񷽰���ѯ�
	 *������@param planId
	 *������@return 
	 *����ֵ��ActivityHandle
	 */
	public ActivityHandle QueryActivityHandleByPlanId(int planId){
		ActivityHandle activityHandle=null;
		for (int i = 0; i < activityHandles.size(); i++) {
			if (planId==activityHandles.get(i).getPlanHandle().getPlanId()) {
				activityHandle=activityHandles.get(i);
				break; 
			}
		}
		return activityHandle;
	}
	
	
	public boolean AddActivity(Activity activity){
		ActivityHandle activityHandle=new ActivityHandle(activity);
		boolean result= activityHandles.add(activityHandle);
		return result;
	}
	
	public boolean RemoveAvtivity(int AcitivityId){
		boolean result=false;
		for (int i = 0; i <activityHandles.size(); i++) {
			if (AcitivityId==activityHandles.get(i).getActivityId()) {
				result=activityHandles.get(i).deleteActivity();
				activityHandles.remove(i);
				break;
			}  
		}
		return result;
	}
	
	
	public List<Activity> getActivity() {
		List<Activity> activities=new ArrayList<Activity>();
		for (int i = 0; i < activityHandles.size(); i++) {
			activities.add(activityHandles.get(i).toActivity());
		}

		return activities;
	}
	
	public int getsize(){
		return activityHandles.size();
		
	}
	public ActivityHandle get(int num){
		return activityHandles.get(num);
	}
	
	
}
