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
import com.Bll.CBllCompetition;
import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.Dao.DaoCompetition;
import com.Dao.DaoUser;
import com.EntityWeb.SMS;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class FoundBackPassWord extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String commend_type_str = new String(request.getParameter("CommendType").getBytes("ISO-8859-1"), "utf-8");// 账户
		int commend_type = Integer.parseInt(commend_type_str);
		
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		
		IBllFrame cBllFrame=CBllFrame.getInstance();
		
		int GET_CHECK_NUMBER = 1; // 点击获取验证码
		int CHECK_SMS_NUMBER = 2; // 验证验证码是否正确
		int COMFIRM_NEW_PWD = 3;  // 修改新密码
		
		// 1. 
		if (commend_type == GET_CHECK_NUMBER) {
			String UserPhone = new String(request.getParameter("UserPhone").getBytes("ISO-8859-1"), "utf-8");
			// 1. 生成SMS对象
			int lifecycle = 60; // 周期为60秒
			SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String nowtime = d.format(new Date());
			String SMSNumber = SendCheckNumber(UserPhone);
			SMS sms = new SMS(UserPhone, nowtime, lifecycle, SMSNumber);
			boolean flag = cBllFrame.pushSMS(sms);
			
			System.out.println("新生成的SMS对象的手机号码：" + sms.getPhoneNumber());
			System.out.println("新生成的SMS对象的生成时间：" + sms.getBulidtime());
			System.out.println("新生成的SMS对象的生命周期：" + sms.getLifecycle());
			System.out.println("新生成的SMS对象的手机验证：" + sms.getCheckNumber());
			
			json.put("result", flag);
			out.println(json);
			out.flush();
			out.close();
		}
		// 2.
		if (commend_type == CHECK_SMS_NUMBER) {
			
			String UserPhone = new String(request.getParameter("UserPhone").getBytes("ISO-8859-1"), "utf-8");
			String SMSNumber = new String(request.getParameter("SMSNumber").getBytes("ISO-8859-1"), "utf-8");
			int res = cBllFrame.IsQualifiedSMS(UserPhone, SMSNumber);
			
			boolean flag = false;
			String ERR_FLAG = null;
			switch (res) {
			case 0:
				ERR_FLAG = "验证成功";
				flag = true;
				break;
			case 1:
				ERR_FLAG = "验证码错误";
				flag = false;
				break;
			case 2:
				ERR_FLAG = "数据条目有效期已过";
				flag = false;
				break;
			case 3:
				ERR_FLAG = "在Queue中找不到所要匹配和验证的手机号码";
				flag = false;
				break;
			}
			
			json.put("result", flag);
			json.put("ERR_FLAG", ERR_FLAG);
			
			System.out.println("CheckSMSNumber 发往客户端的数据是：" + json);
			
			out.println(json);
			out.flush();
			out.close();
		}
		// 3. 
		if (commend_type == COMFIRM_NEW_PWD) {
			String UserPhone = new String(request.getParameter("UserPhone").getBytes("ISO-8859-1"), "utf-8");
			// int UserId = Integer.parseInt(UserIdStr);
			String UserPWD = new String(request.getParameter("UserPWD").getBytes("ISO-8859-1"), "utf-8");

			
			boolean flag = false;
			flag = DaoUser.getInstance().UpdataUserPassword(UserPhone, UserPWD);
			json.put("result", flag);
			out.println(json);
			out.flush();
			out.close();
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
		// 修改密码验证模版
		req.setSmsTemplateCode("SMS_5250339");
	
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
