//package com.Servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import net.sf.json.JSONObject;
//
//import com.Bll.CBllImpl;
//import com.Bll.ICBllFrame;
//
//public class WGetRechageRecordNubmerServlet extends HttpServlet {
//
//
//	public void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		response.setContentType("text/html");  
//		response.setCharacterEncoding("utf-8");  
//		PrintWriter out = response.getWriter();  
//		
//		ICBllFrame icBllFrame = new CBllImpl();
//		int count =icBllFrame.getRechargeRecordNumber();
//		JSONObject jsonObject=new JSONObject();
//		jsonObject.put("rechargerecordnumber", count);
//		System.out.println(jsonObject);
//		out.println(jsonObject);
//		out.flush(); 
//		out.close();  
//	}
//
//	
//}
