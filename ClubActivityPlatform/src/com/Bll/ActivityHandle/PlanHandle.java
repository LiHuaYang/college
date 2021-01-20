package com.Bll.ActivityHandle;

import java.util.List;

import com.Dao.DaoFrame;
import com.Dao.IDaoFrame;
import com.Entity.Mission;
import com.Entity.Plan;

//���񷽰�������
public class PlanHandle {

	private	int	planId	;//	���񷽰�ID
	private	String	planName	;//	���񷽰�����
	private	int	planCreatorId	;//	���񷽰��ƶ���ID
	private	String	planContent	;//	����������
	private List<Mission> missionHandles;//�������б�
	private IDaoFrame daoFrame=new DaoFrame();
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-14����01:59:47
	 *��������
	 *���ܣ���ȡ���ݿ������񷽰���������
	 *������
	 *����ֵ��
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����01:57:47
	 *��������deletePlan
	 *���ܣ�ɾ�����񷽰�
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean deletePlan() {
		planName=null;
		planContent=null;
		missionHandles=null;
		return true;
		
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����04:43:34
	 *��������changePlanerId
	 *���ܣ��ı����񷽰��ƶ���
	 *������@param activityId
	 *������@param plannerId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean changePlanerId(int plannerId) {
		this.planCreatorId=plannerId;
		return true;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����04:44:01
	 *��������CreatePlan
	 *���ܣ��������񷽰�
	 *������@param planName
	 *������@param planContent
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreatePlan(Plan plan) {
		this.planContent=plan.getPlanContent();
		this.planName=plan.getPlanName();
		return true;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����07:47:33
	 *��������CreateActivityMission
	 *���ܣ�����������(��������)
	 *������@param mission
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateActivityMission(List<Mission> mission) {
		missionHandles=mission;
		return true;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����09:23:28
	 *��������SavePlan
	 *���ܣ����񷽰����ͨ��
	 *������@param activityId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean SavePlan(int activityId){
		this.planId=daoFrame.CreatePlan(ToPlan(activityId));
		boolean result=daoFrame.CreateMission(this.missionHandles);
		this.missionHandles=daoFrame.queryMissionsByPlanId(this.planId);
		return result;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����10:54:59
	 *��������SumbitActivityMissionResult
	 *���ܣ��ύ�����ܽ�
	 *������@param missionId
	 *������@param missionResult
	 *������@return 
	 *����ֵ��boolean
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
