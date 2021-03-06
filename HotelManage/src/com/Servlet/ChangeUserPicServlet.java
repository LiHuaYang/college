package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.User;

public class ChangeUserPicServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
        int userId=jsonObject.getInt("UserId");
        String UserName=jsonObject.getString("UserPicture");
        
        ICBllFrame interfaceOfBllFrame=new CBllImpl();
        JSONObject json = new JSONObject();
        boolean result= interfaceOfBllFrame.ChangeUserPic(userId, UserName);
        
        
        json.put("result", result);
        
        System.out.println(json);
        PrintWriter out = response.getWriter();  
       	out.println(json);
        out.flush(); 
        out.close(); 
	}

	
}
