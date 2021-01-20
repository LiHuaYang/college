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
import com.Entity.Room;
/**
 * PGetRoomDetailServlet
 * 概述：返回房间详情
 * 输入：1. roomid
 * 输出：Room
 * 备注：根据RoomId返回房间详情
 * @author Aric
 *
 */
public class PGetRoomDetailServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        
        String callbackName = request.getParameter("jsonp");
        
		// JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
        String roomId = new String(request.getParameter("roomid").getBytes("ISO-8859-1"),"utf-8");
        int roomid = Integer.parseInt(roomId);
        
        IFrame interfaceOfBllFrame = new Impl();
        
        Room result = new Room();
        result= interfaceOfBllFrame.GetRoomDetail(roomid);
       
        JSONObject json1 = new JSONObject().fromObject(result);
        //json1.put("result", result);
        
        PrintWriter out = response.getWriter();  
        String jsonpResult = String.format("%s(%s)", callbackName, json1);
        System.out.println("返回数据："+jsonpResult);
       	out.println(jsonpResult);
        out.flush(); 
        out.close(); 
	}
}
