package cn.usgame.entity_dto;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.usgame.entity.User;

public class UserForm {
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
	
	public UserForm () {};
	public User toUser() {
		User user = new User();
		user.setPhonenumber(this.phonenumber);
		user.setPassword(this.password);
		user.setName(this.name);
		user.setSchool(this.school);
		user.setGrade(this.grade);
		user.setiDcard(this.iDcard);
		user.setContactNumber(this.contactNumber);
		user.setAddress(this.address);
		user.setMotto(this.motto);
		user.setSex(this.sex);
		
		return user;
	}
	
	
	public UserForm (Map<String, String[]> map) {
		this.phonenumber = map.get("phonenumber")[0];
		this.name = map.get("name")[0];
		this.school = map.get("school")[0];
		this.grade = map.get("grade")[0];
		this.iDcard = map.get("iDcard")[0];
		this.contactNumber = map.get("contactNumber")[0];
		this.address = map.get("address")[0];
		this.motto = map.get("motto")[0];
		this.sex = map.get("sex")[0];
	//	this.password = map.get("password")[0];
	}
	
	//验证手机号码合法性
	public boolean  judgePhone(String phonenumber) {
			//电信号码格式
			Pattern p = Pattern.compile("(^1(33|53|77|8[019])\\d{8}$)|(^1700\\d{7}$)");
			Matcher m = p.matcher(phonenumber);
			boolean flag= m.matches();
			
			//联通号码格式
			Pattern p1 = Pattern.compile("(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^1709\\d{7}$)");
			Matcher m1 = p1.matcher(phonenumber);
			boolean flag1= m1.matches();
			
			//移动号码格式
			Pattern p2 = Pattern.compile("(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)");
			Matcher m2 = p2.matcher(phonenumber);
			boolean flag2= m2.matches();
			
			if(flag||flag1||flag2) {
				return true;
			}
			else {
				return false;
			}
		}
	
	//验证性别
	public  boolean  judgeSex() {
		if(this.sex.equals("男")||this.sex.equals("女")||this.sex.equals("")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//验证身份证号
	public boolean  judgeiDcard() {
		if (this.iDcard.equals("")) {
			return true;
		}
		else {
			Pattern p = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
			Matcher m = p.matcher(this.iDcard);
			boolean flag= m.matches();
			
			Pattern p1 = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$");
			Matcher m1= p1.matcher(this.iDcard);
			boolean flag1= m1.matches();
			
			if(flag||flag1) {
				return true;
			}
			else {
				return false;
			}
		}
		
	}
	//验证联系电话
	public boolean  judgeContactNumber() {
		if(this.contactNumber.equals("")) {
			return true;
		}
		else {
			//电信号码格式
			Pattern p = Pattern.compile("(^1(33|53|77|8[019])\\d{8}$)|(^1700\\d{7}$)");
			Matcher m = p.matcher(this.contactNumber);
			boolean flag= m.matches();
			
			//联通号码格式
			Pattern p1 = Pattern.compile("(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^1709\\d{7}$)");
			Matcher m1 = p1.matcher(this.contactNumber);
			boolean flag1= m1.matches();
			
			//移动号码格式
			Pattern p2 = Pattern.compile("(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)");
			Matcher m2 = p2.matcher(this.contactNumber);
			boolean flag2= m2.matches();
			
			if(flag||flag1||flag2) {
				return true;
			}
			else {
				return false;
			}
		}
		       
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
	
	
	
	
	

}
