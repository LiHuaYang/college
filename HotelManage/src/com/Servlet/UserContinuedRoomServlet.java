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

public class UserContinuedRoomServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("textml");
		JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		int orderId=jsonObject.getInt("OrderId");
		int increaseDay=jsonObject.getInt("increaseDay");
		String OrderCheckoutTime=jsonObject.getString("OrderCheckoutTime");
		int OrderMoney=jsonObject.getInt("OrderMoney");
		
		
		ICBllFrame interfaceOfBllFrame=new CBllImpl();
		JSONObject json = new JSONObject();
		
		boolean result1=interfaceOfBllFrame.UserContinuedRoom(orderId,increaseDay,OrderCheckoutTime,OrderMoney);
		json.put("result",result1);
		
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();

	}

	

}
