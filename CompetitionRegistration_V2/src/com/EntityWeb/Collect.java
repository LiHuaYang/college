package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Collect {

	private int CollectId;   //收藏id
	private String CollectName;   //收藏名字（试卷描述）
	private String CollectTime;   //收藏时间
	private int CollectState; //收藏状态
	private int TestPaperId;   //试卷id
	private int Userid;   //用户id
	
	
	public Collect(String CollectName,int TestPaperId,int Userid){
		this.CollectName = CollectName;
		
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.CollectTime=s.format( new Date());
		
		this.TestPaperId = TestPaperId;
		this.Userid = Userid;
	}
	
	public Collect(ResultSet resultSet) throws SQLException{
		this.CollectId=resultSet.getInt("CollectId");
		this.CollectName=resultSet.getString("CollectName");
		this.CollectTime=resultSet.getString("CollectTime");
		this.CollectState=resultSet.getInt("CollectState");
		this.TestPaperId=resultSet.getInt("TestPaperId");
		this.Userid=resultSet.getInt("Userid");
	}

	public int getCollectId() {
		return CollectId;
	}

	public String getCollectName() {
		return CollectName;
	}

	public String getCollectTime() {
		return CollectTime;
	}

	public int getCollectState() {
		return CollectState;
	}

	public int getTestPaperId() {
		return TestPaperId;
	}

	public int getUserid() {
		return Userid;
	}

	@Override
	public String toString() {
		return "Collect [CollectId=" + CollectId + ", CollectName="
				+ CollectName + ", CollectState=" + CollectState
				+ ", CollectTime=" + CollectTime + ", TestPaperId="
				+ TestPaperId + ", Userid=" + Userid + "]";
	}


	
	
}
