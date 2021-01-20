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

import com.Dao.DaoNews;
import com.EntityAndroid.NewsInfo;
import com.EntityWeb.News;

public class GetAllNewsListServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// JSONObject jsonObject = JSONObject.fromObject(new
		// String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request
				.getParameter("json"));

		int page = jsonObject.getInt("page"); // 页数

		DaoNews News = new DaoNews();

		List<News> result = News.getAllNews(page);

		JSONArray json = null;
		try {
			json = JSONArray.fromObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(" GetAllNewsListServlet 返回客户端的信息：" + json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
}
