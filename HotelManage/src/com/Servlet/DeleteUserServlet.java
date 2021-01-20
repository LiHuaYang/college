package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;

import net.sf.json.JSONObject;

public class DeleteUserServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		int userid=jsonObject.getInt("UserId");
		
		ICBllFrame interfaceOfBllFrame=new CBllImpl();
		JSONObject json = new JSONObject();
		
		boolean result1=interfaceOfBllFrame.DeleteUser(userid);
		json.put("result",result1);
		
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
