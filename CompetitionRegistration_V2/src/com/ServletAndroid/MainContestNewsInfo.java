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
import com.EntityAndroid.UserScoreInfo;

//通过选择年级和报名状态显示大赛列表
public class MainContestNewsInfo extends HttpServlet{

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
		    System.out.println("get");
			JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
			String contestObject = request.getParameter("ContestObject"); //竞赛对象
			String contestState  =request.getParameter("ContestState");    //竞赛状态
			int ContestObject=Integer.parseInt(contestObject);
			int ContestState=Integer.parseInt(contestState);
	        
			IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
			JSONArray json = null;
			
			List<CompetitionBasicInfo> UserScoreInfos=interfaceOfBllFrame.SearchCompetitionMain(ContestObject, ContestState);
			jsonObject = new JSONObject();
			
			try {
				json=new JSONArray().fromObject(UserScoreInfos);
			} catch (Exception e) {
				e.printStackTrace();
				jsonObject.put("message","数据出错");
			}
			
			if(json.size()!=0){
				jsonObject.put("flag", true);
				jsonObject.element("result", json); // 添加竞赛列表至JSON对象
			}
			else{
				jsonObject.put("flag", false);
				jsonObject.put("message","搜索为空");
			}
			System.out.println(jsonObject);
			PrintWriter out = response.getWriter();
			out.println(jsonObject);
			out.flush();
			out.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post");
		String contestObject = request.getParameter("ContestObject"); //竞赛对象
		String contestState  =request.getParameter("ContestState");    //竞赛状态
		int ContestObject=Integer.parseInt(contestObject);
		int ContestState=Integer.parseInt(contestState);
        
		IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
		JSONArray json = null;
		
		List<CompetitionBasicInfo> UserScoreInfos=interfaceOfBllFrame.SearchCompetitionMain(ContestObject, ContestState);
		JSONObject jsonObject = new JSONObject();
		
		try {
			json=new JSONArray().fromObject(UserScoreInfos);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("message","数据出错");
		}
		
		if(json.size()!=0){
			jsonObject.put("flag", true);
			jsonObject.element("result", json); // 添加竞赛列表至JSON对象
		}
		else{
			jsonObject.put("flag", false);
			jsonObject.put("message","搜索为空");
		}
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
