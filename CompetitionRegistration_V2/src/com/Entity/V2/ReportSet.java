package com.Entity.V2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Tool.sql.SqlHelper;

public class ReportSet {

	private ArrayList<Report> reportSet;

	//默认构造函数
	public ReportSet() {}
	
	public ReportSet(ResultSet resultSet, String condition) throws SQLException{
		reportSet = new ArrayList<Report>();
		
		while(resultSet.next()){
			Report tempReport = new Report(resultSet,condition);
			reportSet.add(tempReport);
		}

	}
	
	public boolean isOk(ResultSet resultSet, String condition) throws SQLException{
		boolean result = true;
		int i=0;
		
		while(resultSet.next()){
			Report tempReport = new Report(resultSet,condition);
			if(i == 10){
				break;
			}
			if(!tempReport.isHaveScore()){
				result = false;
				break;
			}
			
			i++;
		}

		resultSet.first();
		return result;
	}
	
	public void addItem(Report report){
		reportSet.add(report);
	}
	
	
	public int getSize(){
		return reportSet.size();
	}
	
	public Report getItem(int i){
		
		return reportSet.get(i);
	}
	
	
}
