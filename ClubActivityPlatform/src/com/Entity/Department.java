package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department {
	private int departmentId;// 部门ID
	private String departmentName;// 部门名称
	private int departmentBelongId; // 所属组织
	private String departmentIntroduction;// 部门介绍
	private String departmentPic;// 部门图片
	public Department(){};
	@Id
	@GeneratedValue
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getDepartmentBelongId() {
		return departmentBelongId;
	}

	public void setDepartmentBelongId(int departmentBelongId) {
		this.departmentBelongId = departmentBelongId;
	}

	public String getDepartmentIntroduction() {
		return departmentIntroduction;
	}

	public void setDepartmentIntroduction(String departmentIntroduction) {
		this.departmentIntroduction = departmentIntroduction;
	}

	public String getDepartmentPic() {
		return departmentPic;
	}

	public void setDepartmentPic(String departmentPic) {
		this.departmentPic = departmentPic;
	}

	@Override
	public String toString() {
		return "Department [departmentBelongId=" + departmentBelongId
				+ ", departmentId=" + departmentId
				+ ", departmentIntroduction=" + departmentIntroduction
				+ ", departmentName=" + departmentName + ", departmentPic="
				+ departmentPic + "]";
	}

}
