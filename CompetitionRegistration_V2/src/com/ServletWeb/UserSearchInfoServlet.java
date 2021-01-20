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
import com.EntityWeb.User;

public class UserSearchInfoServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
		IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
//		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		
		int page = jsonObject.getInt("page"); // 页数
		//JSONObject jsonSearchInfo = JSONObject.fromObject(jsonObject.getString("searchInfo"));
		
		// 调用业务层方法
		//List<User> result = interfaceOfBllFrame.UserSearchInfo(jsonSearchInfo, page);
		 List<User> result =  interfaceOfBllFrame.UserSearchInfo(page);
		JSONArray json = null; 
		try {
			json = JSONArray.fromObject(result);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("UserSearchInfoServlet 返回客户端的信息：" + json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
}

