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
import com.Entity.Participants;
/**
 * 
 *作者：movie
 *时间：2015-10-18下午06:38:27
 *函数名：enterActivity
 *功能：报名活动
 *参数：@param participants
 *参数：@return 
 *返回值：boolean
 */
public class EnterActivity extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		//获取参数
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int activityId=jsonObject.getInt("activityId");
		int participantsId=jsonObject.getInt("participantsId");
		String participantsName=jsonObject.getString("participantsName");
		Participants participants=new Participants(activityId, participantsId, participantsName);
		boolean result = bllFrame.enterActivity(participants);
		JSONObject json = new JSONObject();
		json.put("result", result);
		System.out.println(json);
		PrintWriter out = response.getWriter();	
		out.println(json);
		out.flush();
		out.close();
}

}
