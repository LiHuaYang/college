package com.AndroidServlet;

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
import com.AndroidTool.OperationCode;
import com.Entity.Room;

public class ABookARoomServelet extends HttpServlet {
//	public void service(HttpServletRequest request, HttpServletResponse response) 
//	throws ServletException, IOException {
//		response.setContentType("text/html");  
//        response.setCharacterEncoding("utf-8");  
//        // 入住时间	入住天数	入住人数	退房时间	付款金额	房间号	用户号
//        String toLiveTime = new String(request.getParameter(OperationCode.Order.OrderCheckinTime).getBytes("ISO-8859-1"),"utf-8");
//        // 离开时间
//        String livetime = new String(request.getParameter(OperationCode.Order.OrderCheckoutTime).getBytes("ISO-8859-1"),"utf-8");
//        // 预定人、房间编号，入住人数、付款金额、入住天数、预定时间
//        String user = new String(request.getParameter(OperationCode.Address.AddressVillage).getBytes("ISO-8859-1"),"utf-8");
//        
//        System.out.println("安卓端数据--房间类型" + roomtype);
//        System.out.println("安卓端数据--入住时间" + toLiveTime);
//        System.out.println("安卓端数据--退房时间" + livetime);
//        System.out.println("安卓端数据--地区" + address);
//        
//        IFrame interfaceOfBllFrame = new Impl();
//        List<Room> eligibleRoomList = interfaceOfBllFrame.GetEligibleRoom(roomtype, address);
//        
//        JSONArray jsonArray  = new JSONArray().fromObject(eligibleRoomList);
//        
//        PrintWriter out = response.getWriter();  
//        
//        String jsonpResult = String.format("%s", jsonArray);
//        System.out.println("返回数据"+jsonpResult);
//       	out.println(jsonpResult);
//        out.flush(); 
//	}
}
