package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFavoriteCompetition {

	private	String	CollectionTime	;//	收藏时间
	private	String	ContestName	;//	比赛名称
	private	String	ContestStartTime	;//	比赛时间
	private	String	ContestSubject	;//	比赛科目
	private	String	ContestPictureURL	;//	比赛图片
	private	int	ContestNumber	;//	比赛届数
	
	
	public UserFavoriteCompetition(String CollectionTime,String ContestName,String ContestStartTime,String	ContestSubject,String ContestPictureURL,int ContestNumber){
		this.CollectionTime=CollectionTime;
		this.CollectionTime=ContestName;
		this.ContestStartTime=ContestStartTime;
		this.ContestSubject=ContestSubject;
		this.ContestPictureURL=ContestPictureURL;
		this.ContestNumber=ContestNumber;
	}
	
	
	public UserFavoriteCompetition(ResultSet resultSet) throws SQLException{
		this.CollectionTime=resultSet.getString("CollectionTime");
		this.CollectionTime=resultSet.getString("CollectionTime");
		this.ContestStartTime=resultSet.getString("ContestStartTime");
		this.ContestSubject=resultSet.getString("ContestSubject");
		this.ContestPictureURL=resultSet.getString("ContestPictureURL");
		this.ContestNumber=resultSet.getInt("ContestNumber");
	}
	
	
	
	
	
	
	public String getCollectionTime() {
		return CollectionTime;
	}


	public String getContestName() {
		return ContestName;
	}


	public String getContestStartTime() {
		return ContestStartTime;
	}


	public String getContestSubject() {
		return ContestSubject;
	}


	public String getContestPictureURL() {
		return ContestPictureURL;
	}


	public int getContestNumber() {
		return ContestNumber;
	}


	@Override
	public String toString() {
		return "UserFavoriteCompetition [CollectionTime=" + CollectionTime
				+ ", ContestName=" + ContestName + ", ContestNumber="
				+ ContestNumber + ", ContestPictureURL=" + ContestPictureURL
				+ ", ContestStartTime=" + ContestStartTime
				+ ", ContestSubject=" + ContestSubject + "]";
	}

	
}
