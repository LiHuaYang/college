package com.ServletAndroid;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bll.CBllCompetition;
import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.EntityWeb.User;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import net.sf.json.JSONObject;

public class UserRegisterServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
		String UserPhone = new String(request.getParameter("UserPhone").getBytes("ISO-8859-1"),"utf-8");//账户
		String UserPassword = new String(request.getParameter("UserPassword").getBytes("ISO-8859-1"),"utf-8");//密码
		
		
		// 1. 对比内存中已存在的帐号和验证码
		// CBllCompetition.
		
		// 2. 生成短信验证码
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
		
		String str = CreateAndReturnASecurityNumber();
		// {"code":"1234","product":"alidayu"}
		req.setSmsParamString("{\"code\":"+ "'"+ str + "'" + "," +"\"product\":\"优赛乐学\",\"item\":\"优赛乐学\"}");
		// 目标手机号
		req.setRecNum(UserPhone);
		// 短信模版
		req.setSmsTemplateCode("SMS_5250341");

		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
		JSONObject json = new JSONObject();
		User user=new User(UserPhone, UserPassword);
		boolean result=interfaceOfBllFrame.UserRegister(user);
		json.put("result",result);
		System.out.print(result);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
	
	public String CreateAndReturnASecurityNumber() {
		// List<String> checkNumbers = new ArrayList<String>();
		String SecurityNumber = "";
		for (int i=0; i<6; i++) {
			java.util.Random random=new java.util.Random();// 定义随机类
			int result=random.nextInt(10);// 返回[0,10)集合中的整数，注意不包括10
			SecurityNumber = SecurityNumber + Integer.toString(result);
			System.out.println(result);
		}
		return SecurityNumber;
	}
}
