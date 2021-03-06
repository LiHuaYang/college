package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.BllFame;
import com.Bll.IBllFrame;
import com.Entity.Activity;
import com.Entity.Comment;

public class CreateActivity extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//��ȡ����
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int activityBelongId=jsonObject.getInt("activityBelongId");
		String activityIntention=jsonObject.getString("activityIntention");
		int plotterId=jsonObject.getInt("plotterId");
		int plannerId=jsonObject.getInt("plannerId");
		Activity activity=new Activity(0, "", activityBelongId, 0, 0, plotterId, plannerId, "", "", "", "", activityIntention);
		IBllFrame bllFrame = new BllFame();
		boolean result=bllFrame.CreateActivity(activity);
		JSONObject json = new JSONObject();
		json.put("result", result);
		System.out.println(json);

		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
