package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPaperPicture {

	private int TestPaperPictureid;   //试卷图片id
	private int TestPaperNumber;   //第几题
	private String TestPapeTitleUrl;   //题目图片路径
	private String TestPaperAnswerUrl;   //答案图片路径
	private int TestPaperId;   //试卷id
	
	public TestPaperPicture(int TestPaperNumber,String TestPapeTitleUrl,
			String	TestPaperAnswerUrl,int TestPaperId){
		this.TestPaperPictureid = TestPaperPictureid;
		this.TestPaperNumber = TestPaperNumber;
		this.TestPapeTitleUrl = TestPapeTitleUrl;
		this.TestPaperAnswerUrl = TestPaperAnswerUrl;
		this.TestPaperId = TestPaperId;
	}
	
	public TestPaperPicture(ResultSet resultSet) throws SQLException{
		this.TestPaperPictureid=resultSet.getInt("TestPaperPictureid");
		this.TestPaperNumber=resultSet.getInt("TestPaperNumber");
		this.TestPapeTitleUrl=resultSet.getString("TestPapeTitleUrl");
		this.TestPaperAnswerUrl=resultSet.getString("TestPaperAnswerUrl");
		this.TestPaperId=resultSet.getInt("TestPaperId");
	}

	public int getTestPaperPictureid() {
		return TestPaperPictureid;
	}

	public int getTestPaperNumber() {
		return TestPaperNumber;
	}

	public String getTestPapeTitleUrl() {
		return TestPapeTitleUrl;
	}

	public String getTestPaperAnswerUrl() {
		return TestPaperAnswerUrl;
	}

	public int getTestPaperId() {
		return TestPaperId;
	}

	@Override
	public String toString() {
		return "TestPaperPicture [TestPapeTitleUrl=" + TestPapeTitleUrl
				+ ", TestPaperAnswerUrl=" + TestPaperAnswerUrl
				+ ", TestPaperId=" + TestPaperId + ", TestPaperNumber="
				+ TestPaperNumber + ", TestPaperPictureid="
				+ TestPaperPictureid + "]";
	}
	
	

}
