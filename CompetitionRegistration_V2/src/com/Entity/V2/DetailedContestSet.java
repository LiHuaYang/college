package com.Entity.V2;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class DetailedContestSet {

	private List<DetailedContest> detailedContests; // 科目详细信息列表
	
	
	// 默认构造函数
	public DetailedContestSet() {}
	
	// 客户端数据构造函数
	public DetailedContestSet(JSONArray array) {
		
		detailedContests = new ArrayList<DetailedContest>();
		
		int length = array.size();
		for (int i=0; i<length; i++) {
			DetailedContest contest = new DetailedContest(JSONObject.fromObject(array.get(i)));
			this.detailedContests.add(contest);
		}
	}
	
	// 设置大赛ID
	public int setCompetitionId (int competitionId) {
		int length = this.getSize();
		
		for (int i=0; i<length; i++) {
			this.getItem(i).setCompetitionId(competitionId);
		}
		return competitionId;
	}
	
	// 设置竞赛ID
	public void setContestId (int id) {
		int length = this.getSize();
		
		for (int i=0; i<length; i++,id++) {
			this.getItem(i).setContestId(id+1);
		}
	}
	
	// 获取竞赛数据库插入语句
	public String getInsertSql() {
		StringBuilder builder = new StringBuilder();
		
		int length = this.getSize();
		for (int i=0; i<length; i++) {
			builder.append(this.getItem(i).getInsertSql());
		}
		
		return builder.toString();
	}
	
	// 获取单个竞赛信息
	public DetailedContest getItem(int i){
		return detailedContests.get(i);
	}
	
	// 获取竞赛列表的大小
	public int getSize() {
		return this.detailedContests.size();
	}
	
	public JSONArray toJson() {
		JSONArray array = new JSONArray();
		
		for (DetailedContest contest : this.detailedContests) {
			JSONObject jsonObject = contest.toJson();
			array.add(jsonObject);
		}
		
		return array;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
