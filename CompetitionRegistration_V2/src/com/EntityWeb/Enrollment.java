package com.EntityWeb;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Enrollment {

	private	int	enrollmentid	;//	报名id
	private	String	StudentName	;//	报名人姓名
	private	String	StudentSex	;//	性别
	private	String	StudentIDNumber	;//	报名人身份证号
	private	String	StudentSchool	;//	就读学校
	private	int	StudentGrade	;//	就读年级
	private	String	StudentContactsMan	;//	联系人
	private	String	StudentContactsPhon	;//	联系电话
	private	String	UserAddress	;//	地址
	private	String	StudentTeacher	;//	指导老师
	private	String	StudentTeacherPhon	;//	指导老师电话
	private	String	StudentPicture	;//	学生照片
	private	String	CompetitionName	;//	竞赛名称
	private	int	CompetitionSession	;//	竞赛届数
	private	int	ContestObject	;//	竞赛年级
	private	String	ContestSubject	;//	科目
	private	int	ContestMoney	;//	报名费
	private int ContestState; //赛事状态
	private	String	StartTime	;//	赛事开始时间
	private	String	EndTime	;//	赛事结束时间
	private	String	OrganizationName	;//	承办方名称
	private	int	enrollmentState	;//	报名状态
	private	String	StudentTicket	;//	学生准考证号
	private	int	Studentscore	;//	学生成绩
	private	int	StudentRank	;//	学生排名
	private	int	ContestId	;//	竞赛项目id
	private	int	OrganizationId	;//	承办方id
	private	int	UserId	;//	用户id
	private String EnrollmentTime;//报名时间
	
	private String EnrollmentPassword;
	

	public Enrollment() {}
	
	
	public void setEnrollmentid(int enrollmentid) {
		this.enrollmentid = enrollmentid;
	}


	public void setStudentName(String studentName) {
		StudentName = studentName;
	}


	public void setStudentSex(String studentSex) {
		StudentSex = studentSex;
	}


	public void setStudentIDNumber(String studentIDNumber) {
		StudentIDNumber = studentIDNumber;
	}


	public void setStudentSchool(String studentSchool) {
		StudentSchool = studentSchool;
	}


	public void setStudentGrade(int studentGrade) {
		StudentGrade = studentGrade;
	}


	public void setStudentContactsMan(String studentContactsMan) {
		StudentContactsMan = studentContactsMan;
	}


	public void setStudentContactsPhon(String studentContactsPhon) {
		StudentContactsPhon = studentContactsPhon;
	}


	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}


	public void setStudentTeacher(String studentTeacher) {
		StudentTeacher = studentTeacher;
	}


	public void setStudentTeacherPhon(String studentTeacherPhon) {
		StudentTeacherPhon = studentTeacherPhon;
	}


	public void setStudentPicture(String studentPicture) {
		StudentPicture = studentPicture;
	}


	public void setCompetitionName(String competitionName) {
		CompetitionName = competitionName;
	}


	public void setCompetitionSession(int competitionSession) {
		CompetitionSession = competitionSession;
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


	public void setContestState(int contestState) {
		ContestState = contestState;
	}


	public void setStartTime(String startTime) {
		StartTime = startTime;
	}


	public void setEndTime(String endTime) {
		EndTime = endTime;
	}


	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}


	public void setEnrollmentState(int enrollmentState) {
		this.enrollmentState = enrollmentState;
	}


	public void setStudentTicket(String studentTicket) {
		StudentTicket = studentTicket;
	}


	public void setStudentscore(int studentscore) {
		Studentscore = studentscore;
	}


	public void setStudentRank(int studentRank) {
		StudentRank = studentRank;
	}


	public void setContestId(int contestId) {
		ContestId = contestId;
	}


	public void setOrganizationId(int organizationId) {
		OrganizationId = organizationId;
	}


	public void setUserId(int userId) {
		UserId = userId;
	}


	public void setEnrollmentTime(String enrollmentTime) {
		EnrollmentTime = enrollmentTime;
	}


	public Enrollment(String StudentName,
			String StudentSex, String StudentIDNumber, String StudentSchool,
			int StudentGrade, String StudentContactsMan,String StudentContactsPhon, 
			String UserAddress, String StudentTeacher,String StudentTeacherPhon, 
			String StudentPicture, String CompetitionName,int CompetitionSession, 
			int ContestObject,String ContestSubject,int ContestMoney,
			String StartTime, String EndTime,String OrganizationName,int enrollmentState,
			String StudentTicket, int Studentscore,int StudentRank,int ContestId,
			int OrganizationId,int UserId) {
		this.enrollmentid = enrollmentid;
		this.StudentName = StudentName;
		this.StudentSex = StudentSex;
		this.StudentIDNumber = StudentIDNumber;
		this.StudentSchool = StudentSchool;
		this.StudentGrade = StudentGrade;
		this.StudentContactsMan = StudentContactsMan;
		this.StudentContactsPhon = StudentContactsPhon;
		this.UserAddress = UserAddress;
		this.StudentTeacher = StudentTeacher;
		this.StudentTeacherPhon = StudentTeacherPhon;
		this.StudentPicture = StudentPicture;
		this.CompetitionName = CompetitionName;
		this.CompetitionSession = CompetitionSession;
		this.ContestObject = ContestObject;
		this.ContestSubject = ContestSubject;
		this.ContestMoney = ContestMoney;
		this.StartTime = StartTime;
		this.EndTime = EndTime;
		this.OrganizationName = OrganizationName;
		this.enrollmentState = 0;
		this.StudentTicket = StudentTicket;
		this.Studentscore = Studentscore;
		this.StudentRank = StudentRank;
		this.ContestId = ContestId;
		this.OrganizationId = OrganizationId;
		this.UserId = UserId;
	}
	
	public Enrollment(String StudentName,
			String StudentSex, String StudentIDNumber, String StudentSchool,
			int StudentGrade, String StudentContactsMan,String StudentContactsPhon, 
			String UserAddress, String StudentTeacher,String StudentTeacherPhon, 
			String StudentPicture, String CompetitionName,int CompetitionSession, 
			int ContestObject,String ContestSubject,int ContestMoney,
			String StartTime, String EndTime,String OrganizationName,
	        int ContestId,int OrganizationId,int UserId,int enrollmentState) {
		this.enrollmentid = enrollmentid;
		this.StudentName = StudentName;
		this.StudentSex = StudentSex;
		this.StudentIDNumber = StudentIDNumber;
		this.StudentSchool = StudentSchool;
		this.StudentGrade = StudentGrade;
		this.StudentContactsMan = StudentContactsMan;
		this.StudentContactsPhon = StudentContactsPhon;
		this.UserAddress = UserAddress;
		this.StudentTeacher = StudentTeacher;
		this.StudentTeacherPhon = StudentTeacherPhon;
		this.StudentPicture = StudentPicture;
		this.CompetitionName = CompetitionName;
		this.CompetitionSession = CompetitionSession;
		this.ContestObject = ContestObject;
		this.ContestSubject = ContestSubject;
		this.ContestMoney = ContestMoney;
		this.StartTime = StartTime;
		this.EndTime = EndTime;
		this.OrganizationName = OrganizationName;
		this.enrollmentState = enrollmentState;
		this.ContestId = ContestId;
		this.OrganizationId = OrganizationId;
		this.UserId = UserId;
		this.ContestState=2;
		this.Studentscore=-1;
		
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.EnrollmentTime=s.format( new Date());
	}
	public Enrollment(String StudentName,
			String StudentSex, String StudentIDNumber, String StudentSchool,
			int StudentGrade, String StudentContactsMan,String StudentContactsPhon, 
			String UserAddress, String StudentTeacher,String StudentTeacherPhon, 
			String StudentPicture, String CompetitionName,int CompetitionSession, 
			int ContestObject,String ContestSubject,int ContestMoney,
			String StartTime, String EndTime,String OrganizationName,int enrollmentState,
			String StudentTicket, int Studentscore,int StudentRank) {
		this.StudentName = StudentName;
		this.StudentSex = StudentSex;
		this.StudentIDNumber = StudentIDNumber;
		this.StudentSchool = StudentSchool;
		this.StudentGrade = StudentGrade;
		this.StudentContactsMan = StudentContactsMan;
		this.StudentContactsPhon = StudentContactsPhon;
		this.UserAddress = UserAddress;
		this.StudentTeacher = StudentTeacher;
		this.StudentTeacherPhon = StudentTeacherPhon;
		this.StudentPicture = StudentPicture;
		this.CompetitionName = CompetitionName;
		this.CompetitionSession = CompetitionSession;
		this.ContestObject = ContestObject;
		this.ContestSubject = ContestSubject;
		this.ContestMoney = ContestMoney;
		this.StartTime = StartTime;
		this.EndTime = EndTime;
		this.OrganizationName = OrganizationName;
		this.enrollmentState = enrollmentState;
		this.StudentTicket = StudentTicket;
		this.Studentscore = Studentscore;
		this.StudentRank = StudentRank;
	}
	
	public Enrollment(String StudentName,
			String StudentContactsPhon, 
			String CompetitionName, 
			String ContestSubject,
			int enrollmentState,
	        int OrganizationId,int UserId,int enrollmentid,int studentscore) {
		this.enrollmentid = enrollmentid;
		this.StudentName = StudentName;
		this.StudentContactsPhon = StudentContactsPhon;
		this.CompetitionName = CompetitionName;
		this.ContestSubject = ContestSubject;
		this.enrollmentState = enrollmentState;
		this.OrganizationId = OrganizationId;
		this.UserId = UserId;
		this.Studentscore = studentscore;
	}





	public Enrollment(String competitionName) {
		this.CompetitionName = competitionName;
	}
	

	public int getEnrollmentid() {
		return enrollmentid;
	}

	public String getStudentName() {
		return StudentName;
	}

	public String getStudentSex() {
		return StudentSex;
	}

	public String getStudentIDNumber() {
		return StudentIDNumber;
	}

	public String getStudentSchool() {
		return StudentSchool;
	}

	public int getStudentGrade() {
		return StudentGrade;
	}

	public String getStudentContactsMan() {
		return StudentContactsMan;
	}

	public String getStudentContactsPhon() {
		return StudentContactsPhon;
	}

	public String getUserAddress() {
		return UserAddress;
	}

	public String getStudentTeacher() {
		return StudentTeacher;
	}

	public String getStudentTeacherPhon() {
		return StudentTeacherPhon;
	}

	public String getStudentPicture() {
		return StudentPicture;
	}

	public String getCompetitionName() {
		return CompetitionName;
	}

	public int getCompetitionSession() {
		return CompetitionSession;
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

	public int getContestState() {
		return ContestState;
	}

	public String getStartTime() {
		return StartTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public String getOrganizationName() {
		return OrganizationName;
	}

	public int getEnrollmentState() {
		return enrollmentState;
	}

	public String getStudentTicket() {
		return StudentTicket;
	}

	public int getStudentscore() {
		return Studentscore;
	}

	public int getStudentRank() {
		return StudentRank;
	}

	public int getContestId() {
		return ContestId;
	}

	public int getOrganizationId() {
		return OrganizationId;
	}

	public int getUserId() {
		return UserId;
	}

	public String getEnrollmentTime() {
		return EnrollmentTime;
	}
	
	public String getEnrollmentPassword() {
		return EnrollmentPassword;
	}


	public void setEnrollmentPassword(String enrollmentPassword) {
		EnrollmentPassword = enrollmentPassword;
	}


	@Override
	public String toString() {
		return "Enrollment [CompetitionName=" + CompetitionName
				+ ", CompetitionSession=" + CompetitionSession + ", ContestId="
				+ ContestId + ", ContestMoney=" + ContestMoney
				+ ", ContestObject=" + ContestObject + ", ContestState="
				+ ContestState + ", ContestSubject=" + ContestSubject
				+ ", EndTime=" + EndTime + ", EnrollmentTime=" + EnrollmentTime
				+ ", OrganizationId=" + OrganizationId + ", OrganizationName="
				+ OrganizationName + ", StartTime=" + StartTime
				+ ", StudentContactsMan=" + StudentContactsMan
				+ ", StudentContactsPhon=" + StudentContactsPhon
				+ ", StudentGrade=" + StudentGrade + ", StudentIDNumber="
				+ StudentIDNumber + ", StudentName=" + StudentName
				+ ", StudentPicture=" + StudentPicture + ", StudentRank="
				+ StudentRank + ", StudentSchool=" + StudentSchool
				+ ", StudentSex=" + StudentSex + ", StudentTeacher="
				+ StudentTeacher + ", StudentTeacherPhon=" + StudentTeacherPhon
				+ ", StudentTicket=" + StudentTicket + ", Studentscore="
				+ Studentscore + ", UserAddress=" + UserAddress + ", UserId="
				+ UserId + ", enrollmentState=" + enrollmentState
				+ ", enrollmentid=" + enrollmentid + "]";
	}

	



//	public Enrollment(ResultSet resultSet) throws SQLException{
//		this.Address=resultSet.getString("Address");
//		this.Classes=resultSet.getString("Classes");
//		this.ContactsMan=resultSet.getString("ContactsMan");
//		this.ContactsPhon=resultSet.getString("ContactsPhon");
//		this.ContestId=resultSet.getInt("ContestId");
//		this.OrganizationId=resultSet.getInt("OrganizationId");
//		this.StudentIDNumber=resultSet.getString("StudentIDNumber");
//		this.StudentName=resultSet.getString("StudentName");
//		this.StudentPicture=resultSet.getString("StudentPicture");
//		this.StudentRank=resultSet.getInt("StudentRank");
//		this.StudentSchool=resultSet.getString("StudentSchool");
//		this.StudentSex=resultSet.getString("StudentSex");
//		this.StudentTeacher=resultSet.getString("StudentTeacher");
//		this.StudentTeacherPhon=resultSet.getString("StudentTeacherPhon");
//		this.StudentTicket=resultSet.getString("StudentTicket");
//		this.StudentYear=resultSet.getInt("StudentYear");
//		this.Studentscore=resultSet.getInt("Studentscore");
//		this.UserId=resultSet.getInt("UserId");
//		this.enrollmentid=resultSet.getInt("enrollmentid");
//	}
	
}
