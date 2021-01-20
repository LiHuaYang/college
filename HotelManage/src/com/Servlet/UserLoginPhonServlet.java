package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.User;

public class UserLoginPhonServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

			response.setContentType("text/html");  
	        response.setCharacterEncoding("utf-8");
	        
	        JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
	        //int userId=jsonObject.getInt("UserId");
	        String userphon=jsonObject.getString("UserPhone");
	        String password=jsonObject.getString("UserPassword");
	        
	        ICBllFrame interfaceOfBllFrame=new CBllImpl();
	        JSONObject json = new JSONObject();
	        
	        
	        int userid=interfaceOfBllFrame.UserLoginPhon(userphon, password);
	        
//	        try {
//				json=new JSONArray().fromObject(result);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			
	        System.out.print(userid);
			if(userid!=0)
			{
				HttpSession session=request.getSession();
				session.setAttribute("UserId123",userid);
//				session.setAttribute("UserPic",result.get(0).getUserPicture());
//			    session.setAttribute("userName",result.get(0).getUserName());
//			    session.setAttribute("UserId123", result.get(0).getUserId()+"");
			    json.put("result", true);
			}else {
				 json.put("result", false);
	}
			
			System.out.println(userid);
	        PrintWriter out = response.getWriter();  
	       	out.println(json);
	        out.flush(); 
	        out.close();  
		}

	
}
