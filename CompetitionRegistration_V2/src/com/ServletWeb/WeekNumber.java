package com.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.EntityWeb.TestPaper;

public class WeekNumber extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
		IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
		JSONObject json = new JSONObject();
		int competitionId=Integer.parseInt(request.getParameter("CompetitionId"));
		
		int result=interfaceOfBllFrame.GetWeekCountEnrollmentByCompetiitonId(competitionId);
		
		json.put("result",result);
		System.out.println("周报名人数"+result);
		
		
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
	}
}
