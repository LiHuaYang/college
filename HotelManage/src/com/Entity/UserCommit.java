package com.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserCommit {
	private	int	UserCommitId	;//	客户评价号
	private	String	UserCommitTime	;//	评价时间
	private	String	UserCommitContent	;//	评价内容
	private	int	UserCommitRank	;//	评价星级
	private	int	CleanerId	;//	清洁工号
	private	int	UserId	;//	客户号

    public UserCommit(){};
    
    public UserCommit(String UserCommitTime,String UserCommitContent,int UserCommitRank,int CleanerId,int UserId){
    	this.UserCommitTime=UserCommitTime;
    	this.UserCommitRank=UserCommitRank;
    	this.CleanerId=CleanerId;
    	this.UserId=UserId;
    };
    public UserCommit(String UserCommitContent,int UserCommitRank,int CleanerId,int UserId){
		
    	SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.UserCommitTime=s.format( new Date());
    	this.UserCommitRank=UserCommitRank;
    	this.CleanerId=CleanerId;
    	this.UserId=UserId;
    };
    
    @Id
    @GeneratedValue
	public int getUserCommitId() {
		return UserCommitId;
	}

	public void setUserCommitId(int userCommitId) {
		UserCommitId = userCommitId;
	}

	public String getUserCommitTime() {
		return UserCommitTime;
	}

	public void setUserCommitTime(String userCommitTime) {
		UserCommitTime = userCommitTime;
	}

	public String getUserCommitContent() {
		return UserCommitContent;
	}

	public void setUserCommitContent(String userCommitContent) {
		UserCommitContent = userCommitContent;
	}

	public int getUserCommitRank() {
		return UserCommitRank;
	}

	public void setUserCommitRank(int userCommitRank) {
		UserCommitRank = userCommitRank;
	}

	public int getCleanerId() {
		return CleanerId;
	}

	public void setCleanerId(int cleanerId) {
		CleanerId = cleanerId;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	@Override
	public String toString() {
		return "UserCommit [CleanerId=" + CleanerId + ", UserCommitContent="
				+ UserCommitContent + ", UserCommitId=" + UserCommitId
				+ ", UserCommitRank=" + UserCommitRank + ", UserCommitTime="
				+ UserCommitTime + ", UserId=" + UserId + "]";
	};
    
    
}
