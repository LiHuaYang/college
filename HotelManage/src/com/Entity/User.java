package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	private	int	UserId	;//	客户号
	private	String	UserName	;//	客户姓名
	private	String	UserPassword	;//	登入密码
	private	String	UserSex	;//	客户性别
	private	String	UserPhone	;//	电话
	private	String	UserEmail	;//	电子邮箱
	private	String	UserBoth	;//	生日
	private	String	UserIDNumber	;//	身份证号
	private	int	UserVIP	;//	VIP类型
	private	int	UserState	;//	客户状态
	private	int	UserBalance	;//	账户余额
	private	String	UserPicture	;//	用户头像路径
	private	String	UserMessage	;//	自我简介
	
	public User(){};
	
	public User(String UserName,String	UserPassword,String	UserPhone,String UserEmail){
		//this.UserId=UserId;
		this.UserName=UserName;
		this.UserPassword=UserPassword;
		//this.UserSex=UserSex;
		this.UserPhone=UserPhone;
		this.UserEmail=UserEmail;
		//this.UserBoth=UserBoth;
		//this.UserIDNumber=UserIDNumber;
		this.UserVIP=0;
		this.UserState=0;
		//this.UserBalance=UserBalance;
		this.UserPicture="img/rabbit.jpg";
		//this.UserMessage=UserMessage;
		
	}
	
	public User(String UserName,String	UserPassword,String	UserSex,String	UserPhone,String UserEmail,String	UserBoth,String	UserIDNumber,int	UserBalance,String	UserPicture,String	UserMessage){
		this.UserId=UserId;
		this.UserName=UserName;
		this.UserPassword=UserPassword;
		this.UserSex=UserSex;
		this.UserPhone=UserPhone;
		this.UserEmail=UserEmail;
		this.UserBoth=UserBoth;
		this.UserIDNumber=UserIDNumber;
		this.UserVIP=0;
		this.UserState=0;
		this.UserBalance=UserBalance;
		this.UserPicture=UserPicture;
		this.UserMessage=UserMessage;		
	}
	public User(String UserName,String	UserPassword,String	UserSex,String	UserPhone,String UserEmail,String	UserBoth,String	UserIDNumber,int	UserBalance,String	UserMessage){
		this.UserId=UserId;
		this.UserName=UserName;
		this.UserPassword=UserPassword;
		this.UserSex=UserSex;
		this.UserPhone=UserPhone;
		this.UserEmail=UserEmail;
		this.UserBoth=UserBoth;
		this.UserIDNumber=UserIDNumber;
		this.UserVIP=0;
		this.UserState=0;
		this.UserPicture="img/rabbit.jpg";
		this.UserBalance=UserBalance;
		this.UserMessage=UserMessage;		
	}

	public User(int userId, String userName, String userPassword,
			String userSex, String userPhone, String userEmail,
			String userBoth, String userIDNumber, int userVIP, int userState,
			int userBalance, String userPicture) {
		super();
		UserId = userId;
		UserName = userName;
		UserPassword = userPassword;
		UserSex = userSex;
		UserPhone = userPhone;
		UserEmail = userEmail;
		UserBoth = userBoth;
		UserIDNumber = userIDNumber;
		UserVIP = userVIP;
		UserState = userState;
		UserBalance = userBalance;
		UserPicture = userPicture;
	}
	

	@Id
	@GeneratedValue
	public int getUserId() {
		return UserId;
	}




	public void setUserId(int userId) {
		UserId = userId;
	}




	public String getUserName() {
		return UserName;
	}




	public void setUserName(String userName) {
		UserName = userName;
	}




	public String getUserPassword() {
		return UserPassword;
	}




	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}




	public String getUserSex() {
		return UserSex;
	}




	public void setUserSex(String userSex) {
		UserSex = userSex;
	}




	public String getUserPhone() {
		return UserPhone;
	}




	public void setUserPhone(String userPhone) {
		UserPhone = userPhone;
	}




	public String getUserEmail() {
		return UserEmail;
	}




	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}




	public String getUserBoth() {
		return UserBoth;
	}




	public void setUserBoth(String userBoth) {
		UserBoth = userBoth;
	}




	public String getUserIDNumber() {
		return UserIDNumber;
	}




	public void setUserIDNumber(String userIDNumber) {
		UserIDNumber = userIDNumber;
	}




	public int getUserVIP() {
		return UserVIP;
	}




	public void setUserVIP(int userVIP) {
		UserVIP = userVIP;
	}




	public int getUserState() {
		return UserState;
	}




	public void setUserState(int userState) {
		UserState = userState;
	}




	public int getUserBalance() {
		return UserBalance;
	}




	public void setUserBalance(int userBalance) {
		UserBalance = userBalance;
	}




	public String getUserPicture() {
		return UserPicture;
	}




	public void setUserPicture(String userPicture) {
		UserPicture = userPicture;
	}




	public String getUserMessage() {
		return UserMessage;
	}




	public void setUserMessage(String userMessage) {
		UserMessage = userMessage;
	}




	@Override
	public String toString() {
		return "User [UserBalance=" + UserBalance + ", UserBoth=" + UserBoth
				+ ", UserEmail=" + UserEmail + ", UserIDNumber=" + UserIDNumber
				+ ", UserId=" + UserId + ", UserMessage=" + UserMessage
				+ ", UserName=" + UserName + ", UserPassword=" + UserPassword
				+ ", UserPhone=" + UserPhone + ", UserPicture=" + UserPicture
				+ ", UserSex=" + UserSex + ", UserState=" + UserState
				+ ", UserVIP=" + UserVIP + "]";
	}

	
}
