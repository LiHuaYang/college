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

import com.Dao.DaoCompetition;
import com.EntityWeb.Joiner;

public class GetJoinerInfo extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8"); 
		List<Joiner> joiners = null;
		
		
		DaoCompetition daocompetition = new DaoCompetition();
//		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));

		String key = jsonObject.getString("key"); 
		int type = jsonObject.getInt("type");
		System.out.println(type);
		if(type==1){
			joiners = daocompetition.GetJoinerInfo(key);
		}
		
		JSONArray array = JSONArray.fromObject(joiners);
		
		System.out.println("ContestSearchInfoServlet 返回给后台的数据:" + array);
		
		PrintWriter out = response.getWriter();
		out.println(array);
		out.flush();
		out.close();
	}
}
