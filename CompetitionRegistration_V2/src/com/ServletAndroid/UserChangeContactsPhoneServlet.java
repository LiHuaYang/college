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

public class UserChangeContactsPhoneServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
		int UserId = Integer.parseInt(request.getParameter("UserId"));//账户
		String userContactsPhon = new String(request.getParameter("userContactsPhon").getBytes("ISO-8859-1"),"utf-8");//密码
		
		IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
		JSONObject json = new JSONObject();
		
		boolean result=interfaceOfBllFrame.ChangeUserContactsPhon(UserId, userContactsPhon);
		json.put("result",result);
		
		System.out.print(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
	}


}
