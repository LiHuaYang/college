package com.Entity;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.Tool.MyConstant.GradeType;

@Entity
public class Grade {
	private int gradeId;// 等级ID
	private int userId;// 用户ID
	private int gradeBelongType;// 所属类型()
	private int gradeBelongId;// 所属ID
	private int userGrade;// 用户等级
	private String gradeContent;// 简介
	private String gradePic;// 职位照片
	
	public Grade(){};
	public Grade(int userId,int gradeBelongType,int gradeBelongId){
		this.userGrade=GradeType.MEMBER;
		this.userId=userId;
		this.gradeBelongId=gradeBelongId;
		this.gradeBelongType=gradeBelongType;
	}
	public HashMap<String, Object> toHashMap(){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("gradeId", this.gradeId);
		map.put("userId",this.userId);
		map.put("gradeBelongType", this.gradeBelongType);
		map.put("gradeBelongId", this.gradeBelongId);
		map.put("userGrade", this.userGrade);
		map.put("gradeContent", this.gradeContent);
		map.put("gradePic", this.gradePic);
		return map;
	}
	
	@Id
	@GeneratedValue
	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGradeBelongType() {
		return gradeBelongType;
	}

	public void setGradeBelongType(int gradeBelongType) {
		this.gradeBelongType = gradeBelongType;
	}

	public int getGradeBelongId() {
		return gradeBelongId;
	}

	public void setGradeBelongId(int gradeBelongId) {
		this.gradeBelongId = gradeBelongId;
	}

	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}

	public int getUserGrade() {
		return userGrade;
	}

	public void setGradeContent(String gradeContent) {
		this.gradeContent = gradeContent;
	}

	public String getGradeContent() {
		return gradeContent;
	}

	public void setGradePic(String gradePic) {
		this.gradePic = gradePic;
	}

	public String getGradePic() {
		return gradePic;
	}

	@Override
	public String toString() {
		return "Grade [gradeBelongId=" + gradeBelongId + ", gradeBelongType="
				+ gradeBelongType + ", gradeContent=" + gradeContent
				+ ", gradeId=" + gradeId + ", gradePic=" + gradePic
				+ ", userGrade=" + userGrade + ", userId=" + userId + "]";
	}
}
