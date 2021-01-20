package com.ServletAndroid;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.EntityAndroid.UserBaseInfo;

//用户使用账号密码登录
public class LoginAccountServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
		
		String UserAccount = new String(request.getParameter("UserAccount").getBytes("ISO-8859-1"),"utf-8");//账户
		String UserPassword = new String(request.getParameter("UserPassword").getBytes("ISO-8859-1"),"utf-8");//密码
		
		
		IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
		JSONObject json = new JSONObject();
		
		
		UserBaseInfo result=interfaceOfBllFrame.LoginAccount(UserAccount, UserPassword);
		if(result!=null){  
		      json.put("result",result);
		      json.put("flag", true);
		}
		else{
			json.put("flag", false);
		}
		
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}


}
