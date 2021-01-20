package com.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Dao.DaoCompetition;

public class AddCompetitionProjectServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// JSONObject jsonObject = JSONObject.fromObject(new String(request
		// .getParameter("json").getBytes("ISO-8859-1"), "utf-8"));

		JSONObject jsonObject = JSONObject.fromObject(request
				.getParameter("json"));

		String competition_project = jsonObject
				.getString("competition_project");

		System.out.println(competition_project);

		DaoCompetition cd = new DaoCompetition();
		boolean flag = cd.AddCompetitionProject(competition_project);

		jsonObject.put("flag", flag);

		System.out.println(jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}
}
