package com.nbut.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nbut.utils.WebUitls;

import net.sf.json.JSONObject;


public class ProgramSet {

	private int problem_id;// 题目编号，主键
	private String title;// 标题
	private String source;// 来源
	
	private int accepted;// 总ac次数
	private int submit;// 总提交次数
	private String in_date;//题目提交时间
	private String defunct;//是否屏蔽
	
	
	
	public int getProblem_id() {
		return problem_id;
	}
	public void setProblem_id(int problem_id) {
		this.problem_id = problem_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getAccepted() {
		return accepted;
	}

	public void setAccepted(int accepted) {
		this.accepted = accepted;
	}

	public int getSubmit() {
		return submit;
	}

	public void setSubmit(int submit) {
		this.submit = submit;
	}

	public String getIn_date() {
		return in_date;
	}

	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}

	public String getDefunct() {
		return defunct;
	}

	public void setDefunct(String defunct) {
		this.defunct = defunct;
	}
	
	
	public ProgramSet() {
	
	}

	
	public ProgramSet (ResultSet set) throws SQLException {
		if (WebUitls.isExistColumn(set, "problem_id")) {
			this.problem_id = set.getInt("problem_id");
		}
		if (WebUitls.isExistColumn(set, "title")) {
			this.title = set.getString("title");
		}
		if (WebUitls.isExistColumn(set, "source")) {
			this.source = set.getString("source");
		}
		if (WebUitls.isExistColumn(set, "submit")) {
			this.submit = set.getInt("submit");
		}
		if (WebUitls.isExistColumn(set, "accepted")) {
			this.accepted = set.getInt("accepted");
		}
		
		if (WebUitls.isExistColumn(set, "in_date")) {
			Date temp_in_date = (Date) set.getObject("in_date");
			SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			this.in_date = s.format(temp_in_date);
		}
		if (WebUitls.isExistColumn(set, "defunct")) {
			this.defunct = set.getString("defunct");
		}
	}
	
	@Override
	public String toString() {
		return "ProgramSet [problem_id=" + problem_id + ", title=" + title + ", source=" + source + ", accepted="
				+ accepted + ", submit=" + submit + "]";
	}

	public JSONObject toJson(int type) {
		JSONObject jsonData = new JSONObject();
		if(type == 1) {
			jsonData.put("source", this.source);
			jsonData.put("accepted", this.accepted);
			jsonData.put("submit", this.submit);
		}
		else if(type == 2){
			jsonData.put("in_date", this.in_date);
			jsonData.put("defunct",this.defunct);
		}
		jsonData.put("problem_id", this.problem_id);
		jsonData.put("title", this.title);
		
		return jsonData;
	}

}
