package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompetitionStandInfo {
	
	private	String	ContestName	;//	大赛名称
	private	int	ContestNumber	;//	大赛届数
	private	String	ContestForm	;//	赛事形式
	private	String	ContestJoinPrice	;//	报名费
	private	String	ContestTarget	;//	参赛对象
	private	String	ContestStartTime	;//	赛事开始时间
	private	String	ContestEndTime	;//	赛事结束时间
	private	String	ContestSubject	;//	赛事科目
	private	String	ContestRules	;//	赛事章程
	private	String	ContestReward	;//	赛事奖励
	private	int	ContestOnState	;//	赛事进行状态
	private	int	ContestHost	;//	赛事热度
	private	String	ContestChangeDate	;//	大赛修改时间
	private	int	ContestCommentRank	;//	竞赛评价星级
	private	String	ContestCommentContent	;//	竞赛评价
	private	String	ContestPictureURL	;//	竞赛图片
	private	String	ProductName	;//	竞赛试题(商品名称)
	
	

	public CompetitionStandInfo(String contestName, int contestNumber,
			String contestForm, String contestJoinPrice, String contestTarget,
			String contestStartTime, String contestEndTime,
			String contestSubject, String contestRules, String contestReward,
			int contestOnState, int contestHost, String contestChangeDate,
			int contestCommentRank, String contestCommentContent,
			String contestPictureURL, String productName) {
		
		this.ContestName = contestName;
		this.ContestNumber = contestNumber;
		this.ContestForm = contestForm;
		this.ContestJoinPrice = contestJoinPrice;
		this.ContestTarget = contestTarget;
		this.ContestStartTime = contestStartTime;
		this.ContestEndTime = contestEndTime;
		this.ContestSubject = contestSubject;
		this.ContestRules = contestRules;
		this.ContestReward = contestReward;
		this.ContestOnState = contestOnState;
		this.ContestHost = contestHost;
		this.ContestChangeDate = contestChangeDate;
		this.ContestCommentRank = contestCommentRank;
		this.ContestCommentContent = contestCommentContent;
		this.ContestPictureURL = contestPictureURL;
		this.ProductName = productName;
	}
	
	public CompetitionStandInfo(ResultSet resultSet) throws SQLException{
		this.ContestName=resultSet.getString("ContestName");
		this.ContestNumber=resultSet.getInt("ContestNumber");
		this.ContestForm=resultSet.getString("ContestForm");
		this.ContestJoinPrice=resultSet.getString("ContestJoinPrice");
		this.ContestTarget=resultSet.getString("ContestTarget");
		this.ContestStartTime=resultSet.getString("ContestStartTime");
		this.ContestEndTime=resultSet.getString("ContestEndTime");
		this.ContestSubject=resultSet.getString("ContestSubject");
		this.ContestRules=resultSet.getString("ContestRules");
		this.ContestReward=resultSet.getString("ContestReward");
		this.ContestOnState=resultSet.getInt("ContestOnState");
		this.ContestHost=resultSet.getInt("ContestHost");
		this.ContestChangeDate=resultSet.getString("ContestChangeDate");
		this.ContestCommentRank=resultSet.getInt("ContestCommentRank");
		this.ContestCommentContent=resultSet.getString("ContestCommentContent");
		this.ContestPictureURL=resultSet.getString("ContestPictureURL");
		this.ProductName=resultSet.getString("ProductName");
	}

	public String getContestName() {
		return ContestName;
	}
	
	public int getContestNumber() {
		return ContestNumber;
	}

	public String getContestForm() {
		return ContestForm;
	}

	public String getContestJoinPrice() {
		return ContestJoinPrice;
	}

	public String getContestTarget() {
		return ContestTarget;
	}

	public String getContestStartTime() {
		return ContestStartTime;
	}

	public String getContestEndTime() {
		return ContestEndTime;
	}

	public String getContestSubject() {
		return ContestSubject;
	}

	public String getContestRules() {
		return ContestRules;
	}

	public String getContestReward() {
		return ContestReward;
	}

	public int getContestOnState() {
		return ContestOnState;
	}

	public int getContestHost() {
		return ContestHost;
	}

	public String getContestChangeDate() {
		return ContestChangeDate;
	}

	public int getContestCommentRank() {
		return ContestCommentRank;
	}

	public String getContestCommentContent() {
		return ContestCommentContent;
	}

	public String getContestPictureURL() {
		return ContestPictureURL;
	}

	public String getProductName() {
		return ProductName;
	}



	@Override
	public String toString() {
		return "CompetitionStandInfo [ContestChangeDate=" + ContestChangeDate
				+ ", ContestCommentContent=" + ContestCommentContent
				+ ", ContestCommentRank=" + ContestCommentRank
				+ ", ContestEndTime=" + ContestEndTime + ", ContestForm="
				+ ContestForm + ", ContestHost=" + ContestHost
				+ ", ContestJoinPrice=" + ContestJoinPrice + ", ContestName="
				+ ContestName + ", ContestNumber=" + ContestNumber
				+ ", ContestOnState=" + ContestOnState + ", ContestPictureURL="
				+ ContestPictureURL + ", ContestReward=" + ContestReward
				+ ", ContestRules=" + ContestRules + ", ContestStartTime="
				+ ContestStartTime + ", ContestSubject=" + ContestSubject
				+ ", ContestTarget=" + ContestTarget + ", ProductName="
				+ ProductName + "]";
	}
	
	
	

	
}
