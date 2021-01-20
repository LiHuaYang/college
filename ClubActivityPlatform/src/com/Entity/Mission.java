package com.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import net.sf.json.JSONObject;

@Entity
public class Mission {
	private int missionId;// 任务方案分配ID
	private int planId;// 任务方案ID
	private int missionExecutorId;// 分配对象ID
	private String missionContent;// 任务内容
	private int missionPromoterId;// 任务发起人ID
	private int missionType;// 任务总结状态
	private String missionResult;// 任务总结内容
	private String missionTime; // 任务时间
	
	public Mission(){};
	public Mission(JSONObject jsonObject){
		this.planId=jsonObject.getInt("planId");
		this.missionExecutorId=jsonObject.getInt("missionExecutorId");
		this.missionContent=jsonObject.getString("missionContent");
		this.missionPromoterId=jsonObject.getInt("missionPromoterId");
		this.missionType=jsonObject.getInt("missionType");
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.missionTime=s.format( new Date());
	}
	public HashMap<String,Object> toHashMap(){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("missionId", this.missionId);
		map.put("planId", this.planId);
		map.put("missionExecutorId", this.missionExecutorId);
		map.put("missionContent", this.missionContent);
		map.put("missionPromoterId", this.missionPromoterId);
		map.put("missionType", this.missionType);
		map.put("missionResult", this.missionResult);
		map.put("missionTime", this.missionTime);
		return map;
	}
	@Id
	@GeneratedValue
	public int getMissionId() {
		return missionId;
	}

	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getMissionExecutorId() {
		return missionExecutorId;
	}

	public void setMissionExecutorId(int missionExecutorId) {
		this.missionExecutorId = missionExecutorId;
	}

	public String getMissionContent() {
		return missionContent;
	}

	public void setMissionContent(String missionContent) {
		this.missionContent = missionContent;
	}

	public int getMissionPromoterId() {
		return missionPromoterId;
	}

	public void setMissionPromoterId(int missionPromoterId) {
		this.missionPromoterId = missionPromoterId;
	}

	public int getMissionType() {
		return missionType;
	}

	public void setMissionType(int missionType) {
		this.missionType = missionType;
	}

	public String getMissionResult() {
		return missionResult;
	}

	public void setMissionResult(String missionResult) {
		this.missionResult = missionResult;
	}

	public void setMissionTime(String missionTime) {
		this.missionTime = missionTime;
	}

	public String getMissionTime() {
		return missionTime;
	}

	@Override
	public String toString() {
		return "Mission [missionContent=" + missionContent
				+ ", missionExecutorId=" + missionExecutorId + ", missionId="
				+ missionId + ", missionPromoterId=" + missionPromoterId
				+ ", missionResult=" + missionResult + ", missionTime="
				+ missionTime + ", missionType=" + missionType + ", planId="
				+ planId + "]";
	}

}
