package com.EntityAndroid;

import java.util.List;

import com.EntityWeb.Contest;

public class CompetitionMainWebBasicInfo {

	private	String	CompetitionPicture	;//	比赛图片
	private	int	CompetitionId	;//	竞赛id
	private String CompetitionObjectDescribe ;//参赛对象描述
	private	String	CompetitionName	;//	竞赛名称
	private	String	CompetitionEnrollStartTime; //开始报名时间
	private	String	CompetitionEnrollEndTime	;//	竞赛结束报名时间
	private	String	ContestSubject	;//	比赛科目
	private String ContestexamType;//考试形式
	private List<Contest> contetList; // 
	


	public CompetitionMainWebBasicInfo(int CompetitionId,String CompetitionPicture,
			String CompetitionEnrollStartTime,String CompetitionName,String CompetitionObjectDescribe,
			String	CompetitionEnrollEndTime){
		this.CompetitionId=CompetitionId;
		this.CompetitionPicture=CompetitionPicture;
		this.CompetitionEnrollStartTime=CompetitionEnrollStartTime;
		this.CompetitionName=CompetitionName;
		this.CompetitionObjectDescribe=CompetitionObjectDescribe;
		this.CompetitionEnrollEndTime=CompetitionEnrollEndTime;
	}
	
	public CompetitionMainWebBasicInfo(int CompetitionId,String ContestSubject,String ContestexamType){
		this.CompetitionId=CompetitionId;
		this.ContestSubject=ContestSubject;
		this.ContestexamType=ContestexamType;
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

	public String getContestSubject() {
		return ContestSubject;
	}

	public void setContestSubject(String contestSubject) {
		ContestSubject = contestSubject;
	}

	public String getContestexamType() {
		return ContestexamType;
	}

	public void setContestexamType(String contestexamType) {
		ContestexamType = contestexamType;
	}

	public List<Contest> getContetList() {
		return contetList;
	}

	public void setContetList(List<Contest> contetList) {
		this.contetList = contetList;
	}

	@Override
	public String toString() {
		return "CompetitionMainWebBasicInfo [CompetitionEnrollEndTime="
				+ CompetitionEnrollEndTime + ", CompetitionEnrollStartTime="
				+ CompetitionEnrollStartTime + ", CompetitionId="
				+ CompetitionId + ", CompetitionName=" + CompetitionName
				+ ", CompetitionObjectDescribe=" + CompetitionObjectDescribe
				+ ", CompetitionPicture=" + CompetitionPicture
				+ ", ContestSubject=" + ContestSubject + ", ContestexamType="
				+ ContestexamType + ", contetList=" + contetList + "]";
	}
	
	
}
