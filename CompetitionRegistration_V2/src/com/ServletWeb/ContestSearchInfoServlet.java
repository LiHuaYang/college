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
import com.EntityWeb.CompetitionInfo;

public class ContestSearchInfoServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8"); 
		List<CompetitionInfo> competitionInfos = null;
		
		
		IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
//		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));

		int page = jsonObject.getInt("page"); // 页数
		int type = jsonObject.getInt("type"); // 类型
		//JSONArray array =null;
		// 0: 大赛数据列表初始化
		if(type == 0) {
			competitionInfos = interfaceOfBllFrame.ContestSearchInfo(page);	
			//System.out.println("type==0:"+competitionInfos);
			// array = JSONArray.fromObject(competitionInfos);
		}
		// 1: 大赛数据查找
		if(type == 1) {
			
			String keyword = jsonObject.getString("contest_name_keywords");
			System.out.println(keyword);
			competitionInfos = interfaceOfBllFrame.ContestSearchbyname(keyword, page);
			// array = JSONArray.fromObject(competitionInfos);
		}
		
		JSONArray array = JSONArray.fromObject(competitionInfos);
		
		System.out.println("ContestSearchInfoServlet 返回给后台的数据:" + array);
		
		PrintWriter out = response.getWriter();
		out.println(array);
		out.flush();
		out.close();
	}
}
