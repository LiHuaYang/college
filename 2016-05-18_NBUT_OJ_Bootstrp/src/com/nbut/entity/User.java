package com.nbut.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

/**
 *
 * 增加用户权限
 *
 * 作者：ariclee		时间：2016年5月22日下午3:24:06
 */
public class User {

	private String user_id;
	private String email;
	private int submit; // 提交总次数
	private int solved; // 解决数
	private String defunct;
	private String ip;
	private Date accesstime;
	private String volume;
	private String language;
	private String password;
	private Date reg_time;
	private String nick;
	private String school;
	
	private List<String> privileges; // 用户权限列表
	
	public User (ResultSet set) throws SQLException {
		while (set.next()) {
			this.user_id = (String) set.getObject("user_id");
			this.email = (String) set.getObject("email");
			this.submit = (int) set.getInt("submit");
			this.solved = (int) set.getInt("solved");
//			this.defunct = (String) set.getObject("defunct");
			this.ip = (String) set.getObject("ip");
			this.accesstime = (Date) set.getObject("accesstime");
//			this.volume = (String) set.getObject("volume");
//			this.language = (String) set.getObject("language");
			this.password = (String) set.getObject("password");
//			this.reg_time = (Date) set.getObject("reg_time");
			this.nick = (String) set.getObject("nick");
			this.school = (String) set.getObject("school");
			
			String data = (String)set.getObject("privilege"); //String [] privileges = data.split(",");
			if (data==null) {
				return ;
			}
			this.privileges = new ArrayList<String>();
			this.privileges = Arrays.asList(data.split(","));	
		}
	}
	
	public User (String id, String password, String school, String nickname,String email, String clientIp) {
		this.user_id = id;
		this.password = password;
		this.school = school;
		this.nick = nickname;
		this.email = email;
		this.ip = clientIp;
	}
	
	public User() {
		
	}
	
	public String getPassword() {
		return password;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSubmit() {
		return submit;
	}

	public void setSubmit(int submit) {
		this.submit = submit;
	}

	public int getSolved() {
		return solved;
	}

	public void setSolved(int solved) {
		this.solved = solved;
	}

	public String getDefunct() {
		return defunct;
	}

	public void setDefunct(String defunct) {
		this.defunct = defunct;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getAccesstime() {
		return accesstime;
	}

	public void setAccesstime(Date accesstime) {
		this.accesstime = accesstime;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getReg_time() {
		return reg_time;
	}

	public void setReg_time(Date reg_time) {
		this.reg_time = reg_time;
	}

	public String now() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public List<String> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<String> privileges) {
		this.privileges = privileges;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", email=" + email + ", submit=" + submit + ", solved=" + solved
				+ ", defunct=" + defunct + ", ip=" + ip + ", accesstime=" + accesstime + ", volume=" + volume
				+ ", language=" + language + ", password=" + password + ", reg_time=" + reg_time + ", nick=" + nick
				+ ", school=" + school + ", privileges=" + privileges + "]";
	}

	
	
}
