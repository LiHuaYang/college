package com.ServletWeb;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Dao.DaoNews;
import com.EntityAndroid.NewsInfo;

public class ModifyNewsStateServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
//		JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		int NewsId = jsonObject.getInt("newsId");// 用户ID
		
		
		JSONObject json = new JSONObject();
		
		DaoNews daonews = new DaoNews();
		boolean flag = daonews.ModifyNewsState(NewsId);
		
		json.put("flag", flag);
		
		System.out.println("ModifyNews返回用户的数据：" + json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
