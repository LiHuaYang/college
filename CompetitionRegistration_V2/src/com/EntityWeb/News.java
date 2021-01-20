package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;

//新闻表
public class News {

	private	int	NewsId	;//	新闻id
	private	String	NewsTitle	;//	新闻标题
	private	String	NewsContent	;//	新闻内容
	private	String	NewsExtralInfo	;//	新闻附加信息
	private	String	NewsPutTime	;//	新闻发布时间
	private	int	NewsState	;//	新闻类型
	private	int	NewsTop	;//	新闻是否上头条
	private int NewsSaveState;//新闻状态
	
	public News(String	NewsTitle,int NewsTop,String NewsPutTime,int NewsState,int NewsId){
		this.NewsTitle = NewsTitle;
		this.NewsTop = NewsTop;
		this.NewsPutTime = NewsPutTime;
		this.NewsState = NewsState;
		this.NewsId=NewsId;
	}
	
	public News(int	NewsId,String NewsTitle,String NewsContent,
			String	NewsExtralInfo,String NewsPutTime,int NewsState,int NewsTop){
		this.NewsId = NewsId;
		this.NewsTitle = NewsTitle;
		this.NewsContent = NewsContent;	
		this.NewsExtralInfo = NewsExtralInfo;
		this.NewsPutTime = NewsPutTime;
		this.NewsState = NewsState;
		this.NewsTop = NewsTop;
	}
	
	public News(String NewsTitle,int NewsState,String NewsPutTime,int NewsId){
		this.NewsTitle = NewsTitle;
		this.NewsState = NewsState;
		this.NewsPutTime = NewsPutTime;
		this.NewsId=NewsId;
	}
	public News(ResultSet resultSet) throws SQLException{
		this.NewsId=resultSet.getInt("NewsId");
		this.NewsTitle=resultSet.getString("NewsTitle");
		this.NewsContent=resultSet.getString("NewsContent");
		this.NewsExtralInfo=resultSet.getString("NewsExtralInfo");
		this.NewsPutTime=resultSet.getString("NewsPutTime");
		this.NewsState=resultSet.getInt("NewsState");
		this.NewsTop=resultSet.getInt("NewsTop");
	}
	public int getNewsSaveState() {
		return NewsSaveState;
	}

	public void setNewsSaveState(int newsSaveState) {
		NewsSaveState = newsSaveState;
	}

	public void setNewsId(int newsId) {
		NewsId = newsId;
	}

	public void setNewsTitle(String newsTitle) {
		NewsTitle = newsTitle;
	}

	public void setNewsContent(String newsContent) {
		NewsContent = newsContent;
	}

	public void setNewsExtralInfo(String newsExtralInfo) {
		NewsExtralInfo = newsExtralInfo;
	}

	public void setNewsPutTime(String newsPutTime) {
		NewsPutTime = newsPutTime;
	}

	public void setNewsState(int newsState) {
		NewsState = newsState;
	}

	public void setNewsTop(int newsTop) {
		NewsTop = newsTop;
	}

	public News(int NewsId,String NewsTitle,String NewsPutTime,String NewsPic){
		this.NewsId= NewsId;
		this.NewsTitle = NewsTitle;
		this.NewsPutTime = NewsPutTime;
	}
	
	
	public int getNewsId() {
		return NewsId;
	}

	public String getNewsTitle() {
		return NewsTitle;
	}

	public String getNewsContent() {
		return NewsContent;
	}

	public String getNewsExtralInfo() {
		return NewsExtralInfo;
	}

	public String getNewsPutTime() {
		return NewsPutTime;
	}

	public int getNewsState() {
		return NewsState;
	}

	public int getNewsTop() {
		return NewsTop;
	}

	@Override
	public String toString() {
		return "News [NewsContent=" + NewsContent + ", NewsExtralInfo="
				+ NewsExtralInfo + ", NewsId=" + NewsId + ", NewsPutTime="
				+ NewsPutTime + ", NewsState=" + NewsState + ", NewsTitle="
				+ NewsTitle + ", NewsTop=" + NewsTop + "]";
	}
	
	
	
	

}
