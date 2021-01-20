package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import net.sf.json.JSONObject;

@Entity
public class User {
	private int userId;// 用户ID
	private String userName;// 用户姓名
	private long userRoll;// 用户学号
	private int userSex;// 用户性别
	private String userMajor;// 用户专业
	private String userPassword;// 用户密码
	private long userPhone;// 用户手机号
	private String userPic;// 用户头像路径
	private String userAddress;//用户地址
	private String userSignature;//用户个性签名
	private String userEmail;//用户邮箱
	public User(){};
	public User(JSONObject jsonObject){
		this.userId=jsonObject.getInt("userId");
		this.userName=jsonObject.getString("userName");
		this.userRoll=jsonObject.getLong("userRoll");
		this.userSex=jsonObject.getInt("userSex");
		this.userMajor=jsonObject.getString("userMajor");
		this.userPassword=jsonObject.getString("userPassword");
		this.userPhone=jsonObject.getLong("userPhone");
		this.userPic=jsonObject.getString("userPic");
		this.userAddress=jsonObject.getString("userAddress");
		this.userSignature=jsonObject.getString("userSignature");
		this.userEmail=jsonObject.getString("userEmail");
	}
	@Id
	@GeneratedValue
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserRoll() {
		return userRoll;
	}

	public void setUserRoll(long userRoll) {
		this.userRoll = userRoll;
	}

	public int getUserSex() {
		return userSex;
	}

	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}

	public String getUserMajor() {
		return userMajor;
	}

	public void setUserMajor(String userMajor) {
		this.userMajor = userMajor;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}
	public String getUserSignature() {
		return userSignature;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserEmail() {
		return userEmail;
	}
	@Override
	public String toString() {
		return "User [userAddress=" + userAddress + ", userEmail=" + userEmail
				+ ", userId=" + userId + ", userMajor=" + userMajor
				+ ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userPhone=" + userPhone + ", userPic=" + userPic
				+ ", userRoll=" + userRoll + ", userSex=" + userSex
				+ ", userSignature=" + userSignature + "]";
	}


}
