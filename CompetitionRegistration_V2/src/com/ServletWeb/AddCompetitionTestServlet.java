package com.ServletWeb;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.DaoCompetition;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AddCompetitionTestServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
			// JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
			JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
			//竞赛Id
			int ContestId = jsonObject.getInt("ContestId");	
			//试卷名字
			String TestPaperName = jsonObject.getString("TestPaperName");
			// 试卷科目
			String TestSubject = jsonObject.getString("TestSubject");
			// 试卷难度
			int TestDifficulty = jsonObject.getInt("TestDifficulty");
			// 知识点
			String TestKnowledgepoint = jsonObject.getString("TestKnowledgepoint");
			// 发布年份
			int TestYear = jsonObject.getInt("TestYear");
			String TestState = jsonObject.getString("TestState");
			
			// 时间
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String TestPaperTime = s.format(new Date());;
			// 试卷状态
			int TestPaperState = 1;	
			
			DaoCompetition competition = new DaoCompetition();
			
			int res = competition.CreateAContestTes(TestPaperName, TestPaperTime, TestPaperState, TestSubject, TestDifficulty, TestKnowledgepoint, TestYear, TestState, ContestId);
			
			JSONObject judge = new JSONObject();
			judge.put("TestId", res);
			
			System.out.println("AddCompetitionTestServlet 返回前台的数据:" + judge);
			
			PrintWriter out = response.getWriter();
			out.println(judge);
			out.flush();
			out.close();
	}
}
