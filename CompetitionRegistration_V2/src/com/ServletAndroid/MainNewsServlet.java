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
import com.EntityWeb.News;

public class MainNewsServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");

		
		IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
		JSONArray json = null;


		List<News> news=interfaceOfBllFrame.SearchNewsTopStaTime();
		JSONObject jsonObject = new JSONObject();

		try {
			json=new JSONArray().fromObject(news);
			jsonObject.put("flag", true);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("flag", false);
		}
		jsonObject.element("result", json); // 添加新闻列表至JSON对象


		System.out.println(jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();

	}
}
