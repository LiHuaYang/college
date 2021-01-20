package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.EntityWeb.Contest;

public class CompetitionBasicInfo {
	
	private	String	CompetitionName	;//	竞赛名称
	private	String	StartTime	;//	赛事开始时间
	private	String	CompetitionEnrollStartTime	;//	赛事开始报名时间
	private	String	CompetitionEnrollEndTime	;//	竞赛结束报名时间
	private	String	ContestPropaganda	;//	宣传语
	private	String	ContestSubject	;//	比赛科目
	private	int	ContestObject	;//	竞赛年级
	private	int	CompetitionSession	;//	竞赛届数
	private String ContestPicUrl; //详情图片
	private	String	CompetitionPicture	;//	比赛图片
	private	int	CompetitionId	;//	竞赛id
	private String CompetitionObjectDescribe ;//参赛对象描述
	private int ContestState;//比赛状态
	private String CompetitionPriceDescribe;//报名费用说明
	private String CompetitionTimeDescribe;//赛事时间说明
	private String CompetitionInfo;//竞赛状态
	private String ContestexamType;//考试形式
	private int CompetitionState;//比赛状态
	private int ContestId;//竞赛id
	private String EndTime; //结束时间
	private int ContestMoney;//报名费
	private String CompetitionPrize;//奖项设置
	
	
	public CompetitionBasicInfo(){
		
	}
	
	
	public CompetitionBasicInfo(String CompetitionName,String StartTime,String CompetitionEnrollStartTime,
			String CompetitionEnrollEndTime,String ContestPropaganda,String ContestSubject,
			int ContestObject,int CompetitionSession,String CompetitionPicture,int CompetitionId,
			String CompetitionObjectDescribe,int ContestState){
		this.CompetitionName=CompetitionName;
		this.StartTime=StartTime;
		this.ContestPropaganda=CompetitionEnrollStartTime;
		this.CompetitionEnrollEndTime=CompetitionEnrollEndTime;
		this.ContestPropaganda=ContestPropaganda;
		this.ContestSubject=ContestSubject;
		this.ContestObject=ContestObject;
		this.CompetitionSession=CompetitionSession;
		this.CompetitionPicture=CompetitionPicture;
		this.CompetitionId=CompetitionId;
		this.CompetitionObjectDescribe=CompetitionObjectDescribe;
		this.ContestState=ContestState;
	}
	
	public CompetitionBasicInfo(String	ContestSubject){
		this.ContestSubject=ContestSubject;
	}
	
	public CompetitionBasicInfo(String startTime, String endTime,int contestMoney) {
		
		this.StartTime = startTime;
		this.EndTime = endTime;
		this.ContestMoney = contestMoney;
	}

	public CompetitionBasicInfo(String CompetitionName,String StartTime,String CompetitionEnrollStartTime,
			String CompetitionEnrollEndTime,String ContestPropaganda,String ContestSubject,
			int ContestObject,int CompetitionSession,String ContestPicUrl,int CompetitionId,
			String CompetitionObjectDescribe,int ContestState,int ContestId,String CompetitionInfo,
			String ContestexamType,String EndTime,int ContestMoney,String CompetitionTimeDescribe){
		this.CompetitionName=CompetitionName;
		this.StartTime=StartTime;
		this.CompetitionEnrollStartTime=CompetitionEnrollStartTime;
		this.CompetitionEnrollEndTime=CompetitionEnrollEndTime;
		this.ContestPropaganda=ContestPropaganda;
		this.ContestSubject=ContestSubject;
		this.ContestObject=ContestObject;
		this.CompetitionSession=CompetitionSession;
		this.ContestPicUrl=ContestPicUrl;
		this.CompetitionId=CompetitionId;
		this.CompetitionObjectDescribe=CompetitionObjectDescribe;
		this.ContestState=ContestState;
		this.CompetitionInfo=CompetitionInfo;
		this.ContestexamType=ContestexamType;
		this.ContestId=ContestId;
		this.EndTime=EndTime;
		this.ContestMoney=ContestMoney;
		this.CompetitionTimeDescribe=CompetitionTimeDescribe;
	}
	
	
	public CompetitionBasicInfo(String CompetitionName,String StartTime,String CompetitionEnrollStartTime,
			String CompetitionEnrollEndTime,String ContestPropaganda,String ContestSubject,
			int ContestObject,int CompetitionSession,String CompetitionPicture,int CompetitionId,
			String CompetitionObjectDescribe,int CompetitionState,String CompetitionInfo,
			String ContestexamType,String EndTime,int ContestMoney,String CompetitionTimeDescribe,
			String CompetitionPriceDescribe,String CompetitionPrize){
		this.CompetitionName=CompetitionName;
		this.StartTime=StartTime;
		this.CompetitionEnrollStartTime=CompetitionEnrollStartTime;
		this.CompetitionEnrollEndTime=CompetitionEnrollEndTime;
		this.ContestPropaganda=ContestPropaganda;
		this.ContestSubject=ContestSubject;
		this.ContestObject=ContestObject;
		this.CompetitionSession=CompetitionSession;
		this.CompetitionPicture=CompetitionPicture;
		this.CompetitionId=CompetitionId;
		this.CompetitionObjectDescribe=CompetitionObjectDescribe;
		this.CompetitionState=CompetitionState;
		this.CompetitionInfo=CompetitionInfo;
		this.ContestexamType=ContestexamType;
		this.EndTime=EndTime;
		this.ContestMoney=ContestMoney;
		this.CompetitionTimeDescribe=CompetitionTimeDescribe;
		this.CompetitionPriceDescribe=CompetitionPriceDescribe;
		this.CompetitionPrize=CompetitionPrize;
	}
	
	
	public CompetitionBasicInfo(int	CompetitionId,String CompetitionPicture,
			String CompetitionEnrollStartTime,String CompetitionName,String ContestSubject,
			String ContestexamType,String CompetitionObjectDescribe){
		this.CompetitionId=CompetitionId;
		this.CompetitionPicture=CompetitionPicture;
		this.CompetitionEnrollStartTime=CompetitionEnrollStartTime;
		this.CompetitionName=CompetitionName;
		this.ContestSubject=ContestSubject;
		this.ContestexamType=ContestexamType;
		this.CompetitionObjectDescribe=CompetitionObjectDescribe;
	}

	
	public CompetitionBasicInfo(int CompetitionId,String CompetitionPicture,
			String CompetitionEnrollStartTime,String CompetitionName,String CompetitionObjectDescribe){
		this.CompetitionId=CompetitionId;
		this.CompetitionPicture=CompetitionPicture;
		this.CompetitionEnrollStartTime=CompetitionEnrollStartTime;
		this.CompetitionName=CompetitionName;
		this.CompetitionObjectDescribe=CompetitionObjectDescribe;
	}
	
	public CompetitionBasicInfo(int CompetitionId,String ContestSubject,String ContestexamType){
		this.CompetitionId=CompetitionId;
		this.ContestSubject=ContestSubject;
		this.ContestexamType=ContestexamType;
	}
	
	
	
	public CompetitionBasicInfo(ResultSet resultSet) throws SQLException{
		this.CompetitionName=resultSet.getString("CompetitionName");
		this.StartTime=resultSet.getString("StartTime");
		this.CompetitionEnrollStartTime=resultSet.getString("CompetitionEnrollStartTime");
		this.CompetitionEnrollEndTime=resultSet.getString("CompetitionEnrollEndTime");
		this.ContestPropaganda=resultSet.getString("ContestPropaganda");
		this.ContestSubject=resultSet.getString("ContestSubject");
		this.ContestObject=resultSet.getInt("ContestObject");
		this.CompetitionSession=resultSet.getInt("CompetitionSession");
		this.CompetitionPicture=resultSet.getString("CompetitionPicture");
		this.CompetitionId=resultSet.getInt("CompetitionId");
		this.CompetitionObjectDescribe=resultSet.getString("CompetitionObjectDescribe");
		this.ContestState=resultSet.getInt("ContestState");
		
	}
	
	public CompetitionBasicInfo(String competitionName,
			String competitionEnrollEndTime, String contestSubject, String competitionPicture,
			int competitionId, String competitionObjectDescribe,int contestMoney) {
		
		this.CompetitionName = competitionName;
		this.CompetitionEnrollEndTime = competitionEnrollEndTime;
		this.ContestSubject = contestSubject;
		this.CompetitionPicture = competitionPicture;
		this.CompetitionId = competitionId;
		this.CompetitionObjectDescribe = competitionObjectDescribe;
		this.ContestMoney = contestMoney;
	}


	public String getCompetitionName() {
		return CompetitionName;
	}


	public void setCompetitionName(String competitionName) {
		CompetitionName = competitionName;
	}


	public String getStartTime() {
		return StartTime;
	}


	public void setStartTime(String startTime) {
		StartTime = startTime;
	}


	public String getCompetitionEnrollStartTime() {
		return CompetitionEnrollStartTime;
	}


	public void setCompetitionEnrollStartTime(String competitionEnrollStartTime) {
		CompetitionEnrollStartTime = competitionEnrollStartTime;
	}


	public String getCompetitionEnrollEndTime() {
		return CompetitionEnrollEndTime;
	}


	public void setCompetitionEnrollEndTime(String competitionEnrollEndTime) {
		CompetitionEnrollEndTime = competitionEnrollEndTime;
	}


	public String getContestPropaganda() {
		return ContestPropaganda;
	}


	public void setContestPropaganda(String contestPropaganda) {
		ContestPropaganda = contestPropaganda;
	}


	public String getContestSubject() {
		return ContestSubject;
	}


	public void setContestSubject(String contestSubject) {
		ContestSubject = contestSubject;
	}


	public int getContestObject() {
		return ContestObject;
	}


	public void setContestObject(int contestObject) {
		ContestObject = contestObject;
	}


	public int getCompetitionSession() {
		return CompetitionSession;
	}


	public void setCompetitionSession(int competitionSession) {
		CompetitionSession = competitionSession;
	}


	public String getContestPicUrl() {
		return ContestPicUrl;
	}


	public void setContestPicUrl(String contestPicUrl) {
		ContestPicUrl = contestPicUrl;
	}


	public String getCompetitionPicture() {
		return CompetitionPicture;
	}


	public void setCompetitionPicture(String competitionPicture) {
		CompetitionPicture = competitionPicture;
	}


	public int getCompetitionId() {
		return CompetitionId;
	}


	public void setCompetitionId(int competitionId) {
		CompetitionId = competitionId;
	}


	public String getCompetitionObjectDescribe() {
		return CompetitionObjectDescribe;
	}


	public void setCompetitionObjectDescribe(String competitionObjectDescribe) {
		CompetitionObjectDescribe = competitionObjectDescribe;
	}


	public int getContestState() {
		return ContestState;
	}


	public void setContestState(int contestState) {
		ContestState = contestState;
	}


	public String getCompetitionPriceDescribe() {
		return CompetitionPriceDescribe;
	}


	public void setCompetitionPriceDescribe(String competitionPriceDescribe) {
		CompetitionPriceDescribe = competitionPriceDescribe;
	}


	public String getCompetitionTimeDescribe() {
		return CompetitionTimeDescribe;
	}


	public void setCompetitionTimeDescribe(String competitionTimeDescribe) {
		CompetitionTimeDescribe = competitionTimeDescribe;
	}


	public String getCompetitionInfo() {
		return CompetitionInfo;
	}


	public void setCompetitionInfo(String competitionInfo) {
		CompetitionInfo = competitionInfo;
	}


	public String getContestexamType() {
		return ContestexamType;
	}


	public void setContestexamType(String contestexamType) {
		ContestexamType = contestexamType;
	}


	public int getCompetitionState() {
		return CompetitionState;
	}


	public void setCompetitionState(int competitionState) {
		CompetitionState = competitionState;
	}


	public int getContestId() {
		return ContestId;
	}


	public void setContestId(int contestId) {
		ContestId = contestId;
	}


	public String getEndTime() {
		return EndTime;
	}


	public void setEndTime(String endTime) {
		EndTime = endTime;
	}


	public int getContestMoney() {
		return ContestMoney;
	}


	public void setContestMoney(int contestMoney) {
		ContestMoney = contestMoney;
	}


	public String getCompetitionPrize() {
		return CompetitionPrize;
	}


	public void setCompetitionPrize(String competitionPrize) {
		CompetitionPrize = competitionPrize;
	}


	@Override
	public String toString() {
		return "CompetitionBasicInfo [CompetitionEnrollEndTime="
				+ CompetitionEnrollEndTime + ", CompetitionEnrollStartTime="
				+ CompetitionEnrollStartTime + ", CompetitionId="
				+ CompetitionId + ", CompetitionInfo=" + CompetitionInfo
				+ ", CompetitionName=" + CompetitionName
				+ ", CompetitionObjectDescribe=" + CompetitionObjectDescribe
				+ ", CompetitionPicture=" + CompetitionPicture
				+ ", CompetitionPriceDescribe=" + CompetitionPriceDescribe
				+ ", CompetitionPrize=" + CompetitionPrize
				+ ", CompetitionSession=" + CompetitionSession
				+ ", CompetitionState=" + CompetitionState
				+ ", CompetitionTimeDescribe=" + CompetitionTimeDescribe
				+ ", ContestId=" + ContestId + ", ContestMoney=" + ContestMoney
				+ ", ContestObject=" + ContestObject + ", ContestPicUrl="
				+ ContestPicUrl + ", ContestPropaganda=" + ContestPropaganda
				+ ", ContestState=" + ContestState + ", ContestSubject="
				+ ContestSubject + ", ContestexamType=" + ContestexamType
				+ ", EndTime=" + EndTime + ", StartTime=" + StartTime + "]";
	}


	
}
