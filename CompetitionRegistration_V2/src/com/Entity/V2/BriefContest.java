package com.Entity.V2;

import net.sf.json.JSONObject;

/**
 * 
 * @author Administrator
 *
 */
public class BriefContest {
	
	private int competitonId;
	
	private String contestMoney;
	private String contestSubject;
	
	// 默认构造函数
	public BriefContest() {}
	
	// 客户端构造函数
	public BriefContest(JSONObject jsonObj) {
		this.contestSubject = jsonObj.getString("ContestSubject");
		this.contestMoney = jsonObj.getString("ContestMoney");
	}
	
	// 数据库查询Sql
	public String getQuerySql () { 
		StringBuilder builder = new StringBuilder();
		
		builder.append("Select ContestSubject ");
		builder.append("From Contest ");
		builder.append("Where CompetitionId = ");
		builder.append(this.competitonId);
		
		return builder.toString();
	}

	// 设置大赛Id
	public void setCompetitionId (int id) {
		this.competitonId  = id;
	}
	
	public String getSubject () {
		return this.contestSubject;
	}
	
	
	public JSONObject toJson () {
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("contestSubject", this.contestSubject);
		jsonObject.put("contestMoney", this.contestMoney);
		
		return jsonObject;
	}
	
	
	
	
	
	
}	
