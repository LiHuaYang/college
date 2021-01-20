package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Activestage {
	private int activestageId;// 活动阶段ID
	private int activityId;// 活动ID
	private String activestageName;// 活动阶段名称
	private String activestageContent;// 活动阶段内容
	private String activestagePic;// 活动阶段图片路径
	private String activestageTime; // 活动阶段时间
	public Activestage(){}
	@Id
	@GeneratedValue
	public int getActivestageId() {
		return activestageId;
	}

	public void setActivestageId(int activestageId) {
		this.activestageId = activestageId;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivestageName() {
		return activestageName;
	}

	public void setActivestageName(String activestageName) {
		this.activestageName = activestageName;
	}

	public String getActivestageContent() {
		return activestageContent;
	}

	public void setActivestageContent(String activestageContent) {
		this.activestageContent = activestageContent;
	}

	public String getActivestagePic() {
		return activestagePic;
	}

	public void setActivestagePic(String activestagePic) {
		this.activestagePic = activestagePic;
	}

	public String getActivestageTime() {
		return activestageTime;
	}

	public void setActivestageTime(String activestageTime) {
		this.activestageTime = activestageTime;
	}

	@Override
	public String toString() {
		return "Activestage [activestageContent=" + activestageContent
				+ ", activestageId=" + activestageId + ", activestageName="
				+ activestageName + ", activestagePic=" + activestagePic
				+ ", activestageTime=" + activestageTime + ", activityId="
				+ activityId + "]";
	}

}
