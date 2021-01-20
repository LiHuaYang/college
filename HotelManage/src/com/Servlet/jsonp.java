package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

public class jsonp extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter out = response.getWriter();  
       
        String type=new String(request.getParameter("lighttype").getBytes("ISO-8859-1"),"utf-8");
        String callbackName = request.getParameter("jsonp");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("type", type);
        String jsonpResult = String.format("%s(%s)", callbackName, jsonObject);
        System.out.println(jsonpResult);
       	out.println(jsonpResult);
        out.flush(); 
        out.close();  
	}

}
