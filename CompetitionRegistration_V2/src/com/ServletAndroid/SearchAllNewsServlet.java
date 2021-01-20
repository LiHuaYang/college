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

//查找所有的新闻
public class SearchAllNewsServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
		JSONArray json = null;

		String getpage = request.getParameter("page"); // 页数
		int page = Integer.parseInt(getpage); // 转换类型

		List<News> NewsInfos = interfaceOfBllFrame.SearchAllNews(page);
		JSONObject jsonObject = new JSONObject();

		try {
			json = new JSONArray().fromObject(NewsInfos);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("message", "数据出错");
		}

		if (json.size() == 0) {
			jsonObject.put("flag", false);
			jsonObject.put("message", "数据为空");
		} else {
			jsonObject.put("flag", true);
		}

		jsonObject.element("result", json); // 添加新闻列表至JSON对象

		System.out.println(jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}
}