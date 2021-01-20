package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.Bll.BllFame;
import com.Bll.IBllFrame;
import com.Entity.Notice;

/**
 * 
 *作者：movie 
 *时间：2015-10-18下午10:01:25 
 *函数名：QueryHotNotice 
 *功能：查询热门布告 参数：@return
 * 返回值：List<Notice>
 */
public class GetHotNotice extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		List<Notice> notices = bllFrame.QueryHotNotice();
		JSONArray json = null;
		try {
			json = JSONArray.fromObject(notices);
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
