package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsInfo {

	private	int	NewsId	;//	新闻id
	private	String	NewsTitle	;//	新闻标题
	private	String	NewsContent	;//	新闻内容
	private	int	NewsPicId	;//	新闻图片id
	private	String	NewsExtralInfo	;//	新闻附加信息
	private	String	NewsPutTime	;//	新闻发布时间
	private	int	NewsState	;//	新闻类型
	private	int	NewsTop	; //	新闻是否上头条
	private String NewsPicUrl;     //新闻图片路径
	private String NewsSource; //新闻出处
	
	public void setNewsId(int newsId) {
		NewsId = newsId;
	}

	public void setNewsTitle(String newsTitle) {
		NewsTitle = newsTitle;
	}

	public void setNewsContent(String newsContent) {
		NewsContent = newsContent;
	}

	public void setNewsPicId(int newsPicId) {
		NewsPicId = newsPicId;
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

	public void setNewsPicUrl(String newsPicUrl) {
		NewsPicUrl = newsPicUrl;
	}

	public void setNewsSource(String newsSource) {
		NewsSource = newsSource;
	}

	
	
	public NewsInfo(int newsId, String newsTitle, String newsContent,
			int newsPicId, String newsExtralInfo, String newsPutTime,
			int newsState, int newsTop, String newsPicUrl,String NewsSource) {
		this.NewsId = newsId;
		this.NewsTitle = newsTitle;
		this.NewsContent = newsContent;
		this.NewsPicId = newsPicId;
		this.NewsExtralInfo = newsExtralInfo;
		this.NewsPutTime = newsPutTime;
		this.NewsState = newsState;
		this.NewsTop = newsTop;
		this.NewsPicUrl = newsPicUrl;
		this.NewsSource = NewsSource;
	}
	
	public NewsInfo(int	NewsId,String NewsPicUrl,String	NewsTitle){
		this.NewsId = NewsId;
		this.NewsPicUrl = NewsPicUrl;
		this.NewsTitle = NewsTitle;
	}
	
	public NewsInfo(ResultSet resultSet) throws SQLException{
		this.NewsId=resultSet.getInt("NewsId");
		this.NewsTitle=resultSet.getString("NewsTitle");
		this.NewsContent=resultSet.getString("NewsContent");
		this.NewsPicId=resultSet.getInt("NewsPicId");
		this.NewsExtralInfo=resultSet.getString("NewsExtralInfo");
		this.NewsPutTime=resultSet.getString("NewsPutTime");
		this.NewsState=resultSet.getInt("NewsState");
		this.NewsTop=resultSet.getInt("NewsTop");
		this.NewsPicUrl=resultSet.getString("NewsPicUrl");
		this.NewsSource=resultSet.getString("NewsSource");
	}

	
	public NewsInfo () {}
	

	public int getNewsId() {
		return NewsId;
	}

	public String getNewsTitle() {
		return NewsTitle;
	}

	public String getNewsContent() {
		return NewsContent;
	}

	public int getNewsPicId() {
		return NewsPicId;
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

	public String getNewsPicUrl() {
		return NewsPicUrl;
	}

	public String getNewsSource() {
		return NewsSource;
	}

	@Override
	public String toString() {
		return "NewsInfo [NewsContent=" + NewsContent + ", NewsExtralInfo="
				+ NewsExtralInfo + ", NewsId=" + NewsId + ", NewsPicId="
				+ NewsPicId + ", NewsPicUrl=" + NewsPicUrl + ", NewsPutTime="
				+ NewsPutTime + ", NewsSource=" + NewsSource + ", NewsState="
				+ NewsState + ", NewsTitle=" + NewsTitle + ", NewsTop="
				+ NewsTop + "]";
	}
	
	

	
	
	
}
