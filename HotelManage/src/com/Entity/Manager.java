package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Manager {
	private int ManagerId;
	private String ManagerAccount;
	private String ManagerPassword;
	private int ManagerState;
	@Id
	@GeneratedValue
	public int getManagerId() {
		return ManagerId;
	}
	public void setManagerId(int managerId) {
		ManagerId = managerId;
	}
	public String getManagerAccount() {
		return ManagerAccount;
	}
	public void setManagerAccount(String managerAccount) {
		ManagerAccount = managerAccount;
	}
	public String getManagerPassword() {
		return ManagerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		ManagerPassword = managerPassword;
	}
	public int getManagerState() {
		return ManagerState;
	}
	public void setManagerState(int managerState) {
		ManagerState = managerState;
	}
	public Manager(String ManagerAccount, String ManagerPassword, int ManagerState){
		this.ManagerAccount = ManagerAccount;
		this.ManagerPassword = ManagerPassword;
		this.ManagerState = ManagerState;
	}
	public Manager(){}
}
