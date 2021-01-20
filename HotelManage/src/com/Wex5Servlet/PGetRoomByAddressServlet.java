package com.Wex5Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.AndroidBll.IFrame;
import com.AndroidBll.Impl;
import com.Entity.Room;

/**
 * PGetRoomByAddressServlet
 * 概述：根据村庄名（宁海，鄞州等.）返回房间列表
 * 输入：1. village
 * 输出：List<Room>
 * 备注：
 * @author Aric
 *
 */
public class PGetRoomByAddressServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");        
        String callbackName = request.getParameter("jsonp");
        
        String village1  = new String(request.getParameter("village").getBytes("ISO-8859-1"),"utf-8");
        // String village1 = "舟山";
        // System.out.println(village1);
        IFrame interfaceOfBllFrame = new Impl();
        List<Room>  result1 = interfaceOfBllFrame.GetRoomByAddressViilage(village1);
      
        JSONArray jsonArray = new JSONArray().fromObject(result1);
        
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        System.out.println("反回客户端数据："+jsonpResult);
        PrintWriter out = response.getWriter();  
       	out.println(jsonpResult);
        out.flush(); 
        out.close();  
	}
}
