package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

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
 *时间：2015-10-21下午03:50:13
 *函数名：QueryUserPart
 *功能：查询用户参加的部门，包括用户职位
 *参数：@param UserId
 *参数：@return 
 *返回值：HashMap<String,Object>
 */
public class GetUserPart extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		// 获取参数
		JSONObject jsonObject = JSONObject.fromObject(new String(request
				.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int userId = jsonObject.getInt("userId");

		HashMap<String,Object> userpart = bllFrame.QueryUserPart(userId);
		JSONObject json = null;
		try {
			json = JSONObject.fromObject(userpart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
