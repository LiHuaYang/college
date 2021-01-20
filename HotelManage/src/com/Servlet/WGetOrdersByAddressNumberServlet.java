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

public class WGetOrdersByAddressNumberServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8");  
		PrintWriter out = response.getWriter();  
		
		String AddressProvince = new String(request.getParameter("AddressProvince").getBytes("ISO-8859-1"),"utf-8");
		String AddressCity = new String(request.getParameter("AddressCity").getBytes("ISO-8859-1"),"utf-8");
		String AddressVillage = new String(request.getParameter("AddressVillage").getBytes("ISO-8859-1"),"utf-8");
		String DetatilAddress = new String(request.getParameter("DetatilAddress").getBytes("ISO-8859-1"),"utf-8");
		ICBllFrame icBllFrame = new CBllImpl();
		int count =icBllFrame.getOrderNumberByAddress(AddressProvince, AddressCity, AddressVillage, DetatilAddress);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("ordernum2", count);
		System.out.println(jsonObject);
		out.println(jsonObject);
		out.flush(); 
		out.close();  
	}
}
