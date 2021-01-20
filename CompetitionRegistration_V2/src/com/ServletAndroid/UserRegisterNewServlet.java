package com.ServletAndroid;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.EntityWeb.SMS;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class UserRegisterNewServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String UserPhone = new String(request.getParameter("UserPhone")
				.getBytes("ISO-8859-1"), "utf-8");// 账户
		
		IBllFrame cBllFrame=CBllFrame.getInstance();
//		DaoCompetition competition = DaoCompetition.getInstance();
		
		if (null != cBllFrame.IsExitUser(UserPhone)) {
			System.out.println("手机号码为：" + UserPhone + "已经注册!");
			
			JSONObject json = new JSONObject();
			json.put("result", false);
			
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		}
		
		else {
			// 1. 生成SMS对象
			int lifecycle = 60; // 周期为60秒
			SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String nowtime = d.format(new Date());
			// 2. 发送短信
			String SMSNumber = SendCheckNumber(UserPhone);
			JSONObject json = new JSONObject();
			
			if(!("").equals(SMSNumber)){
				SMS sms = new SMS(UserPhone, nowtime, lifecycle, SMSNumber);
				
				boolean flag = cBllFrame.pushSMS(sms);
				System.out.println("新生成的SMS对象的手机号码：" + sms.getPhoneNumber());
				System.out.println("新生成的SMS对象的生成时间：" + sms.getBulidtime());
				System.out.println("新生成的SMS对象的生命周期：" + sms.getLifecycle());
				System.out.println("新生成的SMS对象的手机验证：" + sms.getCheckNumber());
				
				json.put("message", "验证码发送成功");
				json.put("result", flag);
				
				PrintWriter out = response.getWriter();
				out.println(json);
				out.flush();
				out.close();
			}
			else{
				json.put("message", "验证码发送失败");
			}
			
			
		}
	}
	public String CreateAndReturnASecurityNumber() {
		// List<String> checkNumbers = new ArrayList<String>();
		String SecurityNumber = "";
		for (int i = 0; i < 6; i++) {
			java.util.Random random = new java.util.Random();// 定义随机类
			int result = random.nextInt(10);// 返回[0,10)集合中的整数，注意不包括10
			SecurityNumber = SecurityNumber + Integer.toString(result);
			System.out.println(result);
		}
		return SecurityNumber;
	}
	
	public String SendCheckNumber(String Phone) {
		boolean flag = false;
		String SMSNumber = null;
		// 阿里大鱼短信服务器地址
		String url = "http://gw.api.taobao.com/router/rest";
		// 阿里大鱼应用密钥
		String appkey = "23317766";
		// 阿里大鱼...
		String secret = "793012aac1dffea9b8a4900c5eeb8c80";

		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);

		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();

		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("优赛乐学");

		SMSNumber = CreateAndReturnASecurityNumber();
		// {"code":"1234","product":"alidayu"}
		req.setSmsParamString("{\"code\":" + "'" + SMSNumber + "'" + ","
				+ "\"product\":\"优赛乐学\",\"item\":\"优赛乐学\"}");
		// 目标手机号
		req.setRecNum(Phone);
		// 短信模版
		req.setSmsTemplateCode("SMS_5250341");

		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
			flag = true;
			System.out.println(rsp.getBody());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			SMSNumber = null;
			e.printStackTrace();
		}
		return SMSNumber;
	}
}
