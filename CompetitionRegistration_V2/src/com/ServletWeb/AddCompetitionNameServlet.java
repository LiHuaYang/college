package com.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Dao.DaoCompetition;

public class AddCompetitionNameServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// JSONObject jsonObject = JSONObject.fromObject(new String(request
		// .getParameter("json").getBytes("ISO-8859-1"), "UTF-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));

		System.out.println("基础数据添加--JSON格式数据：" + jsonObject);

		String competition_name = jsonObject.getString("competition_name");
		System.out.println("添加基础数据--大赛名：" + competition_name);
		String competition_simple_name = jsonObject.getString("competition_simple_name");
		System.out.println("添加基础数据--大赛简称：" + competition_simple_name);

		System.out.println(competition_name);
		System.out.println(competition_simple_name);

		DaoCompetition cd = new DaoCompetition();
		boolean flag = cd.AddCompetitionName(competition_name,competition_simple_name);

		jsonObject.put("flag", flag);

		System.out.println(jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}
}
