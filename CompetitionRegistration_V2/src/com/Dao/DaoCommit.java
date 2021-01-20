package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.EntityAndroid.ContestCommitInfo;
import com.EntityWeb.ContestCommit;
import com.Tool.sql.JdbcUnit;

public class DaoCommit {
	
//------------------------------安卓部分-----------------------------------	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-27下午08:11:06
	 *函数名：SearchContestCommit
	 *功能：显示评论信息通过大赛id
	 *参数：比赛项目id：CompetitionId
	 *返回值：ContestCommitInfo
	 */
	public List<ContestCommitInfo> SearchContestCommit(int CompetitionId,int page){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		int startPos = (page - 1) * 15;
		
		String sql = "Select c.ContestCommitInfo,c.ContestCommitRank,c.ContestCommitTime," +
				"c.CompetitionId,c.Userid,u.UserPicture,u.UserNickname from ContestCommit c,User u " +
				"where c.Userid=u.Userid and c.CompetitionId="+CompetitionId+" order by c.ContestCommitTime DESC limit "+startPos+","+15;
		
		List<ContestCommitInfo> contestCommitInfos = new ArrayList<ContestCommitInfo>();
		
		ContestCommitInfo contestCommitInfo = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				contestCommitInfo=new ContestCommitInfo(rs);
				contestCommitInfos.add(contestCommitInfo);
			}
			con.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  contestCommitInfos;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-28下午01:04:04
	 *函数名：SearchCountbyCopetiitonId
	 *功能：得到评论总数通过大赛id
	 *参数：大赛id：Competitionid
	 *返回值：int
	 */
	public int SearchCountbyCopetiitonId(int CompetitionId){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "Select count(*) from ContestCommit c,User u where c.Userid=u.Userid " +
				"and c.CompetitionId="+CompetitionId;
		
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
	 *时间：2016-2-26下午03:44:41
	 *函数名：calculationCommitRankAverage
	 *功能：计算大赛的评论平均星级分数
	 *参数：大赛id：Competitionid
	 *返回值：float
	 */
	public float CalculationCommitRankAverage(int CompetitionId){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "Select avg(ContestCommitRank) from ContestCommit where CompetitionId="+CompetitionId;
		
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
	 *时间：2016-2-27下午02:12:42
	 *函数名：ConmmitCreate
	 *功能：新建评论
	 *参数：contestCommit
	 *返回值：boolean
	 */
	public boolean CommitCreate(ContestCommit contestCommit){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "insert into contestCommit(ContestCommitInfo,ContestCommitRank,ContestCommitTime,CompetitionId,Userid) "
				+ "values('"
				+ contestCommit.getContestCommitInfo()
				+ "','"
				+ contestCommit.getContestCommitRank()
				+ "','"
				+ contestCommit.getContestCommitTime()
				+ "',"
				+ contestCommit.getCompetitionId()
				+ ","
				+ contestCommit.getUserid()
				+ ")";
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
}
