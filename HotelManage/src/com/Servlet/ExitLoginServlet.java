package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

public class ExitLoginServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");
        
        JSONObject json = new JSONObject();
        HttpSession session = request.getSession(false);
        if(session!=null){
        	try {
        		session.invalidate();
                System.out.println("session已经销毁");
                json.put("result", true);
			} catch (Exception e) {
				System.out.print("未销毁");
				json.put("result", false);
			}
        	
        }
        System.out.print(json);
        PrintWriter out = response.getWriter();  
       	out.println(json);
        out.flush(); 
        out.close();  
	}

}
