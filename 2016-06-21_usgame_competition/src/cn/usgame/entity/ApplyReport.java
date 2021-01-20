package cn.usgame.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonObject;

public class ApplyReport {
	private int applyReportId;//报名Id
	private int applyReportState;//报名状态
	private String name;//报名人姓名
	private String idCard;//身份证号
	private String school;//学校
	private int grade;//年级
	private String competitionName;//比赛名字
	private String competitionSubject;//比赛科目
	private int competitionGrade;//比赛年级
	private String contectName;//联系人名字
	private String contectPhone;//联系电话
	private String out_trade_no;// 
	private String phoneNumber;//电话号码
	private int money;//金额
	private Date applyReportTime;//报名时间
	
	public Date getApplyReportTime() {
		return applyReportTime;
	}
	public void setApplyReportTime(Date applyReportTime) {
		this.applyReportTime = applyReportTime;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getApplyReportId() {
		return applyReportId;
	}
	public void setApplyReportId(int applyReportId) {
		this.applyReportId = applyReportId;
	}
	public int getApplyReportState() {
		return applyReportState;
	}
	public void setApplyReportState(int applyReportState) {
		this.applyReportState = applyReportState;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getCompetitionName() {
		return competitionName;
	}
	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}
	public String getCompetitionSubject() {
		return competitionSubject;
	}
	public void setCompetitionSubject(String competitionSubject) {
		this.competitionSubject = competitionSubject;
	}
	public int getCompetitionGrade() {
		return competitionGrade;
	}
	public void setCompetitionGrade(int competitionGrade) {
		this.competitionGrade = competitionGrade;
	}
	public String getContectName() {
		return contectName;
	}
	public void setContectName(String contectName) {
		this.contectName = contectName;
	}
	public String getContectPhone() {
		return contectPhone;
	}
	public void setContectPhone(String contectPhone) {
		this.contectPhone = contectPhone;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	
	public ApplyReport(){}
	
	public ApplyReport(int applyReportId, int applyReportState, String name, String idCard, String school, int grade,
			String competitionName, String competitionSubject, int competitionGrade, String contectName,
			String contectPhone, String out_trade_no, String phoneNumber, int money) {
		super();
		this.applyReportId = applyReportId;
		this.applyReportState = applyReportState;
		this.name = name;
		this.idCard = idCard;
		this.school = school;
		this.grade = grade;
		this.competitionName = competitionName;
		this.competitionSubject = competitionSubject;
		this.competitionGrade = competitionGrade;
		this.contectName = contectName;
		this.contectPhone = contectPhone;
		this.out_trade_no = out_trade_no;
		this.phoneNumber = phoneNumber;
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "ApplyReport [applyReportId=" + applyReportId + ", applyReportState=" + applyReportState + ", name="
				+ name + ", idCard=" + idCard + ", school=" + school + ", grade=" + grade + ", competitionName="
				+ competitionName + ", competitionSubject=" + competitionSubject + ", competitionGrade="
				+ competitionGrade + ", contectName=" + contectName + ", contectPhone=" + contectPhone
				+ ", out_trade_no=" + out_trade_no + ", phoneNumber=" + phoneNumber + ", money=" + money + "]";
	}
	public JsonObject toJSON() {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("applyReportId", this.applyReportId);
		jsonData.addProperty("applyReportState", this.applyReportState);
		jsonData.addProperty("name", this.name);
		jsonData.addProperty("idCard", this.idCard);
		jsonData.addProperty("school", this.school);
		jsonData.addProperty("grade", this.grade);
		jsonData.addProperty("competitionName", this.competitionName);
		jsonData.addProperty("competitionSubject", this.competitionSubject);
		jsonData.addProperty("competitionGrade", this.competitionGrade);
		jsonData.addProperty("contectName", this.contectName);
		jsonData.addProperty("contectPhone", this.contectPhone);
		jsonData.addProperty("out_trade_no", this.out_trade_no);
		jsonData.addProperty("phoneNumber", this.phoneNumber);
		jsonData.addProperty("money", this.money);
		jsonData.addProperty("applyReportTime", s.format(this.applyReportTime));
		jsonData.addProperty("methodWay", "<a onclick='detail("+this.phoneNumber+")'>查看详情</a>");
		return jsonData;
	}
	
	public StringBuffer returnsql(String starttime, String endtime, String options, String Info,int orderState) {
		System.out.println(orderState);
		int type = Integer.parseInt(options);
		StringBuffer sql = new StringBuffer(); 
		sql.append("from applyreport where ");
		if(!starttime.equals("")&&!endtime.equals("")) {
			sql.append(" applyReportTime Between '"+starttime+"' and '"+endtime+"' and ");
		}
		if(!Info.equals("")) {
			if(type==1) {
				sql.append(" phoneNumber='"+Info+"' ");
			}
			else {
				sql.append(" competitionName like '%"+Info+"%' ");
			}
		}
		if(orderState==2) {
			if((!starttime.equals("")&&!endtime.equals(""))||(!Info.equals(""))) {
				return sql;
			}
			else {
				sql=new StringBuffer().append("from applyreport ");
				return sql;
			}
		}
		else {
			if((!starttime.equals("")&&!endtime.equals(""))||(!Info.equals(""))) {
				sql.append(" and applyReportState="+orderState);
			}
			else {
				sql.append(" applyReportState="+orderState);
			}
			return sql;
		}
		
	}
}
