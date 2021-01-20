package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cleaner {
	private	int	CleanerId	;//	清洁工号
	private	String	CleanerName	;//	清洁工名
	private	String	CleanerSex	;//	清洁工性别
	private	String	CleanerPhoneNumber	;//	电话
	private	int	CleanerState	;//	清洁员状态
	private	String	CleanerIDNumber	;//	身份证号
	private String CleanerPassWord;//清洁员密码
	

	
	public Cleaner(){}
	
	public Cleaner(String	CleanerName,String	CleanerSex,String	CleanerPhoneNumber,int CleanerState, String	CleanerIDNumber, String CleanerPassWord){
		this.CleanerName=CleanerName;
		this.CleanerPhoneNumber=CleanerPhoneNumber;
		this.CleanerState = CleanerState;
		this.CleanerIDNumber=CleanerIDNumber;
		this.CleanerPassWord = CleanerPassWord;
		this.CleanerPassWord=CleanerPassWord;
	}
	public Cleaner(int cleanerId, String cleanerName, String cleanerSex,
			String cleanerPhnum, String cleanerIdUm, String cleanerPassWord) {
		this.CleanerName =cleanerName;
		this.CleanerId=cleanerId;
		this.CleanerSex=cleanerSex;
		this.CleanerPhoneNumber=cleanerPhnum;
		this.CleanerIDNumber=cleanerIdUm;
		this.CleanerPassWord=cleanerPassWord;
	}


	public Cleaner(int cleanerId, String cleanerName, String cleanerSex,
			String cleanerPhoneNumber, int cleanerState,
			String cleanerIDNumber, String cleanerPassWord) {
		super();
		CleanerId = cleanerId;
		CleanerName = cleanerName;
		CleanerSex = cleanerSex;
		CleanerPhoneNumber = cleanerPhoneNumber;
		CleanerState = cleanerState;
		CleanerIDNumber = cleanerIDNumber;
		CleanerPassWord = cleanerPassWord;
	}

	@Id
	@GeneratedValue
	public int getCleanerId() {
		return CleanerId;
	}

	public void setCleanerId(int cleanerId) {
		CleanerId = cleanerId;
	}

	public String getCleanerName() {
		return CleanerName;
	}

	public void setCleanerName(String cleanerName) {
		CleanerName = cleanerName;
	}

	public String getCleanerSex() {
		return CleanerSex;
	}

	public void setCleanerSex(String cleanerSex) {
		CleanerSex = cleanerSex;
	}

	public String getCleanerPhoneNumber() {
		return CleanerPhoneNumber;
	}

	public void setCleanerPhoneNumber(String cleanerPhoneNumber) {
		CleanerPhoneNumber = cleanerPhoneNumber;
	}

	public int getCleanerState() {
		return CleanerState;
	}

	public void setCleanerState(int cleanerState) {
		CleanerState = cleanerState;
	}

	public String getCleanerIDNumber() {
		return CleanerIDNumber;
	}

	public void setCleanerIDNumber(String cleanerIDNumber) {
		CleanerIDNumber = cleanerIDNumber;
	}
	

	public String getCleanerPassWord() {
		return CleanerPassWord;
	}

	public void setCleanerPassWord(String cleanerPassWord) {
		CleanerPassWord = cleanerPassWord;
	}

	@Override
	public String toString() {
		return "Cleaner [CleanerIDNumber=" + CleanerIDNumber + ", CleanerId="
				+ CleanerId + ", CleanerName=" + CleanerName
				+ ", CleanerPassWord=" + CleanerPassWord
				+ ", CleanerPhoneNumber=" + CleanerPhoneNumber
				+ ", CleanerSex=" + CleanerSex + ", CleanerState="
				+ CleanerState + "]";
	};
	
	
}
