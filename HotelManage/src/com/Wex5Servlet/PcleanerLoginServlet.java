package com.Wex5Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.AndroidBll.IFrame;
import com.AndroidBll.Impl;
import com.Entity.Cleaner;

/**
 * PcleanerLoginServlet
 * 概述：保洁员登录
 * 输入：1. CleanerPhoneNumber	2. CleanerPassword
 * 输出：Cleaner
 * 备注：登陆后返回客户端保洁员自身的信息
 * @author Aric
 *
 */
public class PcleanerLoginServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");        
        String callbackName = request.getParameter("jsonp");
        
        // Requst对象接收数据，并开始解析
        String userinfo   = new String(request.getParameter("CleanerPhoneNumber").getBytes("ISO-8859-1"),"utf-8");
        String password   = new String(request.getParameter("CleanerPassword").getBytes("ISO-8859-1"),"utf-8");
        
        // 调用BLL层的方法将解析好的字符串，进行操作
        IFrame interfaceOfBllFrame = new Impl();
        JSONArray jsonArray = null; 
        
        // List<Cleaner> result1 = new ArrayList<Cleaner>();
        System.out.println("传入的帐号:"+userinfo+ "密码:" + password);
        
        List<Cleaner> result1 = interfaceOfBllFrame.CleanerLoginByPhone(userinfo,password);
        
        if(result1.size() == 0)
        {
            PrintWriter out = response.getWriter();  
            JSONObject js = new JSONObject();
            js.put("check", "false");
            js.put("reason", "wrong password!");
            String jsonpResult = String.format("%s(%s)", callbackName, js);
            System.out.println("反回客户端数据："+jsonpResult);
           	out.println(jsonpResult);
            out.flush(); 
            out.close();  
        }
        else{
        	// List<Cleaner> result = interfaceOfBllFrame.QueryCleanerByPhone(userinfo);
            try {
            	jsonArray = new JSONArray().fromObject(result1);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		// 将JSON对象转化为字符串
            String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
            // 打印字符串
            System.out.println(jsonpResult);
            PrintWriter out = response.getWriter();  
           	out.println(jsonpResult);
            out.flush(); 
            out.close();  
        }
	}
}
