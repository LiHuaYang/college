 package com.nbut.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nbut.utils.WebUitls;

import net.sf.json.JSONObject;

public class ContestSet {
	   private  int contest_id;  	//竞赛id
	   private String title;     	//竞赛标题
	   private String start_time;	//开始时间(年月日时分)
	   private String end_time;     //结束时间(年月日时分)
	   private int  Private;        //公开/内部（0/1）
	   private String creator;      //创建者
	   private String defunct;      //是否屏蔽
	   
	   public ContestSet (ResultSet set) throws SQLException {
			this.contest_id = set.getInt("contest_id");
			this.title = set.getString("title");
			this.start_time = set.getString("start_time");
			this.end_time = set.getString("end_time");
			this.Private = set.getInt("Private");
			if (WebUitls.isExistColumn(set, "user_id")) {
				this.creator = set.getString("user_id");
			} else {
				this.creator = null;
			}
			
			this.defunct = set.getString("defunct");
		}
		public JSONObject toJson() {
			JSONObject jsonData = new JSONObject();
			jsonData.put("contest_id", this.contest_id);
			jsonData.put("title", this.title);
			jsonData.put("start_time", this.start_time);
			jsonData.put("end_time", this.end_time);
			jsonData.put("Private", this.Private);
			jsonData.put("creator", this.creator);
			jsonData.put("defunct", this.defunct);
			return jsonData;
		}
		@Override
		public String toString() {
			return "ContestSet [contest_id=" + contest_id + ", title=" + title + ", start_time=" + start_time
					+ ", end_time=" + end_time + ", Private=" + Private + ", creator=" + creator + ", defunct="
					+ defunct + "]";
		}
		
}
