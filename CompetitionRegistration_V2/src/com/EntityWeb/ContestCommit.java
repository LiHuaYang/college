package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContestCommit {

	private	int	ContestCommitid	;//	大赛评价id
	private	String	ContestCommitInfo	;//	评价内容
	private	String	ContestCommitRank	;//	评价星级
	private	String	ContestCommitTime	;//	评价时间
	private	int	CompetitionId	;//	竞赛项目id
	private	int	Userid	;//	用户id

	public ContestCommit(String ContestCommitInfo,String ContestCommitRank,int CompetitionId,int Userid){
		this.ContestCommitid = ContestCommitid;
		this.ContestCommitInfo = ContestCommitInfo;
		this.ContestCommitRank = ContestCommitRank;
		
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.ContestCommitTime=s.format( new Date());
		
		this.CompetitionId=CompetitionId;
		this.Userid=Userid;
	}
	
	public ContestCommit(ResultSet resultSet) throws SQLException{
		this.ContestCommitInfo=resultSet.getString("ContestCommitInfo");
		this.ContestCommitRank=resultSet.getString("ContestCommitRank");
		this.ContestCommitTime=resultSet.getString("ContestCommitTime");
		this.CompetitionId=resultSet.getInt("CompetitionId");
		this.Userid=resultSet.getInt("Userid");
	}

	public int getContestCommitid() {
		return ContestCommitid;
	}

	public String getContestCommitInfo() {
		return ContestCommitInfo;
	}

	public String getContestCommitRank() {
		return ContestCommitRank;
	}

	public String getContestCommitTime() {
		return ContestCommitTime;
	}

	public int getCompetitionId() {
		return CompetitionId;
	}

	public int getUserid() {
		return Userid;
	}

	@Override
	public String toString() {
		return "ContestCommit [ContestCommitInfo=" + ContestCommitInfo
				+ ", ContestCommitRank=" + ContestCommitRank
				+ ", ContestCommitTime=" + ContestCommitTime
				+ ", ContestCommitid=" + ContestCommitid + ", CompetitionId="
				+ CompetitionId + ", Userid=" + Userid + "]";
	}
	
}
