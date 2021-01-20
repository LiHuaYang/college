package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsStandInfo {

	private	String	NewsTitle	;//	新闻标题
	private	String	NewsPublishTime	;//	新闻时间
	private	int	NewsType	;//	新闻头条类型
	private	String	NewsPictureUrl	;//	新闻图片
	
	
	public NewsStandInfo(String newsTitle, String newsPublishTime,
			int newsType, String newsPictureUrl) {
		this.NewsTitle = newsTitle;
		this.NewsPublishTime = newsPublishTime;
		this.NewsType = newsType;
		this.NewsPictureUrl = newsPictureUrl;
	}
	
	public NewsStandInfo(ResultSet resultSet) throws SQLException{
		this.NewsTitle=resultSet.getString("NewsTitle");
		this.NewsPublishTime=resultSet.getString("NewsPublishTime");
		this.NewsPictureUrl=resultSet.getString("NewsPictureUrl");
		this.NewsType=resultSet.getInt("NewsType");
	}

	public String getNewsTitle() {
		return NewsTitle;
	}

	public String getNewsPublishTime() {
		return NewsPublishTime;
	}

	public int getNewsType() {
		return NewsType;
	}

	public String getNewsPictureUrl() {
		return NewsPictureUrl;
	}


	@Override
	public String toString() {
		return "NewsStandInfo [NewsPictureUrl=" + NewsPictureUrl
				+ ", NewsPublishTime=" + NewsPublishTime + ", NewsTitle="
				+ NewsTitle + ", NewsType=" + NewsType + "]";
	}
	
	

}
