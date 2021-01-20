package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Organization {
	private int organizationId;// 组织ID
	private String organizationName;// 组织名称
	private String organizationIntroduction;// 组织简介
	private String organizationPic;// 组织照片路径
	
	public Organization(){};
	@Id
	@GeneratedValue
	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationIntroduction() {
		return organizationIntroduction;
	}

	public void setOrganizationIntroduction(String organizationIntroduction) {
		this.organizationIntroduction = organizationIntroduction;
	}

	public String getOrganizationPic() {
		return organizationPic;
	}

	public void setOrganizationPic(String organizationPic) {
		this.organizationPic = organizationPic;
	}

	@Override
	public String toString() {
		return "Organization [organizationId=" + organizationId
				+ ", organizationIntroduction=" + organizationIntroduction
				+ ", organizationName=" + organizationName
				+ ", organizationPic=" + organizationPic + "]";
	}

}
