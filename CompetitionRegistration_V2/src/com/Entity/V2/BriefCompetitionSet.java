package com.Entity.V2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;

/**
 * 大赛的简要信息实体类（列表）
 * 
 * @author Administrator
 * 
 */
public class BriefCompetitionSet {
	private List<BriefCompetition> briefCompetitons;

	public List<BriefCompetition> getBriefCompetitons() {
		return briefCompetitons;
	}

	// 默认构造函数
	public BriefCompetitionSet() {
	}

	// 数据库构造函数
	public BriefCompetitionSet(ResultSet rs, String condition) throws SQLException {
		briefCompetitons = new ArrayList<BriefCompetition>();

		while (rs.next()) {
			BriefCompetition curBriefCompetition = new BriefCompetition(rs,condition);
			this.briefCompetitons.add(curBriefCompetition);
		}
	}

	// 客户端数据
	public JSONArray toJson(String condititon) {
		JSONArray array = new JSONArray();

		for (BriefCompetition bc : this.briefCompetitons) {
			array.add(bc.toJson(condititon));
		}
		return array;
	}

	// 设置竞赛组的大赛Id
	public void setContestSetCompetitionId() {
		for (BriefCompetition bf : this.briefCompetitons) {
			bf.setContestSetCompetitionId();
		}
	}
	// 获取List大小
	public int getSize () {
		return this.briefCompetitons.size();
	}
	
	// 获取单个
	public BriefCompetition getItem (int i) {
		return this.briefCompetitons.get(i);
	}
	
	
}

// rs.last(); // 将指针指向最后一行
// int rows = rs.getRow(); // 获取最后一行的行数
// System.out.println("这个结果集一共有" + rows + "行");
//
// ResultSetMetaData rsm = rs.getMetaData(); // 获得列集
// int col = rsm.getColumnCount(); // 获得列的个数
// String colName[] = new String[col];
//
// for (int i=0; i<col; i++) {
// System.out.println(rsm.getColumnName(i + 1));
// }
//
// rs.beforeFirst(); // 初始结果集指针

