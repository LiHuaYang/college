package com.ServletAndroid;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.EntityAndroid.CompetitionBasicInfo;

public class GetContestInfobyIdServlet extends HttpServlet {

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


	        
			int CompetitionId=Integer.parseInt(request.getParameter("CompetitionId"));
	        
			IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
			JSONArray json = null;
			
			
			List<CompetitionBasicInfo> competitionBasicInfo=interfaceOfBllFrame.GetWebContestInfobyId(CompetitionId);
			JSONObject jsonObject = new JSONObject();
			
			try {
				json=new JSONArray().fromObject(competitionBasicInfo);
				jsonObject.put("flag", true);
			} catch (Exception e) {
				e.printStackTrace();
				jsonObject.put("flag", false);
			}
			jsonObject.element("result", json); // 添加竞赛列表至JSON对象
			
			
			System.out.println(jsonObject);
			PrintWriter out = response.getWriter();
			out.println(jsonObject);
			out.flush();
			out.close();
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int CompetitionId=Integer.parseInt(request.getParameter("CompetitionId"));
        
		IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
		JSONArray json = null;
		
		
		List<CompetitionBasicInfo> competitionBasicInfo=interfaceOfBllFrame.GetContestInfobyId(CompetitionId);
		JSONObject jsonObject = new JSONObject();
		
		try {
			json=new JSONArray().fromObject(competitionBasicInfo);
			jsonObject.put("flag", true);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("flag", false);
		}
		jsonObject.element("result", json); // 添加竞赛列表至JSON对象
		
		
		System.out.println(jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
	}

}
