package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFavoriteNews {

	private	int	NewsType	;//	新闻类型
	private	String	NewsTitle	;//	新闻标题
	private	String	NewsPublishTime	;//	新闻发布时间
	
	
	public UserFavoriteNews(int	NewsType,String	NewsTitle,String	NewsPublishTime){
		this.NewsType=NewsType;
		this.NewsTitle=NewsTitle;
		this.NewsPublishTime=NewsPublishTime;
	}
	
	
	public UserFavoriteNews(ResultSet resultSet) throws SQLException{
		this.NewsType=resultSet.getInt("NewsType");
		this.NewsTitle=resultSet.getString("NewsTitle");
		this.NewsPublishTime=resultSet.getString("NewsPublishTime");
	}
	
	
	
	public int getNewsType() {
		return NewsType;
	}


	public String getNewsTitle() {
		return NewsTitle;
	}


	public String getNewsPublishTime() {
		return NewsPublishTime;
	}


	@Override
	public String toString() {
		return "UserFavoriteNews [NewsPublishTime=" + NewsPublishTime
				+ ", NewsTitle=" + NewsTitle + ", NewsType=" + NewsType + "]";
	}
	
	
	
	

}
