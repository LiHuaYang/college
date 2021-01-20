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
import net.sf.json.JSONObject;

import com.Bll.BllFame;
import com.Bll.IBllFrame;
/**
 * 
 *作者：movie
 *时间：2015-10-14下午03:53:11
 *函数名：QueryPlanByPlanCreatorId
 *功能：根据任务发起人ID查询任务方案
 *参数：@param planCreatorId
 *参数：@return 
 *返回值： List<HashMap<String, Object>>
 */
public class GetPlanByPlanCreatorId extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		// 获取参数
		JSONObject jsonObject = JSONObject.fromObject(new String(request
				.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int planCreatorId = jsonObject.getInt("planCreatorId");

		List<HashMap<String, Object>> maps = bllFrame.QueryPlanByPlanCreatorId(planCreatorId);
		JSONArray json = null;
		try {
			json = JSONArray.fromObject(maps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("任务方案"+json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
