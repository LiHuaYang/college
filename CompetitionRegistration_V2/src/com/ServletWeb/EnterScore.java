package com.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Dao.DaoCompetition;

public class EnterScore extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8"); 
		
//		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		
		System.out.println("客户端传来的数据是：" + jsonObject);
		
		
		String id = jsonObject.getString("id"); // id
		String score = jsonObject.getString("score"); // 成绩
		DaoCompetition daocompetition = new DaoCompetition();
		daocompetition.enterscore(score, id);
		

		
		// System.out.println(jsonObject);
		
//		String array = jsonObject;
//		DaoCompetition daocompetition = new DaoCompetition();
//		daocompetition.Publish(contestid);
		
		PrintWriter out = response.getWriter();
		out.flush();
		out.close();
	}
}
