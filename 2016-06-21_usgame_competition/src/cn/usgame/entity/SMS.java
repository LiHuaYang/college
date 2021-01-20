package cn.usgame.entity;

public class SMS {
	private String phoneNumber;
	private String SNSNumber;
	private String nowTime;
	private int lifeCycle;
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSNSNumber() {
		return SNSNumber;
	}
	public void setSNSNumber(String sNSNumber) {
		SNSNumber = sNSNumber;
	}
	public String getNowTime() {
		return nowTime;
	}
	public void setNowTime(String nowTime) {
		this.nowTime = nowTime;
	}
	
	public int getLifeCycle() {
		return lifeCycle;
	}
	public void setLifeCycle(int lifeCycle) {
		this.lifeCycle = lifeCycle;
	}
	public SMS(String phoneNumber, String sNSNumber, String nowTime, int lifeCycle) {
		super();
		this.phoneNumber = phoneNumber;
		SNSNumber = sNSNumber;
		this.nowTime = nowTime;
		this.lifeCycle = lifeCycle;
	}
	
	public SMS(){}
	
	
}
