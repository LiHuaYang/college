package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Participants {
	private int PartRelationId;// 参与关联ID
	private int activityId;// 活动ID
	private int participantsId;// 参与人ID
	private String participantsName;// 参与人名称

	
	public Participants(){};
	public Participants(int activityId,int participantsId, String participantsName){
		this.activityId=activityId;
		this.participantsId=participantsId;
		this.participantsName=participantsName;
	}
	public void setPartRelationId(int partRelationId) {
		PartRelationId = partRelationId;
	}

	@Id
	@GeneratedValue
	public int getPartRelationId() {
		return PartRelationId;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public int getParticipantsId() {
		return participantsId;
	}

	public void setParticipantsId(int participantsId) {
		this.participantsId = participantsId;
	}

	public String getParticipantsName() {
		return participantsName;
	}

	public void setParticipantsName(String participantsName) {
		this.participantsName = participantsName;
	}

	@Override
	public String toString() {
		return "Participants [PartRelationId=" + PartRelationId
				+ ", activityId=" + activityId + ", participantsId="
				+ participantsId + ", participantsName=" + participantsName
				+ "]";
	}

}
