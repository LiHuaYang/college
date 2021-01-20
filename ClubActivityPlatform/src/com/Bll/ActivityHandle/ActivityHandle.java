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

//�������
public class ActivityHandle {
	private int activityId;//�ID
	private int  activityBelongId;//�������֯ID
	private int activityType;//����ͣ����ڶ��⣩
	private int activityState;//�״̬(������߻���)
	private String activityResult;//��ܽ�
	private String activityIntention;//�����
	
	private PlanHandle planHandle;//���񷽰�����
	private SchemeHandle schemeHandle;//��߻�����
	private ActivityPersonnelHandle activityPersonnelHandle;//������˴���
	private  ActivityBulletinHandle activityBulletinHandle;//����洦��
	
	private IDaoFrame daoFrame=new DaoFrame();
	
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-14����03:17:52
	 *��������
	 *���ܣ������ݿ���ȡ�����ݹ���������
	 *������
	 *����ֵ��
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����02:06:15
	 *�������� ���캯��
	 *���ܣ������
	 *�������������֯ID,��߻���,���񷽰��ƶ��ˣ�����򣬻����
	 *����ֵ��
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����01:45:11
	 *��������deleteActivity
	 *���ܣ�ɾ���
	 *������ 
	 *����ֵ��void
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����10:50:04
	 *��������SubmitActivityPlanResult
	 *���ܣ��ύ��ܽ�
	 *������@param missionResult
	 *������@return 
	 *����ֵ��boolean
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
	
	
	/*************************************************  ��߻�  **********************************************************************************/
	
	
	
	


	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����03:41:38
	 *��������SubmitScheme
	 *���ܣ��ύ��߻�
	 *������@param activityName
	 *������@param activityStartTime
	 *������@param activityEndTime
	 *������@param activityAddress
	 *������@param activityFileUrl
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����03:56:58
	 *��������changePlotterId
	 *���ܣ��ı��߻���
	 *������@param PlotterId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����04:30:41
	 *��������examineScheme
	 *���ܣ���˻�߻�
	 *������@param examineType
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����03:41:38
	 *��������ChangeScheme
	 *���ܣ��޸Ļ�߻�
	 *������@param activityName
	 *������@param activityStartTime
	 *������@param activityEndTime
	 *������@param activityAddress
	 *������@param activityFileUrl
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean ChangeScheme(String activityName,String activityStartTime,String activityEndTime,String activityAddress,String activityFileUrl){
		boolean result=false;
		if (this.activityState==ActivityState.SCHEME_AUDIT_STAGE) {
			result=schemeHandle.SubmitScheme(activityName,activityStartTime,activityEndTime,activityAddress,activityFileUrl);
		}
		return result;
	}
	/*************************************************  ���񷽰�    **********************************************************************************/
	
	
	
	
	
	

	
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����04:02:10
	 *��������changePlanerId
	 *���ܣ��޸����񷽰��ƶ���
	 *������@param plannerId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����09:49:40
	 *��������getPlan
	 *���ܣ���ȡ����ƻ�
	 *������@return 
	 *����ֵ��Plan
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����05:20:54
	 *��������CreatePlan
	 *���ܣ��������񷽰�
	 *������@param planName
	 *������@param planContent
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����05:20:54
	 *��������CreatePlan
	 *���ܣ��޸����񷽰�
	 *������@param planName
	 *������@param planContent
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����08:57:25
	 *��������CreateActivityMission
	 *���ܣ������������ύ���񷽰�
	 *������@param mission
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����08:57:25
	 *��������ChangeActivityMission
	 *���ܣ��޸�������
	 *������@param mission
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����10:50:04
	 *��������SumbitActivityMissionResult
	 *���ܣ��ύ�����ܽ�
	 *������@param missionId
	 *������@param missionResult
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����09:24:18
	 *��������examinePlan
	 *���ܣ�������񷽰����ɹ����棬ʧ����ɾ��
	 *������@param examineType
	 *������@return 
	 *����ֵ��boolean
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
	/*******************************************************�����***************************************************************************/
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����09:09:02
	 *��������createActivityBulletin
	 *���ܣ����������
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����09:20:35
	 *��������createActivestage
	 *���ܣ�������׶�
	 *������@param activestage
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����09:23:43
	 *��������enterActivity
	 *���ܣ������μӻ
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����09:38:11
	 *��������examineParticipants
	 *���ܣ���˱�����Ա
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����09:59:52
	 *��������SumbitParticipants
	 *���ܣ��ύ�����Ա
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����10:16:34
	 *��������ToResult
	 *���ܣ�������ܽ�״̬
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����03:27:29
	 *��������toActivity
	 *���ܣ��ѻ������ת��Ϊ�ʵ����
	 *������@return 
	 *����ֵ��Activity
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
