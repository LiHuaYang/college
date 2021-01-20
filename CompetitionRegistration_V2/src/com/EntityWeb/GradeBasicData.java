package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GradeBasicData {

	private int GreadId;   //年级组id
	private int GreadState;   //年级组类型
	
	public GradeBasicData(int GreadId,int GreadState){
		this.GreadId=GreadId;
		this.GreadState=GreadState;
	}
	public GradeBasicData(int GreadState){
		this.GreadState=GreadState;
	}

	public GradeBasicData(ResultSet resultSet) throws SQLException{
		if (resultSet.getString("GreadId") == null) {			
		}
		this.GreadId = resultSet.getInt("GreadId");
		this.GreadState=resultSet.getInt("GreadState");
	}

	public int getGreadId() {
		return GreadId;
	}

	public int getGreadState() {
		return GreadState;
	}

	@Override
	public String toString() {
		return "GradeBasicData [GreadId=" + GreadId + ", GreadState="
				+ GreadState + "]";
	}
		

	
	
}
