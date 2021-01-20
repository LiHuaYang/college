package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.BllFame;
import com.Bll.IBllFrame;
import com.Entity.Corporation;
import com.Entity.Plan;

/**
 * 
 *作者：movie
 *时间：2015-10-20上午09:51:17
 *函数名：QueryPlanByActivityId
 *功能：根据活动ID查询活动任务方案
 *参数：@param activityId
 *参数：@return 
 *返回值：Plan
 */
public class GetPlanByActivityId extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		//获取参数
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int activityId=jsonObject.getInt("activityId");
		Plan plan = bllFrame.QueryPlanByActivityId(activityId);
		JSONObject json = null;
		try {
			json = JSONObject.fromObject(plan);
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
