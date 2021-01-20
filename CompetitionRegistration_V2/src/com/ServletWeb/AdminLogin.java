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

public class AdminLogin extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8"); 
		int judge=0;
		
//		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));

		String username = jsonObject.getString("username"); // 页数
		String password = jsonObject.getString("password"); // 类型
		if(username.equals("root")&&password.equals("123456")){
			judge=1;
		}
		
		System.out.println("ContestSearchInfoServlet 返回给后台的数据:" + judge);
		
		PrintWriter out = response.getWriter();
		out.println(judge);
		out.flush();
		out.close();
	}
}
