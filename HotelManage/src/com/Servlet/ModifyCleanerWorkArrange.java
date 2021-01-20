package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Entity.CleanerWorkArrange;

public class ModifyCleanerWorkArrange extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
				
		String callbackName     = request.getParameter("jsonp");
		JSONObject jsonObject   = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		
		CBllFrame interfaceOfBllFrame = new CBllFrame();
		
		int room_id            = jsonObject.getInt("room_id");
		int cleaner_id         = jsonObject.getInt("cleaner_id");
		int cleaner_work_state = jsonObject.getInt("cleaner_wokr_id");

		CleanerWorkArrange cleanerWorkArrange = new CleanerWorkArrange(cleaner_work_state,room_id,cleaner_id);
		
		JSONObject json = new JSONObject();
		
		boolean result = interfaceOfBllFrame.AddCleanerWorkArrange(cleanerWorkArrange);
		jsonObject.put("result",result);
		
        String jsonpResult = String.format("%s(%s)", callbackName, json);
		System.out.println(jsonpResult);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
