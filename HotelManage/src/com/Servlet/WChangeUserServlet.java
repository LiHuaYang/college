package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.User;

public class WChangeUserServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8");  


		int UserId=Integer.parseInt(request.getParameter("UserId"));
		String UserName = new String(request.getParameter("UserName").getBytes("ISO-8859-1"),"utf-8");//	房间经度
		String UserPassword= new String(request.getParameter("UserPassword").getBytes("ISO-8859-1"),"utf-8");
		String UserSex= new String(request.getParameter("UserSex").getBytes("ISO-8859-1"),"utf-8");
		String UserPhone= new String(request.getParameter("UserPhone").getBytes("ISO-8859-1"),"utf-8");
		String UserEmail=new String(request.getParameter("UserEmail").getBytes("ISO-8859-1"),"utf-8");
		String UserBoth=new String(request.getParameter("UserBoth").getBytes("ISO-8859-1"),"utf-8");
		String UserIDNumber=new String(request.getParameter("UserIDNumber").getBytes("ISO-8859-1"),"utf-8");
		int UserBalance= Integer.parseInt(request.getParameter("UserBalance"));
		String UserPicture=new String(request.getParameter("UserPicture").getBytes("ISO-8859-1"),"utf-8");
		int UserVIP=Integer.parseInt(request.getParameter("UserVIP"));
		int UserState=Integer.parseInt(request.getParameter("UserState"));
			
		ICBllFrame interfaceOfBllFrame=new CBllImpl();
		JSONObject json = new JSONObject();
		
		User user = new User(UserId, UserName, UserPassword,UserSex, UserPhone,UserEmail, UserBoth, UserIDNumber, UserVIP, UserState, UserBalance, UserPicture);
		boolean result= interfaceOfBllFrame.UpdateUser(UserId,user);
		json.put("result", result);
		System.out.println(json);
		PrintWriter out = response.getWriter();  
		out.println(json);
		out.flush(); 
		out.close(); 
	}


}
