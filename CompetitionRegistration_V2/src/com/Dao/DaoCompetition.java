package com.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Entity.V2.BriefCompetition;
import com.Entity.V2.BriefCompetitionSet;
import com.Entity.V2.DetailedCompetition;
import com.EntityAndroid.ComBasicAddMoney;
import com.EntityAndroid.CompetitionBasicInfo;
import com.EntityAndroid.CompetitionMainWebBasicInfo;
import com.EntityAndroid.CompetitionNewsInfo;
import com.EntityAndroid.CompetitonDetailInfo;
import com.EntityAndroid.SearchCompetitionBasicInfo;
import com.EntityAndroid.YearBasicData;
import com.EntityWeb.AreaBasicData;
import com.EntityWeb.Competition;
import com.EntityWeb.CompetitionBasicData;
import com.EntityWeb.CompetitionInfo;
import com.EntityWeb.Contest;
import com.EntityWeb.Enrollment;
import com.EntityWeb.GradeBasicData;
import com.EntityWeb.Joiner;
import com.EntityWeb.Organization;
import com.EntityWeb.OrganizationSet;
import com.EntityWeb.StudentScoreInfo;
import com.EntityWeb.SubjectBasicData;
import com.EntityWeb.TestPaper;
import com.EntityWeb.TestPaperPicture;
import com.EntityWeb.TestYear;
import com.Tool.sql.JdbcUnit;
import com.Tool.MyOpecode;
import com.Tool.ScoreExcelHelper;
import com.Tool.sql.ConnectionPool;


public class DaoCompetition {
	
	public DaoCompetition(){
		System.out.println("DaoCompetition构造函数被调用");
	};
	
//------------------------------安卓部分-----------------------------------	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-16下午01:08:42
	 *函数名：SearchCompetitionNamePicPro
	 *功能：查询所有大赛id,大赛名字，大赛图片，大赛宣传语
	 *参数：无
	 *返回值：List<CompetitionNewsInfo>
	 */
	public List<CompetitionNewsInfo> SearchCompetitionNamePicPro(){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "Select CompetitionId,CompetitionName,CompetitionPicture,CompetitionPropaganda,CompetitionObjectDescribe from competition";
		
		List<CompetitionNewsInfo> competitionNewsInfos = new ArrayList<CompetitionNewsInfo>();
		
		CompetitionNewsInfo competitionNewsInfo = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				competitionNewsInfo=new CompetitionNewsInfo(rs);
				competitionNewsInfos.add(competitionNewsInfo);
			}
			con.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  competitionNewsInfos;
	}	
	
	
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-17下午04:43:49
	 *函数名：SearchCompetitionMain
	 *功能：通过比赛对象和比赛状态查询一些大赛信息
	 *参数：比赛对象:ContestexamType,比赛状态：ContestState
	 *返回值：List<CompetitionBasicInfo>
	 */
	public List<CompetitionBasicInfo> SearchCompetitionMain(int ContestObject,int ContestState){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql="Select CompetitionName,CompetitionEnrollStartTime,CompetitionEnrollEndTime," +
				"CompetitionPropaganda,CompetitionSession,CompetitionPicture,CompetitionId," +
				"CompetitionObjectDescribe,CompetitionState from competition where CompetitionState="+ContestState;
		
		SearchCompetitionBasicInfo competitionBasicInfo1 = null;
		SearchCompetitionBasicInfo competitionBasicInfo2 = null;
		
		List competitionBasicInfos=new ArrayList();
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				String CompetitionName=rs.getString(1);
				String CompetitionEnrollStartTime=rs.getString(2);
				String CompetitionEnrollEndTime=rs.getString(3);
				String ContestPropaganda=rs.getString(4);
				int CompetitionSession=rs.getInt(5);
				String CompetitionPicture=rs.getString(6);
				int CompetitionId=rs.getInt(7);
				String CompetitionObjectDescribe=rs.getString(8);
				int CompetitionState=rs.getInt(9);
				
				competitionBasicInfo1 = new SearchCompetitionBasicInfo(CompetitionName, 
						CompetitionEnrollStartTime, CompetitionEnrollEndTime, ContestPropaganda, 
						CompetitionSession, CompetitionPicture, CompetitionId, CompetitionObjectDescribe,CompetitionState);
				competitionBasicInfos.add(competitionBasicInfo1);
				
				String sql1="";
				
				if(ContestObject>=1&&ContestObject<=6){
				sql1="Select distinct ContestSubject from Contest where CompetitionId="+CompetitionId+" and ContestObject between 1 and 6";
				}
				else if(ContestObject>=7&&ContestObject<=9){
				sql1="Select distinct ContestSubject from Contest where CompetitionId="+CompetitionId+" and ContestObject between 7 and 9";
				}
				else if(ContestObject>=10&&ContestObject<=12){
				sql1="Select distinct ContestSubject from Contest where CompetitionId="+CompetitionId+" and ContestObject between 10 and 12";
			    }
				
				
				PreparedStatement ps1 = jdbcUnit.prepare(con, sql1);
				List<Contest> contests = new ArrayList<Contest>();
				try {
					ResultSet rs1 = ps1.executeQuery(sql1);
					while(rs1.next()){
						Contest contest = new Contest();
						
						String contestSubject = rs1.getString(1);
						
						contest.setContestSubject(contestSubject);
						contests.add(contest);
					}
				} catch (SQLException e) {                                                                                                            
				}
				
				
				String sql2="";
				if(ContestObject>=1&&ContestObject<=6){
				sql2="Select distinct CompetitionId from Contest where CompetitionId="+CompetitionId+" and ContestObject between 1 and 6";
				}
				else if(ContestObject>=7&&ContestObject<=9){
				sql2="Select distinct CompetitionId from Contest where CompetitionId="+CompetitionId+" and ContestObject between 7 and 9";
				}
				else if(ContestObject>=10&&ContestObject<=12){
				sql2="Select distinct CompetitionId from Contest where CompetitionId="+CompetitionId+" and ContestObject between 10 and 12";
			    }
				
				
				PreparedStatement ps2 = jdbcUnit.prepare(con, sql2);
				List<Contest> contests1 = new ArrayList<Contest>();
				try {
					ResultSet rs2 = ps2.executeQuery(sql2);
					while(rs2.next()){
						Contest contest = new Contest();
						
						int CompetitionId1 = rs2.getInt(1);
						
						contest.setCompetitionId(CompetitionId1);
						contests1.add(contest);
					}
				} catch (SQLException e) {                                                                                                            
				}
				
				competitionBasicInfo1.setContestList1(contests);
				competitionBasicInfo1.setContestList2(contests1);
			}
			con.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JSONArray json=JSONArray.fromObject(competitionBasicInfos);
		System.out.println(json);
		
		return  competitionBasicInfos;
		
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-26下午02:54:23
	 *函数名：QueryFinishedContest
	 *功能：查找所有结束的比赛科目
	 *参数：
	 *返回值：List<CompetitionBasicInfo>
	 */
	public List<CompetitionBasicInfo> QueryFinishedContest(){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "Select distinct ContestSubject from contest where ContestState="+4+" ";
		
		List<CompetitionBasicInfo> CompetitionBasicInfos = new ArrayList<CompetitionBasicInfo>();
		CompetitionBasicInfo competitionBasicInfo=null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				String ContestSubject=rs.getString(1);
				
				competitionBasicInfo=new CompetitionBasicInfo(ContestSubject);
				CompetitionBasicInfos.add(competitionBasicInfo);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  CompetitionBasicInfos;
		
	}
	
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-5下午05:52:38
	 *函数名：QuerySearchCompetition
	 *功能：搜索大赛的显示信息
	 *参数：大赛名称：CompetitionSearchName
	 *返回值：List
	 */
	public List QuerySearchCompetition(String CompetitionSearchName){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql="Select CompetitionName,CompetitionEnrollStartTime,CompetitionEnrollEndTime," +
				"CompetitionPropaganda,CompetitionSession,CompetitionPicture,CompetitionId," +
				"CompetitionObjectDescribe,CompetitionState from Competition where CompetitionState!=-1 " +
				"and CompetitionName like '%"+CompetitionSearchName+"%' or CompetitionBriefName like '%"+CompetitionSearchName+"%'";
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		
		SearchCompetitionBasicInfo competitionBasicInfo1 = null;
		SearchCompetitionBasicInfo competitionBasicInfo2 = null;
		
		List competitionBasicInfos=new ArrayList();
		String sql1="";
		
		try {
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()){
				String CompetitionName=rs.getString(1);
				String CompetitionEnrollStartTime=rs.getString(2);
				String CompetitionEnrollEndTime=rs.getString(3);
				String ContestPropaganda=rs.getString(4);
				int CompetitionSession=rs.getInt(5);
				String CompetitionPicture=rs.getString(6);
				int CompetitionId=rs.getInt(7);
				String CompetitionObjectDescribe=rs.getString(8);
				int CompetitionState=rs.getInt(9);
				
				
				competitionBasicInfo1 = new SearchCompetitionBasicInfo(CompetitionName, 
						CompetitionEnrollStartTime, CompetitionEnrollEndTime, ContestPropaganda, 
						CompetitionSession, CompetitionPicture, CompetitionId, CompetitionObjectDescribe,
						CompetitionState);
				competitionBasicInfos.add(competitionBasicInfo1);
				
				sql1="Select distinct StartTime from Contest where CompetitionId="+CompetitionId;
				PreparedStatement ps1 = jdbcUnit.prepare(con, sql1);
				List<Contest> contests1 = new ArrayList<Contest>();
				try {
					ResultSet rs1 = ps1.executeQuery(sql1);
					while(rs1.next()){
						Contest contest = new Contest();
						
						String startTime = rs1.getString(1);
						
						
						contest.setStartTime(startTime);;
						contests1.add(contest);
					}
				} catch (SQLException e) {                                                                                                            
				}
				
				sql1="Select distinct ContestSubject from Contest where CompetitionId="+CompetitionId;
				PreparedStatement ps2 = jdbcUnit.prepare(con, sql1);
				List<Contest> contests2 = new ArrayList<Contest>();
				try {
					ResultSet rs1 = ps1.executeQuery(sql1);
					while(rs1.next()){
						Contest contest = new Contest();
						
						String contestSubject = rs1.getString(1);
						
						contest.setContestSubject(contestSubject);
						contests2.add(contest);
					}
				} catch (SQLException e) {                                                                                                            
				}
				
				sql1="Select distinct ContestObject from Contest where CompetitionId="+CompetitionId;
				PreparedStatement ps3 = jdbcUnit.prepare(con, sql1);
				List<Contest> contests3 = new ArrayList<Contest>();
				try {
					ResultSet rs1 = ps1.executeQuery(sql1);
					while(rs1.next()){
						Contest contest = new Contest();
						
						int contestObject = rs1.getInt(1);
						
						contest.setContestObject(contestObject);
					}
				} catch (SQLException e) {                                                                                                            
				}
				
				competitionBasicInfo1.setContestList1(contests1);
				competitionBasicInfo1.setContestList2(contests2);
				competitionBasicInfo1.setContestList3(contests3);
			}
			// competitionMainWebBasicInfo1s.add(competitionMainWebBasicInfo2s);
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray json=JSONArray.fromObject(competitionBasicInfos);
		System.out.println(json);
		
		return competitionBasicInfos;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-27下午06:26:54
	 *函数名：QueryContestInfobyId
	 *功能：查询大赛的信息通过大赛id
	 *参数：大赛项目id
	 *返回值：CompetitionBasicInfo
	 */
	public List<CompetitionBasicInfo> QueryContestInfobyId(int Competitionid){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql="Select CompetitionName,CompetitionEnrollStartTime," +
		"CompetitionEnrollEndTime,CompetitionPropaganda" +
		"CompetitionSession,CompetitionId,CompetitionObjectDescribe," +
		"CompetitionState,CompetitionTimeDescribe,CompetitionInfo,CompetitionPicture"+
		" from competition where CompetitionState!=-1 and CompetitionId ="+Competitionid;
		
		CompetitonDetailInfo competitionBasicInfo1 = null;
		CompetitonDetailInfo competitionBasicInfo2 = null;
		
		List competitionBasicInfos=new ArrayList();
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				Competition competition=new Competition();
				String CompetitionName=rs.getString(1);
				String CompetitionEnrollStartTime=rs.getString(2);
				String CompetitionEnrollEndTime=rs.getString(3);
				String ContestPropaganda=rs.getString(4);
				int CompetitionSession=rs.getInt(5);
				int CompetitionId1=rs.getInt(6);
				String CompetitionObjectDescribe=rs.getString(7);
				int CompetitionState=rs.getInt(8);
				String CompetitionTimeDescribe=rs.getString(9);
				String CompetitionInfo=rs.getString(10);
				String CompetitionPicture=rs.getString(11);
				
				
				competitionBasicInfo1=new CompetitonDetailInfo(CompetitionName, 
						CompetitionEnrollStartTime, CompetitionEnrollEndTime, ContestPropaganda,
						CompetitionSession, CompetitionId1, CompetitionObjectDescribe, CompetitionState,
						CompetitionInfo,CompetitionTimeDescribe,CompetitionPicture);
				
				competitionBasicInfos.add(competitionBasicInfo1);
				
				String sql1="";
				
				sql1="Select ContestexamType,StartTime,ContestSubject,ContestObject,ContestId," +
						"EndTime,ContestMoney from contest where CompetitionId="+Competitionid;
				
				PreparedStatement ps1 = jdbcUnit.prepare(con, sql1);
				List<Contest> contests = new ArrayList<Contest>();
				try {
					ResultSet rs1 = ps1.executeQuery(sql1);
					while(rs1.next()){
						Contest contest = new Contest();
						
						String ContestexamType = rs1.getString(1);
						String StartTime = rs1.getString(2);
						String ContestSubject = rs1.getString(3);
						int ContestObject = rs1.getInt(4);
						int ContestId = rs1.getInt(5);
						String EndTime = rs1.getString(6);
						int ContestMoney = rs1.getInt(7);
						
						contest.setContestexamType(ContestexamType);
						contest.setStartTime(StartTime);
						contest.setContestSubject(ContestSubject);
						contest.setContestObject(ContestObject);
						contest.setContestId(ContestId);
						contest.setEndTime(EndTime);
						contest.setContestMoney(ContestMoney);
						
						contests.add(contest);
					}
				} catch (SQLException e) {                                                                                                            
				}
				
				
				String sql2="";
				sql2="Select distinct ContestPicUrl from ContestPicture where CompetitionId="+Competitionid;
				
				PreparedStatement ps2 = jdbcUnit.prepare(con, sql2);
				List<Contest> contests1 = new ArrayList<Contest>();
				try {
					ResultSet rs2 = ps2.executeQuery(sql2);
					while(rs2.next()){
						Contest contest = new Contest();
						
						String ContestPicUrl = rs2.getString(1);
						
						contest.setContestPicUrl(ContestPicUrl);
						contests1.add(contest);
					}
				} catch (SQLException e) {                                                                                                            
				}
				
				
				competitionBasicInfo1.setContestList1(contests);
				competitionBasicInfo1.setContestList2(contests1);
			}
			con.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JSONArray json=JSONArray.fromObject(competitionBasicInfos);
		System.out.println(json);
		
		return  competitionBasicInfos;
	}
	
	

	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-27下午06:26:54
	 *函数名：QueryContestInfobyId
	 *功能：查询网页端大赛的信息通过大赛id
	 *参数：大赛项目id
	 *返回值：CompetitionBasicInfo
	 */
	public List<CompetitionBasicInfo> QueryWebContestInfobyId(int Competitionid){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		List<CompetitionBasicInfo> CompetitionBasicInfos = new ArrayList<CompetitionBasicInfo>();
		CompetitionBasicInfo competitionBasicInfo=null;
		
		String sql="Select a.CompetitionName,c.StartTime,a.CompetitionEnrollStartTime," +
				"a.CompetitionEnrollEndTime,a.CompetitionPropaganda,c.ContestSubject,c.ContestObject," +
				"a.CompetitionSession,a.CompetitionPicture,a.CompetitionId,a.CompetitionObjectDescribe," +
				"a.CompetitionState,a.CompetitionTimeDescribe,a.CompetitionInfo,c.ContestexamType," +
				"a.CompetitionPriceDescribe,c.EndTime,c.ContestMoney,a.CompetitionPrize " +
				"from competition a,contest c where a.CompetitionId=c.CompetitionId " +
				"and a.CompetitionState!=-1 and a.CompetitionId ="+Competitionid;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try
		{
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				String CompetitionName=rs.getString(1);
				String StartTime=rs.getString(2);
				String CompetitionEnrollStartTime=rs.getString(3);
				String CompetitionEnrollEndTime=rs.getString(4);
				String ContestPropaganda=rs.getString(5);
				String ContestSubject=rs.getString(6);
				int ContestObject=rs.getInt(7);
				int CompetitionSession=rs.getInt(8);
				String CompetitionPicture=rs.getString(9);
				int CompetitionId=rs.getInt(10);
				String CompetitionObjectDescribe=rs.getString(11);
				int CompetitionState=rs.getInt(12);
				String CompetitionTimeDescribe=rs.getString(13);
				String CompetitionInfo=rs.getString(14);
				String ContestexamType=rs.getString(15);
				String CompetitionPriceDescribe=rs.getString(16);
				String EndTime=rs.getString(17);
				int ContestMoney=rs.getInt(18);
				String CompetitionPrize=rs.getString(19);
				
				competitionBasicInfo=new CompetitionBasicInfo(CompetitionName, 
						StartTime, CompetitionEnrollStartTime, CompetitionEnrollEndTime, 
						ContestPropaganda, ContestSubject, ContestObject, CompetitionSession, 
						CompetitionPicture, CompetitionId, CompetitionObjectDescribe, CompetitionState, 
						CompetitionInfo, ContestexamType, EndTime, ContestMoney, 
						CompetitionTimeDescribe, CompetitionPriceDescribe,CompetitionPrize);
				CompetitionBasicInfos.add(competitionBasicInfo);
			}
			con.close();
			ps.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return CompetitionBasicInfos;
	}
	
	
	
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-28下午02:30:20
	 *函数名：SearchCompetitionCludeMoney
	 *功能：首页显示已经报名且报名截止时间离现在最近的一个大赛
	 *参数：
	 *返回值：List<ComBasicAddMoney>
	 */
	public List<ComBasicAddMoney> SearchCompetitionCludeMoney(){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		ComBasicAddMoney competitionBasicInfo1 = null;
		ComBasicAddMoney competitionBasicInfo2 = null;
		List competitionBasicInfos=new ArrayList();
		
		String sql_mintime = "select min(CompetitionEnrollEndTime) from competition where CompetitionState=2";   //在正在报名比赛中找出离现在最近的报名截止时间
		PreparedStatement ps_mintime = jdbcUnit.prepare(con, sql_mintime);
		try
		{
			ResultSet rs_time = ps_mintime.executeQuery(sql_mintime);
			while (rs_time.next()) {
				
				String Time=rs_time.getString(1);
				
				String sql="select CompetitionName,CompetitionEnrollEndTime,CompetitionPicture,CompetitionId," +
						"CompetitionObjectDescribe from competition where CompetitionState=2 and CompetitionEnrollEndTime='"+Time+"' ";
				
				PreparedStatement ps = jdbcUnit.prepare(con, sql);
				try {
					ResultSet rs = ps.executeQuery(sql);
					while (rs.next()) {
						Competition competition=new Competition();
						
						String CompetitionName=rs.getString(1);
						String CompetitionEnrollEndTime=rs.getString(2);
						String CompetitionPicture=rs.getString(3);
						int CompetitionId1=rs.getInt(4);
						String CompetitionObjectDescribe=rs.getString(5);
						
						competitionBasicInfo1=new ComBasicAddMoney(CompetitionName,CompetitionPicture,CompetitionId1,CompetitionObjectDescribe,CompetitionEnrollEndTime);
						competitionBasicInfos.add(competitionBasicInfo1);
						
						System.out.println(CompetitionId1);
						String sql1="";
						sql1="Select distinct ContestMoney,ContestSubject from contest where CompetitionId="+CompetitionId1;
						
						PreparedStatement ps1 = jdbcUnit.prepare(con, sql1);
						List<Contest> contests = new ArrayList<Contest>();
						try {
							ResultSet rs1 = ps1.executeQuery(sql1);
							while(rs1.next()){
								Contest contest = new Contest();
								
								int ContestMoney = rs1.getInt(1);
								String ContestSubject = rs1.getString(2);
								
								contest.setContestMoney(ContestMoney);
								contest.setContestSubject(ContestSubject);
								contests.add(contest);
							}
							ps1.close();
						} catch (SQLException e) {                                                                                                            
						}
						competitionBasicInfo1.setContestList1(contests);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			con.close();
			ps_mintime.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return  competitionBasicInfos;
		
	}
	
	/**
	 *作者：ZhangHuanMing
	 *时间：2016-1-28下午03:49:12
	 *函数名：Number_Competition
	 *功能：ContestState
	 *参数：查找正在报名和即将报名赛事个数分别是多少
	 *返回值：赛事个数
	 */
	public int Number_Competition(int ContestState){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql="Select CompetitionName from competition where CompetitionState="+ContestState;
		
		int i=0;
		try{
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				i++;
			}
			con.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("失败");
		}
		
		return i;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-3下午09:41:18
	 *函数名：QueryCompetitionInfoEnrollmenting
	 *功能：查询正在报名的比赛的信息
	 *参数：无
	 *返回值：List<Competition>
	 */
	public List<Competition> QueryCompetitionInfoEnrollmenting(){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "Select CompetitionId,CompetitionName,CompetitionPropaganda,CompetitionPicture " +
				"from Competition where CompetitionState=2";
		
		List<Competition> competitions = new ArrayList<Competition>();
		
		Competition competition = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				int CompetitionId=rs.getInt(1);
				String CompetitionName = rs.getString(2);
				String ContestPropaganda = rs.getString(3);
				String Competitionpic=rs.getString(4);
				
				competition=new Competition(CompetitionId, CompetitionName, ContestPropaganda, Competitionpic);
				competitions.add(competition);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  competitions;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-4下午05:35:15
	 *函数名：QueryTestEnrollmentbefore
	 *功能：首页即将报名比赛
	 *参数：无
	 *返回值：List<CompetitionBasicInfo>
	 */
	public List QueryWebEnrollmentbefore(){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql="Select CompetitionId,CompetitionPicture,CompetitionEnrollStartTime," +
				"CompetitionName,CompetitionObjectDescribe,CompetitionEnrollEndTime" +
				" from Competition where CompetitionState=1";
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		
		CompetitionMainWebBasicInfo competitionMainWebBasicInfo1 = null;
		CompetitionMainWebBasicInfo competitionMainWebBasicInfo2 = null;
		
		List competitionMainWebBasicInfo1s=new ArrayList();
		String sql1="";
		
		try {
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()){
				int CompetitionId1=rs.getInt(1);
				String CompetitionPicture=rs.getString(2);
				String CompetitionEnrollStartTime=rs.getString(3);
				String CompetitionName=rs.getString(4);
				String CompetitionObjectDescribe=rs.getString(5);
				String CompetitionEnrollEndTime=rs.getString(6);
				
				competitionMainWebBasicInfo1 = new CompetitionMainWebBasicInfo(CompetitionId1, CompetitionPicture, CompetitionEnrollStartTime, CompetitionName, CompetitionObjectDescribe,CompetitionEnrollEndTime);
				competitionMainWebBasicInfo1s.add(competitionMainWebBasicInfo1);
				
				sql1="Select distinct ContestSubject from Contest where CompetitionId="+CompetitionId1;
				PreparedStatement ps1 = jdbcUnit.prepare(con, sql1);
				List<Contest> contests = new ArrayList<Contest>();
				try {
					ResultSet rs1 = ps1.executeQuery(sql1);
					while(rs1.next()){
						Contest contest = new Contest();
//						int CompetitionId2 = rs1.getInt(1);
						String ContestSubject = rs1.getString(1);
//						String ContestexamType = rs1.getString(3);
						
//						contest.setCompetitionId(CompetitionId2);
//						contest.setContestexamType(ContestexamType);
						contest.setContestSubject(ContestSubject);
						contests.add(contest);
						
					}
				} catch (SQLException e) {                                                                                                            
				}
				
				competitionMainWebBasicInfo1.setContetList(contests);
			}
			// competitionMainWebBasicInfo1s.add(competitionMainWebBasicInfo2s);
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray json=JSONArray.fromObject(competitionMainWebBasicInfo1s);
		System.out.println(json);
		
		return competitionMainWebBasicInfo1s;
		
	}
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-28下午07:38:17
	 *函数名：SearchContestSubject
	 *功能：查询大赛的所有科目
	 *参数：大赛id
	 *返回值：List<String>
	 */
	public List<Contest> SearchContestSubject(int CompetitionId){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql="select DISTINCT ContestSubject FROM contest where CompetitionId="+CompetitionId;
		
		System.out.println(sql);
		List<Contest> results=new ArrayList<Contest>();
		try{
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String ContestSubject=rs.getString(1);
				Contest contest=new Contest(ContestSubject);
				
				results.add(contest);
			}
			con.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("失败");
		}
		return results;
	}

	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-28下午08:57:30
	 *函数名：SearchContestObject
	 *功能：查询大赛的所有年级
	 *参数：大赛id,竞赛科目
	 *返回值：List<Integer>
	 */
	public List<Integer> SearchContestObject(int CompetitionId,String ContestSubject){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql="select DISTINCT ContestObject FROM contest where CompetitionId="+CompetitionId+" and ContestSubject='"+ContestSubject+"' ";
		System.out.println(sql);
		int result=0;
		
		List<Integer> results=new ArrayList<Integer>();
		try{
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				result=rs.getInt(1);
				results.add(result);
			}
			con.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return results;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午04:06:19
	 *函数名：QueryTestNameTimeInfo
	 *功能：查询试卷表的名字和发布时间和难度系数
	 *参数：页数：page
	 *返回值：List<TestPaper>
	 *备注：试卷的状态TestPaperState=1
	 */
	public List<TestPaper> QueryTestNameTimeInfo(int page){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		int startPos = (page - 1) * 20;
		
		String sql = "Select TestPaperId,TestPaperName,TestPaperTime,TestDifficulty from TestPaper where TestPaperState=1 limit "+startPos+","+20;
		
		List<TestPaper> testPapers = new ArrayList<TestPaper>();
		
		TestPaper testPaper = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				int TestPaperId=rs.getInt(1);
				String TestPaperName = rs.getString(2);
				String TestPaperTime = rs.getString(3);
				int TestDifficulty=rs.getInt(4);
				
				testPaper=new TestPaper(TestPaperId, TestPaperName, TestPaperTime, TestDifficulty);
				testPapers.add(testPaper);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  testPapers;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-2-28下午07:42:10
	 *函数名：QueryTextNumber
	 *功能：查询试卷总数
	 *参数：
	 *返回值：试卷总数
	 */
	public int QueryTextNumber(String ContestSubject,String CompetitionName,String StudentGrade){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "select TestPaperId,TestPaperName,TestPaperTime,TestSubject, TestDifficulty from testpaper where TestState='"+StudentGrade+"' and TestSubject='"+ContestSubject+"' and TestPaperName like'%"+CompetitionName+"%' " ;
		
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
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午07:48:26
	 *函数名：QueryTestPaperPictureById
	 *功能：通过试卷id查找试卷图片详情
	 *参数：试卷id：TestPaperid
	 *返回值：List<TestPaperPicture>
	 */
	public List<TestPaperPicture> QueryTestPaperPictureById(int TestPaperId){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "Select * from TestPaperPicture where TestPaperId="+TestPaperId+" order by testPaperNumber";

		List<TestPaperPicture> testPaperPictures = new ArrayList<TestPaperPicture>();
		
		TestPaperPicture testPaperPicture = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				testPaperPicture=new TestPaperPicture(rs);
				testPaperPictures.add(testPaperPicture);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  testPaperPictures;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午09:48:22
	 *函数名：QueryTestPaperSearch
	 *功能：试卷列表搜索功能
	 *参数：
	 *返回值：List<TestPaper>
	 */
	public List<TestPaper> QueryTestPaperSearch(){
		return null;
	}
	

	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-27下午04:20:00
	 *函数名：SearchCountEnrollmentByCompetiitonId
	 *功能：通过大赛id得到此大赛总报名人数
	 *参数：大赛id：competitionId
	 *返回值：int
	 */
	public int SearchCountEnrollmentByCompetiitonId(int CompetitionId){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "Select count(e.UserId) from enrollment e,Contest c,Competition p " +
				"where e.contestid=c.contestid and c.competitionid=p.competitionid " +
				"and p.competitionid="+CompetitionId+" and e.enrollmentState=3";
		
//		System.out.print("总报名人数"+sql);
		int count=0;		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			
			rs.next();
			count = rs.getInt(1);
			
			con.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  count;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-3-4下午09:33:55
	 *函数名：SearchWeekCountEnrollmentByCompetiitonId
	 *功能：通过大赛id得到此大赛周报名人数
	 *参数：大赛id：competitionId
	 *返回值：int
	 */
	public int SearchWeekCountEnrollmentByCompetiitonId(int CompetitionId){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String Day=(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());   //获取当前时间
		Calendar   c   =   Calendar.getInstance(); 
	    c.add(Calendar.DAY_OF_MONTH,-7);   //7天前.... 
	    SimpleDateFormat   sdf   =   new   SimpleDateFormat( "yyyy-MM-dd hh:mm:ss "); 
	    String Day_before=sdf.format(c.getTime()).toString();     //获取一周前的时间
	    String sql = "Select count(e.UserId) from enrollment e,Contest c,Competition p where e.contestid=c.contestid and c.competitionid=p.competitionid " +
	    		"and p.competitionid="+CompetitionId+" and e.EnrollmentTime>='"+Day_before+"' and e.EnrollmentTime<='"+Day+"' and e.enrollmentState=3";
	    
	    
//	    System.out.println("周报名人数"+sql);
//	    System.out.println("当前时间"+Day);
//	    System.out.println("一周前时间"+Day_before);
//	    
		int count=0;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			
			rs.next();
			count = rs.getInt(1);
			
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  count;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-29上午08:53:16
	 *函数名：SearchContestMoneybyId
	 *功能：通过ContestId获取报名费，大赛开始时间，结束时间
	 *参数：竞赛id
	 *返回值：List<Integer>
	 */
	public CompetitionBasicInfo SearchContestMoneybyId(int contestId){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql="select StartTime,EndTime,ContestMoney FROM contest where ContestId="+contestId;
		
//		System.out.println("查询报名费"+sql);
		
		CompetitionBasicInfo result=null;
		try{
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				String StartTime=rs.getString(1);
				String EndTime=rs.getString(2);
				int ContestMoney=rs.getInt(3);
				result = new CompetitionBasicInfo(StartTime,EndTime,ContestMoney);
			}
			con.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-29上午09:12:58
	 *函数名：QueryOrganization
	 *功能：根据竞赛Id来查询承办方
	 *参数：竞赛Id
	 *返回值：List<Organization>
	 */
	public List<Organization> QueryOrganization(int contestId){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "Select o.OrganizationId,o.OrganizationName from Contest c,ContestOrganization co,Organization o where c.ContestId=co.ContestId and co.OrganizationId=o.OrganizationId and c.contestId="+contestId;
		System.out.println("查询竞赛承办方"+sql);
		List<Organization> organizations = new ArrayList<Organization>();
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				int OrganizationId = rs.getInt(1);
				String OrganizationName = rs.getString(2);
				Organization organization = new Organization(OrganizationId, OrganizationName);
				organizations.add(organization);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  organizations;
	}
	
	
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月28日14:32:22
	 *函数名：GetCompetitionNamebyNameID
	 *功能：查询大赛名和简称
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：CompetitionBasicData
	 */	
	public List<CompetitionBasicData> GetCompetitionNamebyNameID() {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql="select * from competitionbasicdata";
		
		List<CompetitionBasicData> competitionBasicDatas=new ArrayList<CompetitionBasicData>();
		CompetitionBasicData competitionBasicData=null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				competitionBasicData=new CompetitionBasicData(rs);
				competitionBasicDatas.add(competitionBasicData);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  competitionBasicDatas;

	}
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月28日16:28:30
	 *函数名：GetCompetitionProjectbyProjectID
	 *功能：查询科目
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：SubjectBasicData
	 */	
	public List<SubjectBasicData> GetCompetitionProjectbyProjectId() {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql="select * from subjectbasicdata";
		
		List<SubjectBasicData> subjectbasicdatas=new ArrayList<SubjectBasicData>();
		SubjectBasicData subjectbasicdata=null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				subjectbasicdata = new SubjectBasicData(rs);
				subjectbasicdatas.add(subjectbasicdata);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return  subjectbasicdatas;
}
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月28日16:33:48
	 *函数名：GetCompetitionObjectbyObjectId
	 *功能：查询竞赛对象
	 *参数：@param ObjectId
	 *参数：@param 
	 *参数：@return
	 *返回值：GradeBasicData
	 */	
	public List<GradeBasicData> GetCompetitionObjectbyObjectId() {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库

		String sql="select * from gradebasicdata";
		List<GradeBasicData> gradebasicdatas = new ArrayList<GradeBasicData>();
		GradeBasicData gradebasicdata = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {

				gradebasicdata = new GradeBasicData(rs);
				gradebasicdatas.add(gradebasicdata);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  gradebasicdatas;
}
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月28日16:42:43
	 *函数名：GetCompetitionAreabyAreaId
	 *功能：查询地区
	 *参数：@param AreaId
	 *参数：@param 
	 *参数：@return
	 *返回值：AreaBasicData
	 */	
	public List<AreaBasicData> GetCompetitionAreabyAreaId() {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql="select * from areabasicdata";
		List<AreaBasicData> areabasicdatas = new ArrayList<AreaBasicData>();
		AreaBasicData areabasicdata = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {

				areabasicdata = new AreaBasicData(rs);
				areabasicdatas.add(areabasicdata);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  areabasicdatas;
 }
	
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月28日18:44:46
	 *函数名：CollectStateJudge
	 *功能：根据试卷id和用户id判断是否收藏
	 *参数：@param TestPaperId
	 *参数：@param userid
	 *参数：@return
	 *返回值：boolean
	 */	
	public boolean CollectStateJudge(int TestPaperId,int userid) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库

		boolean flag=false;
		String sql="select * from collect where TestPaperId='"+TestPaperId+"' and userid="+userid;
		System.out.println("ContestSearchInfo 大赛首页数据列表查询语句: " + sql);
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				int CollectState = rs.getInt(4);
				if(CollectState==0)
				{
					flag=false;
				}
				if(CollectState==1)
				{
					flag=true;
				}

			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
 }

	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月28日19:35:42
	 *函数名：CancelCollect
	 *功能：取消收藏
	 *参数：@param TestPaperId
	 *参数：@param userid
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean CancelCollect(int TestPaperId,int userid) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		boolean flag=true;
		String sql="update collect set CollectState='0' where TestPaperId='"+TestPaperId+"' and userid="+userid;
		System.out.println("ContestSearchInfo 大赛首页数据列表查询语句: " + sql);
		int i=0;
		
		try {
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			ps.execute();
			i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("取消成功");
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			flag=false;
			e.printStackTrace();
			System.out.println("取消失败");
		}
		if(i>0 && flag==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}

	/**
	 * 
	 *作者：lujinye
	 *时间：2016年3月7日19:30:49
	 *函数名：Changepassword(String UserPhone,String UserPWD)
	 *功能：修改密码
	 *参数：@param UserPhone
	 *参数：@param UserPWD
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean Changepassword(String UserPhone,String UserPWD) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		boolean flag=true;
		String sql="update user set UserPassage='"+UserPWD+"' where UserPhone="+UserPhone;
		System.out.println("ContestSearchInfo 大赛首页数据列表查询语句: " + sql);
		int i=0;
		
		try {
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			ps.execute();
			i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("修改成功");
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			flag=false;
			e.printStackTrace();
			System.out.println("修改失败");
		}
		if(i>0 && flag==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-1下午08:25:20
	 *函数名：QueryBasicPictureData
	 *功能：查询首页的主图片
	 *参数：无
	 *返回值：String
	 */
	public String QueryBasicPictureData(){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "select mainPicture from WebsiteBasicData";

		String mainPicture=null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {	
				mainPicture=rs.getString(1);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mainPicture;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-2下午09:00:25
	 *函数名：QuerySearchTestParperCount
	 *功能：查询试卷搜索搜索后的总数
	 *参数：科目：ContestSubject 名字：CompetitionName 年级：StudentGrade
	 *返回值：int
	 */
	public int QuerySearchTestParperCount(String ContestSubject,String CompetitionName,String StudentGrade){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "select count(*) from testpaper where 1=1";
		
		if(!"".equals(ContestSubject)){
			sql=sql+" and TestYear='"+ContestSubject+"'";
		}
		
		if(!"".equals(CompetitionName)){
			sql=sql+" and TestPaperName like'%"+CompetitionName+"%'";
		}
		
		if(!"".equals(StudentGrade)){
			sql=sql+" and TestState= '"+StudentGrade+"'";
		}
		
		int count=0;		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			
			rs.next();
			count = rs.getInt(1);
			
			con.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  count;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-3上午10:49:32
	 *函数名：GetTestPaperYearbyObjectId
	 *功能：查询基础表的年份
	 *参数：无
	 *返回值：List<YearBasicData>
	 */
	public List<YearBasicData> GetTestPaperYearbyObjectId(){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库

		String sql="select * from YearBasicData";
		List<YearBasicData> yearBasicDatas = new ArrayList<YearBasicData>();
		YearBasicData yearBasicData = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {

				yearBasicData = new YearBasicData(rs);
				yearBasicDatas.add(yearBasicData);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  yearBasicDatas;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-3-3下午07:44:49
	 *函数名：QueryContestId
	 *功能：根据大赛id,科目，参赛年级获得唯一的ContestId
	 *参数：大赛id,科目，参赛年级
	 *返回值：ContestId
	 */
	public int QueryContestId(int CompetitionId,String ContestSubject,int ContestObject){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		int ContestId=0;
		String sql="select ContestId from contest where CompetitionId="+CompetitionId+" and  ContestSubject='"+ContestSubject+"' and ContestObject="+ContestObject+" ";
		System.out.println("查询ContestId："+sql);
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {

				ContestId = rs.getInt(1);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  ContestId;
	}
	
	
	/**
	 * 
	 *作者：qiumeifang
     *时间：2016-3-4下午02:45:12
     *函数名：QueryCompetitionpic
	 *功能：根据竞赛id查询详情图片
	 *参数：CompetitionId
	 *返回值：results
	 */
	public List<String> QueryCompetitionpic(int CompetitionId){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql="select ContestPicUrl from contestpicture where CompetitionId="+CompetitionId;
		
		String result=null;
		
		List<String> results=new ArrayList<String>();
		try{
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				result=rs.getString(1);
				results.add(result);
			}
			con.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return results;
	}
	
	/**
	 * 
	 *作者：QiuMeifang
     *时间：2016-3-5上午10:47:10
     *函数名：SearchCompetitionName
	 *功能：查询大赛名字
	 *参数：无
	 *返回值：List<Enrollment>
	 */

	public List<Enrollment> SearchCompetitionName(){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "Select distinct CompetitionName from enrollment";
				
		List<Enrollment> enrollments = new ArrayList<Enrollment>();
		try{
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String CompetitionName=rs.getString(1);
				Enrollment enrollment=new Enrollment(CompetitionName);
				
				enrollments.add(enrollment);
			}
			con.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("失败");
		}
		return enrollments;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-3-9下午07:46:40
	 *函数名：JudgeEnrollOrNot
	 *功能：通过用户身份证号，大赛名称，科目，参赛年级判断此人是否已经报名
	 *参数：用户身份证号，大赛名称，科目，参赛年级
	 *返回值：boolean
	 */
	public boolean JudgeEnrollOrNot(String UserIdNumber,String CompetitionName,String ContestSubject,int ContestObject){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql="select enrollmentState from enrollment where StudentIDNumber='"+UserIdNumber+"' and CompetitionName='"+CompetitionName+"' and ContestSubject='"+ContestSubject+"' and ContestObject="+ContestObject+" ";
		
		int state=0;
		boolean result = true;
		
		try{
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				state=rs.getInt(1);
				if(state==1){    //未付款，可以继续报名
					result = true;
				}
				
				else if(state==3){  // 已付款，不能报名
					result = false;
				}
			}
			con.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
//------------------------------web部分-----------------------------------
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-15下午20:37:34
	 *函数名：ContestRelease
	 *功能：大赛发布
	 *参数：ContestId
	 *返回值：true/false
	 */
	public boolean ContestRelease(int ContestId){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		boolean result=true;
		String sql="update contest set ContestState='1' where ContestId='"+ContestId+"' ";
		int i=0;
		try{
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			ps.execute();
			i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("成功");
			}
			con.close();
			ps.close();
		}catch(SQLException e){
			result=false;
			e.printStackTrace();
			System.out.println("失败");
		}
		if(i>0 && result==true)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-15下午21:47:34
	 *函数名：ContestChangeState
	 *功能：改变大赛进行状态
	 *参数：ContestId，CompetitionState
	 *返回值：true/false
	 */
	public boolean ContestChangeState(int ContestId,int CompetitionState){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		boolean result=true;
		String sql="update contest set ContestState='"+CompetitionState+"' where ContestId='"+ContestId+"' ";
		int i=0;
		try{
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			ps.execute();
			i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("成功");
			}
			con.close();
			ps.close();
		}catch(SQLException e){
			result=false;
			e.printStackTrace();
			System.out.println("失败");
		}
		if(i>0 && result==true)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-16下午16:20:34
	 *函数名：CompetitionCreate
	 *功能：大赛新建
	 *参数：CompetitionInfo(CompetitionName,StartTime,EndTime,
				CompetitionSession,ContestState,CompetitionInfo,ParticularYear,ContestShape,
				ContestPropaganda,ContestPicUrl,ContestObject,ContestSubject,ContestMoney,ContestexamType);
	 *返回值：true/false
	 */
	public boolean CompetitionCreate(CompetitionInfo competition){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		boolean result = true;
		String sql1="insert into contestpicture(ContestPicUrl) values('"+competition.getContestPicUrl()+"')";
		
		String sql2="insert into competition(CompetitionName,CompetitionSession,CompetitionInfo," +
				"ParticularYear) values('"+competition.getCompetitionName()+"',"+competition.getCompetitionSession()+"," +
						"'"+competition.getCompetitionInfo()+"',"+competition.getParticularYear()+")";
		
		String sql3="insert into contest(ContestObject,ContestSubject,ContestMoney,CompetitionPropaganda,ContestState," +
				"StartTime,EndTime,ContestexamType) values('"+competition.getContestObject()+"','"+competition.getContestSubject()+"',"+competition.getContestMoney()+"," +
				"'"+competition.getContestPropaganda()+"','0','"+competition.getStartTime()+"','"+competition.getEndTime()+"',"+competition.getContestexamType()+")";
		
		PreparedStatement pstmt1, pstmt2, pstmt3, pstm4;
		try
		{
			pstmt1=(PreparedStatement)con.prepareStatement(sql1);
			System.out.println("1" + sql1);
			pstmt1.execute();
			pstmt2=(PreparedStatement)con.prepareStatement(sql2);
			System.out.println("2" + sql2);
			pstmt2.execute();
			
			pstmt3=(PreparedStatement)con.prepareStatement(sql3);
			System.out.println("3" + sql3);
			pstmt3.execute();
			
			con.close();
			pstmt1.close();
			pstmt2.close();
			pstmt3.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			result=false;
		}
		return result;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-29上午09:07:58
	 *函数名：ContestSearchByState
	 *功能：
	 *参数：@param state
	 *参数：@return
	 *返回值：List<CompetitionInfo>
	 */
	public List<CompetitionInfo> ContestSearchByState(int state) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "Select b.CompetitionName,a.StartTime,a.EndTime,a.ContestState,a.ContestObject,a.ContestexamType " +
				"from competition b,contest a where a.CompetitionId = b.CompetitionId and " +
				"a.ContestState=" + state + " GROUP BY b.CompetitionName";
		
		System.out.println("List<CompetitionInfo> ContestSearchByState(int state) 大赛首页根据赛事状态查找赛事列表: " + sql);
		List<CompetitionInfo> competitionInfos = new ArrayList<CompetitionInfo>();
		CompetitionInfo competitionInfo = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				String CompetitionName=rs.getString(1);
				String StartTime=rs.getString(2);
				String EndTime=rs.getString(3);
				int ContestState=rs.getInt(4);
				int ContestObject=rs.getInt(5);
				String ContestexamType=rs.getString(6);
				
				competitionInfo=new CompetitionInfo(CompetitionName, StartTime, EndTime,ContestState,ContestObject,ContestexamType);
				competitionInfos.add(competitionInfo);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  competitionInfos;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-29上午08:50:25
	 *函数名：ContestSearchInfo
	 *功能：多条件模糊查询
	 *参数：@param condition
	 *参数：@return
	 *返回值：List<CompetitionInfo>
	 */
	public List<CompetitionInfo> ContestSearchInfo(String condition) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "Select b.CompetitionName,a.StartTime,a.EndTime,a.ContestState,a.ContestObject,a.ContestexamType " +
				"from competition b,contest a where a.CompetitionId = b.CompetitionId and " +
				"b.CompetitionName like '%" + condition + "&' or " +
				"a.ContestState like '%" + condition + "&' or " +
				"a.ContestObject like '%" + condition + "%'";
		
		System.out.println("ContestSearchInfo(String condition) 大赛首页数据多条件模糊查询查询语句: " + sql);
		
		List<CompetitionInfo> competitionInfos = new ArrayList<CompetitionInfo>();
		
		CompetitionInfo competitionInfo = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				String CompetitionName=rs.getString(1);
				String StartTime=rs.getString(2);
				String EndTime=rs.getString(3);
				int ContestState=rs.getInt(4);
				int ContestObject=rs.getInt(5);
				String ContestexamType = rs.getString(6);
				
				competitionInfo=new CompetitionInfo(CompetitionName, StartTime, EndTime,ContestState,ContestObject,ContestexamType);
				competitionInfos.add(competitionInfo);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  competitionInfos;
	}
	
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-16下午18:55:34
	 *函数名：ContestSearchInfo
	 *功能：查询大赛所有信息
	 *参数：无
	 *返回值：CompetitionName，CompetitionEnrollStartTime，CompetitionEnrollEndTime,ContestState,ContestObject,ContestSubject,ContestexamType
	 */
	public List<CompetitionInfo> ContestSearchInfo(int page){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		int startPos = (page - 1) * 10;
		String sql = "Select b.CompetitionName,b.CompetitionEnrollStartTime,b.CompetitionEnrollEndTime,b.CompetitionState,a.ContestObject,a.ContestexamType,a.ContestSubject, a.ContestId,a.CompetitionId from competition b,contest a where a.CompetitionId=b.CompetitionId limit "+ startPos + "," +10;
		System.out.println("ContestSearchInfo 大赛首页数据列表查询语句: " + sql);
		List<CompetitionInfo> competitionInfos = new ArrayList<CompetitionInfo>();
		
		CompetitionInfo competitionInfo = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				String CompetitionName=rs.getString(1);
				String CompetitionEnrollStartTime=rs.getString(2);
				String CompetitionEnrollEndTime=rs.getString(3);
				int CompetitionState=rs.getInt(4);				
				//System.out.println(CompetitionState);
				int ContestObject=rs.getInt(5);
				String ContestexamType=rs.getString(6);
				String ContestSubject=rs.getString(7);
				int ContestId=rs.getInt(8);
				
				
				competitionInfo=new CompetitionInfo(CompetitionState,CompetitionEnrollStartTime, CompetitionEnrollEndTime,CompetitionName , ContestObject,ContestId,ContestexamType,ContestSubject);
				//System.out.println(competitionInfo);
				competitionInfos.add(competitionInfo);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("查询大赛所有信息:"+competitionInfos);
		return  competitionInfos;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-16下午19:06:34
	 *函数名：ContestSearchbyname
	 *功能：通过大赛名称查询大赛信息
	 *参数：CompetitionName
	 *返回值：CompetitionName，StartTime，EndTime,ContestState,ContestObject,ContestexamType
	 */	
	public List<CompetitionInfo> ContestSearchbyname(String CompetitionName,int page){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		int startPos=(page-1)*10;
		String sql = "Select b.CompetitionName, b.CompetitionEnrollStartTime,b.CompetitionEnrollEndTime,a.ContestState,a.ContestObject,a.ContestexamType,a.ContestSubject from competition b,contest a where a.CompetitionId=b.CompetitionId and b.CompetitionName like '%"+CompetitionName+"%' limit "+ startPos + "," +10;
		
		System.out.println("Dao ContestSearchbyname(String CompetitionName,int page)查询语句: " + sql);
		List<CompetitionInfo> competitionInfos = new ArrayList<CompetitionInfo>();
		
		CompetitionInfo competitionInfo = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				String competitionName = rs.getString("CompetitionName");
				String CompetitionEnrollStartTime = rs.getString("CompetitionEnrollStartTime");
				String CompetitionEnrollEndTime = rs.getString("CompetitionEnrollEndTime");
				int ContestState=rs.getInt(4);
				int ContestObject=rs.getInt(5);
				String ContestexamType=rs.getString(6);
				String ContestSubject = rs.getString(7);
				competitionInfo = new CompetitionInfo(competitionName, CompetitionEnrollStartTime, CompetitionEnrollEndTime,ContestState,ContestObject,ContestexamType, ContestSubject);
				competitionInfos.add(competitionInfo);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  competitionInfos;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-16下午19:37:34
	 *函数名：ContestSearchbytime
	 *功能：通过大赛开始结束时间查询大赛信息
	 *参数：StartTime，EndTime
	 *返回值：CompetitionName，StartTime，EndTime,ContestState,ContestObject
	 */	
	public List<CompetitionInfo> ContestSearchbytime(String StartTime,String EndTime,int page){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		int startPos=(page-1)*10;
		String sql = "Select b.CompetitionName,a.ContestState,a.ContestObject,a.ContestexamType from competition b,contest a where a.StartTime='"+StartTime+"' and a.EndTime='"+EndTime+"' limit"+startPos+","+10;
		
		List<CompetitionInfo> competitionInfos = new ArrayList<CompetitionInfo>();
		
		CompetitionInfo competitionInfo = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				String competitionName=rs.getString(1);
				int ContestState=rs.getInt(2);
				int ContestObject=rs.getInt(3);
				String ContestexamType=rs.getString(4);
				
				competitionInfo=new CompetitionInfo(competitionName, StartTime, EndTime,ContestState,ContestObject,ContestexamType);
				competitionInfos.add(competitionInfo);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  competitionInfos;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-16下午19:50:34
	 *函数名：ContestSearchSingelInfo
	 *功能：通过竞赛项目id查找单个大赛的信息
	 *参数：ContestId
	 *返回值：CompetitionInfo(CompetitionName,StartTime,EndTime,
				CompetitionSession,ContestState,CompetitionInfo,ParticularYear,
				ContestPropaganda,ContestPicUrl,ContestObject,ContestSubject,ContestMoney,ContestexamType);
	 */	
	public CompetitionInfo ContestSearchSingelInfo(int ContestId){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		CompetitionInfo competitionInfo=null;
		String sql="select b.CompetitionName,a.StartTime,a.EndTime,b.CompetitionSession,a.ContestState,b.CompetitionInfo," +
				"b.ParticularYear,b.CompetitionPropaganda,c.ContestPicUrl,a.ContestObject,a.ContestSubject," +
				"a.ContestMoney,a.ContestexamType from contest a,competition b,contestpicture c where a.CompetitionId=b.CompetitionId and b.CompetitionId=c.CompetitionId and a.ContestId='"+ContestId+"' ";
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try
		{
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				String CompetitionName = rs.getString(1);
				String StartTime = rs.getString(2);
				String EndTime = rs.getString(3);
				int CompetitionSession = rs.getInt(4);
				int ContestState = rs.getInt(5);
				String CompetitionInfo = rs.getString(6);
				int ParticularYear = rs.getInt(7);
				String ContestPropaganda = rs.getString(8);
				String ContestPicUrl = rs.getString(9);
				int ContestObject = rs.getInt(10);
				String ContestSubject = rs.getString(11);
				int ContestMoney = rs.getInt(12);
				String ContestexamType=rs.getString(13);
				
				competitionInfo=new CompetitionInfo(CompetitionName,StartTime,EndTime,
						CompetitionSession,ContestState,CompetitionInfo,ParticularYear,
						ContestPropaganda,ContestPicUrl,ContestObject,ContestSubject,ContestMoney,ContestexamType);
			}
			con.close();
			ps.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return competitionInfo;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-16下午20:46:34
	 *函数名：ContestSearchByOrganame
	 *功能：通过承办方查找大赛信息
	 *参数：OrganizationName
	 *返回值：CompetitionName，StartTime，EndTime,ContestState,ContestObject,ContestexamType
	 */	
	public List<CompetitionInfo> ContestSearchByOrganame(String OrganizationName,int page){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		int startPos=(page-1)*10;
		String sql = "Select b.CompetitionName,a.StartTime,a.EndTime,a.ContestState,a.ContestObject,a.ContestexamType from competition b,contest a,organization,enrollment where organization.OrganizationName like '%"+OrganizationName+"%' and enrollment.OrganizationId=organization.OrganizationId and enrollment.ContestId=a.ContestId and a.CompetitionId=b.CompetitionId limit "+startPos+","+10;
		
		List<CompetitionInfo> competitionInfos = new ArrayList<CompetitionInfo>();
		
		CompetitionInfo competitionInfo = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				String competitionName=rs.getString(1);
				String StartTime=rs.getString(2);
				String EndTime=rs.getString(3);
				int ContestState=rs.getInt(4);
				int ContestObject=rs.getInt(5);
				String ContestexamType=rs.getString(6);
				
				competitionInfo = new CompetitionInfo(competitionName, StartTime, EndTime,ContestState,ContestObject,ContestexamType);
				competitionInfos.add(competitionInfo);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  competitionInfos;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-23下午01:20:42
	 *函数名：ContestFuzzySearch
	 *功能：根据大赛的名字模糊查询大赛信息
	 *参数：@param page
	 *参数：@param condition
	 *参数：@return
	 *返回值：List<CompetitionInfo>
	 */
	public List<CompetitionInfo> ContestFuzzySearch(int page, String condition) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		int startPos=(page-1)*10;
		/*
		Select b.CompetitionName,a.StartTime,a.EndTime,a.ContestState,a.ContestObject,a.ContestexamType 
		from competition b,contest a
		where b.CompetitionName like "%语%" or a.ContestState like "%语文%" and a.CompetitionId=b.CompetitionId limit 0, 2
		*/
		String sql = "Select b.CompetitionName,a.StartTime,a.EndTime,a.ContestState,a.ContestObject,a.ContestexamType " +
					 "from competition b,contest a " +
				     "where b.CompetitionName like \"%" + condition + "%\" " +
				     "or a.ContestSubject like \"%" + condition + "%\" " +
				     "and a.CompetitionId=b.CompetitionId";
		
		System.out.println("大赛列表主页面SQL语句：" + sql);
		List<CompetitionInfo> competitionInfos = new ArrayList<CompetitionInfo>();
		CompetitionInfo competitionInfo = null;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				String CompetitionName=rs.getString(1);
				String StartTime=rs.getString(2);
				String EndTime=rs.getString(3);
				int ContestState=rs.getInt(4);
				int ContestObject=rs.getInt(5);
				String ContestexamType=rs.getString(6);
				
				competitionInfo=new CompetitionInfo(CompetitionName, StartTime, EndTime,ContestState,ContestObject,ContestexamType);
				competitionInfos.add(competitionInfo);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  competitionInfos;
	}
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-24下午01:14:02
	 *函数名：CreateCompetition
	 *功能：创建单个大赛信息
	 *参数：@param competition
	 *参数：@return
	 *返回值：int
	 */
	public int CreateCompetition(Competition competition) {
		
		int res = 0; // 最新插入的大赛的自增ID
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
//		String sql = "insert into competition(CompetitionName,CompetitionSession,CompetitionInfo," +
//		"ParticularYear) values('"+competition.getCompetitionName()+"',"+competition.getCompetitionSession()+"," +
//		"'"+competition.getCompetitionInfo()+"',"+competition.getParticularYear()+")";
		
		String sql = "INSERT INTO `competition`.`competition` " +
				"(`CompetitionName`, `CompetitionSession`, `CompetitionInfo`, " +
				"`ParticularYear`, `CommitteeName`, `CommitteePhone`, `CommitteeAddress`, " +
				"`CompetitionSponsor`, `CompetitionTimeDescribe`, `CompetitionPrize`, `CompetitionState`, `CompetitionPicture`,`CompetitionObjectDescribe`,`CompetitionEnrollStartTime`,`CompetitionEnrollEndTime`,`CompetitionBriefInfo`,`CompetitionPictureBig`,`CompetitionPriceDescribe`, `CompetitionPropaganda`) " +
				"VALUES ('" + 
				competition.getCompetitionName()+ "','" +
				competition.getCompetitionSession() +"','" +
				competition.getCompetitiondetails() + "','" +   //竞赛详情
				competition.getParticularYear() + "','" +
				competition.getCommitteeName() +"','" +
				competition.getCommitteePhone()+ "','" +
				competition.getCommitteeAddress() + "','" +
				competition.getCompetitionSponsor() +"','" +
				competition.getCompetitionTimeDescribe() + "','" +
				competition.getCompetitionPriceDescribe() + "','" +
				competition.getCompetitionState() + "','" +
				competition.getCompetitionPicture() + "','" +
				competition.getCompetitionObjectDescribe() + "','" +
				competition.getCompetitionEnrollStartTime() + "','" +
				competition.getCompetitionEnrollEndTime() + "','" +
				competition.getCompetitionInfo() + "','" +
				competition.getCompetitionPictureBig() + "','" +
				competition.getCompetitionPriceDescribe() + "','" +
				competition.getContestPropaganda()+ "'" + 
				")";
		
		System.out.println("创建大赛SQL语句：" + sql);
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		PreparedStatement ps1 = null;
		try {
			ps.execute();
			// 获取最新增加的大赛ID
			ps1 = (PreparedStatement)con.prepareStatement("SELECT LAST_INSERT_ID()");
			ResultSet resultSet = ps1.executeQuery();
			while(resultSet.next()){
				res = resultSet.getInt(1);
				System.out.println("最新插入的大赛ID: " + res);
			}
			con.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-24下午03:22:28
	 *函数名：CreateContest
	 *功能：创建单个大赛项目信息
	 *参数：@param contest
	 *参数：@return
	 *返回值：boolean
	 */
	public int CreateContest(Contest contest) {
		boolean flag = true;
		int res = 0; // 最新插入的竞赛的自增ID
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "insert into contest(ContestObject,ContestSubject,ContestMoney," +
		"CompetitionId, StartTime, EndTime, ContestexamType, ContestState) values('"+
		contest.getContestObject()+"',"+ "'" +
		contest.getContestSubject()+"'," +"'"+
		contest.getContestMoney()+"',"+"'"+
		contest.getCompetitionId()+"',"+"'"+
		contest.getStartTime()+"',"+"'"+
		contest.getEndTime()+"',"+"'"+
		contest.getContestexamType()+ "'," + "'" + 
		contest.getContestState() + "')";
		System.out.println("创建大赛里所有的竞赛SQL语句：" + sql);
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		PreparedStatement ps1 = null;
		
		try {
			ps.execute();
			ps1 = (PreparedStatement)con.prepareStatement("SELECT LAST_INSERT_ID()");
			
			ResultSet resultSet = ps1.executeQuery();
			while(resultSet.next()){
				res = resultSet.getInt(1);
				System.out.println("最新插入的竞赛ID: " + res);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			// flag = false;
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-23下午08:19:37
	 *函数名：CreateEnrollment
	 *功能：新建报名表
	 *参数：enrollment
	 *返回值：boolean
	 */
	public boolean CreateEnrollment(Enrollment enrollment) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "insert into enrollment(StudentName,StudentSex,StudentIDNumber,StudentSchool," +
				"StudentGrade,StudentContactsMan,StudentContactsPhon,UserAddress,StudentTeacher," +
				"StudentTeacherPhon,StudentPicture,CompetitionName,CompetitionSession,ContestObject," +
				"ContestSubject,ContestMoney,StartTime,EndTime,OrganizationName,enrollmentState," +
				"ContestId,OrganizationId,UserId,EnrollmentTime,ContestState,Studentscore) "
				+ "values('"
				+ enrollment.getStudentName()+ "','"+ enrollment.getStudentSex()
				+ "','"
				+ enrollment.getStudentIDNumber()+ "','"+ enrollment.getStudentSchool()
				+ "','"
				+ enrollment.getStudentGrade()+ "','"+ enrollment.getStudentContactsMan()
				+ "','"
				+ enrollment.getStudentContactsPhon()+ "','"+ enrollment.getUserAddress()
				+ "','"
				+ enrollment.getStudentTeacher()+ "','"+ enrollment.getStudentTeacherPhon()
				+ "','"
				+ enrollment.getStudentPicture()+ "','"+ enrollment.getCompetitionName()
				+ "','"
				+ enrollment.getCompetitionSession()+ "','"+ enrollment.getContestObject()
				+ "','"
				+ enrollment.getContestSubject()+ "','"+ enrollment.getContestMoney()
				+ "','"
				+ enrollment.getStartTime()
				+ "','"
				+ enrollment.getEndTime()+ "','"+ enrollment.getOrganizationName()
				+ "','"
				+ enrollment.getEnrollmentState()+ "','"+ enrollment.getContestId()
				+ "','"
				+ enrollment.getOrganizationId()+ "','"+ enrollment.getUserId()
				+ "','"
				+ enrollment.getEnrollmentTime()+ "','"+ enrollment.getContestState()
				+ "','"
				+ enrollment.getStudentscore()+"')";
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		
		boolean result = true;
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-28下午06:57:31
	 *函数名：QueryAllCompetitionUser
	 *功能：获取参赛人员列表
	 *参数：
	 *返回值：List<Joiner>
	 */
	public List<Joiner> QueryAllCompetitionUser(int page){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		int startPos=(page-1)*10;
		String sql = "Select StudentName,CompetitionName,ContestSubject,enrollmentState," +
				"ContestObject,StudentContactsPhon from enrollment limit "+startPos+","+10;
		
		List<Joiner> joiners = new ArrayList<Joiner>();
		
		Joiner joiner = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				
				joiner=new Joiner(rs);
				joiners.add(joiner);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  joiners;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-28下午08:02:04
	 *函数名：QueryStuedntByComnaSub
	 *功能：通过大赛名称和大赛科目查找参赛人员
	 *参数：CompetitionName，ContestSubject
	 *返回值：List<Joiner>
	 */
	public List<Joiner> QueryStuedntByComnaSub(String CompetitionName,String ContestSubject,int page){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		int startPos=(page-1)*10;
		String sql = "Select StudentName,CompetitionName,ContestSubject,enrollmentState,ContestObject,StudentContactsPhon from enrollment where CompetitionName='"+CompetitionName+"' and ContestSubject='"+ContestSubject+"' limit "+startPos+","+10;
		
		List<Joiner> joiners = new ArrayList<Joiner>();
		
		Joiner joiner = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql); 
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				
				joiner=new Joiner(rs);
				joiners.add(joiner);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  joiners;
	}
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-28下午01:33:33
	 *函数名：GetOrganizations
	 *功能：获取所有的承办方信息
	 *参数：@return
	 *返回值：List<Organization>
	 */
	public List<Organization> GetOrganizations() {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "select * from organization";
		
		System.out.println("查询承办方信息的SQL语句：" + sql);
		
		List<Organization> organizations = new ArrayList<Organization>();
		Organization organization = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				organization = new Organization(rs);
				organizations.add(organization);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return organizations;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-28下午09:35:35
	 *函数名：QueryALLCompetition
	 *功能：查找所有的大赛
	 *参数：
	 *返回值：CompetitionName
	 */
	public List<Competition> QueryALLCompetition(){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "Select CompetitionName from competition";
		
		List<Competition> Competitions = new ArrayList<Competition>();
		
		Competition competition = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				String competitionName=rs.getString(1);
				
				competition=new Competition(competitionName);
				Competitions.add(competition);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  Competitions;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-28下午09:50:28
	 *函数名：QueryAllSubByCompetitionName
	 *功能：根据大赛名查找大赛下的大赛科目
	 *参数：
	 *返回值：ContestSubject
	 */
	public List<Contest> QueryAllSubByCompetitionName(String CompetitionName){
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "select DISTINCT ContestSubject from contest,competition where contest.CompetitionId=competition.CompetitionId and competition.CompetitionName='"+CompetitionName+"'";
		List<Contest> Contests = new ArrayList<Contest>();
		Contest contest = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				String contestSubject=rs.getString(1);
				
				contest=new Contest(contestSubject);
				Contests.add(contest);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  Contests;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-28下午10:06:01
	 *函数名：CreateContestOrganization
	 *功能：创建某个竞赛的承办方信息
	 *参数：@param ContestId
	 *参数：@param OrganizationId
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean CreateContestOrganization(int ContestId, int OrganizationId) {
		boolean flag = true;
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "INSERT INTO `competition`.`contestorganization` " +
				"(`ContestId`, `OrganizationId`) " +
				"VALUES ('" + ContestId +"','"+ OrganizationId + "')";
		
		System.out.println("创建竞赛的承办方的SQL语句：" + sql);
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-29上午08:04:28
	 *函数名：GetStudentScore
	 *功能：获取所有学生的成绩
	 *参数：@return
	 *返回值：List<StudentScoreInfo>
	 */
	public List<StudentScoreInfo> GetStudentScore(String name) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "select e.StudentName,e.StudentTicket,e.Studentscore,c2.CompetitionName,c2.CompetitionSession,c1.ContestSubject, c1.ContestObject "
					  + "from Contest as c1,Competition as c2,enrollment as e " 
					  + "where e.ContestId = c1.ContestId and c1.CompetitionId = c2.CompetitionId "
					  + "and e.StudentName like '%" + name + "%'";
		List<StudentScoreInfo> infos = new ArrayList<StudentScoreInfo>();
		StudentScoreInfo info = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				// String contestSubject = rs.getString(1);
				info = new StudentScoreInfo(rs);
				infos.add(info);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  infos;
	}
	public List<Joiner> GetJoinerInfo(String name) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "select e.StudentName,c2.CompetitionName,c1.ContestSubject,e.enrollmentState, e.ContestObject,e.StudentContactsPhon "
					  + "from Contest as c1,Competition as c2,enrollment as e " 
					  + "where e.ContestId = c1.ContestId and c1.CompetitionId = c2.CompetitionId "
					  + "and e.StudentName like '%" + name + "%'";
		List<Joiner> infos = new ArrayList<Joiner>();
		Joiner info = null;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				// String contestSubject = rs.getString(1);
				info = new Joiner(rs);
				infos.add(info);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  infos;
	}
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-29下午02:00:58
	 *函数名：GetStudentScore
	 *功能：获取某个大赛某个科目下面所有学生的成绩
	 *参数：@param comname
	 *参数：@param subname
	 *参数：@return
	 *返回值：List<StudentScoreInfo>
	 */
	public List<StudentScoreInfo> GetStudentScore(String comname, String subname) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "select e.StudentName,e.StudentTicket,e.Studentscore,c2.CompetitionName,c2.CompetitionSession,c1.ContestSubject, c1.ContestObject "
					  + "from Contest as c1,Competition as c2,enrollment as e " 
					  + "where e.ContestId = c1.ContestId and c1.CompetitionId = c2.CompetitionId "
					  + "and c2.CompetitionName like '%" + comname + "%' "
					  + "and c1.ContestSubject  like '%" + subname + "%'";
		List<StudentScoreInfo> infos = new ArrayList<StudentScoreInfo>();
		StudentScoreInfo info = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				// String contestSubject = rs.getString(1);
				info = new StudentScoreInfo(rs);
				infos.add(info);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  infos;
	}
	
	
	/**
	 * 
	 *作者：zhengchengdong
	 *时间：2016-2-26下午17:57:58
	 *函数名：DealState
	 *功能：
	 *参数：@param comname
	 *参数：@param subname
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean DealState(String CompetitionName,int State) {
			JdbcUnit jdbcUnit = JdbcUnit.getInstance();
			Connection con = jdbcUnit.createConn(); // 连接数据库
			boolean result=true;
			String sql="update competition set CompetitionState= '"+State+"' where CompetitionName='"+CompetitionName+"' ";
			int i=0;
			try{
				PreparedStatement ps = jdbcUnit.prepare(con, sql);
				ps.execute();
				i=ps.executeUpdate();
				if(i>0)
				{
					System.out.println("成功");
				}
				con.close();
				ps.close();
			}catch(SQLException e){
				result=false;
				e.printStackTrace();
				System.out.println("失败");
			}
			if(i>0 && result==true)
			{
				return true;
			}
			else
			{
				return false;
			}
	}
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月26日21:33:24
	 *函数名：AddCompetitionName
	 *功能：添加大赛名和简称
	 *参数：@param competition_name
	 *参数：@param competition_simple_name
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean AddCompetitionName(String competition_name,String competition_simple_name) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		boolean flag=true;
		String sql="insert into competitionbasicdata (CompetitionBasicName, CompetitionBasicNickName) values ('"+competition_name+"','"+competition_simple_name+"')";
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月27日12:44:54
	 *函数名：AddCompetitionProject
	 *功能：添加大赛科目
	 *参数：@param competition_project
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean AddCompetitionProject(String competition_project) {
			JdbcUnit jdbcUnit = JdbcUnit.getInstance();
			Connection con = jdbcUnit.createConn(); // 连接数据库
			boolean flag=true;
			String sql="insert into subjectbasicdata (SubjectName) values ('"+competition_project+"')";
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			try {
				ps.execute();
				con.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				flag = false;
			}
			return flag;
	}
	
	
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月27日12:55:07
	 *函数名：AddCompetitionObject
	 *功能：添加大赛对象
	 *参数：@param competition_object
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean AddCompetitionObject(int competition_object) {
			JdbcUnit jdbcUnit = JdbcUnit.getInstance();
			Connection con = jdbcUnit.createConn(); // 连接数据库
			boolean flag=true;
			String sql="insert into gradebasicdata (GreadState) values ('"+competition_object+"')";
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			try {
				ps.execute();
				con.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				flag = false;
			}
			return flag;
	}
	
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年3月1日21:41:13
	 *函数名：AddOrganizationInfo
	 *功能：添加承办方信息
	 *参数：@param organization_name
	 *参数：@param organization_address
	 *参数：@param organization_station
	 *参数：@param organization_tel
	 *参数：@param organization_contacts
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean AddOrganizationInfo(String organization_name,String organization_address,int organization_station,
			String organization_tel , String organization_contacts) 
	{
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		boolean flag=true;
		String sql="insert into organization (OrganizationName, OrganizationAddress,OrganizationStation,OrganizationTel,OrganizationContacts) values ('"+organization_name+"','"+organization_address+"','"+organization_station+"','"+organization_tel+"','"+organization_contacts+"')";
		System.out.println("承办方信息:"+sql);
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	/**
	 * 
	 *作者：zhengchengdong
	 *时间：2016-2-27上午10:44:58
	 *函数名：Delete
	 *功能：赛事列表删除功能
	 *参数：@param comname
	 *参数：@param subname
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean Delete(String contestid) {
			JdbcUnit jdbcUnit = JdbcUnit.getInstance();
			Connection con = jdbcUnit.createConn(); // 连接数据库
			boolean result=true;
			String sql="delete from contest where ContestId='"+contestid+"' ";
			int i=0;
			try{
				PreparedStatement ps = jdbcUnit.prepare(con, sql);
				ps.execute();
				i = ps.executeUpdate();
				if (i > 0)
				{ 
					System.out.println("成功");
				}
				con.close();
				ps.close();
			}catch(SQLException e){
				result=false;
				e.printStackTrace();
				System.out.println("失败");
			}
			if(i>0 && result==true)
			{
				return true;
			}
			else
			{
				return false;
			}
	}
	/**
	 * 
	 *作者：zhengchengdong
	 *时间：2016-2-27下午10:44:58
	 *函数名：ContenderList
	 *功能：参赛人员列表显示
	 *参数：@param comname
	 *参数：@param subname
	 *参数：@return
	 *返回值：List<Enrollment>
	 */
	public List<Enrollment> ContenderList(int page) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		int startPos = (page - 1) * 10;
		String sql = "Select StudentName,StudentContactsPhon,CompetitionName,ContestSubject,enrollmentState,OrganizationId,UserId,enrollmentid,studentscore from enrollment limit "+ startPos + "," +10;
		
		// System.out.println("ContestSearchInfo 大赛首页数据列表查询语句: " + sql);
		List<Enrollment> enrollmentinfos = new ArrayList<Enrollment>();
		
		Enrollment enrollmentinfo = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				String StudentName = rs.getString(1);
				String StudentContactsPhon = rs.getString(2);
				String CompetitionName = rs.getString(3);
				String ContestSubject = rs.getString(4);
				int enrollmentState = rs.getInt(5);
				int OrganizationId = rs.getInt(6);
				int UserId = rs.getInt(7);
				int enrollmentid = rs.getInt(8);
				int studentscore = rs.getInt(9);
				
				enrollmentinfo = new Enrollment(StudentName, StudentContactsPhon, CompetitionName, ContestSubject, enrollmentState, OrganizationId, UserId, enrollmentid,studentscore);
//				System.out.println(enrollmentinfo);
				enrollmentinfos.add(enrollmentinfo);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println(enrollmentinfos);
		return  enrollmentinfos;
	}
	
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月27日14:08:05
	 *函数名：GetCompetitionName
	 *功能：获得大赛名和简称
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：List<CompetitionBasicData>
	 */
	public List<CompetitionBasicData> GetCompetitionName() {
			JdbcUnit jdbcUnit = JdbcUnit.getInstance();
			Connection con = jdbcUnit.createConn(); // 连接数据库

			String sql="select * from competitionbasicdata";
			List<CompetitionBasicData> competitionbasicdatas = new ArrayList<CompetitionBasicData>();
			CompetitionBasicData competitionbasicdata = null;
			
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			try {
				ResultSet rs = ps.executeQuery(sql);
				while (rs.next()) {

					competitionbasicdata = new CompetitionBasicData(rs);
					competitionbasicdatas.add(competitionbasicdata);
				}
				con.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return  competitionbasicdatas;
	}
	/**
	 * 
	 *作者：zhengchengdong
	 *时间：2016-2-27下午10:44:58
	 *函数名：enterscore
	 *功能：录入成绩
	 *参数：@param comname
	 *参数：@param subname
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean enterscore(String score,String id) {
			JdbcUnit jdbcUnit = JdbcUnit.getInstance();
			Connection con = jdbcUnit.createConn(); // 连接数据库
			boolean result=true;
			String sql="update enrollment set studentscore= '"+score+"' where enrollmentid='"+id+"' ";
			int i=0;
			try{
				PreparedStatement ps = jdbcUnit.prepare(con, sql);
				ps.execute();
				i=ps.executeUpdate();
				if(i>0)
				{
					System.out.println("成功");
				}
				con.close();
				ps.close();
			}catch(SQLException e){
				result=false;
				e.printStackTrace();
				System.out.println("失败");
			}
			if(i>0 && result==true)
			{
				return true;
			}
			else
			{
				return false;
			}
	}	
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月27日15:10:13
	 *函数名：GetCompetitionProject
	 *功能：获得竞赛科目
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：List<SubjectBasicData>
	 */
	public List<SubjectBasicData> GetCompetitionProject() {
			JdbcUnit jdbcUnit = JdbcUnit.getInstance();
			Connection con = jdbcUnit.createConn(); // 连接数据库

			String sql="select * from subjectbasicdata";
			List<SubjectBasicData> subjectbasicdatas = new ArrayList<SubjectBasicData>();
			SubjectBasicData subjectbasicdata = null;
			
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			try {
				ResultSet rs = ps.executeQuery(sql);
				while (rs.next()) {

					subjectbasicdata = new SubjectBasicData(rs);
					subjectbasicdatas.add(subjectbasicdata);
				}
				con.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return  subjectbasicdatas;
	}
	
	/**
	 * 
	 *作者：zhengchengdong
	 *时间：2016-2-27下午6:36:58
	 *函数名：enterscore
	 *功能：添加参赛人员
	 *参数：@param comname
	 *参数：@param subname
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean  AddContender(Enrollment contender) {
			JdbcUnit jdbcUnit = JdbcUnit.getInstance();
			Connection con = jdbcUnit.createConn(); // 连接数据库
			boolean result=true;
			String sql="insert into enrollment (StudentName,StudentSex,StudentIDNumber,StudentSchool,StudentGrade,StudentContactsMan,StudentContactsPhon,UserAddress,StudentTeacher,StudentTeacherPhon,StudentPicture,CompetitionName,CompetitionSession,ContestObject,ContestSubject,ContestMoney,StartTime,EndTime,OrganizationName,enrollmentState,StudentTicket,Studentscore,StudentRank) values ('"+contender.getStudentName()+"','"+contender.getStudentSex()+"','"+contender.getStudentIDNumber()+"','"+contender.getStudentSchool()+"','"+contender.getStudentGrade()+"','"+contender.getStudentContactsMan()+"','"+contender.getStudentContactsPhon()+"','"+contender.getUserAddress()+"','"+contender.getStudentTeacher()+"','"+contender.getStudentTeacherPhon()+"','"+contender.getStudentPicture()+"','"+contender.getCompetitionName()+"','"+contender.getCompetitionSession()+"','"+contender.getContestObject()+"','"+contender.getContestSubject()+"','"+contender.getContestMoney()+"','"+contender.getStartTime()+"','"+contender.getEndTime()+"','"+contender.getOrganizationName()+"','"+contender.getEnrollmentState()+"','"+contender.getStudentTicket()+"','"+contender.getStudentscore()+"','"+contender.getStudentRank()+"')";
			System.out.println(sql);
			int i=0;
			try{
				PreparedStatement ps = jdbcUnit.prepare(con, sql);
				ps.execute();
				i=ps.executeUpdate();
				if(i>0)
				{
					System.out.println("成功");
				}
				con.close();
				ps.close();
			}catch(SQLException e){
				result=false;
				e.printStackTrace();
				System.out.println("失败");
			}
			if(i>0 && result==true)
			{
				return true;
			}
			else
			{
				return false;
			}
	}
	
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月27日15:16:10
	 *函数名：GetCompetitionObject
	 *功能：获得竞赛对象
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：List<GradeBasicData>
	 */
	public List<GradeBasicData> GetCompetitionObject() {
			JdbcUnit jdbcUnit = JdbcUnit.getInstance();
			Connection con = jdbcUnit.createConn(); // 连接数据库

			String sql="select * from gradebasicdata";
			List<GradeBasicData> gradebasicdatas = new ArrayList<GradeBasicData>();
			GradeBasicData gradebasicdata = null;
			
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			try {
				ResultSet rs = ps.executeQuery(sql);
				while (rs.next()) {

					gradebasicdata = new GradeBasicData(rs);
					gradebasicdatas.add(gradebasicdata);
				}
				con.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return  gradebasicdatas;
	}

//	public boolean CreateANews() {
//		
//	}
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016年2月27日15:16:10
	 *函数名：CreateANews
	 *功能：创建新闻
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：int 新闻自增ID
	 */
	public int CreateANews(String NewsTitle, String NewsContent,String NewsExtralInfo, String NewsPutTime, int NewsState, int NewsTop, String NewsSource,int NewsSaveState) {
		int res = 0; // 最新插入的竞赛的自增ID
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		// INSERT INTO `competition`.`news` (`NewsId`, `NewsTitle`, `NewsContent`, `NewsPicId`, `NewsExtralInfo`, `NewsPutTime`, `NewsState`, `NewsTop`, `NewsSource`) 
		// VALUES ('1', '今日报名人数已破5000', NULL, '1', NULL, '2016/1/1', '2', '1', '宁波牛蛙');
		String sql="INSERT INTO `competition`.`news` (`NewsTitle`, `NewsContent`, `NewsExtralInfo`, `NewsPutTime`, `NewsState`, `NewsTop`, `NewsSource`, `NewsSaveState`) "
			+ " VALUES ('" + NewsTitle + "','" 
			+ NewsContent + "','"
			+ NewsExtralInfo + "','"
			+ NewsPutTime + "','"
			+ NewsState + "','"
			+ NewsTop + "','"
			+ NewsSource + "','"
			+ NewsSaveState + "')";
		
		System.out.println("创建新闻SQL语句：" + sql);
	
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		PreparedStatement ps1 = null;
		try {
			ps.execute();
			// ResultSet rs = ps.executeQuery(sql);
			ps1 = (PreparedStatement)con.prepareStatement("SELECT LAST_INSERT_ID()");
			
			ResultSet resultSet = ps1.executeQuery();
			while(resultSet.next()){
				res = resultSet.getInt(1);
				System.out.println("最新插入的竞赛ID: " + res);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  res;
	}
	public boolean CreateANewsPicture(String NewsPicUrl, int NewsId) {
		boolean flag = true;
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		//String path=NewsPicUrl.replaceAll("\\\\","\\\\\\\\");
		// INSERT INTO `competition`.`newspicture` (`NewsPicId`, `NewsPicUrl`, `NewsId`) VALUES ('1', 'Web/image/news1.jpg', '1');
		String sql="INSERT INTO `competition`.`newspicture` (`NewsPicUrl`, `NewsId`) "
			+" VALUES ('" + NewsPicUrl + "','"
			+ NewsId + "')";
		
		System.out.println("创建新闻图片SQL语句：" + sql);
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			
			ps.execute();
			con.close();
			ps.close();
			
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return  flag;
	}

	
	/**
	 * 
	 *作者：ZhengChengDong
	 *时间：2016年2月28日16:08:10
	 *函数名：SearchPaper
	 *功能：搜索试卷
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：List<TestPaper>
	 */
	public List<TestPaper> SearchPaper(String ContestSubject,String CompetitionName,String StudentGrade,int page){
		
		System.out.println("试卷搜索的科目关键字：" + ContestSubject);
		System.out.println("试卷搜索的试卷名字关键字：" + CompetitionName);
		System.out.println("试卷搜索的年级组关键字：" + StudentGrade);
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		int startPos = (page - 1) * 10;
		String sql = "select TestPaperId,TestPaperName,TestPaperTime,TestSubject, TestDifficulty from testpaper where 1=1 ";
		
		if(!"".equals(ContestSubject)){
			sql=sql+" and TestYear='"+ContestSubject+"'";
		}
		
		if(!"".equals(CompetitionName)){
			sql=sql+" and TestPaperName like'%"+CompetitionName+"%'";
		}
		
		if(!"".equals(StudentGrade)){
			sql=sql+" and TestState= '"+StudentGrade+"' order by TestPaperTime DESC";
		}
		System.out.println("我是sql语句----------------："+sql);
		
		sql=sql+" limit "+ startPos + "," +10;
		
		System.out.print("我是sql语句："+sql);
		
		List<TestPaper> testpapers = new ArrayList<TestPaper>();
		
		TestPaper testpaper = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()){
				int TestPaperId = rs.getInt(1);
				String TestPaperName = rs.getString(2);
				String TestPaperTime = rs.getString(3);
				String TestSubject = rs.getString(4);
				int TestDifficulty = rs.getInt(5);
				testpaper = new TestPaper(TestPaperId, TestPaperName, TestPaperTime, TestSubject,TestDifficulty);
				testpapers.add(testpaper);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(testpapers);
		return  testpapers;
	}
	
	/**
	 * 
	 *作者：ZhengChengDong
	 *时间：2016年2月28日16:08:10
	 *函数名：SearchPaper
	 *功能：搜索试卷
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：List<TestPaper>
	 */
	public int WeekNumber(String StarTime, String EndTime) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "SELECT count(*) from enrollment where EnrollmentTime between '"+StarTime+"' and '"+EndTime+"' ";
		
		System.out.println("ContestSearchInfo 大赛首页数据列表查询语句: " + sql);
		int number=0;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				number = rs.getInt(1);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  number;
	}
	
	
	
	
	/**
	 * 
	 *作者：Linguoyi
	 *时间：2016-2-58
	 *函数名：CreateAContestTes
	 *功能：创建试卷
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：int 试卷自增ID
	 */
	public int CreateAContestTes(String TestPaperName, String TestPaperTime, int TestPaperState, String TestSubject, int TestDifficulty, String TestKnowledgepoint, int TestYear, String TestState, int ContestId) {
		 int res = 0;
		 JdbcUnit jdbcUnit = JdbcUnit.getInstance();
			Connection con = jdbcUnit.createConn(); // 连接数据库
			// INSERT INTO `competition`.`testpaper` (`TestPaperId`, `TestPaperName`, `TestPaperTime`, `TestPaperState`, `TestSubject`, `TestDifficulty`, `TestKnowledgepoint`, `TestYear`, `TestState`, `ContestId`) VALUES ('1', '2011山东中考专项练习', '2011-2-22 12:22:22', '1', '1', '1', '1', '1', '1', '1');
			String sql="INSERT INTO `competition`.`testpaper` (`TestPaperName`, `TestPaperTime`, `TestPaperState`, `TestSubject`, `TestDifficulty`, `TestKnowledgepoint`, `TestYear`, `TestState`, `ContestId`) "
				+" VALUES ('" + TestPaperName + "','"
				+ TestPaperTime + "','"
				+ TestPaperState + "','"
				+ TestSubject + "','"
				+ TestDifficulty + "','"
				+ TestKnowledgepoint + "','"
				+ TestYear + "','"
				+ TestState + "','"
				+ ContestId + "')";
			
			System.out.println("创建竞赛试卷SQL语句：" + sql);
			
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			PreparedStatement ps1 = null;
			try {
				ps.execute();
				
				ps1 = (PreparedStatement)con.prepareStatement("SELECT LAST_INSERT_ID()");
				ResultSet resultSet = ps1.executeQuery();
				while(resultSet.next()){
					res = resultSet.getInt(1);
					System.out.println("最新插入的竞赛ID: " + res);
				}
				
				con.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return res;
	}
	/**
	 * 
	 *作者：Linguoyi
	 *时间：2016-2-28
	 *函数名：Createtestpicture
	 *功能：保存试卷图片
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean Createtestpicture(int TestPaperId, String TestPapeTitleUrl,int TestPaperNumber,String TestPaperAnswerUrl) {
		boolean flag=true;
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
			Connection con = jdbcUnit.createConn(); // 连接数据库
		//	String TestUrl = TestPapeTitleUrl.replaceAll("\\\\","\\\\\\\\");
		//	String TestAnswerUrl = TestPaperAnswerUrl.replaceAll("\\\\","\\\\\\\\");
			String sql="INSERT INTO `competition`.`testpaperpicture` ( `TestPaperNumber`, `TestPapeTitleUrl`, `TestPaperAnswerUrl`, `TestPaperId`)"
				+" VALUES ('" + TestPaperNumber + "','"
				+ TestPapeTitleUrl + "','"
				+ TestPaperAnswerUrl + "','"
				+ TestPaperId + "')";
			
			System.out.println("创建竞赛试卷图片SQL语句：" + sql);
			
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			try {
				ps.execute();			
				con.close();
				ps.close();
			} catch (SQLException e) {
				flag=false;
				e.printStackTrace();
			}
		 return flag;
	}
	
	/**
	 * 
	 *作者：ZhengChengDong
	 *时间：2016年3月1日20:52:10
	 *函数名：InportScore
	 *功能：大赛成绩导入
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：List<TestPaper>
	 */
	public boolean InportScore(String Studentscore, String StudentName,String StudentIDNumber,String ContestSubject,String CompetitionName) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update enrollment set Studentscore= '"+Studentscore+"' where StudentName = '"+StudentName+"' and StudentIDNumber = '"+StudentIDNumber+"' and ContestId = (select ContestId from contest where ContestSubject = '"+ContestSubject+"' and CompetitionId = = (select CompetitionId from competition where CompetitionName = '"+CompetitionName+"')";
		boolean result = false;
		System.out.println("InportScore 大赛首页数据列表查询语句: " + sql);
		int i=0;
		try{
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			ps.execute();
			i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("成功");
			}
			con.close();
			ps.close();
		}catch(SQLException e){
			result=false;
			e.printStackTrace();
			System.out.println("失败");
		}
		if(i>0 && result==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * 
	 *作者：Linguoyi
	 *时间：2016-3-1
	 *函数名：CreateCompetitionPicture
	 *功能：保存竞赛图片
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean CreateCompetitionPicture(String competitionpic) {
		boolean flag=true;
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
			Connection con = jdbcUnit.createConn(); // 连接数据库
		
			//String path=competitionpic.replaceAll("\\\\","\\\\\\\\");
			//	System.out.println("竞赛图片：" + path+competitionpic);
				
			String sql="INSERT INTO `competition`.`websitebasicdata` (`mainPicture`)"+
			" VALUES ('"+competitionpic+"')";

			//System.out.println("创建竞赛试卷图片SQL语句：" + sql);
			
			PreparedStatement ps = jdbcUnit.prepare(con, sql);
			try {
				ps.execute();			
				con.close();
				ps.close();
			} catch (SQLException e) {
				flag=false;
				e.printStackTrace();
			}
		 return flag;
	}
	/**
	 * 
	 *作者：Linguoyi
	 *时间：2016-3-1
	 *函数名：getTestYearServlet
	 *功能：获取竞赛年份
	 *参数：无
	 *参数：@return 竞赛年份
	 *返回值：testyear
	 */
	public List<TestYear> getTestYearServlet() {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql="select YearData from yearbasicdata";

		List<TestYear>  testyearlist = new ArrayList<TestYear>();
		TestYear testyear = null;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				testyear = new TestYear(rs);
				testyearlist.add(testyear);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//System.out.println("年份"+testyearlist);
	 return testyearlist;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-3-3下午02:17:14
	 *函数名：IsExitUser
	 *功能：判断当前数据库中是否存在当前请求的手机号码
	 *参数：
	 *返回值：String
	 */
	public static String IsExitUser(String PhoneNumber) {
		String res = null;
		
		if (PhoneNumber == null) {
			return null;
		}
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "select userphone from user where userphone="+PhoneNumber;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				res = rs.getString(1);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (res == null) {
			System.out.println("此手机号码在数据库中为空" + res);
		}
		return res;
	}
	
	public boolean AddWebIndexPic(String Filename) {
		boolean flag = true;
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		// String sql = "INSERT INTO `competition`.`websitebasicdata` (`mainPicture`) VALUES ('" + Filename + "')";

		String sql = "UPDATE websitebasicdata SET mainPicture='" + Filename + "' WHERE WebsiteBasicDataId=1";
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();			
			con.close();
			ps.close();		
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	JdbcUnit jdbcUnit = JdbcUnit.getInstance();
//	Connection con = jdbcUnit.createConn(); // 连接数据库
	
	//数据库连接池
	ConnectionPool pool = ConnectionPool.getIntense();
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-3-28下午11:11:13
	 *函数名：Add
	 *功能：TODO: 增加一个承办方信息
	 *参数：
	 *返回值：boolean
	 */
	public boolean Add (Organization organization) {
		boolean flag = true;
		
		String insertSql = organization.getInsertSql();
		
		try {
			Connection con = pool.getConnection();
			PreparedStatement ps = con.prepareStatement(insertSql);
			
			ps.execute();
			//返回连接，关闭ps
			pool.returnConnection(con, ps);
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		} 
		
		return flag;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-3-28下午11:27:10
	 *函数名：Query
	 *功能：TODO: 查询所有的承办方信息
	 *参数：
	 *返回值：boolean
	 */
	public OrganizationSet QuerySet () {
		OrganizationSet organizationSet = null;
		ResultSet res = null;
		
		String querySql = new Organization().getQuerySql();
		
		try {
			Connection con = pool.getConnection();
			PreparedStatement ps = con.prepareStatement(querySql);
			
			res = ps.executeQuery(querySql);
			organizationSet = new OrganizationSet(res);
			
			pool.returnConnection(con, ps, res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return organizationSet;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-3-29上午11:13:04
	 *函数名：getLastSquence
	 *功能：TODO
	 *参数：
	 *返回值：int
	 */
	public JSONObject getLastSquence (int contestCount) {
		String querySql = "Select * from squence";
		ResultSet res = null;
		int contestCurrentId = 0;
		int competitionCurrentId = 0;
		
		try {
			Connection con = pool.getConnection();
			PreparedStatement ps = con.prepareStatement(querySql);
			
			res = ps.executeQuery();
			
			while (res.next()) {
				contestCurrentId = Integer.parseInt(res.getString("contest_last_id"));
				System.out.println("起始竞赛ID：" + contestCurrentId);
				competitionCurrentId = Integer.parseInt(res.getString("competition_last_id"));
				System.out.println("起始大赛ID：" + competitionCurrentId);
			}
			
			pool.returnConnection(con, ps, res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("contestCurrentId", contestCurrentId);
		jsonObject.put("competitionCurrentId",competitionCurrentId);
		jsonObject.put("contestCount", contestCount);
		
		System.out.println(jsonObject);
		return jsonObject;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-3-29上午10:34:08
	 *函数名：upDateSquence
	 *功能：更新序列表
	 *参数：
	 *返回值：JSONObject
	 */
	public void upDateSquence (JSONObject jsonObject) {
		StringBuilder builder = new StringBuilder();
		// int competitionId = "";
		int contestCount = jsonObject.getInt("contestCount");
		int contestLastId = jsonObject.getInt("contestCurrentId") + contestCount;
		int competitionLastId = jsonObject.getInt("competitionCurrentId") + 1;
		
		builder.append("UPDATE squence SET ");
		builder.append("contest_last_id = ");
		builder.append("'" + contestLastId + "',");
		builder.append("competition_last_id = ");
		builder.append("'" + competitionLastId + "' ");
		builder.append("Where id = '1'");
		String updateSql = builder.toString();
		
		try {
			Connection con = pool.getConnection();
			PreparedStatement ps = con.prepareStatement(updateSql);
			
			ps.execute();
			
			pool.returnConnection(con, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-3-29上午12:08:33
	 *函数名：Add
	 *功能：添加一个大赛
	 *参数：TODO: 添加大赛待解决
	 *返回值：boolean
	 */
	public boolean Add (DetailedCompetition competition) {
		boolean flag = true;
		Savepoint sp = null;
		Connection con = null;
		
		int contestCount = competition.getDetailContestSetSize();// 0. 拿到竞赛数目
		
		JSONObject ids= getLastSquence (contestCount);// 1. 拿到需要插入的大赛ID和竞赛ID组（更新序列表）
		
		competition.initIds(ids);// 2. 设置需要插入的大赛ID和竞赛ID
		
		String competitionInsertSql = competition.getInsertSql(); // 3. 执行语句
		
		System.out.println("Dao.Add函数Sql语句---" + competitionInsertSql);
		try {
			
			con = pool.getConnection();
			con.setAutoCommit(false);//通知数据库开启事务(start transaction)
//			sp = con.setSavepoint();
//			PreparedStatement ps = con.prepareStatement(competitionInsertSql);
//			ps.addBatch(competitionInsertSql);  
//			ps.execute();
			 
			CallableStatement cstmt = con.prepareCall("{call doExecute(?)}");
			cstmt.setString(1, competitionInsertSql); // 存储过程传参
			System.out.println("执行成功！！！");
			ResultSet resultSet = cstmt.executeQuery();
			
//			con.commit();
			pool.returnConnection(con, cstmt, resultSet);
		} catch (SQLException e) {
			flag = false;
			
//			try {
//				con.rollback(sp);//回滚到设置的事务回滚点
//				con.commit();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-3-31下午08:29:50
	 *函数名：Query
	 *功能：查询首页大赛列表
	 *参数：
	 *返回值：BriefCompetitionSet
	 */
	public BriefCompetitionSet getSet(String condition) {
		ResultSet res = null;
		BriefCompetitionSet briefCompetitionSet = null;
		
		try {
			Connection con = pool.getConnection();

//			CallableStatement cstmt = con.prepareCall( "{call getCompetitionObj()}");
			CallableStatement cstmt = con.prepareCall("{call getCompetitionList()}");
			ResultSet resultSet = cstmt.executeQuery();
			briefCompetitionSet = new BriefCompetitionSet(resultSet, MyOpecode.competition.bCmConOfCmList);
			
			pool.returnConnection(con, cstmt, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return briefCompetitionSet; 
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-4-21上午10:58:06
	 *函数名：getSet
	 *功能：根据年级段来查询大赛列表
	 *参数：
	 *		grade : 1 -- 小学组
	 *		grade : 2 -- 初中组
	 *		grade : 3 -- 高中组
	 *
	 *返回值：BriefCompetitionSet
	 */
	public BriefCompetitionSet getSet(int grade) {
		ResultSet res = null;
		BriefCompetitionSet briefCompetitionSet = null;
		
		try {
			Connection con = pool.getConnection();

//			CallableStatement cstmt = con.prepareCall( "{call getCompetitionObj()}");
			CallableStatement cstmt = con.prepareCall("{call getCompetitionListByGrade(?)}");
			cstmt.setInt(1, grade); // 存储过程传参
			
			ResultSet resultSet = cstmt.executeQuery();
			briefCompetitionSet = new BriefCompetitionSet(resultSet, MyOpecode.competition.bCmConOfCmList);
			
			pool.returnConnection(con, cstmt, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return briefCompetitionSet; 
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-4-2下午09:20:34
	 *函数名：Query
	 *功能：查询单个大赛的详细信息
	 *参数：
	 *返回值：DetailedCompetition
	 */
	public DetailedCompetition getModel (int competitionId) {
		DetailedCompetition competition = null;
		
		try {
			Connection con = pool.getConnection();
			
			CallableStatement cstmt = con.prepareCall( "{call getCompetitionDeatilById(?)}");
			cstmt.setInt(1, competitionId); // 存储过程传参
			
			ResultSet resultSet = cstmt.executeQuery();
			competition = new DetailedCompetition(resultSet);
			
			pool.returnConnection(con, cstmt, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return competition;
	}
	
	/**
	 * 作者：LinHaiZhen
	 * 时间：2016-4-9 下午02:58:26
	 * 函数名：getRecentCompetition
	 * 功能：查询android首页大赛列表
	 * 参数：@return
	 * 返回值：BriefCompetitionSet
	 */
	public BriefCompetitionSet getRecentCompetition(){
		BriefCompetitionSet competition = null;
		
		String querySql = new BriefCompetition().getQuerySql(MyOpecode.competition.getBCmQueryOfAndroidHome);
		
		try {
			Connection con = pool.getConnection();
			
			PreparedStatement ps = con.prepareStatement(querySql);
			ResultSet resultSet = ps.executeQuery();
			
			competition = new BriefCompetitionSet(resultSet,MyOpecode.competition.bCmConOfAndroidHome);
			
			pool.returnConnection(con, ps, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return competition;
	}

	
	// public BriefCompetitionSet
	
	/******************************************************************************************************/
	// 基础数据的存取
	/******************************************************************************************************/	
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-4-9下午10:12:52
	 *函数名：getAllCompetiton
	 *功能：下拉框数据
	 *参数：
	 *返回值：JSONArray
	 *
	 *备注：[{"OrganizationName":"宁波资优少年","OrganizationId":"7"},{"OrganizationName":"宁波一聪教育","OrganizationId":"8"}]
	 */
	public JSONArray getAllOrganization () {
		JSONArray array = null;
		String resStr = null;
		
		try {
			Connection con = pool.getConnection();
			
			CallableStatement cstmt = con.prepareCall( "{call getAllOrganizationNumber()}");
			
			ResultSet resultSet = cstmt.executeQuery();
			while(resultSet.next()) {
				 resStr = resultSet.getString("OrganizationSet");
			}
			array = new JSONArray().fromObject(resStr);
			
			pool.returnConnection(con, cstmt, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		System.out.println("基础数据--承办方信息:" + array);
		return array; 
	}

	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-4-9下午10:12:52
	 *函数名：getCompetitonNumber
	 *功能：获取不同状态下的大赛数目
	 *参数：{"numberOfTobeEnro":"2","numberOfDoingEnro":"0","numberOfDoing":"0"}
	 *返回值：JSONObject
	 *
	 *备注：
	 *	1.即将开始比赛的数目（numberOfTobeEnro） 
	 *	2.正在报名比赛的数目（numberOfDoingEnro） 
	 *	3.正在进行中比赛的数目（numberOfDoing）
	 */
	public JSONObject getCompetitonNumber () {
		JSONObject jsonObject = null;
		String resStr = null;
		
		try {
			Connection con = pool.getConnection();
			
			CallableStatement cstmt = con.prepareCall( "{call getCompetitionNumberInfo()}");
			
			ResultSet resultSet = cstmt.executeQuery();
			while(resultSet.next()) {
				 resStr = resultSet.getString("jsonInfo");
			}
			jsonObject = new JSONObject().fromObject(resStr);
			
			pool.returnConnection(con, cstmt, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		System.out.println("基础数据--各种状态下的大赛数目:" + jsonObject);
		return jsonObject; 
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-4-10下午01:37:13
	 *函数名：getCompetitonNameByState
	 *功能：根据大赛状态返回相应的大赛名和ID
	 *参数：
	 *返回值：JSONArray
	 *
	 *备注：
	 *	[{"CompetitionName":"2016年全国初中数学联赛","CompetitionId":"34","CompetitionState":"1"},
	 *   {"CompetitionName":"第八届IYMC国际青少年数学竞赛(宁波赛区)","CompetitionId":"35","CompetitionState":"1"}]
	 */
	public JSONArray getCompetitonNameByState (int state) {
		JSONArray array = null;
		String resStr = null;
		
		try {
			Connection con = pool.getConnection();
			
			CallableStatement cstmt = con.prepareCall( "{call getCompetitionNameAndIdByState(?)}");
			cstmt.setInt(1, state); // 存储过程传参
			
			ResultSet resultSet = cstmt.executeQuery();
			while(resultSet.next()) {
				 resStr = resultSet.getString("jsonInfo");
			}
			array = new JSONArray().fromObject(resStr);
			
			pool.returnConnection(con, cstmt, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		System.out.println("基础数据--根据大赛的状态返回大赛名和ID:" + array);
		return array;
	}
	/******************************************************************************************************/
	
	
	
	
	
	/**
	 *作者：LiHuaYang
	 *时间：2016-4-15下午01:37:53
	 *函数名：updateScore
	 *功能：导入学生的成绩和导入查询成绩时的密码
	 *参数：List<Enrollment> enrollments 
	 *返回值：boolean
	 *
	 *备注：这里没有做实体类，采用PreparedStatement的addBatch方法，批量操作SQL语句
	 *
	 *格式：
	 *  大赛名	                                                 身份证号	          查询成绩时候的密码	        学生成绩  	学生准考证号码
	 *	浙江省中小学生数学竞赛	111111111111111111	10001				123
	 *	浙江省中小学生数学竞赛	111111111111111112	10002				124
	 *	浙江省中小学生数学竞赛	111111111111111113	10003				125
	 *
	 */
	public boolean updateScore (String excelPath) {
		boolean flag = true;
		String upDateSql = "UpDate Enrollment Set StudentScore=?, EnrollmentPassword=?, StudentTicket=?  Where CompetitionName=? And StudentIDNumber=?";
		PreparedStatement pstmt = null;
		ScoreExcelHelper excelHelper = new ScoreExcelHelper(excelPath);
		
		List<Enrollment> enrollments1 =  excelHelper.ExceltoEntity();
		
		if (enrollments1 == null) {
			System.out.println("enrollments == null");
			return false;
		}
		int length = enrollments1.size();
		try {
			Connection con = pool.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement(upDateSql);
			for (int i = 0; i < length; i++) {
				Enrollment enrollment =  enrollments1.get(i);

				pstmt.setInt(1, enrollment.getStudentscore());
				pstmt.setString(2, enrollment.getEnrollmentPassword());
				pstmt.setString(3, enrollment.getStudentTicket());
				pstmt.setString(4, enrollment.getCompetitionName());
				pstmt.setString(5, enrollment.getStudentIDNumber());
				
				pstmt.addBatch(); //addBatch();执行后暂时记录此条插入
			}
			pstmt.executeBatch(); //下句执行后开始批量插入数据
			
			pool.returnConnection(con, pstmt);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} 
		return flag;
	}
	
	public boolean updateeEnrollmentState () {
		return true;
	}

	
}


