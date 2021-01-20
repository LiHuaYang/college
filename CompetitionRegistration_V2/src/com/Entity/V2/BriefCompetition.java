package com.Entity.V2;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Tool.MyOpecode;
import com.Tool.sql.SqlHelper;

/**
 * 大赛的简要信息实体类（单个）
 * @author Administrator
 *
 */
public class BriefCompetition {
	public BriefContestSet getContests() {
		return contests;
	}

	private int competitionId; // 大赛Id
	private String competitionName; //大赛名字
	private String competitionSession; // 大赛届数
	private String competitionPicture; // 大赛图片
	private String competitionObjectDescribe; // 参赛对象描述
	private	String competitionEnrollStartTime	;//	赛事开始报名时间
	private	String competitionEnrollEndTime	;//	竞赛结束报名时间
	private String competitionPropaganda;    //大赛宣传语
	private int competitionState; // 大赛状态
	private BriefContestSet contests; //  赛事科目
	
	// 默认构造函数
	public BriefCompetition () {}
	
	//  客户端数据构造函数
	public BriefCompetition(JSONObject jsonObj) {
		this.competitionName = jsonObj.getString("competitionName");
		this.competitionSession = jsonObj.getString("competitionSession");
		this.competitionPicture = jsonObj.getString("competitionPicture");
		this.competitionObjectDescribe = jsonObj.getString("competitionObjectDescribe");
		this.competitionEnrollStartTime = jsonObj.getString("competitionEnrollStartTime");
		this.competitionEnrollEndTime = jsonObj.getString("competitionEnrollEndTime");
	}
	
	/**
	 *
	 */
	public BriefCompetition(ResultSet resultSet, String condition) throws SQLException {
		
		if(condition == MyOpecode.competition.bCmConOfAndroidHome){
			if (resultSet.findColumn("CompetitionId") > 0 ) {
				this.competitionId= resultSet.getInt("CompetitionId");
			}
			if (resultSet.findColumn("CompetitionName") > 0 && this.competitionName==null) {
				this.competitionName = resultSet.getString("CompetitionName");
//				System.out.println(this.competitionName);
			}
			if (resultSet.findColumn("CompetitionPicture") > 0 && this.competitionPicture==null) {
				this.competitionPicture = resultSet.getString("CompetitionPicture");
			}
			if(resultSet.findColumn("CompetitionPropaganda") > 0){
				this.competitionPropaganda = resultSet.getString("CompetitionPropaganda");
			}
		}else if (condition == MyOpecode.competition.bCmConOfCmList) {
			if (resultSet.findColumn("CompetitionId") > 0 ) {
				this.competitionId= resultSet.getInt("CompetitionId");
			}
			if (resultSet.findColumn("CompetitionName") > 0 && this.competitionName==null) {
				this.competitionName = resultSet.getString("CompetitionName");
//				System.out.println(this.competitionName);
			}
			if (resultSet.findColumn("CompetitionSession") > 0 && this.competitionSession==null) {
				this.competitionSession = resultSet.getString("CompetitionSession");
			}
			if (resultSet.findColumn("CompetitionPicture") > 0 && this.competitionPicture==null) {
				this.competitionPicture = resultSet.getString("CompetitionPicture");
			}
			if (resultSet.findColumn("CompetitionObjectDescribe") > 0 && this.competitionObjectDescribe==null) {
				this.competitionObjectDescribe = resultSet.getString("CompetitionObjectDescribe");
			}
			if (resultSet.findColumn("CompetitionEnrollStartTime") > 0 && this.competitionEnrollStartTime==null) {
				this.competitionEnrollStartTime = resultSet.getString("CompetitionEnrollStartTime");
			}
			if (resultSet.findColumn("CompetitionEnrollEndTime") > 0 && this.competitionEnrollEndTime==null) {
				this.competitionEnrollEndTime = resultSet.getString("CompetitionEnrollEndTime");
			}
			if (resultSet.findColumn("CompetitionState") > 0) {
				this.competitionState = resultSet.getInt("CompetitionState");
			}
			if (resultSet.findColumn("BriefContest") > 0) {
				this.contests = new BriefContestSet(new JSONArray().fromObject(resultSet.getString("BriefContest")));
			}
		}
		
	}
	


	// 获取大赛简要信息列表Sql
	public String getQuerySql(String condition) {
		StringBuilder builder = new StringBuilder();
		
		if(condition == MyOpecode.competition.getBCmQueryOfAndroidHome){
			builder.append("Select ");
			builder.append("competitionId,competitionName,competitionPicture,competitionPropaganda");
			builder.append(" From competition");
			builder.append(" where competitionState = 2");
			builder.append(" order by CompetitionEnrollEndTime;");

		}else{
			builder.append("Select ");
			builder.append(new SqlHelper().getModelPro(this) + ",");
			builder.append(" From competition as cp");
			builder.append(" Where CompetitionState = 2");
		}

		System.out.println("大赛简要信息数据库查询语句："+ builder.toString() );
		return builder.toString();
	}
	

	//功能：根据大赛状态获取sql
	public String getQuerySql(int contestState){
		StringBuilder builder = new StringBuilder();
		
		builder.append("select");
		builder.append(" count(*)");
		builder.append(" from competition");
		builder.append(" where competitionState=1");
		
		return builder.toString();
	}
	
	// 获取大赛简要信息科目信息Sql
	public String getBriefContestSetQuerySql () {
		return new BriefContest().getQuerySql();
	}
	
	// 客户端数据
	public JSONObject toJson(String condition) {
		JSONObject jsonObject = new JSONObject();
		
		if(condition == MyOpecode.competition.tojsonOfCmList){
			jsonObject.put("competitionId", this.competitionId);
			jsonObject.put("competitionName", this.competitionName);
			jsonObject.put("competitionSession", this.competitionSession);
			jsonObject.put("competitionPicture", this.competitionPicture);
			jsonObject.put("competitionObjectDescribe", this.competitionObjectDescribe);
			jsonObject.put("competitionEnrollStartTime", this.competitionEnrollStartTime);
			jsonObject.put("competitionEnrollEndTime", this.competitionEnrollEndTime);
			jsonObject.put("competitionState", this.competitionState);
			
			jsonObject.put("BriefContest", this.contests.toJson());
			
		}else if (condition == MyOpecode.competition.tojsonOfAndroidHome) {
			jsonObject.put("competitionId", this.competitionId);
			jsonObject.put("competitionName", this.competitionName);
			jsonObject.put("competitionPicture", this.competitionPicture);
			jsonObject.put("competitionPropaganda", this.competitionPropaganda);
		}
		
		return jsonObject;
	}
	
	// 设置竞赛组的大赛id
	public void setContestSetCompetitionId () {
		this.contests.setCompetitionId(this.competitionId);
	}

	// 获取大赛Id
	public int getCompetitionId() {
		return competitionId;
	}

	public void setContests(BriefContestSet contests) {
		this.contests = contests;
	}
	
	public BriefContest getContest() {
		return contests.getItem();
	}
	
	// 增加一个竞赛科目信息
	public void addContest (BriefContest contest) {
		this.contests.add (contest);
	}

	
	
	
	
	
	
	
	
}
