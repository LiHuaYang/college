package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompetitionUserStandInfo {

	private	String	ContestName	;//	比赛名字
	private	String	ContestStartTime	;//	比赛时间
	private	String	UserPhone	;//	用户号码
	private	String	ContestTicketDetailAddress	;//	准考证领取地址
	private	String	ContestExamDetailAddress	;//	比赛地点
	private	int	ContestNumber	;//	比赛届数
	
	
	public CompetitionUserStandInfo(String ContestName,String ContestStartTime,String UserPhone,
			String ContestTicketDetailAddress,String ContestExamDetailAddress,int ContestNumber){
		this.ContestName=ContestName;
		this.ContestStartTime=ContestStartTime;
		this.UserPhone=UserPhone;
		this.ContestTicketDetailAddress=ContestTicketDetailAddress;
		this.ContestExamDetailAddress=ContestExamDetailAddress;
		this.ContestNumber=ContestNumber;
	}
	
	public CompetitionUserStandInfo(ResultSet resultSet) throws SQLException{
		this.ContestName=resultSet.getString("ContestName");
		this.ContestStartTime=resultSet.getString("ContestStartTime");
		this.UserPhone=resultSet.getString("UserPhonev");
		this.ContestTicketDetailAddress=resultSet.getString("ContestTicketDetailAddress");
		this.ContestExamDetailAddress=resultSet.getString("ContestExamDetailAddress");
		this.ContestNumber=resultSet.getInt("ContestNumber");
		
	}
	
	
	
	
	public String getContestName() {
		return ContestName;
	}

	public String getContestStartTime() {
		return ContestStartTime;
	}

	public String getUserPhone() {
		return UserPhone;
	}

	public String getContestTicketDetailAddress() {
		return ContestTicketDetailAddress;
	}

	public String getContestExamDetailAddress() {
		return ContestExamDetailAddress;
	}

	public int getContestNumber() {
		return ContestNumber;
	}

	@Override
	public String toString() {
		return "CompetitionUserStandInfo [ContestExamDetailAddress="
				+ ContestExamDetailAddress + ", ContestName=" + ContestName
				+ ", ContestNumber=" + ContestNumber + ", ContestStartTime="
				+ ContestStartTime + ", ContestTicketDetailAddress="
				+ ContestTicketDetailAddress + ", UserPhone=" + UserPhone + "]";
	}

	
	
}
