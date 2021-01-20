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
import com.EntityWeb.Joiner;

//显示所有参赛人员列表
public class QueryAllCompetitionUserServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int page=Integer.parseInt(request.getParameter("page"));   //页数

		IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
		JSONArray json = null;
		JSONObject jsonObject=new JSONObject();
		
		List<Joiner> result = interfaceOfBllFrame.QueryAllCompetitionUser(page);
		
		try {
			json=new JSONArray().fromObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.element("result",json);

		System.out.println(jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}
}