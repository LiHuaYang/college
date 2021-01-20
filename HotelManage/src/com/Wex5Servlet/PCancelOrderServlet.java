package com.Wex5Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.AndroidBll.IFrame;
import com.AndroidBll.Impl;

/**
 * PCancelOrderServlet
 * 概述：用户取消订单
 * 输入：1. userid	2. orderid
 * 输出：boolean （是否取消成功的消息）
 * @author Aric
 *
 */
public class PCancelOrderServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        
        String callbackName = request.getParameter("jsonp");
        
        String str_userid = new String(request.getParameter("userid").getBytes("ISO-8859-1"),"utf-8");
        String str_orderid = new String(request.getParameter("orderid").getBytes("ISO-8859-1"),"utf-8");
        
        int    userid = Integer.parseInt(str_userid);
        int    orderid = Integer.parseInt(str_orderid);
        
        IFrame interfaceOfBllFrame = new Impl();
        
        boolean result1 = interfaceOfBllFrame.CancelOrder(orderid, userid);

        JSONArray jsonArray = new JSONArray().fromObject(result1);
        
        PrintWriter out = response.getWriter();  
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        System.out.println("返回数据："+jsonpResult);
       	out.println(jsonpResult);
        out.flush(); 
        out.close(); 
	}
}
