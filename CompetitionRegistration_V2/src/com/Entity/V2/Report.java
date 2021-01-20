package com.Entity.V2;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Tool.MyOpecode;
import com.Tool.sql.SqlHelper;

import net.sf.json.JSONObject;

public class Report {

	private String studentName;             //学生姓名
	private String studentTicket;           //学生准考证号
	private String enrollmentPassword;      //查成绩密码
	private String studentIDNumber;         //学生身份证号
	
	private String studentScore;            //学生分数
	
	private String competitionName;         //赛事名称
	private String competitionSession;      //赛事届数
	private String contestObject;           //比赛等级
	private String contestSubject;          //比赛科目
	
	//默认构造函数
	public Report() {}
	
	
	public Report(ResultSet resultSet,String condition) throws SQLException{

		if(condition == MyOpecode.report.reportCon){
			while(resultSet.next()){
				if (SqlHelper.isExistColumn(resultSet, "CompetitionName")) {
					this.competitionName = resultSet.getString("CompetitionName");
				}
				if(SqlHelper.isExistColumn(resultSet, "StudentName")){
					this.studentName = resultSet.getString("StudentName");
				}
				if(SqlHelper.isExistColumn(resultSet, "studentTicket")){
					this.studentTicket = resultSet.getString("studentTicket");
				}
				if(SqlHelper.isExistColumn(resultSet, "ContestObject")){
					this.contestObject = resultSet.getString("ContestObject");
				}
				if(SqlHelper.isExistColumn(resultSet, "ContestSubject")){
					this.contestSubject = resultSet.getString("ContestSubject");
				}
				if(SqlHelper.isExistColumn(resultSet, "StudentScore")){
					this.studentScore = resultSet.getString("StudentScore");
				}
			}
		}
		if(condition == MyOpecode.report.reportSetCon){
			if (SqlHelper.isExistColumn(resultSet, "CompetitionName")) {
				this.competitionName = resultSet.getString("CompetitionName");
			}
			if(SqlHelper.isExistColumn(resultSet, "StudentName")){
				this.studentName = resultSet.getString("StudentName");
			}
			if(SqlHelper.isExistColumn(resultSet, "studentTicket")){
				this.studentTicket = resultSet.getString("studentTicket");
			}
			if(SqlHelper.isExistColumn(resultSet, "ContestObject")){
				this.contestObject = resultSet.getString("ContestObject");
			}
			if(SqlHelper.isExistColumn(resultSet, "ContestSubject")){
				this.contestSubject = resultSet.getString("ContestSubject");
			}
			if(SqlHelper.isExistColumn(resultSet, "StudentScore")){
				this.studentScore = resultSet.getString("StudentScore");
			}
			if(SqlHelper.isExistColumn(resultSet, "EnrollmentPassword")){
				this.enrollmentPassword = resultSet.getString("EnrollmentPassword");
			}
		}
		
	}
	
	//客户端数据构造函数
	public Report(JSONObject jsonObject){
		this.studentName = jsonObject.getString("StudentName");
		this.studentTicket = jsonObject.getString("StudentTicket");
		this.competitionName = jsonObject.getString("CompetitionName");
		this.enrollmentPassword = jsonObject.getString("EnrollmentPassword");
		
	}
	
	//获取成绩查询语句
	public String getQuerySql(){
		String sql = "select ";
		sql += "StudentName,StudentScore,CompetitionName,ContestObject,ContestSubject,StudentTicket ";
		sql += "FROM enrollment ";
		sql += "WHERE ";
		sql += "StudentName='" + this.studentName +
		       "' AND CompetitionName='" + this.competitionName +
		       "' AND StudentTicket='" + this.studentTicket + 
		       "' AND EnrollmentPassword='" + this.enrollmentPassword + "'";
		
		return sql;
	}
	
	public String getQuerySql(String competitionName){
		String sql = "select ";
		sql += "StudentName,StudentScore,CompetitionName,ContestObject,ContestSubject,StudentTicket,EnrollmentPassword";
		sql += " from enrollment ";
		sql += "where ";
		sql += "CompetitionName='" + competitionName + "'";
		
		return sql;
	}
	
	public JSONObject toJSON(){
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("studentName", this.studentName);
		jsonObject.put("studentScore", this.studentScore);
		jsonObject.put("competitionName", this.competitionName);
		jsonObject.put("contestObject", this.contestObject);
		jsonObject.put("contestSubject", this.contestSubject);
		jsonObject.put("studentTicket", this.studentTicket);
		
		return jsonObject;
		
	}
     
	public boolean isHaveScore(){
		 if(this.studentScore == "-1"){
			 return false;
		 }else{
			 return true;
		 }
	}
	
	public boolean isThisCache(String competitionName){
		if(this.competitionName.equals(competitionName))
			return true;
		else
			return false;
	}

	
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentTicket() {
		return this.studentTicket;
	}

	public void setStudentTicket(String studentTicket) {
		this.studentTicket = studentTicket;
	}

	public String getEnrollmentPassword() {
		return this.enrollmentPassword;
	}

	public void setEnrollmentPassword(String enrollmentPassword) {
		this.enrollmentPassword = enrollmentPassword;
	}

	public String getCompetitionName() {
		return this.competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}
	
	
	
	
	
	
	
	
}
