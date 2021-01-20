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
import com.Entity.Cleaner;
import com.Entity.OrderTable;

public class WCleanerRegister extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8");  

		String CleanerIDNumber =  new String(request.getParameter("CleanerIDNumber").getBytes("ISO-8859-1"),"utf-8");
		String CleanerPhoneNumber = new String(request.getParameter("CleanerPhoneNumber").getBytes("ISO-8859-1"),"utf-8");
		String CleanerName = new String(request.getParameter("CleanerName").getBytes("ISO-8859-1"),"utf-8");
		String CleanerPassWord = new String(request.getParameter("CleanerPassWord").getBytes("ISO-8859-1"),"utf-8");
		String CleanerSex = new String(request.getParameter("CleanerSex").getBytes("ISO-8859-1"),"utf-8");
		int CleanerState = 0;
		ICBllFrame interfaceOfBllFrame=new CBllImpl();
		JSONObject json = new JSONObject();

		Cleaner cleaner = new Cleaner(CleanerName, CleanerSex, CleanerPhoneNumber, CleanerState, CleanerIDNumber, CleanerPassWord);
		boolean result=interfaceOfBllFrame.CleanerRegister(cleaner);

		json.put("result", result);
		System.out.println(json);
		PrintWriter out = response.getWriter();  
		out.println(json);
		out.flush(); 
		out.close();  
	}
}
