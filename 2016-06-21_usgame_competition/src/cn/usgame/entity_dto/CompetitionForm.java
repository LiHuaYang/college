package cn.usgame.entity_dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import com.google.gson.JsonObject;
import cn.usgame.entity.Competition;

public class CompetitionForm {
	
	private String competitionId;// 比赛ID
	private String competitionName;// 比赛名字
	private String competitionSubject;// 比赛科目
	private Date competitionApplyStartTime;// 比赛开始报名时间
	private Date competitionApplyEndTime; // 比赛结束报名时间
	private String competitionJoinerDes;// 参加人员描述
	private String competitionMoney;// 比赛报名费用
	private int competitionType;// 比赛类型--初赛，决赛
	private String competitionPrizeDes; // 比赛奖项描述
	
	private String competitionTestTimeDes;// 比赛开始时间
	private String competitionApplyAddress;// 比赛报名地址
	private String competitionTestAddress;// 比赛地址
	private String competitionDetail;// 比赛详细信息
	private int competitionState; // 比赛状态 ，结束，正在报名
	private String competitionSupportDesc; //比赛主办方描述
	private int competitionForm;//比赛形式 1：笔试 2:听力 3:笔试加听力
	private String competitionGrade;//比赛年级
	
	
	public CompetitionForm( String competitionName, String competitionSubject,int competitionForm ,int competitionType,
			Date competitionApplyStartTime, Date competitionApplyEndTime, String competitionJoinerDes,
			String competitionMoney,  String competitionPrizeDes, String competitionTestTimeDes,
			String competitionApplyAddress, String competitionTestAddress, String competitionDetail,String competitionSupportDesc
			) {
		super();
		this.competitionName = competitionName;
		this.competitionSubject = competitionSubject;
	    this.competitionApplyStartTime =competitionApplyStartTime;
		this.competitionApplyEndTime = competitionApplyEndTime;
		this.competitionJoinerDes = competitionJoinerDes;
		this.competitionMoney = competitionMoney;
		this.competitionType = competitionType;
		this.competitionPrizeDes = competitionPrizeDes;
		this.competitionTestTimeDes = competitionTestTimeDes;
		this.competitionApplyAddress = competitionApplyAddress;
		this.competitionTestAddress = competitionTestAddress;
		this.competitionDetail = competitionDetail;
		this.competitionSupportDesc = competitionSupportDesc;
		this.competitionForm = competitionForm;
	}
	public  CompetitionForm (Map<String, String[]> map) {
		this.competitionId = map.get("competitionId")[0];
		this.competitionName = map.get("competitionName")[0];
		this.competitionSubject = map.get("competitionSubject")[0];
		this.competitionForm = Integer.parseInt(map.get("competitionForm")[0]);
		this.competitionType = Integer.parseInt(map.get("competitionType")[0]);
		
		try {
			this.competitionApplyStartTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(map.get("competitionApplyStartTime")[0]);
			this.competitionApplyEndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(map.get("competitionApplyEndTime")[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.competitionJoinerDes = map.get("competitionJoinerDes")[0];
		this.competitionMoney = map.get("competitionMoney")[0];
		this.competitionPrizeDes = map.get("competitionPrizeDes")[0];
		this.competitionTestTimeDes = map.get("competitionTestTimeDes")[0];
		this.competitionApplyAddress = map.get("competitionApplyAddress")[0];
		this.competitionTestAddress = map.get("competitionTestAddress")[0];
		this.competitionDetail = map.get("competitionDetail")[0];
		this.competitionSupportDesc =map.get("competitionSupportDesc")[0];
		this.competitionGrade=map.get("competitionGrade")[0];
	}
	/**
	 * @param pro
	 */
	public CompetitionForm(Properties pro) {
		
		this.competitionName = pro.getProperty("js_competitionName");
		this.competitionSubject = pro.getProperty("js_competitionSubject");
		try {
			
			this.competitionApplyStartTime = new SimpleDateFormat("yyyy-MM-dd").parse(pro.getProperty("js_competitionApplyStartTime"));
			this.competitionApplyEndTime = new SimpleDateFormat("yyyy-MM-dd").parse(pro.getProperty("js_competitionApplyEndTime"));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		this.competitionJoinerDes = pro.getProperty("js_competitionJoinerDes");
		this.competitionMoney = pro.getProperty("js_competitionMoney");
		
		this.competitionType = Integer.parseInt(pro.getProperty("js_competitionType"));
		this.competitionPrizeDes = pro.getProperty("js_competitionPrizeDes");
		this.competitionTestTimeDes = pro.getProperty("js_competitionTestTimeDes");
		this.competitionApplyAddress = pro.getProperty("js_competitionApplyAddress");
		this.competitionTestAddress = pro.getProperty("js_competitionTestAddress");
		this.competitionDetail = pro.getProperty("js_competitionDetail");
		this.competitionForm = Integer.parseInt(pro.getProperty("js_competitionForm"));
		
	}
	
	
	
//public CompetitionForm(Properties pro) {
//		
//		this.competitionName = pro.getProperty("js_competitionName");
//		this.competitionSubject = pro.getProperty("js_competitionSubject");
//		
//		try {
//			
//			this.competitionApplyStartTime = new SimpleDateFormat("yyyy-MM-dd").parse(pro.getProperty("js_competitionApplyStartTime"));
//			this.competitionApplyEndTime = new SimpleDateFormat("yyyy-MM-dd").parse(pro.getProperty("js_competitionApplyEndTime"));
//			
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		this.competitionJoinerDes = pro.getProperty("js_competitionJoinerDes");
//		this.competitionMoney = pro.getProperty("js_competitionMoney");
//		
//		this.competitionType = Integer.parseInt(pro.getProperty("js_competitionType"));
//		this.competitionPrizeDes = pro.getProperty("js_competitionPrizeDes");
//		this.competitionTestTimeDes = pro.getProperty("js_competitionTestTimeDes");
//		this.competitionApplyAddress = pro.getProperty("js_competitionApplyAddress");
//		this.competitionTestAddress = pro.getProperty("js_competitionTestAddress");
//		this.competitionDetail = pro.getProperty("js_competitionDetail");
//	}
	
	public JsonObject validate() {
		JsonObject obj  = new JsonObject();
		return null;
	}
	
	public Competition toCompetition() {
		Competition com = new Competition();
		com.setCompetitionId(this.competitionId);
		com.setCompetitionName(this.competitionName);
		com.setCompetitionSubject(this.competitionSubject);
		com.setCompetitionApplyStartTime(this.competitionApplyStartTime);
		com.setCompetitionApplyEndTime(this.competitionApplyEndTime);
		com.setCompetitionJoinerDes(this.competitionPrizeDes);
		com.setCompetitionMoney(this.competitionMoney);
		com.setCompetitionType(this.competitionType);
		com.setCompetitionPrizeDes(this.competitionPrizeDes);
		com.setCompetitionTestTimeDes(this.competitionTestTimeDes);
		com.setCompetitionApplyAddress(this.competitionApplyAddress);
		com.setCompetitionTestAddress(this.competitionTestAddress);
		com.setCompetitionDetail(this.competitionDetail);
		com.setCompetitionForm(this.competitionForm);
		com.setCompetitionSupportDesc(competitionSupportDesc);
		com.setCompetitionGrade(this.competitionGrade);
		return com;
	}

	public String getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(String competitionId) {
		this.competitionId = competitionId;
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

	public Date getCompetitionApplyStartTime() {
		return competitionApplyStartTime;
	}

	public void setCompetitionApplyStartTime(Date competitionApplyStartTime) {
		this.competitionApplyStartTime = competitionApplyStartTime;
	}

	public Date getCompetitionApplyEndTime() {
		return competitionApplyEndTime;
	}

	public void setCompetitionApplyEndTime(Date competitionApplyEndTime) {
		this.competitionApplyEndTime = competitionApplyEndTime;
	}

	public String getCompetitionJoinerDes() {
		return competitionJoinerDes;
	}

	public void setCompetitionJoinerDes(String competitionJoinerDes) {
		this.competitionJoinerDes = competitionJoinerDes;
	}

	public String getCompetitionMoney() {
		return competitionMoney;
	}

	public void setCompetitionMoney(String competitionMoney) {
		this.competitionMoney = competitionMoney;
	}

	public int getCompetitionType() {
		return competitionType;
	}

	public void setCompetitionType(int competitionType) {
		this.competitionType = competitionType;
	}

	public String getCompetitionPrizeDes() {
		return competitionPrizeDes;
	}

	public void setCompetitionPrizeDes(String competitionPrizeDes) {
		this.competitionPrizeDes = competitionPrizeDes;
	}

	public String getCompetitionTestTimeDes() {
		return competitionTestTimeDes;
	}

	public void setCompetitionTestTimeDes(String competitionTestTimeDes) {
		this.competitionTestTimeDes = competitionTestTimeDes;
	}

	public String getCompetitionApplyAddress() {
		return competitionApplyAddress;
	}

	public void setCompetitionApplyAddress(String competitionApplyAddress) {
		this.competitionApplyAddress = competitionApplyAddress;
	}

	public String getCompetitionTestAddress() {
		return competitionTestAddress;
	}

	public void setCompetitionTestAddress(String competitionTestAddress) {
		this.competitionTestAddress = competitionTestAddress;
	}

	public String getCompetitionDetail() {
		return competitionDetail;
	}

	public void setCompetitionDetail(String competitionDetail) {
		this.competitionDetail = competitionDetail;
	}

	public int getCompetitionState() {
		return competitionState;
	}

	public void setCompetitionState(int competitionState) {
		this.competitionState = competitionState;
	}

	public String getCompetitionSupportDesc() {
		return competitionSupportDesc;
	}

	public void setCompetitionSupportDesc(String competitionSupportDesc) {
		this.competitionSupportDesc = competitionSupportDesc;
	}

	public int getCompetitionForm() {
		return competitionForm;
	}

	public void setCompetitionForm(int competitionForm) {
		this.competitionForm = competitionForm;
	}
}
