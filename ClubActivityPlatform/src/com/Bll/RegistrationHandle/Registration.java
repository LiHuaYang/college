package com.Bll.RegistrationHandle;

public class Registration {
	private int userId;
	private String userName;
	private int belongType;
	private int belongId;
	private String registrationContent;
	
	public Registration(int userId,String userName, int belongType,int belongId,String registrationContent){
		this.userId=userId;
		this.belongType=belongType;
		this.belongId=belongId;
		this.userName=userName;
		this.registrationContent=registrationContent;
	}
	
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public int getBelongType() {
		return belongType;
	}
	public int getBelongId() {
		return belongId;
	}
	public String getRegistrationContent() {
		return registrationContent;
	}
	@Override
	public String toString() {
		return "Registration [belongId=" + belongId + ", belongType="
				+ belongType + ", registrationContent=" + registrationContent
				+ ", userId=" + userId + ", userName=" + userName + "]";
	}
	
	
}
