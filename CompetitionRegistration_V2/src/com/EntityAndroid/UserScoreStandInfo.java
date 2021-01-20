package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserScoreStandInfo {

	private	String	ContestName	;//	比赛名字
	private	String	ContestSubject	;//	比赛科目
	private	int	ContestNumber	;//	比赛届数
	private	String	ContestStartTime	;//	比赛开始时间
	private	String	ContestEndTime	;//	比赛结束时间
	private	int	UserContestScore	;//	用户比赛成绩
	private	int	UserContestRanking	;//	比赛排名
	private	String	UserContestLevel	;//	参赛级别
	
	
	public UserScoreStandInfo(String ContestName,String ContestSubject,int ContestNumber,
			String	ContestStartTime,String ContestEndTime,int UserContestScore,
			int UserContestRanking,String UserContestLevel){
		this.ContestName=ContestName;
		this.ContestSubject=ContestSubject;
		this.ContestNumber=ContestNumber;
		this.ContestStartTime=ContestStartTime;
		this.ContestEndTime=ContestEndTime;
		this.UserContestScore=UserContestScore;
		this.UserContestRanking=UserContestRanking;
		this.UserContestLevel=UserContestLevel;
		
	}
	
	public UserScoreStandInfo(ResultSet resultSet) throws SQLException{
		this.ContestName=resultSet.getString("ContestName");
		this.ContestSubject=resultSet.getString("ContestSubject");
		this.ContestNumber=resultSet.getInt("ContestNumber");
		this.ContestStartTime=resultSet.getString("ContestStartTime");
		this.ContestEndTime=resultSet.getString("ContestEndTime");
		this.UserContestScore=resultSet.getInt("UserContestScore");
		this.UserContestRanking=resultSet.getInt("UserContestRanking");
		this.UserContestLevel=resultSet.getString("UserContestLevel");
		
	}
	
	
	public String getContestName() {
		return ContestName;
	}

	public String getContestSubject() {
		return ContestSubject;
	}

	public int getContestNumber() {
		return ContestNumber;
	}

	public String getContestStartTime() {
		return ContestStartTime;
	}

	public String getContestEndTime() {
		return ContestEndTime;
	}

	public int getUserContestScore() {
		return UserContestScore;
	}

	public int getUserContestRanking() {
		return UserContestRanking;
	}

	public String getUserContestLevel() {
		return UserContestLevel;
	}

	@Override
	public String toString() {
		return "UserScoreStandInfo [ContestEndTime=" + ContestEndTime
				+ ", ContestName=" + ContestName + ", ContestNumber="
				+ ContestNumber + ", ContestStartTime=" + ContestStartTime
				+ ", ContestSubject=" + ContestSubject + ", UserContestLevel="
				+ UserContestLevel + ", UserContestRanking="
				+ UserContestRanking + ", UserContestScore=" + UserContestScore
				+ "]";
	}

}
