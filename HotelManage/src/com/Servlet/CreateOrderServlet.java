package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.OrderTable;

public class CreateOrderServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        
        JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
        int OrderStayinDay=jsonObject.getInt("OrderStayinDay");
        int OrderStayinPeopleNumber=jsonObject.getInt("OrderStayinPeopleNumber");
        String OrderCheckinTime=jsonObject.getString("OrderCheckinTime");
        String OrderCheckoutTime=jsonObject.getString("OrderCheckoutTime");
        int OrderMoney=jsonObject.getInt("OrderMoney");
        int OrderState=jsonObject.getInt("OrderState");
        int UserId=jsonObject.getInt("UserId");
        int RoomId=jsonObject.getInt("RoomId");
        String OrderUsername=jsonObject.getString("OrderUsername");
        String OrderUserphon=jsonObject.getString("OrderUserphon");
        String OrderUserIDnumber=jsonObject.getString("OrderUserIDnumber");
              
        ICBllFrame interfaceOfBllFrame=new CBllImpl();
        JSONObject json = new JSONObject();
        OrderTable order=new OrderTable(OrderUserIDnumber, OrderUserphon, OrderUsername, 
        		OrderStayinDay, OrderStayinPeopleNumber, 
        		OrderCheckinTime, OrderCheckoutTime, OrderMoney, OrderState, UserId, RoomId);
        
        boolean result=interfaceOfBllFrame.CreateOrder(order);
        
        json.put("result", result);
        
        //String jsonpResult = String.format("%s(%s)", callbackName, jsonObject);
        
        System.out.println(json);
        PrintWriter out = response.getWriter();  
       	out.println(json);
        out.flush(); 
        out.close();  
	}

}
