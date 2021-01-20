package com.BasicEntity.V2;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class OrganizerSet {
	
	private List<Organizer> orgaizers ;
	
	// 客户端数据构造函数
	public OrganizerSet(JSONArray array) {
		int length = array.size();
		orgaizers = new ArrayList<Organizer>();
		
		for (int i=0; i<length; i++) {
			Organizer organizer = new Organizer(JSONObject.fromObject(array.get(i)));
			this.orgaizers.add(organizer);
		}
	}
	
	// 获取数据库插入语句
	public String getInsertSql() {
		// return "";
		int length = this.getSize();
		StringBuilder builder = new StringBuilder();
		
		for (int i=0; i<length; i++) {
			builder.append( this.orgaizers.get(i).getInsertSql());
		}
		return builder.toString();
	}
	
	// 设置竞赛ID
	public int setContestId (int contestId) {
		int length = this.getSize();
		
		for (int i=0; i<length; i++) {
			Organizer organizer = orgaizers.get(i);
			organizer.setContestId(contestId);
		}
		return contestId;
	}
	
	public Organizer getItem(int i) {
		return this.orgaizers.get(i);
	}
	// 获取组织列表的大小
	public int getSize(){
		return orgaizers.size();
	}
	
	public JSONArray toJson() {
		
		JSONArray array = new JSONArray();
		
		for (Organizer organizer : this.orgaizers) {
			JSONObject jsonObject = organizer.toJson();
			array.add(jsonObject);
		}
		return array;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
