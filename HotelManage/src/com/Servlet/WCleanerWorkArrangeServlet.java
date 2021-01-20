package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Entity.CleanerWorkArrange;

public class WCleanerWorkArrangeServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");


		CBllFrame interfaceOfBllFrame = new CBllFrame();

		int RoomId = Integer.parseInt(request.getParameter("RoomId"));
		int CleanerId = Integer.parseInt(request.getParameter("CleanerId"));
		int CleanerWorkState = 0;

		CleanerWorkArrange cleanerWorkArrange = new CleanerWorkArrange(CleanerWorkState, RoomId, CleanerId);

		JSONObject json = new JSONObject();

		boolean result = interfaceOfBllFrame.AddCleanerWorkArrange(cleanerWorkArrange);
		json.put("result",result);

		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
}
