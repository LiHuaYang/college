package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.BllFame;
import com.Bll.IBllFrame;
import com.Entity.Mission;
/**
 * 
 *作者：movie
 *时间：2015-10-19下午07:56:04
 *函数名：CreateMission
 *功能：创建并发布子任务
 *参数：@param mission
 *参数：@return 
 *返回值：boolean
 */
public class CreateMission extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//获取参数
		JSONArray jsonArray = JSONArray.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		List<Mission> missions=new ArrayList<Mission>();
		for (int i = 0; i < jsonArray.size(); i++) {
			Mission mission=new Mission(jsonArray.getJSONObject(i));
			missions.add(mission);
		}
		IBllFrame bllFrame = new BllFame();
		boolean result=bllFrame.CreateMission(missions);
		JSONObject json = new JSONObject();
		json.put("result", result);
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
