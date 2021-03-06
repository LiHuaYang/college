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
import com.Bll.RegistrationHandle.Registration;
import com.Entity.Participants;
/**
 * 
 *作者：movie
 *时间：2015-10-18下午06:43:37
 *函数名：QueryActivityEnter
 *功能：查看活动报名人员
 *参数：@param activityId
 *参数：@return 
 *返回值：List<Participants>
 */
public class GetActivityEnter extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		//获取参数
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int activityId=jsonObject.getInt("activityId");

	
		List<Participants> registrations=bllFrame.QueryActivityEnter(activityId);
		JSONArray json=JSONArray.fromObject(registrations);
		System.out.println(json);
		PrintWriter out = response.getWriter();	
		out.println(json);
		out.flush();
		out.close();
	}

	
}
