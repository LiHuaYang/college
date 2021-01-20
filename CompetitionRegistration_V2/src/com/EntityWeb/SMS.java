package com.EntityWeb;


public class SMS {

	private int SMSID; // 短信验证码ID
	private String PhoneNumber; // 用户请求的手机号码
	private String CheckNumber; // 验证码
	private String Bulidtime; // 记录创建时间
	private int Lifecycle; // 记录生命周期
	
	public SMS() {
		
	}
	public SMS(String PhoneNumber, String Bulidtime, int Lifecycle, String checkNumber) {
		this.PhoneNumber = PhoneNumber;
		this.Bulidtime = Bulidtime;
		this.Lifecycle = Lifecycle;
		this.CheckNumber = checkNumber;
	}
	
	public boolean CheckInfoISExit() {
		boolean flag = false;

		
		return flag;
	}
	
	public boolean PushASMS() {
		boolean flag = false;
		
		
		return flag;
	}
	
	public boolean PopASMS() {
		boolean flag = false;
		
		return flag;
	}
	
	
	public int getSMSID() {
		return SMSID;
	}
	public void setSMSID(int sMSID) {
		SMSID = sMSID;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getCheckNumber() {
		return CheckNumber;
	}
	public void setCheckNumber(String checkNumber) {
		CheckNumber = checkNumber;
	}
	public String getBulidtime() {
		return Bulidtime;
	}
	public void setBulidtime(String bulidtime) {
		Bulidtime = bulidtime;
	}
	public int getLifecycle() {
		return Lifecycle;
	}
	public void setLifecycle(int lifecycle) {
		Lifecycle = lifecycle;
	}
	
}
