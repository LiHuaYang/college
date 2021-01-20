package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

//显示评论信息
public class ContestCommitInfo {
	private	int	ContestCommitid	;//	大赛评价id
	private	String	ContestCommitInfo	;//	评价内容
	private	String	ContestCommitRank	;//	评价星级
	private	String	ContestCommitTime	;//	评价时间
	private	int	CompetitionId	;//	竞赛项目id
	private	int	Userid	;//	用户id
	private String UserPicture;//用户图片
	private String UserNickname;//用户姓名
	
	public ContestCommitInfo(String ContestCommitInfo,String ContestCommitRank,
			String ContestCommitTime,int CompetitionId,int Userid,
			String UserPicture,String UserNickname){
		this.ContestCommitid=ContestCommitid;
		this.ContestCommitInfo=ContestCommitInfo;
		this.ContestCommitRank=ContestCommitRank;
		
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.ContestCommitTime=s.format( new Date());
		
		this.CompetitionId=CompetitionId;
		this.Userid=Userid;
		this.UserPicture=UserPicture;
		this.UserNickname=UserNickname;
	}
	
	public ContestCommitInfo(ResultSet resultSet) throws SQLException{
		this.ContestCommitInfo=resultSet.getString("ContestCommitInfo");
		this.ContestCommitRank=resultSet.getString("ContestCommitRank");
		this.ContestCommitTime=resultSet.getString("ContestCommitTime");
		this.CompetitionId=resultSet.getInt("CompetitionId");
		this.Userid=resultSet.getInt("Userid");
		this.UserPicture=resultSet.getString("UserPicture");
		this.UserNickname=resultSet.getString("UserNickname");
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

	public String getUserPicture() {
		return UserPicture;
	}

	public String getUserNickname() {
		return UserNickname;
	}

	@Override
	public String toString() {
		return "ContestCommitInfo [CompetitionId=" + CompetitionId
				+ ", ContestCommitInfo=" + ContestCommitInfo
				+ ", ContestCommitRank=" + ContestCommitRank
				+ ", ContestCommitTime=" + ContestCommitTime
				+ ", ContestCommitid=" + ContestCommitid + ", UserNickname="
				+ UserNickname + ", UserPicture=" + UserPicture + ", Userid="
				+ Userid + "]";
	}

	
}
