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

//修改用户密码
public class UserChangePasswordServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
		int userid = Integer.parseInt(request.getParameter("UserId"));//id
		String OldPassword = new String(request.getParameter("OldPassword").getBytes("ISO-8859-1"),"utf-8");//旧密码
		String UserPassword = new String(request.getParameter("UserPassword").getBytes("ISO-8859-1"),"utf-8");//新密码
		
		
		IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
		JSONObject json = new JSONObject();
		
		boolean result=interfaceOfBllFrame.ChangeUserPassword(userid, OldPassword, UserPassword);
		
		json.put("result",result);
		System.out.print(result);
		
		
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
	}


}
