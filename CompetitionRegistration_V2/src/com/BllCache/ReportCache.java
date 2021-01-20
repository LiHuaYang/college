package com.BllCache;

import java.util.Vector;

import javax.annotation.security.RunAs;

import com.Entity.V2.Report;
import com.Entity.V2.ReportSet;

public class ReportCache {

	private static Vector<Report> reportsCache = new Vector<Report>();
	private String competitionName;
	private volatile static ReportCache reportCache;
	
	
	private ReportCache(){}       //单例
	
	public static ReportCache getInstense(){
		if(reportCache == null){
			synchronized (ReportCache.class) {
				if(reportCache == null){
					reportCache = new ReportCache();
				}
			}
		}
		return reportCache;
	}
	
	//将所有成绩加载到缓存中
	public void addReporttoCache(ReportSet reportSet){
		System.out.println("reportSet---cache---size--" + reportSet.getSize());
		
		Runnable ra = new scoreThread(reportSet);
		Thread thread = new Thread(ra);
		thread.start();
	}
	
	
	//清除所有缓存
	public void clearCache(){
		reportsCache.clear();
		this.competitionName = "";
	}
	
	//从缓存中拿数据
	public Report searchScoreByInfoOnCache(Report info){
		Report report = null;
		
		for(int i=0; i<reportsCache.size(); i++){
			Report tempReport = reportsCache.get(i);
			//对比信息
			if(tempReport.getCompetitionName().equals(info.getCompetitionName()) && 
					tempReport.getStudentName().equals(info.getStudentName()) &&
					tempReport.getStudentTicket().equals(info.getStudentTicket()) &&
					tempReport.getEnrollmentPassword().equals(info.getEnrollmentPassword())){
				
				report = tempReport;
			}
		}

		return report;
	}
	
	
	//添加item到缓存
	public void addReporttoCache(Report report){
		if(report != null){
			reportsCache.add(report);
		}
	}
	
	//返回缓存的大小
	public int getCacheSize(){
		return reportsCache.size();
	}
	
	//设置缓存大小
	public void setCacheSize(int CacheSize){
		reportsCache.setSize(CacheSize);
	}

	//设置缓存大赛名称
	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

	public String getCompetitionName() {
		return competitionName;
	}
	
	//数据加载到缓存
	class scoreThread implements Runnable{
		private ReportSet reportSet;
		
		public scoreThread(ReportSet reportSet){
			this.reportSet = reportSet;
		}

		@Override
		public void run() {
			
			for(int i=0; i<reportSet.getSize(); i++){
				Report report = reportSet.getItem(i);
				if(report!=null){
					reportsCache.add(report);
				}
			}
			
			System.out.println("reportsCache--cache--size--" + reportsCache.size());
		}
		
	}
}
