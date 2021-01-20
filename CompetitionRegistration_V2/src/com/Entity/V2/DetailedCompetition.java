package com.Entity.V2;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Tool.sql.SqlHelper;


/**
 * 大赛的详细信息（单个）
 * @author Administrator
 *
 */
public class DetailedCompetition {
	
	// 大赛的简要信息
	private String competitionName; //大赛名字
	private String competitionSession; // 大赛届数
	private String  competitionPropaganda; // 大赛口号
	private	String	competitionEnrollStartTime	;//	赛事开始报名时间
	private	String	competitionEnrollEndTime	;//	竞赛结束报名时间
	// 大赛的详细信息
	private	String	competitionInfo;  // 竞赛简介
	private String  competitionSponsor;  // 主办方
	private	String	competitionTimeDescribe;  // 赛事时间说明
	private	String	competitionPrize;  // 奖项
	private	String	competitionObjectDescribe;  // 参赛对象描述
	private	String	competitionPriceDescribe;  // 报名费用说明
	private String  competitionState;  // 大赛的状态
	private String  competitionPicture; // 大赛的小图片
	private String  competitionPictureBig;  //大赛大图片
	
	private String competitionBriefInfo; // 大赛简介
	
	private DetailedContestSet contestSet;// 大赛的科目信息
	
	public DetailedCompetition() {}
	
	// 客户端数据构造函数
	public DetailedCompetition(JSONObject jsonObj) {
		this.competitionName = jsonObj.getString("competitionName");
		this.competitionSession = jsonObj.getString("competitionSession");
		this.competitionPropaganda = jsonObj.getString("competitionPropaganda");
		this.competitionEnrollStartTime = jsonObj.getString("competitionEnrollStartTime");
		this.competitionEnrollEndTime = jsonObj.getString("competitionEnrollEndTime");
		
		this.competitionInfo = jsonObj.getString("competitionInfo");
		this.competitionSponsor = jsonObj.getString("competitionSponsor");
		this.competitionTimeDescribe = jsonObj.getString("competitionTimeDescribe");
		this.competitionPrize = jsonObj.getString("competitionPrize");
		this.competitionObjectDescribe = jsonObj.getString("competitionObjectDescribe");
		this.competitionPriceDescribe = jsonObj.getString("competitionPriceDescribe");
		this.competitionState = jsonObj.getString("competitionState");
		this.competitionPicture = jsonObj.getString("competitionPicture");
		this.competitionPictureBig = jsonObj.getString("competitionPictureBig");
		
		this.contestSet = new DetailedContestSet(JSONArray.fromObject(jsonObj.get("contestSet")));
	}
	
	// 数据库构造函数
	public DetailedCompetition (ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			if (resultSet.findColumn("CompetitionName") > 0) {
				this.competitionName = resultSet.getString("CompetitionName");
			}
			if (resultSet.findColumn("CompetitionState") > 0) {
				this.competitionState = resultSet.getString("CompetitionState");
			}
			if (resultSet.findColumn("CompetitionSession") > 0) {
				this.competitionSession = resultSet.getString("CompetitionSession");
			}
			if (resultSet.findColumn("CompetitionPropaganda") > 0) {
				this.competitionPropaganda = resultSet.getString("CompetitionPropaganda");
			}
			if (resultSet.findColumn("CompetitionInfo") > 0) {
				this.competitionInfo = resultSet.getString("CompetitionInfo");
			}
			if (resultSet.findColumn("CompetitionSponsor") > 0) {
				this.competitionSponsor = resultSet.getString("CompetitionSponsor");
			}
			if (resultSet.findColumn("CompetitionTimeDescribe") > 0) {
				this.competitionTimeDescribe = resultSet.getString("CompetitionTimeDescribe");
			}
			if (resultSet.findColumn("CompetitionPrize") > 0) {
				this.competitionPrize = resultSet.getString("CompetitionPrize");
			}
			if (resultSet.findColumn("CompetitionPriceDescribe") > 0) {
				this.competitionPriceDescribe = resultSet.getString("CompetitionPriceDescribe");
			}
			if (resultSet.findColumn("CompetitionPictureBig") > 0) {
				this.competitionPictureBig = resultSet.getString("CompetitionPictureBig");
			}
			if (resultSet.findColumn("CompetitionPicture") > 0) {
				this.competitionPicture = resultSet.getString("CompetitionPicture");
			}
			if (resultSet.findColumn("CompetitionObjectDescribe") > 0) {
				this.competitionObjectDescribe = resultSet.getString("CompetitionObjectDescribe");
			}
			if (resultSet.findColumn("CompetitionEnrollStartTime") > 0) {
				this.competitionEnrollStartTime = resultSet.getString("CompetitionEnrollStartTime");
			}
			if (resultSet.findColumn("CompetitionEnrollEndTime") > 0) {
				this.competitionEnrollEndTime = resultSet.getString("CompetitionEnrollEndTime");
			}
			if (resultSet.findColumn("CompetitionBriefInfo") > 0) {
				this.competitionBriefInfo = resultSet.getString("CompetitionBriefInfo");
			}
			// 竞赛组初始化
			if (resultSet.findColumn("DetailContestSet") > 0) {
				this.contestSet = new DetailedContestSet(JSONArray.fromObject(resultSet.getString("DetailContestSet")));
			}
		}
	}
	
	// 获取数据库插入语句
	public String getInsertSql() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("INSERT INTO competition (");
		builder.append(new SqlHelper().getModelPro(this));
		builder.append(") VALUE (");
		builder.append(this.getProVal());
		builder.append(");");
		
		builder.append(this.getContestSetInsertSql()); // 获取竞赛组的数据库插入语句
		
		return builder.toString();
	}
	
	// 获取竞赛组的数据库插入语句
	public String getContestSetInsertSql () {
		return this.contestSet.getInsertSql();
	}
	
	
	// 获取类属性的值
	public String getProVal () {
		StringBuilder builder = new StringBuilder();
		
		builder.append( "'" + this.competitionName + "'," );
		builder.append( "'" + this.competitionSession + "'," );
		builder.append( "'" + this.competitionPropaganda + "',");
		builder.append( "'" + this.competitionEnrollStartTime + "'," );
		builder.append( "'" + this.competitionEnrollEndTime + "'," );
		builder.append( "'" + this.competitionInfo + "'," );
		builder.append( "'" + this.competitionSponsor + "'," );
		builder.append( "'" + this.competitionTimeDescribe + "'," );
		builder.append( "'" + this.competitionPrize + "'," );
		builder.append( "'" + this.competitionObjectDescribe + "'," );
		builder.append( "'" + this.competitionPriceDescribe + "'," );
		builder.append( "'" + this.competitionState + "'," );
		builder.append( "'" + this.competitionPicture + "'," );
		builder.append( "'" + this.competitionPictureBig + "'" );
		
		return builder.toString();
	}
	
	// 获取竞赛组的SQL插入语句
	public String getInsertContestSetSql () {
		return this.contestSet.getInsertSql();
	}
	
	// 设置竞赛组的大赛ID
	public int setContestSetCompetitionId (int competitionId) {
		this.contestSet.setCompetitionId(competitionId);
		return competitionId;
	}
	
	// 设置竞赛的组的竞赛ID
	public void setContestSetContestId (int contestCurrentId) {
		this.contestSet.setContestId(contestCurrentId);
	}
	
	// 
	public int getDetailContestSetSize(){
		return this.contestSet.getSize();
	}
	
	public DetailedContest getDetailContestItem(int i){
		return this.contestSet.getItem(i);
	}
	
	// 初始化大赛ID和竞赛ID组
	public boolean initIds (JSONObject jsonObject) {
		int competitionCurrentId = jsonObject.getInt("competitionCurrentId");
		
		int contestCurrentId = jsonObject.getInt("contestCurrentId");
		
		this.setContestSetCompetitionId(competitionCurrentId + 1);
		this.setContestSetContestId(contestCurrentId);
		return true;
	}
	
	
	public JSONObject toJson () {
		JSONObject jsonObject = new JSONObject();
			
		jsonObject.put("competitionName", this.competitionName);
		jsonObject.put("competitionState", this.competitionState);
		jsonObject.put("competitionSession", this.competitionSession);
		jsonObject.put("competitionPropaganda", this.competitionPropaganda);
		jsonObject.put("competitionEnrollStartTime", this.competitionEnrollStartTime);
		jsonObject.put("competitionEnrollEndTime", this.competitionEnrollEndTime);
		jsonObject.put("competitionInfo", this.competitionInfo);
		jsonObject.put("competitionSponsor", this.competitionSponsor);
		jsonObject.put("competitionTimeDescribe", this.competitionTimeDescribe);
		jsonObject.put("competitionPrize", this.competitionPrize);
		jsonObject.put("competitionObjectDescribe", this.competitionObjectDescribe);
		jsonObject.put("competitionPriceDescribe", this.competitionPriceDescribe);
		jsonObject.put("competitionState", this.competitionState);
		jsonObject.put("competitionPicture", this.competitionPicture);
		jsonObject.put("competitionPictureBig", this.competitionPictureBig);
		jsonObject.put("competitionBriefInfo", this.competitionBriefInfo);
		
		jsonObject.put("contestSet", this.contestSet.toJson()); //
		
		return jsonObject;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
