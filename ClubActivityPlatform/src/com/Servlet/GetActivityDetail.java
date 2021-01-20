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
import com.Entity.Activity;
/**
 * 
 *作者：movie
 *时间：2015-10-20上午09:21:05
 *函数名：QuertActivityDetail
 *功能：通过活动ID查询活动详情
 *参数：@param activity
 *参数：@return 
 *返回值：Activity
 */
public class GetActivityDetail extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

response.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");
IBllFrame bllFrame = new BllFame();
//获取参数
JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
int activityId=jsonObject.getInt("activityId");	
Activity activity = bllFrame.QueryActivityDetail(activityId);
JSONObject json = null;
try {
	json = JSONObject.fromObject(activity);
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
