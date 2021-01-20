package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfobyId {
	private	String	UserName; //	用户姓名
	private	String	UserSex	; //	性别
	private	String	UserIDNumber; //	用户身份证号
	private	String	UserSchool	; //	就读学校
	private	String	UserContactsMan	; //	联系人
	private	String	UserContactsPhon;//	联系电话
	private	String	UserAddress	; //	地址
	private	String	UserTeacher	; //	指导老师
	private	String	UserTeacherPhon	; //	指导老师电话
	private int UserGrade; //用户年级
	private	String	UserPicture	; //	用户头像
	private String UserNickName;    //用户昵称
	
	public UserInfobyId(String UserName,String UserSex,String UserIDNumber,String UserSchool,
			String UserContactsMan,String UserContactsPhon,String UserAddress,String UserTeacher,
			String UserTeacherPhon,int UserGrade){
		this.UserName=UserName;
		this.UserSex=UserSex;
		this.UserIDNumber=UserIDNumber;
		this.UserSchool=UserSchool;
		this.UserContactsMan=UserContactsMan;
		this.UserContactsPhon=UserContactsPhon;
		this.UserAddress=UserAddress;
		this.UserTeacher=UserTeacher;
		this.UserTeacherPhon=UserTeacherPhon;
		this.UserGrade=UserGrade;
		this.UserPicture=UserPicture;
	}
	
	
    public UserInfobyId(ResultSet resultSet) throws SQLException{
		
		this.UserName=resultSet.getString("UserName");
		this.UserSex=resultSet.getString("UserSex");
		this.UserIDNumber=resultSet.getString("UserIDNumber");
		this.UserSchool=resultSet.getString("UserSchool");
		this.UserContactsMan=resultSet.getString("UserContactsMan");
		this.UserContactsPhon=resultSet.getString("UserContactsPhon");
		this.UserAddress=resultSet.getString("UserAddress");
		this.UserTeacher=resultSet.getString("UserTeacher");
		this.UserGrade=resultSet.getInt("UserGrade");
		this.UserPicture=resultSet.getString("UserPicture");
		this.UserNickName = resultSet.getString("UserNickname");
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

	public int getUserGrade() {
		return UserGrade;
	}

	public String getUserPicture() {
		return UserPicture;
	}
	
	

	@Override
	public String toString() {
		return "UserInfobyId [UserAddress=" + UserAddress
				+ ", UserContactsMan=" + UserContactsMan
				+ ", UserContactsPhon=" + UserContactsPhon + ", UserGrade="
				+ UserGrade + ", UserIDNumber=" + UserIDNumber + ", UserName="
				+ UserName + ", UserPicture=" + UserPicture + ", UserSchool="
				+ UserSchool + ", UserSex=" + UserSex + ", UserTeacher="
				+ UserTeacher + ", UserTeacherPhon=" + UserTeacherPhon + "]";
	}


	public void setUserNickName(String userNickName) {
		UserNickName = userNickName;
	}


	public String getUserNickName() {
		return UserNickName;
	}
	
	
	
	
}
