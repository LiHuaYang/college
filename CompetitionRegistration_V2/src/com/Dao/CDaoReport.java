package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Entity.V2.Report;
import com.Entity.V2.ReportSet;
import com.Tool.MyOpecode;
import com.Tool.sql.ConnectionPool;
import com.Tool.sql.SqlHelper;

public class CDaoReport {

	ConnectionPool pool = ConnectionPool.getIntense();
	
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-13 下午07:23:49
	 * 函数名：searchScoreByCheck
	 * 功能：通过输入信息查询成绩
	 * 参数：@param info
	 * 参数：@return
	 * 返回值：Report
	 */
	public Report searchScoreByCheck(Report info){
	    Report report = null;
	    String querySql = info.getQuerySql();
	    
	    try {
			Connection con = pool.getConnection();
			PreparedStatement ps = con.prepareStatement(querySql);
			
			ResultSet resultSet = ps.executeQuery(querySql);
			
			report = new Report(resultSet,MyOpecode.report.reportCon);
			
			pool.returnConnection(con, ps, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return report;
	}
	
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-13 下午07:23:29
	 * 函数名：searchScoreByUserId
	 * 功能：通过用户id查询成绩
	 * 参数：@param userId
	 * 参数：@return
	 * 返回值：ReportSet
	 */
	public ReportSet searchScoreByUserId(int userId){
		ReportSet reportSet = null;
		return reportSet;
	}
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-21 下午03:03:08
	 * 函数名：getReportSetByCompetitionName
	 * 功能：导入成绩缓存
	 * 参数：@param competitionName
	 * 参数：@return
	 * 返回值：ReportSet
	 */
	public ReportSet getReportSetByCompetitionName(String competitionName){
		ReportSet reportSet = null;
		String querySql = new Report().getQuerySql(competitionName);
		System.out.println("查询此大赛成绩是否导入的sql---" + querySql);
		boolean result = false;
		
		try {
			Connection conn = pool.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(querySql);
			
			ResultSet resultSet = ps.executeQuery();
			
			result = new ReportSet().isOk(resultSet, MyOpecode.report.reportSetCon);
			
			if(result){
				reportSet = new ReportSet(resultSet, MyOpecode.report.reportSetCon);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reportSet;
		
	}
}
