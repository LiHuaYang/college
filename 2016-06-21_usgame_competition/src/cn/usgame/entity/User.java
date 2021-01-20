package cn.usgame.entity;

import java.text.SimpleDateFormat;

import com.google.gson.JsonObject;

public class User {
	private String phonenumber;      //注册手机号码
	private String password;         //密码
	private String name;             //姓名
	private String school;           //学校
	private String grade;            //年级
	private String iDcard;           //身份证号
	private String contactNumber;    //联系电话
	private String address;          //地址
	private String motto;            //座右铭
	private String sex;              //性别
	
	public User() {}
	
	public User(String phonenumber, String password, String name, String school, String grade, String iDcard,
			String contactNumber, String address, String motto, String sex) {
		super();
		this.phonenumber = phonenumber;
		this.password = password;
		this.name = name;
		this.school = school;
		this.grade = grade;
		this.iDcard = iDcard;
		this.contactNumber = contactNumber;
		this.address = address;
		this.motto = motto;
		this.sex = sex;
	}

	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getiDcard() {
		return iDcard;
	}
	public void setiDcard(String iDcard) {
		this.iDcard = iDcard;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "User [phonenumber=" + phonenumber + ", password=" + password + ", name=" + name + ", school=" + school
				+ ", grade=" + grade + ", iDcard=" + iDcard + ", contactNumber=" + contactNumber + ", address="
				+ address + ",  motto=" + motto + ", sex=" + sex + "]";
	}

	public JsonObject toJSON() {
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("phonenumber", this.phonenumber);
		jsonData.addProperty("password", this.password);
		jsonData.addProperty("name", this.name);
		jsonData.addProperty("school",this.school );
		jsonData.addProperty("grade", this.grade);
		jsonData.addProperty("iDcard", this.iDcard);
		jsonData.addProperty("contactNumber", this.contactNumber);
		jsonData.addProperty("address", this.address);
		jsonData.addProperty("motto", this.motto);
		jsonData.addProperty("sex", this.sex);
		return jsonData;
	}
	
     
     
     
}
