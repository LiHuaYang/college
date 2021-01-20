package com.ServletAndroid;

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
import com.EntityAndroid.CompetitionNewsInfo;

public class CompetitionNewsServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
		IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
		JSONArray json = null;
		
		List<CompetitionNewsInfo> competitionNewsInfo=interfaceOfBllFrame.SearchCompetitionNamePicPro();
		
		int number_soon=interfaceOfBllFrame.Number_Competition(1);    //即将报名
		int number_ing=interfaceOfBllFrame.Number_Competition(2);    //正在报名
//		System.out.println("111"+number_soon);
//		System.out.println("222"+number_ing);
		JSONObject jsonObject = new JSONObject();
		
		try {
			json=new JSONArray().fromObject(competitionNewsInfo);
			jsonObject.put("flag", true);
			jsonObject.put("number_soon",number_soon);
			jsonObject.put("number_ing",number_ing);
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


}
