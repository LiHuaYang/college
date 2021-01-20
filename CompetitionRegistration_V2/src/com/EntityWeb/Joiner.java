package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Joiner {
	
	private String StudentName;  //竞赛人员姓名
	private String CompetitionName;   //竞赛人员参加的大赛
	private String ContestSubject;       //大赛科目
	private int enrollmentState;     //参赛报名状态
	private int ContestObject;   //参赛对象
	private String StudentContactsPhon;    //联系电话
	
	
	public Joiner(String studentName, String competitionName,
			String contestSubject, int enrollmentState, int contestObject,
			String studentContactsPhon) {
		this.StudentName = studentName;
		this.CompetitionName = competitionName;
		this.ContestSubject = contestSubject;
		this.enrollmentState = enrollmentState;
		this.ContestObject = contestObject;
		this.StudentContactsPhon = studentContactsPhon;
	}

	public Joiner(ResultSet resultSet) throws SQLException{
		
		this.StudentName=resultSet.getString("StudentName");
		this.CompetitionName=resultSet.getString("CompetitionName");
		this.ContestSubject=resultSet.getString("ContestSubject");
		this.enrollmentState=resultSet.getInt("enrollmentState");
		this.ContestObject=resultSet.getInt("ContestObject");
		this.StudentContactsPhon=resultSet.getString("StudentContactsPhon");
	}

	public String getStudentName() {
		return StudentName;
	}

	public String getCompetitionName() {
		return CompetitionName;
	}

	public String getContestSubject() {
		return ContestSubject;
	}

	public int getEnrollmentState() {
		return enrollmentState;
	}

	public int getContestObject() {
		return ContestObject;
	}

	public String getStudentContactsPhon() {
		return StudentContactsPhon;
	}

	@Override
	public String toString() {
		return "Joiner [CompetitionName=" + CompetitionName
				+ ", ContestObject=" + ContestObject + ", ContestSubject="
				+ ContestSubject + ", StudentContactsPhon="
				+ StudentContactsPhon + ", StudentName=" + StudentName
				+ ", enrollmentState=" + enrollmentState + "]";
	}
	
	
}
