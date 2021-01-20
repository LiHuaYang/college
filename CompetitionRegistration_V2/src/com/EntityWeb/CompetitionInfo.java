package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompetitionInfo {
	
	private	String	CompetitionName	;//	竞赛名称
	private	String	StartTime	;//	赛事开始时间
	private	String	EndTime	;//	竞赛结束时间
	private	String	CompetitionEnrollStartTime	;//	报名开始时间
	private	String	CompetitionEnrollEndTime	;//	报名结束时间
	private	int	CompetitionSession	;//	竞赛届数
	private	String	CompetitionInfo	;//	竞赛介绍
	private	int	ParticularYear	;//	年份
	private String ContestPropaganda; //竞赛宣传语
	private	int	ContestState	;//	竞赛状态
	private	String	ContestPicUrl	;//	竞赛图片路径
	private	int	ContestObject	;//	赛事对象
	private	String	ContestSubject	;//	科目
	private	int	ContestMoney	;//	报名费
	private String ContestexamType;   //考试类型
	private int ContestId;//赛事id
	private int CompetitionState;//赛事状态
	
	
	public CompetitionInfo(String CompetitionName, String StartTime,
			String EndTime, int CompetitionSession, int	ContestState,String CompetitionInfo,
			int ParticularYear,String ContestPropaganda,String	ContestPicUrl,int ContestObject, 
			String ContestSubject,int ContestMoney,String ContestexamType){
		this.CompetitionName = CompetitionName;
		this.StartTime = StartTime;
		this.EndTime = EndTime;
		this.CompetitionSession = CompetitionSession;
		this.ContestState = ContestState;
		this.CompetitionInfo = CompetitionInfo;
		this.ParticularYear = ParticularYear;
		this.ContestPropaganda = ContestPropaganda;
		this.ContestPicUrl = ContestPicUrl;
		this.ContestObject = ContestObject;
		this.ContestSubject = ContestSubject;
		this.ContestMoney = ContestMoney;
		this.ContestexamType = ContestexamType;
	}
	
	
	public CompetitionInfo(String CompetitionName, String CompetitionEnrollStartTime,
			String CompetitionEnrollEndTime, int ContestState, int ContestObject,String ContestexamType, String ContestSubject) {

		this.CompetitionName = CompetitionName;
		this.CompetitionEnrollStartTime = CompetitionEnrollStartTime;
		this.CompetitionEnrollEndTime = CompetitionEnrollEndTime;
		this.ContestState = ContestState;
		this.ContestObject = ContestObject;
		this.ContestexamType=ContestexamType;
		this.ContestSubject = ContestSubject;
	}
	public CompetitionInfo(String CompetitionName, String StartTime,
			String EndTime, int ContestState, int ContestObject,String ContestexamType) {
		this.CompetitionName = CompetitionName;
		this.StartTime = StartTime;
		this.EndTime = EndTime;
		this.ContestState = ContestState;
		this.ContestObject = ContestObject;
		this.ContestexamType=ContestexamType;
	}
	
	public CompetitionInfo(String CompetitionName, String StartTime,
			String EndTime, int ContestState, int ContestObject,String ContestexamType,int ContestId) {
		this.CompetitionName = CompetitionName;
		this.StartTime = StartTime;
		this.EndTime = EndTime;
		this.ContestState = ContestState;
		this.ContestObject = ContestObject;
		this.ContestexamType=ContestexamType;
		this.ContestId=ContestId;
	}
	public CompetitionInfo(int CompetitionState, String CompetitionEnrollStartTime,
			String CompetitionEnrollEndTime,String CompetitionName , int ContestObject,int ContestId,String ContestexamType,String ContestSubject) {
		this.CompetitionName = CompetitionName;
		this.CompetitionEnrollStartTime = CompetitionEnrollStartTime;
		this.CompetitionEnrollEndTime = CompetitionEnrollEndTime;
		this.CompetitionState = CompetitionState;
		this.ContestObject = ContestObject;
		this.ContestexamType=ContestexamType;
		this.ContestId=ContestId;
		this.ContestSubject=ContestSubject;
	}

	public CompetitionInfo(ResultSet resultSet) throws SQLException{
		if (resultSet.getString("CompetitionName") == null) {
			
		}
		this.CompetitionName = resultSet.getString("CompetitionName");
		this.StartTime=resultSet.getString("StartTime");
		this.EndTime=resultSet.getString("EndTime");
		this.CompetitionSession=resultSet.getInt("CompetitionSession");
		this.CompetitionInfo=resultSet.getString("CompetitionInfo");
		this.CompetitionState = resultSet.getInt("CompetitionState");
		this.ParticularYear=resultSet.getInt("ParticularYear");
		this.ContestPropaganda=resultSet.getString("ContestPropaganda");
		this.ContestState=resultSet.getInt("ContestState");
//		this.ContestPicUrl=resultSet.getString("ContestPicUrl");
		this.ContestObject=resultSet.getInt("ContestObject");
		this.ContestSubject=resultSet.getString("ContestSubject");
		this.ContestMoney=resultSet.getInt("ContestMoney");
		this.ContestexamType=resultSet.getString("ContestexamType");
		this.CompetitionEnrollStartTime=resultSet.getString("CompetitionEnrollStartTime");
		this.CompetitionEnrollEndTime=resultSet.getString("CompetitionEnrollEndTime");
	}
	

	public String getCompetitionName() {
		return CompetitionName;
	}

	public String getStartTime() {
		return StartTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public int getCompetitionSession() {
		return CompetitionSession;
	}

	public String getCompetitionInfo() {
		return CompetitionInfo;
	}

	public int getParticularYear() {
		return ParticularYear;
	}

	public String getContestPropaganda() {
		return ContestPropaganda;
	}

	public int getContestState() {
		return ContestState;
	}

	public String getContestPicUrl() {
		return ContestPicUrl;
	}

	public int getContestObject() {
		return ContestObject;
	}

	public String getContestSubject() {
		return ContestSubject;
	}

	public int getContestMoney() {
		return ContestMoney;
	}
	
	public String getContestexamType(){
		return ContestexamType;
	}
	public int getContestId() {
		return ContestId;
	}
    public String getCompetitionEnrollStartTime()
    {
    	return CompetitionEnrollStartTime;
    }

    public String getCompetitionEnrollEndTime()
    {
    	return CompetitionEnrollEndTime;
    }
	@Override
	public String toString() {
		return "CompetitionInfo [CompetitionInfo=" + CompetitionInfo
				+ ", CompetitionName=" + CompetitionName
				+ ", CompetitionSession=" + CompetitionSession
				+ ", CompetitionState=" + CompetitionState
				+ ", ContestMoney=" + ContestMoney + ", ContestObject="
				+ ContestObject + ", ContestPicUrl=" + ContestPicUrl
				+ ", ContestPropaganda=" + ContestPropaganda
				+", CompetitionEnrollStartTime=" + CompetitionEnrollStartTime
				+", CompetitionEnrollEndTime=" + CompetitionEnrollEndTime
				+ ", ContestState=" + ContestState + ", ContestSubject="
				+ ContestSubject + ", ContestexamType=" + ContestexamType
				+ ", EndTime=" + EndTime + ", ParticularYear=" + ParticularYear
				+ ", StartTime=" + StartTime + "]";
	}


	public int getCompetitionState() {
		return CompetitionState;
	}


	public void setCompetitionState(int competitionState) {
		CompetitionState = competitionState;
	}


	public void setCompetitionName(String competitionName) {
		CompetitionName = competitionName;
	}


	public void setStartTime(String startTime) {
		StartTime = startTime;
	}


	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
    
	public void setCompetitionEnrollStartTime(String competitionEnrollStartTime) {
		CompetitionEnrollStartTime = competitionEnrollStartTime;
	}


	public void setCompetitionEnrollEndTime(String competitionEnrollEndTime) {
		CompetitionEnrollEndTime = competitionEnrollEndTime;
	}

	public void setCompetitionSession(int competitionSession) {
		CompetitionSession = competitionSession;
	}


	public void setCompetitionInfo(String competitionInfo) {
		CompetitionInfo = competitionInfo;
	}


	public void setParticularYear(int particularYear) {
		ParticularYear = particularYear;
	}


	public void setContestPropaganda(String contestPropaganda) {
		ContestPropaganda = contestPropaganda;
	}


	public void setContestState(int contestState) {
		ContestState = contestState;
	}


	public void setContestPicUrl(String contestPicUrl) {
		ContestPicUrl = contestPicUrl;
	}


	public void setContestObject(int contestObject) {
		ContestObject = contestObject;
	}


	public void setContestSubject(String contestSubject) {
		ContestSubject = contestSubject;
	}


	public void setContestMoney(int contestMoney) {
		ContestMoney = contestMoney;
	}


	public void setContestexamType(String contestexamType) {
		ContestexamType = contestexamType;
	}


	public void setContestId(int contestId) {
		ContestId = contestId;
	}



	
	

}
