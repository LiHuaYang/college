package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

public class Loginout extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String sign="";
		
		HttpSession session=request.getSession();
		try{
			session.invalidate();
			sign="退出成功！";
		}catch (Exception e) {
			sign="退出失败！";
		}
		
		
		
		PrintWriter out = response.getWriter();
		Map<String, String> message=new HashMap<String, String>();
		message.put("result", sign);
		JSONObject json=JSONObject.fromObject(message);
		out.println(json);
		out.close();

	}
}
