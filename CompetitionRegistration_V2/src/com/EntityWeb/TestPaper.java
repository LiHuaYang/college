package com.EntityWeb;

public class TestPaper {
	private	int	TestPaperId	;//	试卷id
	private	String	TestPaperName	;//	试卷名字
	private	String	TestPaperTime	;//	试卷发布时间
	private	int	TestPaperState	;//	试卷状态
	private	String	TestSubject	;//	科目
	private	int	TestDifficulty	;//	难度
	private	String	TestKnowledgepoint	;//	知识点
	private	int	TestYear	;//	年份
	private	String	TestState	;//	年级类型
	private	int	ContestId	;//	竞赛id
	
	public TestPaper(int TestPaperId,String TestPaperName,String TestPaperTime,int TestPaperState,
			String TestSubject,int TestDifficulty,String TestKnowledgepoint,int TestYear,
			String TestState,int ContestId){
		this.TestPaperId = TestPaperId;
		this.TestPaperName = TestPaperName;
		this.TestPaperTime = TestPaperTime;
		this.TestPaperState = TestPaperState;
		this.TestSubject = TestSubject;
		this.TestDifficulty = TestDifficulty;
		this.TestKnowledgepoint = TestKnowledgepoint;
		this.TestYear = TestYear;
		this.TestState = TestState;
		this.ContestId = ContestId;
	}
	
	public TestPaper(int TestPaperId,String TestPaperName,String TestPaperTime,String TestSubject,int TestDifficulty){
		this.TestPaperId = TestPaperId;
		this.TestPaperName = TestPaperName;
		this.TestPaperTime = TestPaperTime;
		this.TestSubject = TestSubject;
		this.TestDifficulty = TestDifficulty;
	}
	
	public TestPaper(int TestPaperId,String	TestPaperName,String TestPaperTime,int TestDifficulty){
		this.TestPaperId = TestPaperId;
		this.TestPaperName = TestPaperName;
		this.TestPaperTime = TestPaperTime;
		this.TestDifficulty = TestDifficulty;
	}
	
	public int getTestPaperId() {
		return TestPaperId;
	}
	public String getTestPaperName() {
		return TestPaperName;
	}
	public String getTestPaperTime() {
		return TestPaperTime;
	}
	public int getTestPaperState() {
		return TestPaperState;
	}
	public String getTestSubject() {
		return TestSubject;
	}
	public int getTestDifficulty() {
		return TestDifficulty;
	}
	public String getTestKnowledgepoint() {
		return TestKnowledgepoint;
	}
	public int getTestYear() {
		return TestYear;
	}
	public String getTestState() {
		return TestState;
	}
	public int getContestId() {
		return ContestId;
	}
	
	
	@Override
	public String toString() {
		return "TestPaper [ContestId=" + ContestId + ", TestDifficulty="
				+ TestDifficulty + ", TestKnowledgepoint=" + TestKnowledgepoint
				+ ", TestPaperId=" + TestPaperId + ", TestPaperName="
				+ TestPaperName + ", TestPaperState=" + TestPaperState
				+ ", TestPaperTime=" + TestPaperTime + ", TestState="
				+ TestState + ", TestSubject=" + TestSubject + ", TestYear="
				+ TestYear + "]";
	}
	
	

}
