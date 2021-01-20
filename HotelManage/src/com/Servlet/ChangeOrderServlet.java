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
import com.Entity.User;

public class ChangeOrderServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
		 
        int OrderId=Integer.parseInt(request.getParameter("OrderId"));
        int OrderStayinDay=Integer.parseInt(request.getParameter("OrderStayinDay"));
        int OrderStayinPeopleNumber=Integer.parseInt(request.getParameter("OrderStayinPeopleNumber"));
        String OrderCheckinTime=new String(request.getParameter("OrderCheckinTime").getBytes("ISO-8859-1"),"utf-8");
        int OrderMoney=Integer.parseInt(request.getParameter("OrderMoney"));
        int OrderState=Integer.parseInt(request.getParameter("OrderState"));
        int UserId=Integer.parseInt(request.getParameter("UserId"));
        int RoomId=Integer.parseInt(request.getParameter("RoomId"));
        String OrderUserIDnumber=new String(request.getParameter("OrderUserIDnumber").getBytes("ISO-8859-1"),"utf-8");
        String OrderUserphon=new String(request.getParameter("OrderUserphon").getBytes("ISO-8859-1"),"utf-8");
        String OrderUsername=new String(request.getParameter("OrderUsername").getBytes("ISO-8859-1"),"utf-8");
        String OrderCheckoutTime=new String(request.getParameter("OrderCheckoutTime").getBytes("ISO-8859-1"),"utf-8");
        String OrderTime = new String(request.getParameter("OrderTime").getBytes("ISO-8859-1"),"utf-8");
        ICBllFrame interfaceOfBllFrame=new CBllImpl();
        JSONObject json = new JSONObject();
        OrderTable order = new OrderTable(OrderId, OrderStayinDay, OrderStayinPeopleNumber, OrderCheckinTime, OrderTime, OrderCheckoutTime, OrderMoney, OrderState, UserId, RoomId, OrderUsername, OrderUserphon, OrderUserIDnumber);
        boolean result= interfaceOfBllFrame.UpdateOrder(order);
       
        json.put("result", result);
        
        System.out.println(json);
        PrintWriter out = response.getWriter();  
       	out.println(json);
        out.flush(); 
        out.close(); 
	}


}
