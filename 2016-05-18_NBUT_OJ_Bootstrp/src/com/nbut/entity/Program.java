package com.nbut.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONObject;

/**
 * 
 *
 * 作者：ariclee		时间：2016年5月19日下午10:09:04
 */
public class Program {

	private int problem_id;    // 题目编号，主键
	private String title;    // 标题
	private String description;    // 题目描述
	private String input;    // 输入说明
	private String output;    // 输出说明
	private String sample_input;    // 输入参照
	private String sample_output;    // 输出参照
	private String spj;    // 是否为特别题目
	private String hint;    // 暗示
	private String source;    // 来源
	private String in_date;    // 加入时间
	private int time_limit;    // 限时（秒）
	private int memory_limit;    // 空间限制(MByte)
	private String defunct;    // 是否屏蔽（Y/N）
	private int accepted;    // 总ac次数
	private int submit;    // 总提交次数
	private String solved;    // 解答（未用）

	
	public Program() {}
	
	public Program(int problem_id, String title, String description, String input, String output, String sample_input,
			String sample_output, String spj, String hint, String source, String in_date, int time_limit,
			int memory_limit, String defunct, int accepted, int submit, String solved) {
		super();
		this.problem_id = problem_id;
		this.title = title;
		this.description = description;
		this.input = input;
		this.output = output;
		this.sample_input = sample_input;
		this.sample_output = sample_output;
		this.spj = spj;
		this.hint = hint;
		this.source = source;
		this.in_date = in_date;
		this.time_limit = time_limit;
		this.memory_limit = memory_limit;
		this.defunct = defunct;
		this.accepted = accepted;
		this.submit = submit;
		this.solved = solved;
	}


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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getInput() {
		return input;
	}


	public void setInput(String input) {
		this.input = input;
	}


	public String getOutput() {
		return output;
	}


	public void setOutput(String output) {
		this.output = output;
	}


	public String getSample_input() {
		return sample_input;
	}


	public void setSample_input(String sample_input) {
		this.sample_input = sample_input;
	}


	public String getSample_output() {
		return sample_output;
	}


	public void setSample_output(String sample_output) {
		this.sample_output = sample_output;
	}


	public String getSpj() {
		return spj;
	}


	public void setSpj(String spj) {
		this.spj = spj;
	}


	public String getHint() {
		return hint;
	}


	public void setHint(String hint) {
		this.hint = hint;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getIn_date() {
		return in_date;
	}


	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}


	public int getTime_limit() {
		return time_limit;
	}


	public void setTime_limit(int time_limit) {
		this.time_limit = time_limit;
	}


	public int getMemory_limit() {
		return memory_limit;
	}


	public void setMemory_limit(int memory_limit) {
		this.memory_limit = memory_limit;
	}


	public String getDefunct() {
		return defunct;
	}


	public void setDefunct(String defunct) {
		this.defunct = defunct;
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


	public String getSolved() {
		return solved;
	}


	public void setSolved(String solved) {
		this.solved = solved;
	}


	public Program (ResultSet set) throws SQLException {
		while (set.next()) {
			this.problem_id = (int) set.getObject("problem_id");
			this.title = (String) set.getObject("title");
			this.description = (String) set.getObject("description");
			this.input = (String) set.getObject("input");
			this.output = (String) set.getObject("output");
			this.sample_input = (String) set.getObject("sample_input");
			this.sample_output = (String) set.getObject("sample_output");
			this.hint = (String) set.getObject("hint");
			this.source = (String) set.getObject("source");
			this.time_limit = (int) set.getObject("time_limit");
			this.memory_limit = (int) set.getObject("memory_limit");
			this.accepted = (int) set.getObject("accepted");
			this.submit = (int) set.getObject("submit");
		}
	}


	@Override
	public String toString() {
		return "Program [problem_id=" + problem_id + ", title=" + title + ", description=" + description + ", input="
				+ input + ", output=" + output + ", sample_input=" + sample_input + ", sample_output=" + sample_output
				+ ", spj=" + spj + ", hint=" + hint + ", source=" + source + ", in_date=" + in_date + ", time_limit="
				+ time_limit + ", memory_limit=" + memory_limit + ", defunct=" + defunct + ", accepted=" + accepted
				+ ", submit=" + submit + ", solved=" + solved + "]";
	}
	public JSONObject toJson() {
		JSONObject jsonData = new JSONObject();
		jsonData.put("problem_id", this.problem_id);
		jsonData.put("title", this.title);
		jsonData.put("description", this.description);
		jsonData.put("input", this.input);
		jsonData.put("output", this.output);
		jsonData.put("sample_input", this.sample_input);
		jsonData.put("sample_output", this.sample_output);
		jsonData.put("hint", this.hint);
		jsonData.put("source", this.source);
		jsonData.put("time_limit", this.time_limit);
		jsonData.put("memory_limit", this.memory_limit);
		jsonData.put("accepted", this.accepted);
		jsonData.put("submit", this.submit);
		return jsonData;
	}
	
	
	
}


/************************************************************

	problem_id		int			11		N		题目编号，主键
	title			varchar		200		N		标题
	description		text				Y		题目描述
	inupt			text				Y		输入说明
	output			text				Y		输出说明
	sample_input	text				Y		输入参照
	sample_output	text				Y		输出参照
	spj				char		1		N		是否为特别题目
	hint			text				Y		暗示
	source			varchar		100		Y		来源
	in_date			datetime			Y		加入时间
	time_limit		int			11		N		限时（秒）
	memory_limit	int			11		N		空间限制(MByte)
	defunct			char		1		N		是否屏蔽（Y/N）
	accepted		int			11		Y		总ac次数
	submit			int			11		Y		总提交次数
	solved			int			11		Y		解答（未用）

************************************************************/