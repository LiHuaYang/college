package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserScoreInfo {
	private String StudentName;  //报名人的姓名
	private String StudentGrade; //就读年级
	private String CompetitionName;   //竞赛名称
	private String ContestSubject;   //科目
	private int CompetitionSession;  //竞赛届数
	private int Studentscore;  //成绩
	private String OrganizationAddress; // 准考证领取地址
	
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getOrganizationAddress() {
		return OrganizationAddress;
	}

	public void setOrganizationAddress(String organizationAddress) {
		OrganizationAddress = organizationAddress;
	}

	public void setStudentGrade(String studentGrade) {
		StudentGrade = studentGrade;
	}

	public void setCompetitionName(String competitionName) {
		CompetitionName = competitionName;
	}

	public void setContestSubject(String contestSubject) {
		ContestSubject = contestSubject;
	}

	public void setCompetitionSession(int competitionSession) {
		CompetitionSession = competitionSession;
	}

	public void setStudentscore(int studentscore) {
		Studentscore = studentscore;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public void setCompetitionId(int competitionId) {
		CompetitionId = competitionId;
	}

	private String StartTime;   //比赛开始时间
	private int CompetitionId;    //大赛id
	
	public UserScoreInfo(String StudentName, String StudentGrade,
			String CompetitionName, String ContestSubject,
			int CompetitionSession, int Studentscore,String StartTime,int CompetitionId){
		this.StudentName = StudentName;
		this.StudentGrade = StudentGrade;
		this.CompetitionName = CompetitionName;
		this.ContestSubject = ContestSubject;
		this.CompetitionSession = CompetitionSession;
		this.Studentscore = Studentscore;
		this.StartTime=StartTime;
		this.CompetitionId=CompetitionId;
	}
	
	public UserScoreInfo(ResultSet resultSet) throws SQLException{
		this.StudentName=resultSet.getString("StudentName");
		this.StudentGrade=resultSet.getString("StudentGrade");
		this.CompetitionName=resultSet.getString("CompetitionName");
		this.ContestSubject=resultSet.getString("ContestSubject");
		this.CompetitionSession=resultSet.getInt("CompetitionSession");
		this.Studentscore=resultSet.getInt("Studentscore");
		this.StartTime=resultSet.getString("StartTime");
		this.CompetitionId=resultSet.getInt("CompetitionId");
	}
	
	

	public UserScoreInfo(String studentGrade, String competitionName,
			String contestSubject, int competitionSession, String startTime,
			int competitionId) {
		this.StudentGrade = studentGrade;
		this.CompetitionName = competitionName;
		this.ContestSubject = contestSubject;
		this.CompetitionSession = competitionSession;
		this.StartTime = startTime;
		this.CompetitionId = competitionId;
	}
	public UserScoreInfo(String studentGrade, String competitionName,
			String contestSubject, int competitionSession, String startTime,
			int competitionId,String studentName) {
		this.StudentGrade = studentGrade;
		this.CompetitionName = competitionName;
		this.ContestSubject = contestSubject;
		this.CompetitionSession = competitionSession;
		this.StartTime = startTime;
		this.CompetitionId = competitionId;
		this.StudentName = studentName;
	}

	public String getStudentName() {
		return StudentName;
	}

	public String getStudentGrade() {
		return StudentGrade;
	}

	public String getCompetitionName() {
		return CompetitionName;
	}

	public String getContestSubject() {
		return ContestSubject;
	}

	public int getCompetitionSession() {
		return CompetitionSession;
	}

	public int getStudentscore() {
		return Studentscore;
	}

	public String getStartTime() {
		return StartTime;
	}

	public int getCompetitionId() {
		return CompetitionId;
	}

	@Override
	public String toString() {
		return "UserScoreInfo [CompetitionId=" + CompetitionId
				+ ", CompetitionName=" + CompetitionName
				+ ", CompetitionSession=" + CompetitionSession
				+ ", ContestSubject=" + ContestSubject + ", StartTime="
				+ StartTime + ", StudentGrade=" + StudentGrade
				+ ", StudentName=" + StudentName + ", Studentscore="
				+ Studentscore + "]";
	}

	
}
