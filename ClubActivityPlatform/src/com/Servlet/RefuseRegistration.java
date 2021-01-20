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

public class RefuseRegistration extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		//获取参数
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int userId =jsonObject.getInt("userId");
		int belongType=jsonObject.getInt("belongType");
		int belongId=jsonObject.getInt("belongId");

		boolean result = bllFrame.RefuseRegistration(belongType, belongId, userId);
		JSONObject json = new JSONObject();
		json.put("result", result);
		PrintWriter out = response.getWriter();	
		out.println(json);
		out.flush();
		out.close();
	}

}
