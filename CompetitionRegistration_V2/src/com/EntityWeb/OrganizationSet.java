package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



public class OrganizationSet {
	
	List <Organization> organizations;
	
	// 默认构造函数
	public OrganizationSet () {}
	
//	public OrganizationSet (List <Organization> organizations) {
//		
//		this.organizations = organizations;
//	}
	
	// 客户端数据构造函数
	public OrganizationSet(JSONArray array) {
		int length = array.size();
		organizations = new ArrayList<Organization>();
		for (int i=0; i<length; i++) {
			Organization organization= new Organization(JSONObject.fromObject(array.get(i)));
			this.organizations.add(organization);
		}
	}
	
	// 数据库数据构造函数
	public OrganizationSet(ResultSet res) throws SQLException {
		organizations = new ArrayList<Organization>();
		
		while (res.next()) {
			Organization organization = new Organization(res);
			organizations.add(organization);
		}
	}
	
	// 设置竞赛ID
	public int setContestId (int contestId) {
		int length = this.getSize();
		for (int i=0; i<length; i++) {
			Organization organization = organizations.get(i);
			organization.setContestId(contestId);
		}
		return contestId;
	}
	
	// 获取组织列表的大小
	public int getSize(){
		return organizations.size();
	}
	
	public Organization getItem (int i) {
		return this.organizations.get(i);
	}
	
	public JSONArray toJson () {
		JSONArray array = new JSONArray();
		
		for (Organization organization : this.organizations) {
			JSONObject jsonObject = organization.toJson();
			array.add(jsonObject);
		}
		
		return array;
	}
}
