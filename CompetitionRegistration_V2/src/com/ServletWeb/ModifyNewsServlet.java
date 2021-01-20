package com.ServletWeb;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.Dao.DaoNews;
import com.EntityAndroid.NewsInfo;

public class ModifyNewsServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
//		JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		int NewsId = jsonObject.getInt("newsId");// 用户ID
		String NewsTitle = jsonObject.getString("newstitle");
		String NewsContent = jsonObject.getString("newscontent");
		String NewsExtralInfo = jsonObject.getString("newsExtralInfo");
		int NewsState = jsonObject.getInt("newsState");
		int NewsTop= jsonObject.getInt("newsTop");
		//String NewsPicUrl = jsonObject.getString("newspic");
		String NewsSource = jsonObject.getString("newssource");
		
		
		JSONObject json = new JSONObject();
		
		NewsInfo news = new NewsInfo ();
		news.setNewsId(NewsId);
		news.setNewsTitle(NewsTitle);
		news.setNewsContent(NewsContent);
		news.setNewsExtralInfo(NewsExtralInfo);
		news.setNewsState(NewsState);
		news.setNewsTop(NewsTop);
		news.setNewsSource(NewsSource);
		
		DaoNews daonews = new DaoNews();
		boolean flag = daonews.ModifyNews(news);
		
		json.put("flag", flag);
		
		System.out.println("ModifyNews返回用户的数据：" + json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
