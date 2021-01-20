package com.nbut.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

public class Contest {
   private  int contest_id;  	//竞赛id
   private String title;     	//竞赛标题
   private String  start_time;	   //开始时间(年月日时分)
   private String  end_time;
   private String defunct;      //是否屏蔽（Y/N）
   private String description;  //描述
   private int  Private;        //公开/内部（0/1）
   private int langmask;        //语言
   private String password;     //密码
   
   private List<String> user_ids; // 竞赛参加者的ID
   private List<String> problem_ids; // 竞赛包含的问题ID
   
   public Contest(String title,String start_time,String end_time,String defunct,String description,int Private,int langmask,String password){
	 super();
	 this.title = title;
	 this.start_time = start_time;
	 this.end_time = end_time;
	 this.defunct = defunct;
	 this.description = description;
	 this.Private = Private;
	 this.langmask = langmask;
	 this.password = password;
   }
   
   public Contest (ResultSet set) {
	   try {
		   while (set.next()) {
			   this.contest_id = (int) set.getObject("contest_id");
			   this.title = (String) set.getObject("title");
			   Date start = (Date) set.getObject("start_time");
			   SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			   this.start_time = s.format(start);
			   Date end = (Date) set.getObject("end_time");
			   this.end_time = s.format(end);
			   this.defunct = (String) set.getObject("defunct");
			   this.description = (String) set.getObject("description");
			   this.Private = (int) set.getObject("Private");
			   this.langmask = (int) set.getObject("langmask");
			   this.password = (String) set.getObject("password");
			   String uIds = (String)set.getObject("user_ids");
			   this.user_ids = Arrays.asList(uIds.split(","));
			   String pIds = (String)set.getObject("problem_ids");
			   this.problem_ids =  Arrays.asList(pIds.split(","));
		   }
		
		} catch (SQLException e) {
			throw new RuntimeException("Contest--Contest ERROR!!");
		}
	}
	public JSONObject toJson() {
		JSONObject jsonData = new JSONObject();
		jsonData.put("contest_id", this.contest_id);
		jsonData.put("title", this.title);
		jsonData.put("start_time", this.start_time);
		jsonData.put("end_time", this.end_time);
		jsonData.put("defunct", this.defunct);
		jsonData.put("description", this.description);
		jsonData.put("Private", this.Private);
		jsonData.put("langmask", this.langmask);
		jsonData.put("password", this.password);
		jsonData.put("user_ids", this.user_ids);
		jsonData.put("problem_ids", this.problem_ids);
		return jsonData;
	}
	
	
	
	@Override
	public String toString() {
		return "Contest [contest_id=" + contest_id + ", title=" + title + ", start_time=" + start_time + ", end_time="
				+ end_time + ", defunct=" + defunct + ", description=" + description + ", Private=" + Private
				+ ", langmask=" + langmask + ", password=" + password + ", user_ids=" + user_ids + ", problem_ids="
				+ problem_ids + "]";
	}
	public int getContest_id() {
		return contest_id;
	}
	public void setContest_id(int contest_id) {
		this.contest_id = contest_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getDefunct() {
		return defunct;
	}
	public void setDefunct(String defunct) {
		this.defunct = defunct;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrivate() {
		return Private;
	}
	public void setPrivate(int private1) {
		Private = private1;
	}
	public int getLangmask() {
		return langmask;
	}
	public void setLangmask(int langmask) {
		this.langmask = langmask;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
