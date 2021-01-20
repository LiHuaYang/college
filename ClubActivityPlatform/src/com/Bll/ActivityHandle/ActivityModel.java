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
	 *作者：movie
	 *时间：2015-12-14下午03:38:03
	 *函数名：
	 *功能：创建活动模型
	 *参数：
	 *返回值：
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
	 *作者：movie
	 *时间：2015-12-14下午03:38:32
	 *函数名：QueryActivityHandleById
	 *功能：根据活动ID查询活动
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：ActivityHandle
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
	 *作者：movie
	 *时间：2015-12-14下午03:39:26
	 *函数名：QueryActivityHandleByPlanId
	 *功能：根据任务方案查询活动
	 *参数：@param planId
	 *参数：@return 
	 *返回值：ActivityHandle
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
