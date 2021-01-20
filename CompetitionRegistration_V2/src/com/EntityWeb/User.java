package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	
	private	int	UserId	;//	用户id
	private	String	UserPhone	;//	用户手机（账号）
	private	String	UserPassage	;//	用户密码
	private	String	UserName	;//	用户姓名
	private	String	UserSex	;//	性别
	private	String	UserIDNumber	;//	用户身份证号
	private	String	UserSchool	;//	就读学校
	private	int	UserYear	;//	就读年份
	private	String	UserContactsMan	;//	联系人
	private	String	UserContactsPhon	;//	联系电话
	private	String	UserAddress	;//	地址
	private	String	UserTeacher	;//	指导老师
	private	String	UserTeacherPhon	;//	指导老师电话
	private	String	UserPicture	;//	用户头像
	private	String	UserNickname	;//	用户昵称
	private	String	UserLoginTime	;//	用户登录时间
	private	int	UserState	;//	状态
	private	int	UserIntegral	;//	积分
	private int UserGrade;      //用户年级

	
	public User(int userId, String UserPhone, String UserPassage,
			String UserName, String UserSex,
			String UserIDNumber, String UserSchool, int UserYear, String UserContactsMan,
			String UserContactsPhon, String UserAddress, String UserTeacher,
			String UserTeacherPhon, String UserPicture,String UserNickname, 
			String UserLoginTime, int UserState, int UserIntegral,int UserGrade) {
		this.UserId = userId;
		this.UserPhone = UserPhone;
		this.UserPassage = UserPassage;
		this.UserName = UserName;
		this.UserSex = UserSex;
		this.UserIDNumber = UserIDNumber;
		this.UserSchool = UserSchool;
		this.UserYear = UserYear;
		this.UserContactsMan = UserContactsMan;
		this.UserContactsPhon = UserContactsPhon;
		this.UserAddress = UserAddress;
		this.UserTeacher = UserTeacher;
		this.UserTeacherPhon = UserTeacherPhon;
		this.UserPicture = UserPicture;
		this.UserNickname = UserNickname;
		this.UserLoginTime = UserLoginTime;
		this.UserState = UserState;
		this.UserIntegral = UserIntegral;
		this.UserGrade=UserGrade;
	}
	
	public User(String UserPhone,String UserPassword){
		this.UserPhone = UserPhone;
		this.UserPassage = UserPassword;
	}
	
	public User(String UserNickname,String	UserSex,String UserContactsPhon,int UserGrade, String UserAddress){
		this.UserNickname = UserNickname;
		this.UserSex = UserSex;
		this.UserContactsPhon = UserContactsPhon;
		this.UserGrade = UserGrade;
		this.UserAddress=UserAddress;
	}
	
	public User(String userPhone, String userName, String userSex,
			String userIDNumber, String userSchool, int userYear,
			String userContactsMan, String userContactsPhon,
			String userAddress, String userTeacher, String userTeacherPhon,
			String userPicture,int userState,int userGrade) {
		
		this.UserPhone = userPhone;
		this.UserName = userName;
		this.UserSex = userSex;
		this.UserIDNumber = userIDNumber;
		this.UserSchool = userSchool;
		this.UserYear = userYear;
		this.UserContactsMan = userContactsMan;
		this.UserContactsPhon = userContactsPhon;
		this.UserAddress = userAddress;
		this.UserTeacher = userTeacher;
		this.UserTeacherPhon = userTeacherPhon;
		this.UserPicture = userPicture;
		this.UserState = userState;
		this.UserGrade=userGrade;
	}


	public User(ResultSet resultSet) throws SQLException{
		try{
			if(resultSet.findColumn("UserId")>0){
				this.UserId=resultSet.getInt("UserId");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserPhone")>0){
				this.UserPhone=resultSet.getString("UserPhone");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserPassage")>0){
				this.UserPassage=resultSet.getString("UserPassage");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserName")>0){
				this.UserName=resultSet.getString("UserName");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserSex")>0){
				this.UserSex=resultSet.getString("UserSex");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserIDNumber")>0){
				this.UserIDNumber=resultSet.getString("UserIDNumber");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserSchool")>0){
				this.UserSchool=resultSet.getString("UserSchool");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserYear")>0){
				this.UserYear=resultSet.getInt("UserYear");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserContactsMan")>0){
				this.UserContactsMan=resultSet.getString("UserContactsMan");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserContactsPhon")>0){
				this.UserContactsPhon=resultSet.getString("UserContactsPhon");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserAddress")>0){
				this.UserAddress=resultSet.getString("UserAddress");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserTeacher")>0){
				this.UserTeacher=resultSet.getString("UserTeacher");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserTeacherPhon")>0){
				this.UserTeacherPhon=resultSet.getString("UserTeacherPhon");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserPicture")>0){
				this.UserPicture=resultSet.getString("UserPicture");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserNickname")>0){
				this.UserNickname=resultSet.getString("UserNickname");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserLoginTime")>0){
				this.UserLoginTime=resultSet.getString("UserLoginTime");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserState")>0){
				this.UserState=resultSet.getInt("UserState");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserIntegral")>0){
				this.UserIntegral=resultSet.getInt("UserIntegral");
			}
		}catch(SQLException e){}
		try{
			if(resultSet.findColumn("UserGrade")>0){
				this.UserGrade=resultSet.getInt("UserGrade");
			}
		}catch(SQLException e){}
		
		try{
			if(resultSet.findColumn("UserPhone")>0){
				this.UserPhone=resultSet.getString("UserPhone");
			}
		}catch(SQLException e){}
	}

	
	public int getUserId() {
		return UserId;
	}

	public String getUserPhone() {
		return UserPhone;
	}

	public String getUserPassage() {
		return UserPassage;
	}

	public String getUserName() {
		return UserName;
	}

	public String getUserSex() {
		return UserSex;
	}

	public String getUserIDNumber() {
		return UserIDNumber;
	}

	public String getUserSchool() {
		return UserSchool;
	}

	public int getUserYear() {
		return UserYear;
	}

	public String getUserContactsMan() {
		return UserContactsMan;
	}

	public String getUserContactsPhon() {
		return UserContactsPhon;
	}

	public String getUserAddress() {
		return UserAddress;
	}

	public String getUserTeacher() {
		return UserTeacher;
	}

	public String getUserTeacherPhon() {
		return UserTeacherPhon;
	}

	public String getUserPicture() {
		return UserPicture;
	}

	public String getUserNickname() {
		return UserNickname;
	}

	public String getUserLoginTime() {
		return UserLoginTime;
	}

	public int getUserState() {
		return UserState;
	}

	public int getUserIntegral() {
		return UserIntegral;
	}

	
	public int getUserGrade() {
		return UserGrade;
	}

	@Override
	public String toString() {
		return "User [UserAddress=" + UserAddress + ", UserContactsMan="
				+ UserContactsMan + ", UserContactsPhon=" + UserContactsPhon
				+ ", UserGrade=" + UserGrade + ", UserIDNumber=" + UserIDNumber
				+ ", UserId=" + UserId + ", UserIntegral=" + UserIntegral
				+ ", UserLoginTime=" + UserLoginTime + ", UserName=" + UserName
				+ ", UserNickname=" + UserNickname + ", UserPassage="
				+ UserPassage + ", UserPhone=" + UserPhone + ", UserPicture="
				+ UserPicture + ", UserSchool=" + UserSchool + ", UserSex="
				+ UserSex + ", UserState=" + UserState + ", UserTeacher="
				+ UserTeacher + ", UserTeacherPhon=" + UserTeacherPhon
				+ ", UserYear=" + UserYear + "]";
	}


	
}
