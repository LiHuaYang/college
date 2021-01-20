package com.nbut.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nbut.utils.WebUitls;

import net.sf.json.JSONObject;


public class SolutionSet {
	private int solution_id;
	private int problem_id;
	private String user_id;
	private int result;
	private int time;
	private int memory;
	private int language;
	private int code_length;
	private String in_date;
	private double pass_rate; // 答案正确率
	
	
	public double getPass_rate() {
		return pass_rate;
	}
	public void setPass_rate(double pass_rate) {
		this.pass_rate = pass_rate;
	}
	public SolutionSet () {}
	public int getSolution_id() {
		return solution_id;
	}

	public void setSolution_id(int solution_id) {
		this.solution_id = solution_id;
	}

	public int getProblem_id() {
		return problem_id;
	}

	public void setProblem_id(int problem_id) {
		this.problem_id = problem_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public int getCode_length() {
		return code_length;
	}

	public void setCode_length(int code_length) {
		this.code_length = code_length;
	}

	public String getIn_date() {
		return in_date;
	}

	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}

	public SolutionSet (ResultSet set) throws SQLException {
		this.solution_id = set.getInt("solution_id");
		this.problem_id = set.getInt("problem_id");
		this.user_id = set.getString("user_id");
		this.time = set.getInt("time");
		this.memory = set.getInt("memory");
		this.in_date = set.getString("in_date");
		this.result = set.getInt("result");
		this.language = set.getInt("language");
		this.code_length = set.getInt("code_length");
		if (WebUitls.isExistColumn(set, "pass_rate")) {
			this.pass_rate = set.getDouble("pass_rate"); 
		}
	}
	
	public JSONObject toJson(int judge) {
		JSONObject jsonData = new JSONObject();
		jsonData.put("solution_id", this.solution_id);
		jsonData.put("problem_id", this.problem_id);
		jsonData.put("user_id", this.user_id);
		jsonData.put("time", this.time);
		jsonData.put("memory", this.memory);
		jsonData.put("in_date", this.in_date);
		jsonData.put("result", this.result);
		jsonData.put("code_length", this.code_length);
		jsonData.put("pass_rate", this.pass_rate);
		String temp = null;
		switch (this.language) {
		case 0:
			temp = new String("C");
			break;
		case 1:
			temp = new String("C++");
			break;
		case 2:
			temp = new String("Pascal");
			break;
		case 3:
			temp = new String("Java");
			break;
		case 4:
			temp = new String("Ruby");
			break;
		case 5:
			temp = new String("Bash");
			break;
		case 6:
			temp = new String("Python");
			break;
		case 7:
			temp = new String("PHP");
			break;
		case 8:
			temp = new String("Perl");
			break;
		case 9:
			temp = new String("C#");
			break;
		case 10:
			temp = new String("Obj-C");
			break;
		case 11:
			temp = new String("FreeBasic");
			break;
		case 12:
			temp = new String("Schema");
			break;
		case 13:
			temp = new String("Clang");
			break;
		case 14:
			temp = new String("Clang++");
			break;
		case 15:
			temp = new String("Lua");
			break;
		case 16:
			temp = new String("Swift");
			break;
		}
		if(judge == 0) {
			jsonData.put("language", temp);
		}
		else if(judge == 1) {
			String temp1 = temp;
			temp = new String("<a href='seeCode.html?problem_id="+this.problem_id+"&solution_Id="+this.getSolution_id()+"'>"+temp1+"</a>/<a href='submit_problem.html?problem_id="+this.problem_id+"&solution_Id="+this.getSolution_id()+"'>Edit</a>");
			jsonData.put("language", temp);
		}
		return jsonData;
	}
	
}
