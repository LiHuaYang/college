package com.ServletAndroid;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;

public class GetWeekCountEnrollmentByCompetiitonId extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		super.service(req, resp);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	        
		    int CompetitionId=Integer.parseInt(request.getParameter("CompetitionId"));//大赛id
	        
		    IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
			JSONObject json = new JSONObject();
			
			int result=interfaceOfBllFrame.GetWeekCountEnrollmentByCompetiitonId(CompetitionId);
			
			json.put("result",result);
			System.out.print(result);
			
			
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
	}
}
