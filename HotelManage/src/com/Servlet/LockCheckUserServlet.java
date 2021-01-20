package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;

public class LockCheckUserServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8");  
		PrintWriter out = response.getWriter();  
		
		int userId = Integer.parseInt(request.getParameter("UserId"));
		int UserState = Integer.parseInt(request.getParameter("UserState"));
		ICBllFrame icBllFrame = new CBllImpl();
		boolean bisLock = icBllFrame.LockCheckUser(userId, UserState);
		
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("Check", bisLock);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObject);
		out.println(jsonObject);
		out.flush(); 
		out.close();  
	}
}
