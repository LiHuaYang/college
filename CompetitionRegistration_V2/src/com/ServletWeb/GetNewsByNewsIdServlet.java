package com.ServletWeb;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.Dao.DaoNews;
import com.EntityAndroid.NewsInfo;
import com.EntityWeb.News;
import com.EntityWeb.User;

public class GetNewsByNewsIdServlet extends HttpServlet {
			public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
//		JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		int NewsId=jsonObject.getInt("NewsId"); 
		//System.out.println(NewsId);
		
		DaoNews news = new DaoNews();
		JSONObject json = new JSONObject();
		List<NewsInfo> result = news.QuerySingleNewsbyId(NewsId);
		
		jsonObject.put("result", result);	
		
			System.out.println(jsonObject);
			PrintWriter out = response.getWriter();
			out.println(jsonObject);
			out.flush();
			out.close();
		}

}
