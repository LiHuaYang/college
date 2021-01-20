package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.Bll.BllFame;
import com.Bll.IBllFrame;
/**
 * 
 *作者：movie
 *时间：2015-10-18下午04:31:41
 *函数名：QueryHotActivity
 *功能：查询热门活动
 *参数： 
 *返回值：void
 */
public class GetHotActivity extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame=new BllFame();
		List<HashMap<String, Object>> maps=bllFrame.QueryHotActivity();
		JSONArray json=null;
		try {
			json=JSONArray.fromObject(maps);
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
