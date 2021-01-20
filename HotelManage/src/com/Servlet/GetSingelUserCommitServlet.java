package com.Servlet;

import java.io.IOException;
import net.sf.json.JSONObject;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.Cleaner;
import com.Entity.UserCommit;
public class GetSingelUserCommitServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
		
		
		JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
        int UserCommitId=jsonObject.getInt("UserCommitId");
        
        ICBllFrame interfaceOfBllFrame=new CBllImpl();
        JSONObject json = new JSONObject();
        UserCommit result= interfaceOfBllFrame.GetSingelUserCommit(UserCommitId);
        
        json.put("result", result);
        
        System.out.println(json);
        PrintWriter out = response.getWriter();  
       	out.println(json);
        out.flush(); 
        out.close(); 
	}

}
