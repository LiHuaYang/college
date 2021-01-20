package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetOrderRoomByUserIdServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("textml");  
        response.setCharacterEncoding("utf-8");  
		
		
		JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
        int userid=jsonObject.getInt("UserId");
        
        ICBllFrame interfaceOfBllFrame=new CBllImpl();
        JSONArray json = null;
        
        List<HashMap<String,Object>> result= interfaceOfBllFrame.QueryOrderRommByUserId(userid);
        
        try{
        	json=new JSONArray().fromObject(result);
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        System.out.println(json);
        PrintWriter out = response.getWriter();  
       	out.println(json);
        out.flush(); 
        out.close(); 

	}


}
