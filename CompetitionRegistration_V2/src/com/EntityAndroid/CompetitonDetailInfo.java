package com.EntityAndroid;

import java.util.List;

import com.EntityWeb.Contest;

public class CompetitonDetailInfo {
	private	String	CompetitionName	;//	竞赛名称
	private	String	CompetitionEnrollStartTime	;//	赛事开始报名时间
	private	String	CompetitionEnrollEndTime	;//	竞赛结束报名时间
	private	String	ContestPropaganda	;//	宣传语
	private	int	CompetitionSession	;//	竞赛届数
	private	String	CompetitionPicture	;//	比赛图片
	private	int	CompetitionId	;//	竞赛id
	private String CompetitionObjectDescribe ;//参赛对象描述
	private String CompetitionTimeDescribe;//赛事时间说明
	private String CompetitionInfo;//竞赛状态
	private int CompetitionState;//比赛状态
	private List<Contest> ContestList1;
	private List<Contest> ContestList2;
	
	public CompetitonDetailInfo(String CompetitionName,String CompetitionEnrollStartTime,
			String CompetitionEnrollEndTime,String ContestPropaganda,int CompetitionSession,
			int CompetitionId,String CompetitionObjectDescribe,int CompetitionState,
			String CompetitionInfo,String CompetitionTimeDescribe,String CompetitionPicture){
		this.CompetitionName=CompetitionName;
		this.CompetitionEnrollStartTime=CompetitionEnrollStartTime;
		this.CompetitionEnrollEndTime=CompetitionEnrollEndTime;
		this.ContestPropaganda=ContestPropaganda;
		this.CompetitionSession=CompetitionSession;
		this.CompetitionId=CompetitionId;
		this.CompetitionObjectDescribe=CompetitionObjectDescribe;
		this.CompetitionState=CompetitionState;
		this.CompetitionInfo=CompetitionInfo;
		this.CompetitionTimeDescribe=CompetitionTimeDescribe;
		this.CompetitionPicture=CompetitionPicture;
	}

	public String getCompetitionName() {
		return CompetitionName;
	}

	public void setCompetitionName(String competitionName) {
		CompetitionName = competitionName;
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

	public String getCompetitionInfo() {
		return CompetitionInfo;
	}

	public void setCompetitionInfo(String competitionInfo) {
		CompetitionInfo = competitionInfo;
	}

	public int getCompetitionState() {
		return CompetitionState;
	}

	public void setCompetitionState(int competitionState) {
		CompetitionState = competitionState;
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
		return "CompetitonDetailInfo [CompetitionEnrollEndTime="
				+ CompetitionEnrollEndTime + ", CompetitionEnrollStartTime="
				+ CompetitionEnrollStartTime + ", CompetitionId="
				+ CompetitionId + ", CompetitionInfo=" + CompetitionInfo
				+ ", CompetitionName=" + CompetitionName
				+ ", CompetitionObjectDescribe=" + CompetitionObjectDescribe
				+ ", CompetitionPicture=" + CompetitionPicture
				+ ", CompetitionSession=" + CompetitionSession
				+ ", CompetitionState=" + CompetitionState
				+ ", CompetitionTimeDescribe=" + CompetitionTimeDescribe
				+ ", ContestList1=" + ContestList1 + ", ContestList2="
				+ ContestList2 + ", ContestPropaganda=" + ContestPropaganda
				+ "]";
	}
	
	


}
