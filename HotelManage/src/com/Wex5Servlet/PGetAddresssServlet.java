package com.Wex5Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.Address;
/**
 * PGetAddresssServlet
 * 概述：获取地区列表
 * 输入：无
 * 输出：List<Address>（地区列表）
 * 备注：在用户登录以后，返回给用户地区列表
 * @author Aric
 *
 */
public class PGetAddresssServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");        
        String callbackName = request.getParameter("jsonp");
        
        ICBllFrame interfaceOfBllFrame = new CBllImpl();
        List<Address> result1 = new ArrayList<Address>();
        result1 = interfaceOfBllFrame.GetAllAddress();
        
        JSONArray jsonArray;
        jsonArray = new JSONArray().fromObject(result1);
        
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        
        System.out.println("反回客户端数据："+jsonpResult);
        
        PrintWriter out = response.getWriter();  
       	out.println(jsonpResult);
        out.flush(); 
        out.close();  
	}
}
