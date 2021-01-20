package com.Dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.Dao.DaoErollmentOrder;
import com.Entity.V2.EnrollmentOrder;
import com.Tool.sql.ConnectionPool;

/**
 * 
 * 
 * 订单的接口类
 * 
 *
 */
public class DaoErollmentOrderImp implements DaoErollmentOrder {

	
	
	
	/***
	 * 
交易时间	微信支付单号	商户订单号	商户号	特约商户号	设备号	appid	下单用户	交易场景	交易状态	支付成功时间	交易金额(元)	现金券抵扣金额(元)
2016/4/25 13:37	`4006322001201604255202263124	`wxbd2420d3a7c050d61461562617	1317319901			wxbd2420d3a7c050d6	oe_BRwmbLEstVYKBy_GzrC97QUsE	公众号支付	买家已支付	2016/4/25 13:37	60	0
2016/4/25 10:56	`4008152001201604255196919655	`wxbd2420d3a7c050d61461552970	1317319901			wxbd2420d3a7c050d6	oe_BRwnmT8EnYKc3cjgKHp7iQs3Y	公众号支付	买家已支付	2016/4/25 10:56	60	0
2016/4/21 20:03	`4009012001201604215067396018	`wxbd2420d3a7c050d61461240204	1317319901			wxbd2420d3a7c050d6	oe_BRwiEEQTVTMK_60nia8hzwzIc	公众号支付	买家已支付	2016/4/21 20:03	60	0
2016/4/20 15:10	`4001122001201604205024816789	`wxbd2420d3a7c050d61461136204	1317319901			wxbd2420d3a7c050d6	oe_BRwnmbTXWudut-uZueWzn3E94	公众号支付	买家已支付	2016/4/20 15:10	60	0
2016/4/19 13:14	`4008792001201604194990465098	`wxbd2420d3a7c050d61461042873	1317319901			wxbd2420d3a7c050d6	oe_BRwuqfOP4pcs57OAHvnuV2Beg	公众号支付	买家已支付	2016/4/19 13:14	60	0
2016/4/17 13:59	`4008972001201604174928228466	`wxbd2420d3a7c050d61460872744	1317319901			wxbd2420d3a7c050d6	oe_BRwoCFqfZHWaxsCnCriEsIR7Q	公众号支付	买家已支付	2016/4/17 13:59	60	0

	 */
	@Test
	public void test1 () {
		EnrollmentOrder enrollmentOrder = new EnrollmentOrder();
		
		enrollmentOrder.setAttach("1");
		enrollmentOrder.setLocalid("1");
		enrollmentOrder.setOpenid("oe_BRwmbLEstVYKBy_GzrC97QUsE"); // 用户标识
		enrollmentOrder.setOut_trade_no("wxbd2420d3a7c050d61461562617"); // 商户订单号
		enrollmentOrder.setTransaction_id("4006322001201604255202263124");
		enrollmentOrder.setTime_end("2016/4/25 13:37"); // 
		enrollmentOrder.setTotal_fee("60");
		
		add(enrollmentOrder);
	}
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-4-21下午12:38:06
	 *函数名：add
	 *功能：TODO
	 *参数：
	 *返回值：void
	 */
	
	public void add(EnrollmentOrder enrollmentOrder) {
		ConnectionPool pool = ConnectionPool.getIntense();
		try {
			Connection con = pool.getConnection();
			
//			INSERT INTO `competition`.`enrollmentorder` (`localuserid`, `openid`, `total_fee`, `transaction_id`, `out_trade_no`, `time_end`, `attach`) VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL);
			String sql = "Insert Into EnrollmentOrder(localuserid,openid,total_fee,transaction_id,out_trade_no,time_end,attach)Value(?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setObject(1, enrollmentOrder.getLocalid());
			preparedStatement.setObject(2, enrollmentOrder.getOpenid());
			preparedStatement.setObject(3, enrollmentOrder.getTotal_fee());
			preparedStatement.setObject(4, enrollmentOrder.getTransaction_id());
			preparedStatement.setObject(5, enrollmentOrder.getOut_trade_no());
			preparedStatement.setObject(6, enrollmentOrder.getTime_end());
			preparedStatement.setObject(7, enrollmentOrder.getAttach());
			
			preparedStatement.execute();
			pool.returnConnection(con, preparedStatement, null);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			
		}
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-4-21下午12:38:06
	 *函数名：query
	 *功能：TODO
	 *参数：
	 *返回值：EnrollmentOrder
	 */
	public JSONObject query(String userId) {
		ConnectionPool pool = ConnectionPool.getIntense();
		EnrollmentOrder order = null;
		Map<String, String> map = new HashMap<String, String>();
		
		JSONObject json = new JSONObject();
		try {
			Connection con = pool.getConnection();
			String sql = "Select * from EnrollmentOrder as e,Enrollment as ee Where e.localuserid='" + userId + "' and ee.userid=e.localuserid;";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet res = preparedStatement.executeQuery();
			while (res.next()) {
				json.put("localuserid", res.getString("localuserid"));
				json.put("openid", res.getString("openid"));
				json.put("total_fee", res.getString("total_fee"));
				json.put("transaction_id", res.getString("transaction_id"));
				json.put("out_trade_no", res.getString("out_trade_no"));
				json.put("time_end", res.getString("time_end"));
				json.put("attach", res.getString("attach"));
			}
			pool.returnConnection(con, preparedStatement, null);
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			
		}
		return json;
	}
	
	@Test
	public void test2 () {
		Map<String, String> map = query("19");
		
		for (Object obj : map.entrySet()) {
			Entry<String, String> en = (Entry) obj;
			
			System.out.println(en.getValue());
		}
	}
	
	
	
}
