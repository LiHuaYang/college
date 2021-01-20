package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.Bll.BllFame;
import com.Bll.IBllFrame;

public class LoginServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//获取参数
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		System.out.println(jsonObject);
		String userroll = jsonObject.getString("userRoll");
		String password = jsonObject.getString("userPassword");
		IBllFrame bll = new BllFame();
		JSONObject json = new JSONObject();
		Map<String, Object> result = bll.Login(userroll, password);
		json=JSONObject.fromObject(result);
		
		if (Integer.parseInt(result.get("result").toString()) >0) {
			HttpSession session = request.getSession();
			session.setAttribute("UserId", result.get("result"));
		}
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
	}

}
