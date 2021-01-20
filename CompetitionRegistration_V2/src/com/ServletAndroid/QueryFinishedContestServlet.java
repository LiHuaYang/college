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
import com.EntityAndroid.CompetitionBasicInfo;

//获得所有已结束的比赛科目
public class QueryFinishedContestServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
		IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
		JSONArray json = null;
		JSONObject jsonObject=new JSONObject();
		
		
		List<CompetitionBasicInfo> result=interfaceOfBllFrame.QueryFinishedContest();
		try {
			json=new JSONArray().fromObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jsonObject.element("result",json);
		
		System.out.println(jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}


}