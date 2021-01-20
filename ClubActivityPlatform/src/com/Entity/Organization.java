package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Organization {
	private int organizationId;// ��֯ID
	private String organizationName;// ��֯����
	private String organizationIntroduction;// ��֯���
	private String organizationPic;// ��֯��Ƭ·��
	
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
