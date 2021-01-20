package cn.usgame.entity_dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.usgame.entity.ApplyReport;
import cn.usgame.pay.WeChatCount;
import cn.usgame.utils.WebUtils;



/**
 * 
 * 用户标识 			openid 			是 		String(128) 	wxd930ea5d5a258f4f 	用户在商户appid下的唯一标识
 * 
 * 总金额 			total_fee 		是 		Int 	100 	订单总金额，单位为分
 * 
 * 微信支付订单号 	transaction_id 	是 		String(32) 		1217752501201407033233368018 	微信支付订单号
 * 
 * 商户订单号 		out_trade_no 	是 		String(32) 		1212321211201407033568112322 	商户系统的订单号，与请求一致。
 * 
 * 支付完成时间 		time_end 		是 		String(14) 		20141030133525 	支付完成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
 * 
 * 商家数据包 		attach 			否 		String(128) 	123456 	商家数据包，原样返回
 * 
 */


public class ApplyReportForm {
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
	private String out_trade_no; // 
	private String phoneNumber;//电话号码
	private int money;//金额
	
	public ApplyReport toApplyReport() {
		ApplyReport applyreport = new ApplyReport();
		applyreport.setApplyReportId(this.applyReportId);
		applyreport.setApplyReportState(this.applyReportState);
		applyreport.setName(this.name);
		applyreport.setIdCard(this.idCard);
		applyreport.setSchool(this.school);
		applyreport.setGrade(this.grade);
		applyreport.setCompetitionName(this.competitionName);
		applyreport.setCompetitionSubject(this.competitionSubject);
		applyreport.setCompetitionGrade(this.competitionGrade);
		applyreport.setContectName(this.contectName);
		applyreport.setContectPhone(this.contectPhone);
		applyreport.setOut_trade_no(this.out_trade_no);
		applyreport.setPhoneNumber(this.phoneNumber);
		applyreport.setMoney(this.money);
		applyreport.setApplyReportTime(new Date());
		return applyreport;
	}
	
	public ApplyReportForm(Map<String, String[]> map,String phoneNumber){
		this.name = map.get("name")[0];
		this.idCard = map.get("idCard")[0];
		this.school = map.get("school")[0];
		this.grade = Integer.parseInt(map.get("grade")[0]);
		this.competitionName = map.get("competitionName")[0];
		this.competitionSubject = map.get("competitionSubject")[0];
		this.competitionGrade = Integer.parseInt(map.get("competitionGrade")[0]);
		this.contectName = map.get("contectName")[0];
		this.contectPhone = map.get("contectPhone")[0];
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("MMddHHmmss");
		String time = outFormat.format(now);
		this.applyReportId =Integer.parseInt(time);
		this.phoneNumber = phoneNumber;
		this.money = Integer.parseInt(map.get("money")[0]);
		this.out_trade_no = WebUtils.getTimeStamp() + new WeChatCount().getAppid();
	}
	
	public boolean  judgeIdcard() {
		boolean result = true;
		Pattern p = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
		Matcher m = p.matcher(this.idCard);
		boolean flag= m.matches();
		
		Pattern p1 = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$");
		Matcher m1= p1.matcher(this.idCard);
		boolean flag1= m1.matches();
		
		if(flag||flag1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean judgePhoneNum() {
		//电信号码格式
		Pattern p = Pattern.compile("(^1(33|53|77|8[019])\\d{8}$)|(^1700\\d{7}$)");
		Matcher m = p.matcher(this.contectPhone);
		boolean flag= m.matches();

		//联通号码格式
		Pattern p1 = Pattern.compile("(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^1709\\d{7}$)");
		Matcher m1 = p1.matcher(this.contectPhone);
		boolean flag1= m1.matches();

		//移动号码格式
		Pattern p2 = Pattern.compile("(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)");
		Matcher m2 = p2.matcher(this.contectPhone);
		boolean flag2= m2.matches();

		if(flag||flag1||flag2) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
