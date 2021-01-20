package com.Entity.V2;

import java.sql.ResultSet;
import java.sql.SQLException;



// 用户报名订单
public class EnrollmentOrder {

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
	
	private String localid; // 用户本地的ID
	private String openid;// 用户标识--用户ID(用户在商户appid下的唯一标识)
	private String total_fee;// 总金额
	private String transaction_id; // 微信支付订单号, 微信生成,
	private String out_trade_no; // 商户订单号, 系统生成
	private String time_end;
	private String attach;
	
	
	 public EnrollmentOrder () {}


	public EnrollmentOrder (ResultSet resultSet) throws SQLException {
		this.localid = resultSet.getString("localid");
		this.openid = resultSet.getString("openid");
		this.total_fee = resultSet.getString("total_fee");
		this.transaction_id = resultSet.getString("transaction_id");
		this.out_trade_no = resultSet.getString("out_trade_no");
		this.time_end = resultSet.getString("time_end");
		this.attach = resultSet.getString("attach");
	}
	
	
	
	public String getLocalid() {
		return localid;
	}
	public void setLocalid(String localid) {
		this.localid = localid;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String totalFee) {
		total_fee = totalFee;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transactionId) {
		transaction_id = transactionId;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String outTradeNo) {
		out_trade_no = outTradeNo;
	}
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String timeEnd) {
		time_end = timeEnd;
	}
	
	@Override
	public String toString() {
		return "EnrollmentOrder [attach=" + attach + ", localid=" + localid
				+ ", openid=" + openid + ", out_trade_no=" + out_trade_no
				+ ", time_end=" + time_end + ", total_fee=" + total_fee
				+ ", transaction_id=" + transaction_id + "]";
	}
}
