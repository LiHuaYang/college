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
import com.Entity.OrderTable;

/**
 * PcreateOrderServlet
 * 概述：用户下订单
 * 输入：1. userid	2. roomid	3. OrderStayinDay
 * 		4. OrderStayinPeopleNumber	5. OrderCheckinTime
 * 		6. OrderMoneynew	7. OrderState
 * 输出：boolean（订单是否增加成功的消息）
 * 备注：在用户点击下单以后，系统自动增加一条Order
 * @author Aric
 *
 */
public class PcreateOrderServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");        
        String callbackName = request.getParameter("jsonp");
        
        String userid  = new String(request.getParameter("userid").getBytes("ISO-8859-1"),"utf-8");
        String roomid  = new String(request.getParameter("roomid").getBytes("ISO-8859-1"),"utf-8");
        // 入住天数
        String OrderStayinDay = new String (request.getParameter("OrderStayinDay").getBytes("ISO-8859-1"),"utf-8");
        String OrderStayinPeopleNumber = new String (request.getParameter("OrderStayinPeopleNumber").getBytes("ISO-8859-1"),"utf-8");
        // 入住时间
        String OrderCheckinTime = new String (request.getParameter("OrderCheckinTime").getBytes("ISO-8859-1"),"utf-8");
        String OrderMoney = new String(request.getParameter("OrderMoneynew").getBytes("ISO-8859-1"),"utf-8");
        String OrderState = new String (request.getParameter("OrderState").getBytes("ISO-8859-1"),"utf-8");
        
        int user_id = Integer.valueOf(userid).intValue();
        int room_id = Integer.valueOf(roomid).intValue();
        int stay_day = Integer.valueOf(OrderStayinDay).intValue();
        int peo_num  = Integer.valueOf(OrderStayinPeopleNumber).intValue();
        int money = Integer.valueOf(OrderMoney).intValue();
        int state = Integer.valueOf(OrderState).intValue();
        
        IFrame interfaceOfBllFrame = new Impl();
        
        // 创建订单时候先进行日期格式转换：2015-12-25--》2015/12/25
        // String OrderCheckinTimeNew = new Impl().TransDateStr(OrderCheckinTime);
        // 算出用户退房时间
        String OrderCheckoutTime = new Impl().getCycleEndTime(OrderCheckinTime, stay_day);
        
        OrderTable order= new OrderTable(stay_day,peo_num,OrderCheckinTime,OrderCheckoutTime, money,state,user_id,room_id);
        System.out.println("应该退房时间:" + OrderCheckoutTime);
        
        // int OrderStayinDay,int	OrderStayinPeopleNumber	,String	OrderCheckinTime,int OrderMoney,int	OrderState,int	UserId,	int	RoomId)
        boolean result1 = interfaceOfBllFrame.CreateOrder(order);
        
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
