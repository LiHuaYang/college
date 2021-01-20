package com.EntityWeb;

import java.sql.ResultSet;
import java.sql.SQLException;
import net.sf.json.JSONObject;

import com.Tool.sql.SqlHelper;


/**
 * 大赛承办方类
 * @author Administrator
 */
public class Organization {

	private int contestId;
	private	int	OrganizationId	;//	承办方id
	private	String	OrganizationName	;//	承办方名称
	private	String	OrganizationAddress	;//	承办方地址
	private	int	OrganizationStation	;//	状态
	private	String	OrganizationTel	;//	联系电话
	private	String	OrganizationContacts	;//	联系人
	
	// 默认构造函数
	public Organization () {}

	// 客户端数据构造函数
	public Organization (JSONObject jsonObject) {
		
		if (jsonObject.containsKey("OrganizationName")) {
			this.OrganizationName = jsonObject.getString("OrganizationName");
		}
		else {
			this.OrganizationName = null;
		}
		if (jsonObject.containsKey("OrganizationAddress")) {
			this.OrganizationAddress = jsonObject.getString("OrganizationAddress");
		}
		else {
			this.OrganizationAddress = null;
		}
		if (jsonObject.containsKey("OrganizationStation")) {
			this.OrganizationStation = jsonObject.getInt("OrganizationStation");
		}
		else {
			this.OrganizationStation = 0; // TODO:组织的默认状态
		}
		if (jsonObject.containsKey("OrganizationTel")) {
			this.OrganizationTel = jsonObject.getString("OrganizationTel");
		}
		else {
			this.OrganizationTel = null;
		}
		if (jsonObject.containsKey("OrganizationContacts")) {
			this.OrganizationContacts = jsonObject.getString("OrganizationContacts");
		}
		else {
			this.OrganizationContacts = null;
		}
	}
	
	// 数据库数据构造函数
	public Organization (ResultSet resultSet) throws SQLException {
		if (resultSet.findColumn("OrganizationName") > 0) {
			this.OrganizationName = resultSet.getString("OrganizationName");
		}
		if (resultSet.findColumn("OrganizationAddress") > 0) {
			this.OrganizationAddress = resultSet.getString("OrganizationAddress");
		}
		if (resultSet.findColumn("OrganizationStation") > 0) {
			this.OrganizationStation = resultSet.getInt("OrganizationStation");
		}
		if (resultSet.findColumn("OrganizationTel") > 0) {
			this.OrganizationTel = resultSet.getString("OrganizationTel");
		}
		if (resultSet.findColumn("OrganizationContacts") > 0) {
			this.OrganizationContacts = resultSet.getString("OrganizationContacts");
		}
	}
	
	
	public String getOrganizationAddress() {
		return OrganizationAddress;
	}

	public void setOrganizationAddress(String organizationAddress) {
		OrganizationAddress = organizationAddress;
	}

	public int getOrganizationStation() {
		return OrganizationStation;
	}

	public void setOrganizationStation(int organizationStation) {
		OrganizationStation = organizationStation;
	}

	public String getOrganizationTel() {
		return OrganizationTel;
	}

	public void setOrganizationTel(String organizationTel) {
		OrganizationTel = organizationTel;
	}

	public String getOrganizationContacts() {
		return OrganizationContacts;
	}

	public void setOrganizationContacts(String organizationContacts) {
		OrganizationContacts = organizationContacts;
	}

	public int getContestId() {
		return contestId;
	}

	public Organization(int	OrganizationId,String OrganizationName){
		this.OrganizationId=OrganizationId;
		this.OrganizationName=OrganizationName;
	}
	
	
	// 获取插入语句
	public String getInsertSql () {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Insert Into Organization (");
		builder.append(new SqlHelper().getModelPro(this));
		builder.append(") Value (");
		builder.append(this.getProVal());
		builder.append(")");
		
		return builder.toString();
	}
	
	
	
	// 获取类属性的值
	public String getProVal () {
		StringBuilder builder = new StringBuilder();
		
		builder.append( "'" + this.OrganizationName + ".," );
		builder.append( "'" + this.OrganizationAddress + "'," );
		builder.append( "'" + this.OrganizationStation + "'," );
		builder.append( "'" + this.OrganizationTel + "',");
		builder.append( "'" + this.OrganizationContacts + "'" );
		
		return builder.toString();
	}
	
	
	// 获取数据库查询语句
	public String getQuerySql () {
		
		StringBuilder builder = new StringBuilder();
		builder.append("Select * from Organization");
		return builder.toString();
	}
	
	public void setContestId (int contestId) {
		this.contestId = contestId;
	}
	
	public JSONObject toJson () {
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("OrganizationId",this.OrganizationId);
		jsonObject.put("OrganizationName",this.OrganizationId);
		jsonObject.put("OrganizationAddress",this.OrganizationId);
		jsonObject.put("OrganizationStation",this.OrganizationId);
		jsonObject.put("OrganizationTel",this.OrganizationId);
		jsonObject.put("OrganizationContacts",this.OrganizationId);
		return jsonObject;
	}
	
	public int getOrganizationId() {
		return OrganizationId;
	}

	public void setOrganizationId(int organizationId) {
		OrganizationId = organizationId;
	}

	public String getOrganizationName() {
		return OrganizationName;
	}

	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}
}

/*********
遍历类属性：
	Iterator iterator = jsonObject.keys();
	while(iterator.hasNext()){					
		String key = (String) iterator.next();	       
		String value = jsonObject.getString(key);
	}

private int contestId;
private	int	OrganizationId	;//	承办方id
private	String	OrganizationName	;//	承办方名称
private	String	OrganizationAddress	;//	承办方地址
private	int	OrganizationStation	;//	状态
private	String	OrganizationTel	;//	联系电话
private	String	OrganizationContacts	;//	联系人
*/



