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
import com.Entity.RoomEquipment;
/**
 * PGetRoomEquipment
 * 概述：返回房间设备
 * 输入：1. RoomEquipmentid
 * 输出：RoomEquipment
 * 备注：根据RoomEquipmentid返回房间设备详情
 * @author Aric
 *
 */
public class PGetRoomEquipment extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");        
        String callbackName = request.getParameter("jsonp");
        
        String RoomEquipmentid = new String(request.getParameter("RoomEquipmentid").getBytes("ISO-8859-1"),"utf-8");
        int  id = Integer.parseInt(RoomEquipmentid);
        
        IFrame interfaceOfBllFrame = new Impl();
        RoomEquipment result1 = interfaceOfBllFrame.GetRoomEquipmentsList(id);
        
        JSONArray jsonArray = new JSONArray().fromObject(result1);
        
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        
        System.out.println("反回客户端数据："+jsonpResult);
        
        PrintWriter out = response.getWriter();  
       	out.println(jsonpResult);
        out.flush(); 
        out.close();  
	}
}
