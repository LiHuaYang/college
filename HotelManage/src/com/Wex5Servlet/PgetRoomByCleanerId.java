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

import com.AndroidBll.IFrame;
import com.AndroidBll.Impl;
import com.Entity.Room;
/**
 * PgetRoomByCleanerId
 * 概述：根据清洁工编号返回房间列表
 * 输入：1. cleanerid
 * 输出：List<Room>
 * 备注：每个保洁员都有自己负责的房间，返回的不仅仅是待打扫的房间
 * @author Aric
 *
 */
public class PgetRoomByCleanerId extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        
        String callbackName = request.getParameter("jsonp");
        
        // 传入CleanerId返回房间列表
        // select * from Room where Roomid = (select RoomId from CleanerWorkArrange where CleanerId = ?)
        // select * from room , CleanerWorkArrange where CleanerWorkArrange.roomid = room.roomId and Cleanerid = ?
        String ID = new String(request.getParameter("cleanerid").getBytes("ISO-8859-1"),"utf-8");
        int   cleanerid = Integer.parseInt(ID);
        
        IFrame interfaceOfBllFrame = new Impl();
        
        List<Room> result1 = new ArrayList<Room>();
        result1 = interfaceOfBllFrame.PCleanerGetRoom(cleanerid);
       
        // JSONObject json1 = new JSONObject().fromObject(result1);
        // json1.put("result", result1);        
        JSONArray jsonArray = null; 
        jsonArray = new JSONArray().fromObject(result1);
        
        PrintWriter out = response.getWriter();  
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        System.out.println("返回数据："+jsonpResult);
       	out.println(jsonpResult);
        out.flush(); 
	}
}
