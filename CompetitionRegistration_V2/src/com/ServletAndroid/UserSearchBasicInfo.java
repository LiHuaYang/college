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
import com.EntityWeb.User;

public class UserSearchBasicInfo extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
		int UserId = Integer.parseInt(request.getParameter("UserId"));//账户		
		
		IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
		JSONObject json = new JSONObject();
		
		
		User result = interfaceOfBllFrame.SearchUserBasicInfo(UserId);
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
