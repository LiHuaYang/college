package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchScord {
	private	String	StudentName	;//	报名人姓名
	private	String	StudentSex	;//	性别
	private	String	StudentSchool	;//	就读学校
	private	int	StudentGrade	;//	就读年级
	private	String	StudentPicture	;//	学生照片
	private	String	StudentTicket	;//	学生准考证号
	private	String	StartTime	;//	赛事开始时间
	private	int	ContestObject	;//	竞赛年级
	private	String	ContestSubject	;//	科目
	private	int	Studentscore	;//	学生成绩
	private	int	StudentRank	;//	学生排名
	private String CompetitionName;//大赛名称
	
	
	
	public SearchScord(ResultSet resultSet) throws SQLException{
		this.StudentName=resultSet.getString("StudentName");
		this.StudentSex=resultSet.getString("StudentSex");
		this.StudentSchool=resultSet.getString("StudentSchool");
		this.StudentGrade=resultSet.getInt("StudentGrade");
		this.StudentPicture=resultSet.getString("StudentPicture");
		this.StudentTicket=resultSet.getString("StudentTicket");
		this.StartTime=resultSet.getString("StartTime");
		this.ContestObject=resultSet.getInt("ContestObject");
		this.ContestSubject=resultSet.getString("ContestSubject");
		this.Studentscore=resultSet.getInt("Studentscore");
		this.StudentRank=resultSet.getInt("StudentRank");
		this.CompetitionName=resultSet.getString("CompetitionName");
	}


	public String getStudentName() {
		return StudentName;
	}


	public String getStudentSex() {
		return StudentSex;
	}


	public String getStudentSchool() {
		return StudentSchool;
	}


	public int getStudentGrade() {
		return StudentGrade;
	}


	public String getStudentPicture() {
		return StudentPicture;
	}


	public String getStudentTicket() {
		return StudentTicket;
	}


	public String getStartTime() {
		return StartTime;
	}


	public int getContestObject() {
		return ContestObject;
	}


	public String getContestSubject() {
		return ContestSubject;
	}


	public int getStudentscore() {
		return Studentscore;
	}


	public int getStudentRank() {
		return StudentRank;
	}


	public String getCompetitionName() {
		return CompetitionName;
	}


	@Override
	public String toString() {
		return "SearchScord [CompetitionName=" + CompetitionName
				+ ", ContestObject=" + ContestObject + ", ContestSubject="
				+ ContestSubject + ", StartTime=" + StartTime
				+ ", StudentGrade=" + StudentGrade + ", StudentName="
				+ StudentName + ", StudentPicture=" + StudentPicture
				+ ", StudentRank=" + StudentRank + ", StudentSchool="
				+ StudentSchool + ", StudentSex=" + StudentSex
				+ ", StudentTicket=" + StudentTicket + ", Studentscore="
				+ Studentscore + "]";
	}
	
	
	
	
}
