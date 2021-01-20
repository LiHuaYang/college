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

public class ChangeUserServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
		
		
		JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
        int userId=jsonObject.getInt("UserId");
        String userName=jsonObject.getString("UserName");
//        String UserPassword=jsonObject.getString("UserPassword");
        String userSex=jsonObject.getString("UserSex");
        String userPhone=jsonObject.getString("UserPhone");
        String userEmail=jsonObject.getString("UserEmail");
        String userBoth=jsonObject.getString("UserBoth");
        String userIdNumber=jsonObject.getString("UserIDNumber");
//        int UserBalance=jsonObject.getInt("UserBalance");
        String userMessage=jsonObject.getString("UserMessage");
        
        ICBllFrame interfaceOfBllFrame=new CBllImpl();
        JSONObject json = new JSONObject();
//        User user=new User(UserName,UserSex,UserPhone,UserEmail,UserBoth,UserIDNumber,UserMessage);
        boolean result= interfaceOfBllFrame.UpdateUserPart(userId, userName, userSex, userBoth, userPhone, userEmail, userIdNumber, userMessage);
        
        
        json.put("result", result);
        
        System.out.println(json);
        PrintWriter out = response.getWriter();  
       	out.println(json);
        out.flush(); 
        out.close(); 
	}


}
