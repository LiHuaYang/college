package com.BasicEntity.V2;

import net.sf.json.JSONObject;

public class Organizer {
	
	private int organizerId;
	
	private String organizationName;
	private String organizationAddress;
	private String organizationTel;
	private String organizationContactor;
	private String organizationStation;
	
	private int contestId ; // 竞赛Id
	
	
	// 设置竞赛Id
	public void setContestId(int contestId) {
		this.contestId = contestId;
	}

	// 设置组织ID
	
	
	public Organizer(JSONObject jsonObj) {
//		this.organizationName = jsonObj.getString("name");
//		this.organizationAddress = jsonObj.getString("address");
//		this.organizationTel = jsonObj.getString("tel");
//		this.organizationContactor = jsonObj.getString("contactor");
//		this.organizationStation = jsonObj.getString("station");
		this.organizerId = jsonObj.getInt("OrganizationId");
		
		if (jsonObj.containsKey("OrganizationName")) {
			this.organizationName = jsonObj.getString("OrganizationName");
		}
	}
	
	// 获取竞赛插入语句
	public String getInsertSql() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Insert into contestorganization (");
		builder.append("organizationId, contestid) ");
		builder.append("Value (");
		builder.append("'" + this.organizerId + "',");
		builder.append("'" + this.contestId + "'");
		builder.append(");");
		
		return builder.toString();
	}
	
	// 获取竞赛插入值
	public String getValue() {
		return organizerId + "," + contestId;
	}
	
	public JSONObject toJson() {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("organizerId", this.organizerId);
		jsonObject.put("organizationName", this.organizationName);
		
		return jsonObject;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
