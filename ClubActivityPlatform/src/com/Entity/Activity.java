package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Activity {
	private int activityId;// �ID
	private String activityName;// �����
	private int activityBelongId;// �������֯ID
	private int activityType;// ����ͣ����ڶ��⣩
	private int activityState;// �״̬(������߻���)
	private int plotterId;// ��߻���Id
	private int plannerId;// ���񷽰��ƶ���Id
	private String activityAddress;// ��ص�
	private String activityStartTime;// ���ʼʱ��
	private String activityEndTime;// �����ʱ��
	private String activityResult;// ��ܽ�
	private String activityIntention;// �����
	public Activity(){}
	public Activity(int activityId, String activityName, int activityBelongId,
			int activityType, int activityState, int plotterId, int plannerId,
			String activityAddress, String activityStartTime,
			String activityEndTime, String activityResult,
			String activityIntention) {
		
		this.activityId=activityId;
		this.activityName=activityName;
		this.activityBelongId=activityBelongId;
		this.activityType=activityType;
		this.activityState=activityState;
		this.plotterId=plotterId;
		this.plannerId=plannerId;
		this.activityAddress=activityAddress;
		this.activityStartTime=activityStartTime;
		this.activityEndTime=activityEndTime;
		this.activityResult=activityResult;
		this.activityIntention=activityIntention;

	}
	
	@Id
	@GeneratedValue
	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public int getActivityBelongId() {
		return activityBelongId;
	}

	public void setActivityBelongId(int activityBelongId) {
		this.activityBelongId = activityBelongId;
	}

	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}

	public int getActivityState() {
		return activityState;
	}

	public void setActivityState(int activityState) {
		this.activityState = activityState;
	}

	public int getPlotterId() {
		return plotterId;
	}

	public void setPlotterId(int plotterId) {
		this.plotterId = plotterId;
	}

	public int getPlannerId() {
		return plannerId;
	}

	public void setPlannerId(int plannerId) {
		this.plannerId = plannerId;
	}

	public String getActivityAddress() {
		return activityAddress;
	}

	public void setActivityAddress(String activityAddress) {
		this.activityAddress = activityAddress;
	}

	public String getActivityStartTime() {
		return activityStartTime;
	}

	public void setActivityStartTime(String activityStartTime) {
		this.activityStartTime = activityStartTime;
	}

	public String getActivityEndTime() {
		return activityEndTime;
	}

	public void setActivityEndTime(String activityEndTime) {
		this.activityEndTime = activityEndTime;
	}

	public String getActivityResult() {
		return activityResult;
	}

	public void setActivityResult(String activityResult) {
		this.activityResult = activityResult;
	}

	public String getActivityIntention() {
		return activityIntention;
	}

	public void setActivityIntention(String activityIntention) {
		this.activityIntention = activityIntention;
	}
	@Override
	public String toString() {
		return "Activity [activityAddress=" + activityAddress
				+ ", activityBelongId=" + activityBelongId
				+ ", activityEndTime=" + activityEndTime + ", activityId="
				+ activityId + ", activityIntention=" + activityIntention
				+ ", activityName=" + activityName + ", activityResult="
				+ activityResult + ", activityStartTime=" + activityStartTime
				+ ", activityState=" + activityState + ", activityType="
				+ activityType + ", plannerId=" + plannerId + ", plotterId="
				+ plotterId + "]";
	}
	
}
