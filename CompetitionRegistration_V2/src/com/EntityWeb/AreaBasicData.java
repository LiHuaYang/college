package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AreaBasicData {
	private int AreaId;   //地区id
	private String AreaAddress;   //地区
	
	public AreaBasicData(int AreaId,String AreaAddress){
		this.AreaId=AreaId;
		this.AreaAddress=AreaAddress;
	}
	
	public AreaBasicData(String AreaAddress){
		this.AreaAddress=AreaAddress;
	}
    
	public AreaBasicData(ResultSet resultSet) throws SQLException{
		if (resultSet.getString("AreaId") == null) {			
		}
		this.AreaId = resultSet.getInt("AreaId");
		this.AreaAddress=resultSet.getString("AreaAddress");
	}
	
	public int getAreaId() {
		return AreaId;
	}

	public String getAreaAddress() {
		return AreaAddress;
	}

	@Override
	public String toString() {
		return "AreaBasicData [AreaAddress=" + AreaAddress + ", AreaId="
				+ AreaId + "]";
	}
	
	
}
