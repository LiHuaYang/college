package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserBasicCollect {
	private	int	UserCollectionId	;//	收藏id  
	private	int	UserId	;//	用户id
	private	String	CollectionTime	;//	收藏时间
	private	int	CollectionType	;//	收藏类型
	
	
	
	public UserBasicCollect(int	UserCollectionId,int UserId,String CollectionTime,int CollectionType){
		this.UserCollectionId=UserCollectionId;
		this.UserId=UserId;
		
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.CollectionTime=s.format( new Date());
		
		this.CollectionType=CollectionType;
		
	}
	
	
	public UserBasicCollect(ResultSet resultSet) throws SQLException{
		this.UserCollectionId=resultSet.getInt("UserCollectionId");
		this.CollectionTime=resultSet.getString("CollectionTime");
		this.UserId=resultSet.getInt("UserId");
		this.CollectionType=resultSet.getInt("CollectionType");
	}
	
	
	public int getUserCollectionId() {
		return UserCollectionId;
	}
	public int getUserId() {
		return UserId;
	}
	public String getCollectionTime() {
		return CollectionTime;
	}
	public int getCollectionType() {
		return CollectionType;
	}


	@Override
	public String toString() {
		return "UserBasicCollect [CollectionTime=" + CollectionTime
				+ ", CollectionType=" + CollectionType + ", UserCollectionId="
				+ UserCollectionId + ", UserId=" + UserId + "]";
	}

	
	
	
	

}
