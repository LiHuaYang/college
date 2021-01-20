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

public class Publish extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8"); 
		
//		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
//		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
//		System.out.println("客户端传来的数据是：" + jsonObject1);
//		System.out.println("客户端传来的数据是：" + jsonObject2);
//		
//		JSONArray jsonArray1 =  JSONArray.fromObject(jsonObject1.getString("json"));
//		JSONArray jsonArray2 =  JSONArray.fromObject(jsonObject2.getString("json"));
		String CompetitionName = jsonObject.getString("CompetitionName"); 
		int State = jsonObject.getInt("State"); 
		
		//System.out.println("解析后的数据是：" + jsonArray2);
	//	int length  = jsonArray1.size();
		//for (int i=0; i<length; i++) {
		//	String str = (String) jsonArray1.get(i);
		//	String str1 = (String) jsonArray2.get(i);
			DaoCompetition daocompetition = new DaoCompetition();
			boolean flag=daocompetition.DealState(CompetitionName,State);
			System.out.println(State+CompetitionName);
		//}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
}
