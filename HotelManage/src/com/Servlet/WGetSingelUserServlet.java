package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.User;

public class WGetSingelUserServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8");  

		
		int userId=Integer.parseInt(request.getParameter("UserId"));
		ICBllFrame interfaceOfBllFrame=new CBllImpl();
		JSONObject json = null;
		User result= interfaceOfBllFrame.QuerySingelUser(userId);
		try {
			json= new JSONObject().fromObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(json);
		PrintWriter out = response.getWriter();  
		out.println(json);
		out.flush(); 
		out.close(); 
	}
}
