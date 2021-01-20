package com.BasicEntity.V2;

import net.sf.json.JSONObject;

public class Picture {

	private String id;
	private String picUrl;
	
	
	// 客户端数据
	public Picture(JSONObject jsonObj) {
		this.picUrl = jsonObj.getString("picUrl");
		this.id = jsonObj.getString("id");
	}


	public String getPicUrl() {
		return picUrl;
	}
}
