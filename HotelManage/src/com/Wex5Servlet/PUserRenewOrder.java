package com.Wex5Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import com.AndroidBll.IFrame;
import com.AndroidBll.Impl;
/**
 * PUserRenewOrder
 * 概述：用户续订订单
 * 输入：1. orderid	2. daycount	3. roomprice
 * 输出：boolean
 * 备注：
 * @author Aric
 *
 */
public class PUserRenewOrder extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        
        String callbackName = request.getParameter("jsonp");
        
        String str_orderid 	  = new String(request.getParameter("orderid").getBytes("ISO-8859-1"),"utf-8");
        String str_daycount   = new String(request.getParameter("daycount").getBytes("ISO-8859-1"),"utf-8");
        String str_roomprice  = new String(request.getParameter("roomprice").getBytes("ISO-8859-1"),"utf-8");
        
        int orderid = Integer.parseInt(str_orderid);
        int daycount = Integer.parseInt(str_daycount);
        int roomprice = Integer.parseInt(str_roomprice);
        IFrame interfaceOfBllFrame = new Impl();
        boolean result1 = interfaceOfBllFrame.RenewOrder(orderid, daycount, roomprice);
        
        JSONObject json1 = new JSONObject().fromObject(result1);
        
        json1.put("result", result1);
        
        PrintWriter out = response.getWriter();  
        String jsonpResult = String.format("%s(%s)", callbackName, json1);
        System.out.println("返回数据："+jsonpResult);
       	out.println(jsonpResult);
        out.flush(); 
        out.close(); 
	}
}
