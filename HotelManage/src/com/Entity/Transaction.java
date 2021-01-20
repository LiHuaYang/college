package com.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {
	private	int	TransactionId	;//	���׼�¼��
	private	String	TransactionTime	;//	����ʱ��
	private	String	TransactionDetail	;//	����
	private	int	TransactionMoney	;//	���
	private	int	TransactionState	;//	״̬
	private	int	Userid	;//	�ͻ���
	
	
	public Transaction(){}
	
	public Transaction(String TransactionDetail,int TransactionMoney,int Userid){
		
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.TransactionTime=s.format( new Date());
		
		this.TransactionDetail=TransactionDetail;
		this.TransactionMoney=TransactionMoney;
		this.TransactionState=1;
		this.Userid=Userid;
	}
	
	@Id
	@GeneratedValue
	public int getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(int transactionId) {
		TransactionId = transactionId;
	}
	public String getTransactionTime() {
		return TransactionTime;
	}
	public void setTransactionTime(String transactionTime) {
		TransactionTime = transactionTime;
	}
	public String getTransactionDetail() {
		return TransactionDetail;
	}
	public void setTransactionDetail(String transactionDetail) {
		TransactionDetail = transactionDetail;
	}
	public int getTransactionMoney() {
		return TransactionMoney;
	}
	public void setTransactionMoney(int transactionMoney) {
		TransactionMoney = transactionMoney;
	}
	public int getTransactionState() {
		return TransactionState;
	}
	public void setTransactionState(int transactionState) {
		TransactionState = transactionState;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	
	@Override
	public String toString() {
		return "Transaction [TransactionDetail=" + TransactionDetail
				+ ", TransactionId=" + TransactionId + ", TransactionMoney="
				+ TransactionMoney + ", TransactionState=" + TransactionState
				+ ", TransactionTime=" + TransactionTime + ", Userid=" + Userid
				+ "]";
	}

	
}
