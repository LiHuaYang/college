package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class YearBasicData {

	private int YearBasicDataId; // 年份基础数据表Id
	private String  YearData;  //年份
	
	public YearBasicData(int YearBasicDataId,String YearData){
		this.YearBasicDataId=YearBasicDataId;
		this.YearData=YearData;
	}
	
	public YearBasicData(ResultSet resultSet) throws SQLException{
		this.YearBasicDataId=resultSet.getInt("YearBasicDataId");
		this.YearData=resultSet.getString("YearData");
	}

	public int getYearBasicDataId() {
		return YearBasicDataId;
	}

	public String getYearData() {
		return YearData;
	}

	@Override
	public String toString() {
		return "YearBasicData [YearBasicDataId=" + YearBasicDataId
				+ ", YearData=" + YearData + "]";
	}
	
	

}
