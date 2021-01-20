package com.ServletWX;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Bll.CBllEnrollment;
import com.Entity.V2.EnrollmentOrder;
import com.Tool.GetWxOrderno;

/****
 ##需要实现的功能：
 接受微信的支付通知消息
 通知微信收到消息
 创建本地的订单
 1. 获取信息
 2. 创建对象
 3. 数据库读写
 4. 

 设计数据库表格
 xxxx1. 在Enrollment中加上订单ID


 ****2. 另外 创建一张表
 2.1 字段1：本地的用户ID和微信返回的信息

 */

/*******
 * 以下字段在return_code为SUCCESS的时候有返回 <xml>
 * <appid><![CDATA[wx2421b1c4370ec43b]]></appid>
 * <attach><![CDATA[支付测试]]></attach> <bank_type><![CDATA[CFT]]></bank_type>
 * <fee_type><![CDATA[CNY]]></fee_type>
 * <is_subscribe><![CDATA[Y]]></is_subscribe>
 * <mch_id><![CDATA[10000100]]></mch_id>
 * <nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>
 * <openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>
 * <out_trade_no><![CDATA[1409811653]]></out_trade_no>
 * <result_code><![CDATA[SUCCESS]]></result_code>
 * <return_code><![CDATA[SUCCESS]]></return_code>
 * <sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign>
 * <sub_mch_id><![CDATA[10000100]]></sub_mch_id>
 * <time_end><![CDATA[20140903131540]]></time_end> <total_fee>1</total_fee>
 * <trade_type><![CDATA[JSAPI]]></trade_type>
 * <transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>
 * </xml>
 *****/

public class NotifyServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(ServletInputStream) request.getInputStream()));

		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		Map<String, String> hashMap = null;
		try {
			hashMap = GetWxOrderno.doXMLParse(sb.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (hashMap.get("result_code").toString().equalsIgnoreCase("SUCCESS")) {

			// 开始数据库操作
			EnrollmentOrder enrollmentOrder = new EnrollmentOrder();

			enrollmentOrder.setOpenid(hashMap.get("openid").toString());

			enrollmentOrder.setTotal_fee(hashMap.get("total_fee").toString());
			enrollmentOrder.setTransaction_id(hashMap.get("transaction_id")
					.toString());
			enrollmentOrder.setOut_trade_no(hashMap.get("out_trade_no")
					.toString());
			enrollmentOrder.setTime_end(hashMap.get("time_end").toString());
			enrollmentOrder.setAttach(hashMap.get("attach").toString());
			enrollmentOrder.setLocalid(hashMap.get("attach").toString()); // 微信将ToPayServlet发过去的UserId原样返回

			System.out.println(enrollmentOrder.toString());

			CBllEnrollment bllEnrollment = CBllEnrollment.getInstance();

			bllEnrollment.addEnrollmentOrder(enrollmentOrder);

			response.getWriter().write(NotifyServlet.setXML("SUCCESS", "")); // 告诉微信服务器，我收到信息了，不要在调用回调action了
			System.out.println("-------------"
					+ NotifyServlet.setXML("SUCCESS", ""));
		}

		System.out.println("NotifyServlet:" + sb);
		response.sendRedirect("");

		// InputStream inStream = request.getInputStream();
		// ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		// byte[] buffer = new byte[1024];
		// int len = 0;
		// while ((len = inStream.read(buffer)) != -1) {
		// outSteam.write(buffer, 0, len);
		// }
		// System.out.println("~~~~~~~~~~~~~~~~付款成功~~~~~~~~~");
		// outSteam.close();
		// inStream.close();
		// String result = new
		// String(outSteam.toByteArray(),"utf-8");//获取微信调用我们notify_url的返回信息
		//      
		// Map<Object, Object> map = null;
		// try {
		// map = GetWxOrderno.doXMLParse(result);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//        
		// for(Object keyValue : map.keySet()){
		// System.out.println(keyValue+"="+map.get(keyValue));
		// }
		//        
		// if (map.get("result_code").toString().equalsIgnoreCase("SUCCESS")) {
		//
		// // 开始数据库操作
		// response.getWriter().write(NotifyServlet.setXML("SUCCESS", "")); //
		// 告诉微信服务器，我收到信息了，不要在调用回调action了
		// System.out.println("-------------"+NotifyServlet.setXML("SUCCESS",
		// ""));
		// }
	}

	public void paySuccess(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		InputStream inStream = request.getInputStream();
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}
		System.out.println("~~~~~~~~~~~~~~~~付款成功~~~~~~~~~");
		outSteam.close();
		inStream.close();
		String result = new String(outSteam.toByteArray(), "utf-8");// 获取微信调用我们notify_url的返回信息

		Map<Object, Object> map = GetWxOrderno.doXMLParse(result);

		for (Object keyValue : map.keySet()) {
			System.out.println(keyValue + "=" + map.get(keyValue));
		}

		if (map.get("result_code").toString().equalsIgnoreCase("SUCCESS")) {

			response.getWriter().write(NotifyServlet.setXML("SUCCESS", "")); // 告诉微信服务器，我收到信息了，不要在调用回调action了
			System.out.println("-------------"
					+ NotifyServlet.setXML("SUCCESS", ""));
		}
	}

	public static String setXML(String return_code, String return_msg) {
		return "<xml><return_code><![CDATA[" + return_code
				+ "]]></return_code><return_msg><![CDATA[" + return_msg
				+ "]]></return_msg></xml>";
	}
}
