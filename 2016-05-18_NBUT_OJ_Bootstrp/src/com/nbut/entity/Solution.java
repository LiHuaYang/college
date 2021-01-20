package com.nbut.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nbut.utils.WebUitls;

import net.sf.json.JSONObject;


public class Solution {

	private int solution_id;
	private int problem_id;
	private String user_id;
	private int time;
	private int memory;
	private String in_date;
	private int result;
	private int language;
	private String ip;
	private int contest_id;
	private int valid;
	private int num;
	private int code_length;
	private String judgetime;
	private String pass_rate;
	
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
	public String getIn_date() {
		return in_date;
	}
	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getLanguage() {
		return language;
	}
	public void setLanguage(int language) {
		this.language = language;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getContest_id() {
		return contest_id;
	}
	public void setContest_id(int contest_id) {
		this.contest_id = contest_id;
	}
	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCode_length() {
		return code_length;
	}
	public void setCode_length(int code_length) {
		this.code_length = code_length;
	}
	public String getJudgetime() {
		return judgetime;
	}
	public void setJudgetime(String judgetime) {
		this.judgetime = judgetime;
	}
	public String getPass_rate() {
		return pass_rate;
	}
	public void setPass_rate(String pass_rate) {
		this.pass_rate = pass_rate;
	}
	public Solution() {};
	public Solution(int codeLength,String userId,int problemId,String inTime,String ip,int language) {
		this.code_length = codeLength;
		this.user_id = userId;
		this.problem_id = problemId;
		this.in_date = inTime;
		this.ip = ip;
		this.language = language;
	}
	public Solution (ResultSet set) throws SQLException {

		if (WebUitls.isExistColumn(set, "solution_id")) {
			this.solution_id = set.getInt("solution_id");
		}
		if (WebUitls.isExistColumn(set, "problem_id")) {
			this.problem_id = set.getInt("problem_id");
		}
		if (WebUitls.isExistColumn(set, "user_id")) {
			this.user_id = set.getString("user_id");
		}
		
		if (WebUitls.isExistColumn(set, "time")) {
			this.time = set.getInt("time");
		}
		
		if (WebUitls.isExistColumn(set, "memory")) {
			this.memory = set.getInt("memory");
		}
		
		if (WebUitls.isExistColumn(set, "in_date")) {
			this.in_date = set.getString("in_date");
		}
		
		if (WebUitls.isExistColumn(set, "result")) {
			this.result = set.getInt("result");
		}

		if (WebUitls.isExistColumn(set, "language")) {
			this.language = set.getInt("language");
		}
		
		if (WebUitls.isExistColumn(set, "ip")) {
			this.ip = set.getString("ip");
		}
		
		if (WebUitls.isExistColumn(set, "contest_id")) {
			this.contest_id = set.getInt("contest_id");
		}
		
		if (WebUitls.isExistColumn(set, "valid")) {
			this.valid = set.getInt("valid");
		}
		
		if (WebUitls.isExistColumn(set, "num")) {
			this.num = set.getInt("num");
		}
		
		if (WebUitls.isExistColumn(set, "code_length")) {
			this.code_length = set.getInt("code_length");
		}
		
		if (WebUitls.isExistColumn(set, "judgetime")) {
			this.judgetime = set.getString("judgetime");
		}
		
		if (WebUitls.isExistColumn(set, "pass_rate")) {
			this.pass_rate = set.getString("pass_rate");
		}
	}
	public JSONObject toJson() {
		JSONObject jsonData = new JSONObject();
		jsonData.put("solution_id", this.solution_id);
		jsonData.put("problem_id", this.problem_id);
		jsonData.put("user_id", this.user_id);
		jsonData.put("time", this.time);
		jsonData.put("memory", this.memory);
		jsonData.put("in_date", this.in_date);
		jsonData.put("result", this.result);
		jsonData.put("language", this.language);
		jsonData.put("code_length", this.code_length);
		return jsonData;
	}

	@Override
	public String toString() {
		return "Solution [solution_id=" + solution_id + ", problem_id=" + problem_id + ", user_id=" + user_id
				+ ", time=" + time + ", memory=" + memory + ", in_date=" + in_date + ", result=" + result
				+ ", language=" + language + ", ip=" + ip + ", contest_id=" + contest_id + ", valid=" + valid + ", num="
				+ num + ", code_length=" + code_length + ", judgetime=" + judgetime + ", pass_rate=" + pass_rate + "]";
	}
	
}

