package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.EntityAndroid.NewsInfo;
import com.EntityWeb.News;
import com.Tool.sql.JdbcUnit;

//新闻管理
public class DaoNews {

	
	
	
//------------------------------安卓部分-----------------------------------
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-16下午09:02:36
	 *函数名：SearchNewsTopStaTime
	 *功能：查询新闻的头条，发布时间和状态
	 *参数：无
	 *返回值：List<News>
	 */
	public List<News> SearchNewsTopStaTime(){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql="Select NewsTop,NewsState,NewsPutTime,NewsTitle,NewsId from news where NewsSaveState=1 limit 0,7";
		
		List<News> newslist = new ArrayList<News>();
		
		News news = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				int NewsTop=rs.getInt(1);
				int NewsState=rs.getInt(2);
				String NewsPutTime=rs.getString(3);
				String NewsTitle=rs.getString(4);
				int NewsId=rs.getInt(5);
//				competitionNewsInfo=new CompetitionNewsInfo(ContestPicUrl, CompetitionName, ContestPropaganda);
				news=new News(NewsTitle, NewsTop, NewsPutTime, NewsState, NewsId);
				newslist.add(news);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  newslist;
	}
	
	
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-29下午08:49:00
	 *函数名：SearchAllNews
	 *功能：查找所有的新闻
	 *参数：
	 *返回值：List<NewsInfo>
	 */
	public List<News> SearchAllNews(int page){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		int startPos = (page - 1) * 10;
		String sql="Select * from news where NewsSaveState=1 and NewsTop=0 order by NewsPutTime DESC limit "+ startPos + "," +10;
		
		List<News> newslist = new ArrayList<News>();
		
		News news = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		
		try {
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				news=new News(rs);
				newslist.add(news);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  newslist;
	}


	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-25上午09:57:40
	 *函数名：SearchTopNews
	 *功能：查询头条新闻里的内容
	 *参数：无
	 *返回值：List<NewsInfo>
	 */
	public List<NewsInfo> QueryTopNews(){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql="Select n.NewsId,p.NewsPicUrl,n.NewsTitle from news n,newspicture p where n.NewsId=p.NewsId and n.NewsTop=1";
		
		List<NewsInfo> newsInfolist = new ArrayList<NewsInfo>();
		
		NewsInfo newsInfo = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				int NewsId=rs.getInt(1);
				String NewsPicUrl=rs.getString(2);
				String NewsTitle=rs.getString(3);
//				competitionNewsInfo=new CompetitionNewsInfo(ContestPicUrl, CompetitionName, ContestPropaganda);
				newsInfo=new NewsInfo(NewsId, NewsPicUrl, NewsTitle);
				newsInfolist.add(newsInfo);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  newsInfolist;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-25下午01:07:09
	 *函数名：QuerySingleNewsbyId
	 *功能：通过id查找单个新闻内容
	 *参数：newsId:新闻id
	 *返回值：List<NewsInfo>
	 */
	public List<NewsInfo> QuerySingleNewsbyId(int newsId){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql="Select n.*,p.NewsPicUrl from news n,newspicture p where n.NewsId=p.NewsId and NewsSaveState=1 and n.NewsId="+newsId;
		
		List<NewsInfo> newsInfolist = new ArrayList<NewsInfo>();
		
		NewsInfo newsInfo = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				newsInfo=new NewsInfo(rs);
				newsInfolist.add(newsInfo);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  newsInfolist;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-25下午07:07:12
	 *函数名：QueryNewsbyNameState
	 *功能：通过名字和状态查找新闻
	 *参数：NewsSearch:新闻名字或者状态
	 *返回值：List<News>
	 */
	public List<News> QueryNewsbyNameState(String NewsSearch){
		
		System.out.println("NewsSearch" + NewsSearch);
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql=null;
		Pattern pattern = Pattern.compile("[0-9]*"); 
		Matcher isNum = pattern.matcher(NewsSearch);
		if( !isNum.matches() ){
			sql="Select NewsTitle,NewsState,NewsPutTime,NewsId from news where NewsSaveState=1 and NewsTitle like '%"+NewsSearch+"%'";
	    } 
		else{
			int newsSearchState=Integer.parseInt(NewsSearch);
			sql="Select NewsTitle,NewsState,NewsPutTime,NewsId from news where NewsSaveState=1 and NewsState="+newsSearchState;
		}
		
		List<News> newslist = new ArrayList<News>();
		
		News news = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				String NewsTitle=rs.getString(1);
				int NewsState=rs.getInt(2);
				String NewsPutTime=rs.getString(3);
				int NewsId=rs.getInt(4);
//				competitionNewsInfo=new CompetitionNewsInfo(ContestPicUrl, CompetitionName, ContestPropaganda);
				news=new News(NewsTitle, NewsState, NewsPutTime, NewsId);
				newslist.add(news);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  newslist;
	}
	
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-2-26下午07:24:14
	 *函数名：GetNewsNumber
	 *功能：获得所有新闻总数
	 *参数：
	 *返回值：int
	 */
	public int GetNewsNumber(){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql="Select * from news where NewsTop=0 and NewsSaveState=1";
		
		int i=0;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				i++;
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  i;
	}
//------------------------------web部分-----------------------------------	
	
	/**
	 * 
	 *作者：lgy
	 *时间：2016-2-26
	 *函数名：addnews
	 *功能：添加新闻
	 *参数：news
	 *返回值：boolean
	 */
//	public boolean AddNews(NewsInfo news){
//		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
//		Connection con = jdbcUnit.createConn(); // 连接数据库
//		
//		String sql="insert into competition.news (NewsId, NewsTitle,NewsContent,NewsPicId,NewsExtralInfo,NewsPutTime,NewsState,NewsTop,NewsSource) values (NULL,"+news.getNewsTitle()
//		+","+news.getNewsContent()+",NULL,"++ NULL, NULL, NULL, NULL, NULL)";
//		System.out.println(news.getNewsPutTime());
//		
//		boolean result=true;
//		return result;
//		
//	}
	/**
	 * 
	 *作者：linguoyi
	 *时间：2016-2-27
	 *函数名：getAllNews
	 *功能：查找所有的新闻
	 *参数：page
	 *返回值：List<NewsInfo>
	 */
	public List<News> getAllNews(int page){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		int startPos = (page - 1) * 10;
		String sql="Select * from news limit "+ startPos + ",10";
		
		List<News> newslist = new ArrayList<News>();
		
		News news = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				news = new News(rs);
				news.setNewsSaveState(rs.getInt("NewsSaveState"));
				newslist.add(news);
			}
			System.out.println(newslist);
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  newslist;
	}
	/**
	 * 
	 *作者：linguoyi
	 *时间：2016-2-27
	 *函数名：ModifyNews
	 *功能：通过新闻Id修改新闻信息
	 *参数：news
	 *返回值：boolean
	 */
	public boolean ModifyNews(NewsInfo news){
		boolean flag=true;
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql="update news set NewsTitle='"+news.getNewsTitle()+"',NewsContent='"+news.getNewsContent()+
			"',NewsExtralInfo='"+news.getNewsExtralInfo()+"',NewsState='"+news.getNewsState()+
			"',NewsTop='"+news.getNewsTop()+"',NewsSource='"+news.getNewsSource()+
			"' where NewsId=" + news.getNewsId();
		//System.out.println(sql);
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			 flag=false;
			e.printStackTrace();
		}
		return  flag;
	}
	/**
	 * 
	 *作者：linguoyi
	 *时间：2016-2-27
	 *函数名：ModifyNewsState
	 *功能：通过新闻Id修改新闻状态
	 *参数：newsId
	 *返回值：boolean
	 */
	public boolean ModifyNewsState(int newsId){
		boolean flag=true;
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql="update news set NewsSaveState=0 where NewsId="+newsId;
		//System.out.println(sql);
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			 flag=false;
			e.printStackTrace();
		}
		return  flag;
	}

}
