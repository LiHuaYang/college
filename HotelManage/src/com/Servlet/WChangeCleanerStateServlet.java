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

public class WChangeCleanerStateServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8");  

		int CleanerId = Integer.parseInt(request.getParameter("CleanerId"));
		int CleanerState = Integer.parseInt(request.getParameter("CleanerState"));
		ICBllFrame interfaceOfBllFrame=new CBllImpl();
		JSONObject json = new JSONObject();

		boolean Check=interfaceOfBllFrame.UpdateCleanerState(CleanerId, CleanerState);
		try {
			json.put("Check", Check);
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
