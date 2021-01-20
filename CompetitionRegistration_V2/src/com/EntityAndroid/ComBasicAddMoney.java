package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.EntityWeb.Contest;

public class ComBasicAddMoney {
	
	private	String	CompetitionName	;//	竞赛名称
	private	String	ContestPropaganda	;//	宣传语
	private	int	CompetitionSession	;//	竞赛届数
	private	String	CompetitionPicture	;//	比赛图片
	private	int	CompetitionId	;//	竞赛id
	private String CompetitionObjectDescribe ;//参赛对象描述
	private String CompetitionTimeDescribe ;//参赛时间描述
	private String CompetitionEnrollEndTime;   //报名截止时间
	private List<Contest> ContestList1;
	private List<Contest> ContestList2;
	
	
	
	public ComBasicAddMoney(String competitionName,
			String contestPropaganda,
			int competitionSession, String CompetitionPicture, int competitionId,
			String competitionObjectDescribe,String CompetitionTimeDescribe) {
		
		this.CompetitionName = competitionName;
		this.ContestPropaganda = contestPropaganda;
		this.CompetitionSession = competitionSession;
		this.CompetitionPicture = CompetitionPicture;
		this.CompetitionId = competitionId;
		this.CompetitionObjectDescribe = competitionObjectDescribe;
		this.CompetitionTimeDescribe=CompetitionTimeDescribe;
	}

	

	public ComBasicAddMoney(String competitionName, String competitionPicture,
			int competitionId, String competitionObjectDescribe,
			String competitionEnrollEndTime) {
		
		this.CompetitionName = competitionName;
		this.CompetitionPicture = competitionPicture;
		this.CompetitionId = competitionId;
		this.CompetitionObjectDescribe = competitionObjectDescribe;
		this.CompetitionEnrollEndTime = competitionEnrollEndTime;
	}



	public String getCompetitionName() {
		return CompetitionName;
	}
	
	public String getCompetitionEnrollEndTime() {
		return CompetitionEnrollEndTime;
	}



	public void setCompetitionName(String competitionName) {
		CompetitionName = competitionName;
	}



	public String getContestPropaganda() {
		return ContestPropaganda;
	}



	public void setContestPropaganda(String contestPropaganda) {
		ContestPropaganda = contestPropaganda;
	}



	public int getCompetitionSession() {
		return CompetitionSession;
	}



	public void setCompetitionSession(int competitionSession) {
		CompetitionSession = competitionSession;
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



	public String getCompetitionTimeDescribe() {
		return CompetitionTimeDescribe;
	}



	public void setCompetitionTimeDescribe(String competitionTimeDescribe) {
		CompetitionTimeDescribe = competitionTimeDescribe;
	}



	public List<Contest> getContestList1() {
		return ContestList1;
	}



	public void setContestList1(List<Contest> contestList1) {
		ContestList1 = contestList1;
	}



	public List<Contest> getContestList2() {
		return ContestList2;
	}



	public void setContestList2(List<Contest> contestList2) {
		ContestList2 = contestList2;
	}



	@Override
	public String toString() {
		return "ComBasicAddMoney [CompetitionEnrollEndTime="
				+ CompetitionEnrollEndTime + ", CompetitionId=" + CompetitionId
				+ ", CompetitionName=" + CompetitionName
				+ ", CompetitionObjectDescribe=" + CompetitionObjectDescribe
				+ ", CompetitionPicture=" + CompetitionPicture
				+ ", CompetitionSession=" + CompetitionSession
				+ ", CompetitionTimeDescribe=" + CompetitionTimeDescribe
				+ ", ContestList1=" + ContestList1 + ", ContestList2="
				+ ContestList2 + ", ContestPropaganda=" + ContestPropaganda
				+ "]";
	}


}
