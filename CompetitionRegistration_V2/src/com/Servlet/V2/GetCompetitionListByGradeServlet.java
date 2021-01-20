package com.Servlet.V2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.Entity.V2.BriefCompetitionSet;
import com.Tool.MyOpecode;

public class GetCompetitionListByGradeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		JSONObject jsonData = JSONObject.fromObject(request.getParameter("data"));
		System.out.println(jsonData);
		int grade = jsonData.getInt("competitionGrade");
		
		IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
		
		BriefCompetitionSet briefCompetitionSet = interfaceOfBllFrame.getCompetitionSet(grade);
		
		JSONArray jsonArray = briefCompetitionSet.toJson(MyOpecode.competition.tojsonOfCmList);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data",jsonArray);
		jsonObject.put("msg", true);
		
		System.out.println("GetCompetitionListByGradeServlet:" + jsonObject);
		out.println(jsonObject);
		out.flush();
		out.close();
	}

}
