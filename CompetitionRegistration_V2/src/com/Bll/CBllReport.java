package com.Bll;

import com.BllCache.ReportCache;
import com.Dao.CDaoFrame;
import com.Dao.IDaoFrame;
import com.Entity.V2.Report;
import com.Entity.V2.ReportSet;

public class CBllReport {

	IDaoFrame iDaoFrame = CDaoFrame.getInstance();
	
	private ReportCache reportCache = ReportCache.getInstense();
	
	public CBllReport(){
		System.out.println("CBllReport构造函数被调用");
	}
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-12 下午09:14:00
	 * 函数名：searchScoreByCheck
	 * 功能：通过输入信息查询成绩
	 * 参数：@param info
	 * 参数：@return
	 * 返回值：Report
	 */
	public Report searchScoreByInfo(Report info){
		Report report = null;

		//1.判断查找的比赛成绩是否为缓存的比赛
		if(info.isThisCache(reportCache.getCompetitionName())){
			//1.1.从缓存中查找
			report = reportCache.searchScoreByInfoOnCache(info);
			
			//1.2.如果缓存中没有，从数据库查找
			if(report == null){
				report =  iDaoFrame.searchScoreByCheck(info);
				System.out.println("从数据库查找成绩1");
			}else{
				System.out.println("从缓存查找成绩");
			}
		}else{
			report =  iDaoFrame.searchScoreByCheck(info);
			System.out.println("从数据库查找成绩2");
		}
		
		return report;
	}
	
	
	
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-16 下午09:56:42
	 * 函数名：putReportSetToCache
	 * 功能：加载reportSet到缓存
	 * 参数：@param reportSet
	 * 返回值：void
	 */
	public boolean addReportSetToCache(String competitionName){
		boolean result = false;
		//1设置缓存当前比赛名称为空
		reportCache.setCompetitionName("");   
		//2.获取要加入缓存比赛的数据
		long startTime = System.nanoTime();  //開始時間
		ReportSet reportSet = iDaoFrame.getReportSetByCompetitionName(competitionName);
		long consumingTime = System.nanoTime() - startTime; //消耗時間
		System.out.println("查询成绩时间--" + consumingTime);
		
		//3.如果获取的成绩不为空，先清除当前缓存的值，再把数据加载到缓存
		if(reportSet != null){
			reportCache.clearCache();
			reportCache.addReporttoCache(reportSet);
			result = true;
		}
		
		//4.如果加载成功，设置缓存的比赛名称
		if(result){
			reportCache.setCompetitionName(competitionName);
		}
		
		return result;
	}
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-19 下午04:02:34
	 * 函数名：clearScoreCache
	 * 功能：清除缓存
	 * 参数：@param competitionName
	 * 参数：@return
	 * 返回值：boolean
	 */
	public boolean clearScoreCache(String competitionName){
		boolean result = false;
		
		if(competitionName != null){
			reportCache.clearCache();
			System.out.println("reportSet---bll---size--" + reportCache.getCacheSize());
			result = true;
		}
		
		return result;
	}
	


	
	
	
	
	
	
	
	
	
}
