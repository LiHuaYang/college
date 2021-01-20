package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;

//竞赛项目表
public class Contest {

	private	int	ContestId	;//	竞赛项目id
	private	int	ContestObject	;//	竞赛年级
	private	String	ContestSubject	;//	科目
	private	int	ContestMoney	;//	报名费
	private	int	CompetitionId	;//	竞赛id
	private int ContestState   ;//竞赛状态
	private	String	StartTime	;//	赛事开始时间
	private	String	EndTime	;//	竞赛结束时间
	
	private	String	ContestexamType	;//	考试类型
	
	private	String	ContestPicUrl	;//	考试类型
	
	public Contest () {}
	
	

	public void setContestId(int contestId) {
		ContestId = contestId;
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



	public void setCompetitionId(int competitionId) {
		CompetitionId = competitionId;
	}


	public void setContestState(int contestState) {
		ContestState = contestState;
	}


	public void setStartTime(String startTime) {
		StartTime = startTime;
	}


	public void setEndTime(String endTime) {
		EndTime = endTime;
	}



	public void setContestexamType(String contestexamType) {
		ContestexamType = contestexamType;
	}

	
	
	
	public String getContestPicUrl() {
		return ContestPicUrl;
	}



	public void setContestPicUrl(String contestPicUrl) {
		ContestPicUrl = contestPicUrl;
	}



	public Contest(int ContestId,int ContestObject, String ContestSubject,int ContestMoney, 
			int CompetitionId,String StartTime,
			String EndTime,String	ContestexamType) {
		this.ContestId = ContestId;
		this.ContestObject = ContestObject;
		this.ContestSubject = ContestSubject;
		this.ContestMoney = ContestMoney;
		this.CompetitionId = CompetitionId;
		this.ContestState = 0;
		this.StartTime = StartTime;
		this.EndTime = EndTime;
		this.ContestexamType = ContestexamType;
	}
	
	public Contest(String ContestSubject){
		this.ContestSubject=ContestSubject;
	}
	
	public Contest(ResultSet resultSet) throws SQLException{
		this.ContestId=resultSet.getInt("ContestId");
		this.CompetitionId=resultSet.getInt("CompetitionId");
		this.ContestObject=resultSet.getInt("ContestObject");
		this.ContestSubject=resultSet.getString("ContestSubject");
		this.ContestMoney=resultSet.getInt("ContestMoney");		
		this.ContestState=resultSet.getInt("ContestState");
		this.StartTime=resultSet.getString("StartTime");		
		this.EndTime=resultSet.getString("EndTime");
		this.ContestexamType=resultSet.getString("ContestexamType");
	}


	public int getContestId() {
		return ContestId;
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


	public int getCompetitionId() {
		return CompetitionId;
	}


	public int getContestState() {
		return ContestState;
	}


	public String getStartTime() {
		return StartTime;
	}


	public String getEndTime() {
		return EndTime;
	}




	public String getContestexamType() {
		return ContestexamType;
	}



	@Override
	public String toString() {
		return "Contest [CompetitionId=" + CompetitionId + ", ContestId="
				+ ContestId + ", ContestMoney=" + ContestMoney
				+ ", ContestObject=" + ContestObject + ", ContestPicUrl="
				+ ContestPicUrl + ", ContestState=" + ContestState
				+ ", ContestSubject=" + ContestSubject + ", ContestexamType="
				+ ContestexamType + ", EndTime=" + EndTime + ", StartTime="
				+ StartTime + "]";
	}



	
	


	
	

	

}
