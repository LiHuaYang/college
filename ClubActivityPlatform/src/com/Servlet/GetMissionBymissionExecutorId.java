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
 *时间：2015-10-22下午03:27:49
 *函数名：QueryMissionBymissionExecutorId
 *功能：根据用户查询他收到的子任务
 *参数：@param missionExecutorId
 *参数：@return 
 *返回值：List<Mission>
 */
public class GetMissionBymissionExecutorId extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

response.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");
//获取参数
JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
int missionExecutorId =jsonObject.getInt("missionExecutorId");
IBllFrame bllFrame=new BllFame();
List<HashMap<String, Object>> maps=bllFrame.QueryMissionBymissionExecutorId(missionExecutorId);
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
