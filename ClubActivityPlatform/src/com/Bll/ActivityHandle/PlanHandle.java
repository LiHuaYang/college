package com.Bll.ActivityHandle;

import java.util.List;

import com.Dao.DaoFrame;
import com.Dao.IDaoFrame;
import com.Entity.Mission;
import com.Entity.Plan;

//任务方案处理类
public class PlanHandle {

	private	int	planId	;//	任务方案ID
	private	String	planName	;//	任务方案名称
	private	int	planCreatorId	;//	任务方案制定人ID
	private	String	planContent	;//	方案总内容
	private List<Mission> missionHandles;//子任务列表
	private IDaoFrame daoFrame=new DaoFrame();
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-14下午01:59:47
	 *函数名：
	 *功能：获取数据库中任务方案到缓存中
	 *参数：
	 *返回值：
	 */
	public PlanHandle(int activityId,int planCreatorId){   
		Plan plan=daoFrame.QueryPlanByActivityId(activityId);
		this.planId=plan.getPlanId();
		this.planName=plan.getPlanName();
		this.planCreatorId=planCreatorId;
		this.planContent=plan.getPlanContent();
		this.missionHandles=daoFrame.queryMissionsByPlanId(planId);
		
	}
	
	public PlanHandle(int planCreatorId) {
		this.planCreatorId=planCreatorId;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午01:57:47
	 *函数名：deletePlan
	 *功能：删除任务方案
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean deletePlan() {
		planName=null;
		planContent=null;
		missionHandles=null;
		return true;
		
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午04:43:34
	 *函数名：changePlanerId
	 *功能：改变任务方案制定人
	 *参数：@param activityId
	 *参数：@param plannerId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean changePlanerId(int plannerId) {
		this.planCreatorId=plannerId;
		return true;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午04:44:01
	 *函数名：CreatePlan
	 *功能：创建任务方案
	 *参数：@param planName
	 *参数：@param planContent
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreatePlan(Plan plan) {
		this.planContent=plan.getPlanContent();
		this.planName=plan.getPlanName();
		return true;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午07:47:33
	 *函数名：CreateActivityMission
	 *功能：创建子任务(包括更新)
	 *参数：@param mission
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreateActivityMission(List<Mission> mission) {
		missionHandles=mission;
		return true;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午09:23:28
	 *函数名：SavePlan
	 *功能：任务方案审核通过
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SavePlan(int activityId){
		this.planId=daoFrame.CreatePlan(ToPlan(activityId));
		boolean result=daoFrame.CreateMission(this.missionHandles);
		this.missionHandles=daoFrame.queryMissionsByPlanId(this.planId);
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18上午10:54:59
	 *函数名：SumbitActivityMissionResult
	 *功能：提交任务总结
	 *参数：@param missionId
	 *参数：@param missionResult
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SumbitActivityMissionResult(int missionId,String missionResult) {
		boolean result=false;
	
		for (int i = 0; i < missionHandles.size(); i++) {
		
			if (missionHandles.get(i).getMissionId()==missionId) {
				missionHandles.get(i).setMissionResult(missionResult);
				result=daoFrame.SubmitMissionResult(missionId, missionResult);
				break;
			}
		}
		return result;
	}
	
	
	
	
	public Plan ToPlan(int activityId){
		Plan plan=new Plan(this.planId,this.planName, activityId, this.planCreatorId, this.planContent);
		return plan;
	}
	
	public int getPlanCreatorId() {
		return planCreatorId;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public List<Mission> getmisMissions(){
		return missionHandles;
	}
	
	


	

	
}
