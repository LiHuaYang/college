package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompetitionNewsInfo {

	private int CompetitionId;//大赛id
	private	String	CompetitionPicture	;//	竞赛图片路径
	private	String	CompetitionName	;//	竞赛名称
	private	String	ContestPropaganda	;//	宣传语

	public CompetitionNewsInfo(){}
	
	public CompetitionNewsInfo(int CompetitionId,String CompetitionPicture, String CompetitionName,
			String ContestPropaganda){
		this.CompetitionId = CompetitionId;
		this.CompetitionPicture = CompetitionPicture;
		this.CompetitionName = CompetitionName;
		this.ContestPropaganda = ContestPropaganda;
	}
	
	
	
	public CompetitionNewsInfo(ResultSet resultSet) throws SQLException{
		this.CompetitionId=resultSet.getInt("CompetitionId");
		this.CompetitionPicture=resultSet.getString("CompetitionPicture");
		this.CompetitionName=resultSet.getString("CompetitionName");
		this.ContestPropaganda=resultSet.getString("ContestPropaganda");
	}

	public int getCompetitionId() {
		return CompetitionId;
	}

	public String getCompetitionPicture() {
		return CompetitionPicture;
	}

	public String getCompetitionName() {
		return CompetitionName;
	}

	public String getContestPropaganda() {
		return ContestPropaganda;
	}

	@Override
	public String toString() {
		return "CompetitionNewsInfo [CompetitionId=" + CompetitionId
				+ ", CompetitionName=" + CompetitionName
				+ ", CompetitionPicture=" + CompetitionPicture
				+ ", ContestPropaganda=" + ContestPropaganda + "]";
	}

	
	
}
