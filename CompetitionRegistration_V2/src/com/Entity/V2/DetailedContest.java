package com.Entity.V2;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.BasicEntity.V2.OrganizerSet;
import com.Tool.sql.SqlHelper;

public class DetailedContest {
	
	private int contestId; // 竞赛ID
	private int competitionId; // 大赛ID
	
	private	String	contestObject;  // 竞赛年级
	private	String	contestSubject;  // 科目
	private	String	contestMoney;  // 报名费
	private String  contestState ;  // 竞赛状态
	private	String	startTime;  // 赛事开始时间
	private	String	endTime;  // 竞赛结束时间
	private	String	contestexamType;  // 考试类型
	
	private OrganizerSet organizerSet; // 承办方信息
	
	// 默认构造函数
	public DetailedContest () {}
	
	public DetailedContest(JSONObject jsonObject) {
		
		String Id = jsonObject.getString("ContestId");
		this.contestId = Integer.parseInt(Id);
		
		this.contestObject = jsonObject.getString("ContestObject");
		this.contestSubject = jsonObject.getString("ContestSubject");
		this.contestMoney = jsonObject.getString("ContestMoney");
		this.contestState = jsonObject.getString("ContestState");
		this.startTime = jsonObject.getString("StartTime");
		this.endTime = jsonObject.getString("EndTime");
		this.contestexamType = jsonObject.getString("ContestexamType");
		
		this.organizerSet = new OrganizerSet(JSONArray.fromObject(jsonObject.getString("OrganizerSet")));
	}

	// 设置大赛ID
	public void setCompetitionId(int competitionId) {
		this.competitionId = competitionId;
	}
	
	// 设置竞赛ID 
	public void setContestId (int contestId) {
		this.contestId = contestId;
		
		setOrganizerContestId(); // 同时设置相对应的承办方的组织ID
	}
	// 设置组织信息中的竞赛ID
	public void setOrganizerContestId () {
		this.organizerSet.setContestId(this.contestId);
	}
	
	// 获取竞赛插入语句
	public String getInsertSql () {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Insert Into Contest (");
		builder.append(new SqlHelper().getModelPro(this));
		builder.append(") Value (");
		builder.append(this.getProVal());
		builder.append(");");
		
		// 获取组织信息数据库插入语句
		builder.append(this.organizerSet.getInsertSql());
		
		return builder.toString();
	}

	// 获取类属性的值
	public String getProVal () {
		StringBuilder builder = new StringBuilder();
		
		builder.append( "'" + this.contestId + "'," );
		builder.append( "'" + this.competitionId + "'," );
		builder.append( "'" + this.contestObject + "'," );
		builder.append( "'" + this.contestSubject + "'," );
		builder.append( "'" + this.contestMoney+ "'," );
		builder.append( "'" + this.contestState + "',");
		builder.append( "'" + this.startTime + "',");
		builder.append( "'" + this.endTime + "',");
		builder.append( "'" + this.contestexamType + "'");
		
		return builder.toString();
	}

	// 获取竞赛组织信息的大小
	public int getOrganizerSetSize () {
		return this.organizerSet.getSize();
	}
	
	
	//获取竞赛组织信息的数据库插入语句
	public String getOrganizerInsertSql() {
		this.organizerSet.getInsertSql();
		return "";
	}
	
	
	public JSONObject toJson() {
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("contestId", this.contestId);
		jsonObject.put("contestObject", this.contestObject);
		jsonObject.put("contestSubject", this.contestSubject);
		jsonObject.put("contestMoney", this.contestMoney);
		jsonObject.put("contestState", this.contestState);
		jsonObject.put("startTime", this.startTime);
		jsonObject.put("endTime", this.endTime);
		jsonObject.put("contestexamType", this.contestexamType);
		jsonObject.put("organizerSet", this.organizerSet.toJson()); //
		
		return jsonObject;
	}
	
	
}
