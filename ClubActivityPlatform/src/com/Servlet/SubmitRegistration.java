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
/**
 * 
 *作者：movie
 *时间：2015-10-19下午07:08:47
 *函数名：SubmitRegistration
 *功能：批准申请人加入部门
 *参数：@param belongType
 *参数：@param belongId
 *参数：@param userId
 *参数：@return 
 *返回值：boolean
 */
public class SubmitRegistration extends HttpServlet {

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

		boolean result = bllFrame.SubmitRegistration(belongType, belongId, userId);
		JSONObject json = new JSONObject();
		json.put("result", result);
		PrintWriter out = response.getWriter();	
		out.println(json);
		out.flush();
		out.close();
	}
}
