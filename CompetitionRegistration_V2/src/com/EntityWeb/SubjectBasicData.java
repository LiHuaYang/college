package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectBasicData {

	private int SubjectId;   //科目id
	private String SubjectName;   //科目名字
	
	public SubjectBasicData(int SubjectId,String SubjectName){
		this.SubjectId=SubjectId;
		this.SubjectName=SubjectName;
	}
	public SubjectBasicData(String SubjectName){
		this.SubjectName=SubjectName;
	}

	public SubjectBasicData(ResultSet resultSet) throws SQLException{
		if (resultSet.getString("SubjectId") == null) {			
		}
		this.SubjectId = resultSet.getInt("SubjectId");
		this.SubjectName=resultSet.getString("SubjectName");
	}

	public int getSubjectId() {
		return SubjectId;
	}

	public String getSubjectName() {
		return SubjectName;
	}

	@Override
	public String toString() {
		return "SubjectBasicData [SubjectId=" + SubjectId + ", SubjectName="
				+ SubjectName + "]";
	}
	
    
}
