package com.ServletAndroid;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import com.Bll.CBllCompetition;
import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.EntityWeb.User;

public class CheckSMSNumber extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String UserPhone = new String(request.getParameter("UserPhone").getBytes("ISO-8859-1"), "utf-8");// 账户
		String UserPassword = new String(request.getParameter("UserPassWord").getBytes("ISO-8859-1"), "utf-8");// 账户
		String SMSNumber = new String(request.getParameter("SMSNumber").getBytes("ISO-8859-1"), "utf-8");// 账户
		
		System.out.println("用户验证注册手机号：" + UserPhone);
		System.out.println("用户验证密码：" + UserPassword);
		
		IBllFrame cBllFrame=CBllFrame.getInstance();
		
		// 1. 
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
		// 验证成功，则注册该用户
		if (flag) {
			User user = new User(UserPhone, UserPassword);
			boolean result = cBllFrame.UserRegister(user);
			flag = result;
		}
		
		JSONObject json = new JSONObject();
		json.put("result", flag);
		json.put("ERR_FLAG", ERR_FLAG);
		
		System.out.println("CheckSMSNumber 发往客户端的数据是：" + json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
}
