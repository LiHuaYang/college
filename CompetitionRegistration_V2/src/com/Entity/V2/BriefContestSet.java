package com.Entity.V2;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 简要的竞赛信息
 * @author Administrator
 *
 */
public class BriefContestSet {
	private List<BriefContest> contests;
	
	
	// 默认构造函数
	public BriefContestSet () {
		this.contests = new ArrayList<BriefContest>();
	}

	public BriefContestSet(JSONArray jsonArray) {
		int length = jsonArray.size();
		contests = new ArrayList<BriefContest>();
		
		for (int i=0; i<length; i++) {
			BriefContest briefContest = new BriefContest(JSONObject.fromObject(jsonArray.get(i)));
			contests.add(briefContest);
		}
	}
	
	
	// 获取竞赛简要信息Sql
	public String getQuerySql () {
		return this.contests.get(0).getQuerySql();
	}
	
	
	// 设置竞赛Set大赛的Id
	public void setCompetitionId (int competitionId) {
		
		for (BriefContest bf : this.contests) {
			bf.setCompetitionId(competitionId);
		}
	}
	
	public String getContestSubjects () {
		String name = null;
		
		for (BriefContest bc : this.contests) {
			name = name + bc.getSubject();
		}
		
		return name;
	}

	// 
	public void add (BriefContest briefContest) {
		this.contests.add(briefContest);
	}
	
	public BriefContest getItem () {
		return this.contests.get(0);
	}
	
	
	public JSONArray toJson() {
		JSONArray array = new JSONArray();
		for (BriefContest briefContest : this.contests) {
			JSONObject jsonObject = briefContest.toJson();
			array.add(jsonObject);
		}
		return array;
	}
	
	
	
	
	
	
	
	
	
	
}
