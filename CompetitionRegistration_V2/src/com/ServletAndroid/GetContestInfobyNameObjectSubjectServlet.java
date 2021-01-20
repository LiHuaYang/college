package com.ServletAndroid;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.EntityAndroid.CompetitionBasicInfo;

public class GetContestInfobyNameObjectSubjectServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		super.service(req, resp);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		String condition = request.getParameter("contestSearchWords");//大赛名字
		System.out.println("大赛搜索词--" + condition);

		IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
		JSONArray json = null;
		jsonObject = new JSONObject();

		List result = interfaceOfBllFrame.QuerySearchCompetition(condition);
		try {
			json = new JSONArray().fromObject(result);
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

		jsonObject.element("result", json);

		System.out.println(jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String condition = request.getParameter("contestSearchWords");
		System.out.println(condition);

		IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
		JSONArray json = null;
		JSONObject jsonObject = new JSONObject();

		List<CompetitionBasicInfo> result = interfaceOfBllFrame.QuerySearchCompetition(condition);
		try {
			json = new JSONArray().fromObject(result);
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

		jsonObject.element("result", json);

		System.out.println(jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
	}

}
