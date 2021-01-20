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
import com.EntityAndroid.UserScoreInfo;
import com.EntityWeb.Competition;
import com.EntityWeb.User;

public class QueryScoreByUserid extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
		int Userid=jsonObject.getInt("Userid");
		List<UserScoreInfo> result = interfaceOfBllFrame.SearchScoreByUserid(Userid);
		JSONArray array = JSONArray.fromObject(result);
		System.out.println("ContestSearchInfoServlet 返回给后台的数据:" + array);
		PrintWriter out = response.getWriter();
		out.println(array);
		out.flush();
		out.close();
	}

}
