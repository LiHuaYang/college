package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBaseInfo {

	private	int	UserId	;//	用户id
	private	String 	UserPicture	;//	用户图片路径
	private	String 	UserNickname	;//	用户昵称

	
	public UserBaseInfo(int UserId,String UserPicture,String UserNickname){
		this.UserId=UserId;
		this.UserPicture=UserPicture;
		this.UserNickname=UserNickname;
	}
	
	public UserBaseInfo(ResultSet resultSet) throws SQLException{
		this.UserId=resultSet.getInt("UserId");
		this.UserPicture=resultSet.getString("UserPicture");
		this.UserNickname=resultSet.getString("UserNickname");
		
	}
	
	public int getUserId() {
		return UserId;
	}


	public String getUserPicture() {
		return UserPicture;
	}

	public String getUserNickname() {
		return UserNickname;
	}

	@Override
	public String toString() {
		return "UserBaseInfo [UserId=" + UserId + ", UserNickname="
				+ UserNickname + ", UserPicture=" + UserPicture + "]";
	}


	
	
	
	
	

	
	
}
