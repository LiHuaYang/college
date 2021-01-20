package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CompetitionBasicData {
	
	private int CompetitionBasicId;   //大赛名字基础id
	private String CompetitionBasicName;   //大赛名字
	private String CompetitionBasicNickName;   //大赛名字简称
	
	public CompetitionBasicData(int CompetitionBasicId,String CompetitionBasicName,
			String CompetitionBasicNickName){
		this.CompetitionBasicId=CompetitionBasicId;
		this.CompetitionBasicName=CompetitionBasicName;
		this.CompetitionBasicNickName=CompetitionBasicNickName;
	}

	public CompetitionBasicData(ResultSet resultSet) throws SQLException{
		this.CompetitionBasicId=resultSet.getInt("CompetitionBasicId");
		this.CompetitionBasicName=resultSet.getString("CompetitionBasicName");
		this.CompetitionBasicNickName=resultSet.getString("CompetitionBasicNickName");
	}
	
	
	
	public int getCompetitionBasicId() {
		return CompetitionBasicId;
	}

	public String getCompetitionBasicName() {
		return CompetitionBasicName;
	}

	public String getCompetitionBasicNickName() {
		return CompetitionBasicNickName;
	}

	@Override
	public String toString() {
		return "CompetitionBasicData [CompetitionBasicId=" + CompetitionBasicId
				+ ", CompetitionBasicName=" + CompetitionBasicName
				+ ", CompetitionBasicNickName=" + CompetitionBasicNickName
				+ "]";
	}
		
		
		

}
