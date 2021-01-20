package com.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ConsumptionRecord {
	private	int	ConsumptionId	;//	���Ѽ�¼��
	private	String	ConsumptionTime	;//	����ʱ��
	private	int	ConsumptionMoney	;//	���ѽ��
	private	String	ConsumptionAddress	;//	���ѵص�
	private	String	ConsumptionName	;//	�µ�����
	private	String	ConsumptionPhon	;//	�µ��ֻ���
	private	String	ConsumptionIDNumber	;//	�µ����֤
	private	int	Userid	;//	�ͻ���
	
	public ConsumptionRecord(){};
	
	public ConsumptionRecord(int ConsumptionMoney,String ConsumptionAddress,String	ConsumptionName,String	ConsumptionPhon,String	ConsumptionIDNumber,int	Userid){
		
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.ConsumptionTime=s.format( new Date());
		
		this.ConsumptionMoney=ConsumptionMoney;
		this.ConsumptionAddress=ConsumptionAddress;
		this.ConsumptionName=ConsumptionName;
		this.ConsumptionPhon=ConsumptionPhon;
		this.ConsumptionIDNumber=ConsumptionIDNumber;
		this.Userid=Userid;
	};
	
	@Id
	@GeneratedValue
	public int getConsumptionId() {
		return ConsumptionId;
	}
	public void setConsumptionId(int consumptionId) {
		ConsumptionId = consumptionId;
	}
	public String getConsumptionTime() {
		return ConsumptionTime;
	}
	public void setConsumptionTime(String consumptionTime) {
		ConsumptionTime = consumptionTime;
	}
	public int getConsumptionMoney() {
		return ConsumptionMoney;
	}
	public void setConsumptionMoney(int consumptionMoney) {
		ConsumptionMoney = consumptionMoney;
	}
	public String getConsumptionAddress() {
		return ConsumptionAddress;
	}
	public void setConsumptionAddress(String consumptionAddress) {
		ConsumptionAddress = consumptionAddress;
	}
	
	public String getConsumptionName() {
		return ConsumptionName;
	}

	public void setConsumptionName(String consumptionName) {
		ConsumptionName = consumptionName;
	}

	public String getConsumptionPhon() {
		return ConsumptionPhon;
	}

	public void setConsumptionPhon(String consumptionPhon) {
		ConsumptionPhon = consumptionPhon;
	}

	public String getConsumptionIDNumber() {
		return ConsumptionIDNumber;
	}

	public void setConsumptionIDNumber(String consumptionIDNumber) {
		ConsumptionIDNumber = consumptionIDNumber;
	}

	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	
	@Override
	public String toString() {
		return "ConsumptionRecord [ConsumptionAddress=" + ConsumptionAddress
				+ ", ConsumptionIDNumber=" + ConsumptionIDNumber
				+ ", ConsumptionId=" + ConsumptionId + ", ConsumptionMoney="
				+ ConsumptionMoney + ", ConsumptionName=" + ConsumptionName
				+ ", ConsumptionPhon=" + ConsumptionPhon + ", ConsumptionTime="
				+ ConsumptionTime + ", Userid=" + Userid + "]";
	}

}
