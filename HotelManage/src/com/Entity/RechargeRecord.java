package com.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RechargeRecord {
	private	int	RechargeId	;//	充值记记录号
	private	String	RechargeTime	;//	充值时间
	private	int	RechargeMoney	;//	充值金额
	private	int	UserId	;//	客户号

	public RechargeRecord(){}
	
	public RechargeRecord(int	RechargeMoney,int	UserId){
		
		
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.RechargeTime=s.format( new Date());
		this.RechargeMoney=RechargeMoney;
		this.UserId=UserId;
	}
	
	@Id
	@GeneratedValue
	public int getRechargeId() {
		return RechargeId;
	}

	public void setRechargeId(int rechargeId) {
		RechargeId = rechargeId;
	}

	public String getRechargeTime() {
		return RechargeTime;
	}

	public void setRechargeTime(String rechargeTime) {
		RechargeTime = rechargeTime;
	}

	public int getRechargeMoney() {
		return RechargeMoney;
	}

	public void setRechargeMoney(int rechargeMoney) {
		RechargeMoney = rechargeMoney;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	@Override
	public String toString() {
		return "RechargeRecord [RechargeId=" + RechargeId + ", RechargeMoney="
				+ RechargeMoney + ", RechargeTime=" + RechargeTime
				+ ", UserId=" + UserId + "]";
	};
	
	
}
