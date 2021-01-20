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
import com.Dao.DaoCompetition;
import com.Entity.V2.DetailedCompetition;

/**
 * 
 * 根据浏览器的请求，返回相应的大赛详细信息
 * 
 */
public class GetCompetitionDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		IBllFrame icBllFrame = (IBllFrame) CBllFrame.getInstance(); // 取得实例
		
		JSONObject jsonData = JSONObject.fromObject(request.getParameter("data"));
		System.out.println(jsonData);
		int competitionId = jsonData.getInt("competitionId");
		
		
//		JSONObject jsonMSG  = JSONObject.fromObject(request.getParameter("msg"));
//		int competitionId = Integer.parseInt(request.getParameter("competitionId"));   
		
//		System.out.println("jsonData--" + jsonData);
//		
//		int competitionId = jsonData.getInt("competitionId");
		
		System.out.println("competitionId--" + competitionId);
		
		DetailedCompetition competition = icBllFrame.getCompetitionDetail(competitionId);	//接受大赛ID
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", competition.toJson());
		jsonObject.put("msg", true);
		
		System.out.println("GetCompetitionDetailServlet:" + jsonObject);
		out.println(jsonObject);
		out.flush();
		out.close();
	}
}
