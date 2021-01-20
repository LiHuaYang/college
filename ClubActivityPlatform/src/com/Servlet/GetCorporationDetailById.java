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
import com.Entity.Corporation;
/**
 * 
 *作者：movie
 *时间：2015-10-19上午11:02:38
 *函数名：QueryCorporationDetailById
 *功能：查询社团详情
 *参数：@param corporationId
 *参数：@return 
 *返回值：Corporation
 */
public class GetCorporationDetailById extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		//获取参数
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int corporationId=jsonObject.getInt("corporationId");	
		Corporation corporation = bllFrame.QueryCorporationDetailById(corporationId);
		JSONObject json = null;
		try {
			json = JSONObject.fromObject(corporation);
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
