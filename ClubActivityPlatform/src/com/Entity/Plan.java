package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Plan {
	private int planId;// 任务方案ID
	private String planName;// 任务方案名称
	private int activityId;// 所属活动
	private int planCreatorId;// 任务方案制定人ID
	private String planContent;// 方案总内容
	
	public Plan(){};
	public Plan(int planId,String planName,int activityId,int planCreatorId,String planContent){
		this.planName=planName;
		this.activityId=activityId;
		this.planContent=planContent;
		this.planCreatorId=planCreatorId;
		this.planId=planId;
	}
	
	
	@Id
	@GeneratedValue
	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public int getPlanCreatorId() {
		return planCreatorId;
	}

	public void setPlanCreatorId(int planCreatorId) {
		this.planCreatorId = planCreatorId;
	}

	public String getPlanContent() {
		return planContent;
	}

	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}

	@Override
	public String toString() {
		return "Plan [activityId=" + activityId + ", planContent="
				+ planContent + ", planCreatorId=" + planCreatorId
				+ ", planId=" + planId + ", planName=" + planName + "]";
	}

}
