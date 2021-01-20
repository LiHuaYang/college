package com.EntityWeb;

import java.sql.SQLException;

import java.sql.ResultSet;

public class StudentScoreInfo {

	private String StudentName;  // 学生姓名
	private String StudentTicket;// 学生准考证号
	private String Studentscore;// 学生成绩
	private String CompetitionName;// 大赛名字
	private String CompetitionSession;// 大赛届数
	private String ContestSubject;// 比赛科目
	private int ContestObject; // 竞赛年级
	
	public  StudentScoreInfo() {}
	
	public StudentScoreInfo(ResultSet rs) throws SQLException {
		this.CompetitionName = rs.getString("CompetitionName");
		this.CompetitionSession = rs.getString("CompetitionSession");
		this.ContestSubject = rs.getString("ContestSubject");
		this.StudentName = rs.getString("StudentName");
		this.Studentscore = rs.getString("Studentscore");
		this.StudentTicket = rs.getString("StudentTicket");
		this.ContestObject = rs.getInt("ContestObject");
	}
	
	public String getStudentName() {
		return StudentName;
	}
	public int getContestObject() {
		return ContestObject;
	}

	public void setContestObject(int contestObject) {
		ContestObject = contestObject;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentTicket() {
		return StudentTicket;
	}
	public void setStudentTicket(String studentTicket) {
		StudentTicket = studentTicket;
	}
	public String getStudentscore() {
		return Studentscore;
	}
	public void setStudentscore(String studentscore) {
		Studentscore = studentscore;
	}
	public String getCompetitionName() {
		return CompetitionName;
	}
	public void setCompetitionName(String competitionName) {
		CompetitionName = competitionName;
	}
	public String getCompetitionSession() {
		return CompetitionSession;
	}
	public void setCompetitionSession(String competitionSession) {
		CompetitionSession = competitionSession;
	}
	public String getContestSubject() {
		return ContestSubject;
	}
	public void setContestSubject(String contestSubject) {
		ContestSubject = contestSubject;
	}
	
	
	
	
}
