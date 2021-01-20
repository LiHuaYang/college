package com.Servlet.V2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.Tool.ScoreExcelHelper;

public class OpenCheckScore extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		JSONObject jsonData = JSONObject.fromObject(request.getParameter("data"));
		System.out.println(jsonData);
		
		String competitionName = jsonData.getString("CompetitionName");

	    IBllFrame iBllFrame = CBllFrame.getInstance();
		boolean result = iBllFrame.addReportSetToCache(competitionName);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", result);
		
		out.println(jsonObject);
		out.flush();
		out.close();
	}

}
