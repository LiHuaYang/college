package com.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.EntityWeb.StudentScoreInfo;

public class GetStudentScore extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
		
//		JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		int type = jsonObject.getInt("type");
		List<StudentScoreInfo> scoreInfos = null;
		if (1 == type) {
			String name = jsonObject.getString("key");
			scoreInfos = interfaceOfBllFrame.GetStudentScore(name);
		}
		if (2 == type) {
			String comname = jsonObject.getString("competitionName");
			String subname = jsonObject.getString("sujectName");
			scoreInfos = interfaceOfBllFrame.GetStudentScore(comname, subname);
		}

		JSONArray array = JSONArray.fromObject(scoreInfos);
		System.out.println("GetStudentScore 返回客户端的数据: " + array);
		PrintWriter out = response.getWriter();
		out.println(array);
		out.flush();
		out.close();
	}
}
