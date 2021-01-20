package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Participants {
	private int PartRelationId;// �������ID
	private int activityId;// �ID
	private int participantsId;// ������ID
	private String participantsName;// ����������

	
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
