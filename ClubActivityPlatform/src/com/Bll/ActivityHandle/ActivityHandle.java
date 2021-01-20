package com.Bll.ActivityHandle;

import java.util.List;

import com.Dao.DaoFrame;
import com.Dao.IDaoFrame;
import com.Entity.Activestage;
import com.Entity.Activity;
import com.Entity.Mission;
import com.Entity.Participants;
import com.Entity.Plan;
import com.Tool.MyConstant;
import com.Tool.MyConstant.ActivityState;
import com.Tool.MyConstant.ExamineType;

//活动处理类
public class ActivityHandle {
	private int activityId;//活动ID
	private int  activityBelongId;//活动所属组织ID
	private int activityType;//活动类型（对内对外）
	private int activityState;//活动状态(提出，策划等)
	private String activityResult;//活动总结
	private String activityIntention;//活动意向
	
	private PlanHandle planHandle;//任务方案处理
	private SchemeHandle schemeHandle;//活动策划处理
	private ActivityPersonnelHandle activityPersonnelHandle;//活动参与人处理
	private  ActivityBulletinHandle activityBulletinHandle;//活动布告处理
	
	private IDaoFrame daoFrame=new DaoFrame();
	
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-14下午03:17:52
	 *函数名：
	 *功能：从数据库中取出数据构建控制类
	 *参数：
	 *返回值：
	 */
	public ActivityHandle(Activity activity,int num){
		this.activityId=activity.getActivityId();
		this.activityBelongId=activity.getActivityBelongId();
		this.activityType=activity.getActivityType();
		this.activityState=activity.getActivityState();
		this.activityIntention=activity.getActivityIntention();
		
		this.planHandle=new PlanHandle(activity.getPlannerId());
		this.schemeHandle=new SchemeHandle(activity.getPlotterId());
		
		if (activityState>ActivityState.SCHEME_AUDIT_STAGE) {
			this.schemeHandle=new SchemeHandle(activity);
		}
		if (activityState>ActivityState.PLANNING_AUDIT_STAGE) {
			this.planHandle=new PlanHandle(activityId, activity.getPlannerId());
			this.activityPersonnelHandle=new ActivityPersonnelHandle(activityId);
			this.activityBulletinHandle=new ActivityBulletinHandle(activityId);
			
		}
		this.activityResult=activity.getActivityResult();
		
		
				
		
		
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午02:06:15
	 *函数名： 构造函数
	 *功能：创建活动
	 *参数：活动所属组织ID,活动策划人,任务方案制定人，活动意向，活动类型
	 *返回值：
	 */
	public ActivityHandle(Activity activity){
		this.activityBelongId=activity.getActivityBelongId();
		this.activityType=0;
		this.activityState=MyConstant.ActivityState.SCHEME_STAGE;
		activity.setActivityState(this.activityState);
		this.activityIntention=activity.getActivityIntention();
		this.planHandle=new PlanHandle(activity.getPlannerId());
		this.schemeHandle=new SchemeHandle(activity.getPlotterId());
		this.activityId=daoFrame.CreateActivity(activity);
		
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午01:45:11
	 *函数名：deleteActivity
	 *功能：删除活动
	 *参数： 
	 *返回值：void
	 */
	public boolean deleteActivity(){
		boolean result=false;
		if (this.activityState<=ActivityState.PLANNING_AUDIT_STAGE) {
			result=daoFrame.DeleteActivity(this.activityId);
			schemeHandle.deleteScheme();
			planHandle.deletePlan();
			
		}
		return result;
	}
	
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18上午10:50:04
	 *函数名：SubmitActivityPlanResult
	 *功能：提交活动总结
	 *参数：@param missionResult
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SubmitActivityPlanResult(String activityResult){
		boolean result=false;
		if (this.activityState==ActivityState.SUMMARY_STAGE){
			this.activityState=ActivityState.END_STAGE;
			this.activityResult=activityResult;
			result=daoFrame.UpdateActivity(toActivity());
			
		}
		return result;
	}
	
	
	/*************************************************  活动策划  **********************************************************************************/
	
	
	
	


	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午03:41:38
	 *函数名：SubmitScheme
	 *功能：提交活动策划
	 *参数：@param activityName
	 *参数：@param activityStartTime
	 *参数：@param activityEndTime
	 *参数：@param activityAddress
	 *参数：@param activityFileUrl
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SubmitScheme(String activityName,String activityStartTime,String activityEndTime,String activityAddress,String activityFileUrl){
		boolean result=false;
			if (this.activityState==ActivityState.SCHEME_STAGE) {
				schemeHandle.SubmitScheme(activityName,activityStartTime,activityEndTime,activityAddress,activityFileUrl);
				this.activityState=ActivityState.SCHEME_AUDIT_STAGE;
				result=daoFrame.UpdateActivityState(this.activityId, this.activityState);
			}
		return result;
	}

	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午03:56:58
	 *函数名：changePlotterId
	 *功能：改变活动策划人
	 *参数：@param PlotterId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean  changePlotterId(int PlotterId){
		boolean result=false;
		if (this.activityState==ActivityState.SCHEME_STAGE) {
			result=schemeHandle.changePlotterId(PlotterId);
		}
		return result;
	}

	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午04:30:41
	 *函数名：examineScheme
	 *功能：审核活动策划
	 *参数：@param examineType
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean examineScheme(int examineType){
		boolean result=false;
		if (this.activityState==ActivityState.SCHEME_AUDIT_STAGE) {
			if (examineType==ExamineType.SUCCESS) {
				this.activityState=ActivityState.PLANNING_STAGE;
				schemeHandle.saveScheme(this.activityId);
			}
			else {
				this.activityState=ActivityState.SCHEME_STAGE;
				schemeHandle.deleteScheme();
			}
		}
		result=daoFrame.UpdateActivityState(this.activityId, this.activityState);
		return result;
	} 
	
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午03:41:38
	 *函数名：ChangeScheme
	 *功能：修改活动策划
	 *参数：@param activityName
	 *参数：@param activityStartTime
	 *参数：@param activityEndTime
	 *参数：@param activityAddress
	 *参数：@param activityFileUrl
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean ChangeScheme(String activityName,String activityStartTime,String activityEndTime,String activityAddress,String activityFileUrl){
		boolean result=false;
		if (this.activityState==ActivityState.SCHEME_AUDIT_STAGE) {
			result=schemeHandle.SubmitScheme(activityName,activityStartTime,activityEndTime,activityAddress,activityFileUrl);
		}
		return result;
	}
	/*************************************************  任务方案    **********************************************************************************/
	
	
	
	
	
	

	
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午04:02:10
	 *函数名：changePlanerId
	 *功能：修改任务方案制定人
	 *参数：@param plannerId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean changePlanerId(int plannerId){
		boolean result=false;
		if (this.activityState<=ActivityState.PLANNING_STAGE) {
			result=planHandle.changePlanerId(plannerId);
		}
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午09:49:40
	 *函数名：getPlan
	 *功能：获取任务计划
	 *参数：@return 
	 *返回值：Plan
	 */
	public Plan getPlan(){
		Plan plan=null;
		if (planHandle!=null) {
			plan=planHandle.ToPlan(this.activityId);
		}
		return plan; 
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午05:20:54
	 *函数名：CreatePlan
	 *功能：创建任务方案
	 *参数：@param planName
	 *参数：@param planContent
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreatePlan(Plan plan){
		boolean result=false;
		if (this.activityState==ActivityState.PLANNING_STAGE){
			result=planHandle.CreatePlan(plan);
			
		}
		
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午05:20:54
	 *函数名：CreatePlan
	 *功能：修改任务方案
	 *参数：@param planName
	 *参数：@param planContent
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdatePlan(Plan plan){
		boolean result=false;
		if (this.activityState==ActivityState.PLANNING_AUDIT_STAGE){
			result=planHandle.CreatePlan(plan);
		}
		
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午08:57:25
	 *函数名：CreateActivityMission
	 *功能：创建子任务，提交任务方案
	 *参数：@param mission
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreateActivityMission(List<Mission> mission){
		boolean result=false;
		if (this.activityState==ActivityState.PLANNING_STAGE){
			planHandle.CreateActivityMission(mission);
			this.activityState=ActivityState.PLANNING_AUDIT_STAGE;
			result=daoFrame.UpdateActivityState(this.activityId, this.activityState);
		}
		return result;
	}
	
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午08:57:25
	 *函数名：ChangeActivityMission
	 *功能：修改子任务
	 *参数：@param mission
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean ChangeActivityMission(List<Mission> mission){
		boolean result=false;
		if (this.activityState==ActivityState.PLANNING_AUDIT_STAGE){
			result=planHandle.CreateActivityMission(mission);
			
		}
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18上午10:50:04
	 *函数名：SumbitActivityMissionResult
	 *功能：提交任务总结
	 *参数：@param missionId
	 *参数：@param missionResult
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SumbitActivityMissionResult(int missionId,String missionResult){
		boolean result=false;
	
		if (this.activityState>=ActivityState.GOING_STAGE){
			result=planHandle.SumbitActivityMissionResult(missionId,missionResult);
		}
		return result;
	}
	

	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午09:24:18
	 *函数名：examinePlan
	 *功能：审核任务方案，成功保存，失败则删除
	 *参数：@param examineType
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean examinePlan(int examineType){
		boolean result=false;
		if (this.activityState==ActivityState.PLANNING_AUDIT_STAGE) {
			if (examineType==ExamineType.SUCCESS) {
				this.activityState=ActivityState.GOING_STAGE;
				planHandle.SavePlan(this.activityId);
			}
			else {
				this.activityState=ActivityState.PLANNING_STAGE;
				planHandle.deletePlan();
			}
		}
		result=daoFrame.UpdateActivityState(this.activityId, this.activityState);
		return result;
	} 
	/*******************************************************活动布告***************************************************************************/
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18上午09:09:02
	 *函数名：createActivityBulletin
	 *功能：创建活动布告
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean createActivityBulletin(){
		boolean result=false;
		if (this.activityState==ActivityState.GOING_STAGE) {
			this.activityBulletinHandle=new ActivityBulletinHandle();
			this.activityPersonnelHandle=new ActivityPersonnelHandle();
			result=true;
		}
		return true;
	}
	
	
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18上午09:20:35
	 *函数名：createActivestage
	 *功能：创建活动阶段
	 *参数：@param activestage
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean createActivestage(Activestage activestage){
		boolean result=false;
		if (this.activityState==ActivityState.GOING_STAGE) {
			result=activityBulletinHandle.createActivestage(activestage);
		}
		return true;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18上午09:23:43
	 *函数名：enterActivity
	 *功能：报名参加活动
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean enterActivity(Participants participants){
		boolean result=false;
		if (this.activityState==ActivityState.GOING_STAGE&&activityPersonnelHandle.getEnterType()) {
			
			result=activityPersonnelHandle.enterActivity(participants);
		}
		return result;
	} 
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18上午09:38:11
	 *函数名：examineParticipants
	 *功能：审核报名人员
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean examineParticipants(List<Participants> participants){
		boolean result=false;
		if (this.activityState==ActivityState.GOING_STAGE&&activityPersonnelHandle.getEnterType()) {
			result=activityPersonnelHandle.examineParticipants(participants);
		}
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18上午09:59:52
	 *函数名：SumbitParticipants
	 *功能：提交审核人员
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SumbitParticipants(){
		boolean result=false;
		if (this.activityState==ActivityState.GOING_STAGE&&activityPersonnelHandle.getEnterType()) {
			result=activityPersonnelHandle.SaveParticipants(this.activityId);
		}
		return result;
	}
	
	
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18上午10:16:34
	 *函数名：ToResult
	 *功能：活动进入总结状态
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean ToResult(){
		boolean result=false;
		if (this.activityState==ActivityState.GOING_STAGE&&!activityPersonnelHandle.getEnterType()) {
			activityState=ActivityState.SUMMARY_STAGE;
			result=daoFrame.UpdateActivityState(this.activityId, this.activityState);
		}
		return result;
	}
	

	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午03:27:29
	 *函数名：toActivity
	 *功能：把活动处理类转化为活动实体类
	 *参数：@return 
	 *返回值：Activity
	 */
	public Activity toActivity(){
		Activity activity=new Activity(this.activityId, schemeHandle.getActivityName(),this.activityBelongId, this.activityType, this.activityState, schemeHandle.getPlotterId(), planHandle.getPlanId(), schemeHandle.getActivityAddress(), schemeHandle.getActivityStartTime(), schemeHandle.getActivityEndTime(), this.activityResult, this.activityIntention);
		
		return activity;
	}
	
	

	
	
	public int getActivityId() {
		return activityId;
	}

	public int getActivityBelongId() {
		return activityBelongId;
	}

	public int getActivityType() {
		return activityType;
	}

	public int getActivityState() {
		return activityState;
	}

	public String getActivityResult() {
		return activityResult;
	}

	public String getActivityIntention() {
		return activityIntention;
	}

	public PlanHandle getPlanHandle() {
		return planHandle;
	}
		
	public SchemeHandle getSchemeHandle() {
		return schemeHandle;
	}

	public ActivityPersonnelHandle getActivityPersonnelHandle() {
		return activityPersonnelHandle;
	}

	public ActivityBulletinHandle getActivityBulletinHandle() {
		return activityBulletinHandle;
	}

	
}
