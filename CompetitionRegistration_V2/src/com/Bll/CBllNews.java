package com.Bll;

import java.util.List;

import com.Dao.CDaoFrame;
import com.Dao.IDaoFrame;
import com.EntityAndroid.NewsInfo;
import com.EntityAndroid.NewsStandInfo;
import com.EntityWeb.News;

//新闻管理
public class CBllNews {
	IDaoFrame iDaoFrame = CDaoFrame.getInstance();
	
//	//CBllCompetition单例
//	private volatile static CBllNews cBllNews = null;
//	
//	private CBllNews(){
//		System.out.println("CBllNews构造函数被调用");
//	};
//	
//	public static CBllNews getInstance(){
//		if(cBllNews == null){
//			synchronized (CBllNews.class) {
//				if(cBllNews == null){
//					cBllNews = new CBllNews();
//				}
//			}
//		}
//		
//		return cBllNews;
//	}
	
	public CBllNews(){
		System.out.println("CBllNews构造函数被调用");
	};
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
		List<News> result=iDaoFrame.SearchNewsTopStaTime();
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午05:15:16
	 *函数名：QueryNewsMain
	 *功能：查询新闻主界面显示信息
	 *参数：新闻类型：NewsType
	 *返回值：List<NewsStandInfo>
	 */
	public List<NewsStandInfo> QueryNewsMain(int NewsType){
		return null;
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
		List<News> result=null;
		result=iDaoFrame.SearchAllNews(page);
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-25上午10:26:18
	 *函数名：SearchTopNews
	 *功能： 查询头条新闻里的内容
	 *参数：无
	 *返回值：List<NewsInfo>
	 */
	public List<NewsInfo> SearchTopNews(){
		List<NewsInfo> result=null;
		result=iDaoFrame.QueryTopNews();
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-25下午01:20:05
	 *函数名：SearchSingleNewsbyId
	 *功能：通过id查找单个新闻内容
	 *参数：newsId:新闻id
	 *返回值：List<NewsInfo>
	 */
	public List<NewsInfo> SearchSingleNewsbyId(int newsId){
		List<NewsInfo> result=iDaoFrame.QuerySingleNewsbyId(newsId);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-25下午07:49:03
	 *函数名：GetNewsbyNameState
	 *功能：通过名字和状态查找新闻
	 *参数：NewsSearch:新闻名字或者状态
	 *返回值：List<News>
	 */
	public List<News> SearchNewsbyNameState(String NewsSearch){
		String judgeNewsSearch=null;
		if(NewsSearch.equals("小学")){
			judgeNewsSearch="1";
		}
		else if(NewsSearch.equals("初中")){
			judgeNewsSearch="2";
		}
		else if(NewsSearch.equals("高中")){
			judgeNewsSearch="3";
		}
		else{
			judgeNewsSearch=NewsSearch;
		}
		List<News> result=iDaoFrame.QueryNewsbyNameState(judgeNewsSearch);
		return result;
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
		
		int count=0;
		count=iDaoFrame.GetNewsNumber();
		return count;
	}
//------------------------------web部分-----------------------------------	

}
