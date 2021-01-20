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
 *时间：2015-10-20下午04:59:38
 *函数名：SumbitActivityMissionResult
 *功能：提交任务总结
 *参数：@param planId
 *参数：@param missionId
 *参数：@param missionResult
 *参数：@return 
 *返回值：boolean
 */
public class SumbitActivityMissionResult extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		//获取参数
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int planId =jsonObject.getInt("planId");
		int missionId=jsonObject.getInt("missionId");
		String missionResult=jsonObject.getString("missionResult");
	
		boolean result = bllFrame.SumbitActivityMissionResult(planId, missionId, missionResult);
		JSONObject json = new JSONObject();
		json.put("result", result);
		PrintWriter out = response.getWriter();	
		out.println(json);
		out.flush();
		out.close();
}


}
