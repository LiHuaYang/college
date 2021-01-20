package com.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;

public class  ModifyUser extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
//		JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		String ModifyType1 = jsonObject.getString("ModifyType"); // 修改类型
		int UserId = jsonObject.getInt("UserId");// 用户ID
		
		int ModifyType = Integer.parseInt(ModifyType1);
		
		IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
		
		JSONObject json = new JSONObject();
		
		// ModifyType=1 为用户删除 
		// ModifyType=2 为用户恢复
		boolean flag = interfaceOfBllFrame.ModifyUser(UserId, ModifyType);
		
		json.put("flag", flag);
		
		System.out.println("ModifyUser 返回用户的数据：" + json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
}
