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

import com.Dao.DaoCompetition;
import com.EntityWeb.CompetitionBasicData;
import com.EntityWeb.TestYear;

public class GetTestYearServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
     request.setCharacterEncoding("UTF-8");
     response.setContentType("text/html;charset=UTF-8");
	
     DaoCompetition cd = new DaoCompetition();			
     List<TestYear> testyears = cd.getTestYearServlet();
     JSONObject json = new JSONObject();
		JSONArray jsonArray = null;
		
      jsonArray = new JSONArray().fromObject(testyears);
		
		try {
			json.put("testyears", jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("testyears"+json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	
	}
	

}
