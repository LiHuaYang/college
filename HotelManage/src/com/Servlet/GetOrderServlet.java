package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.hibernate.criterion.Order;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.Room;
import com.Entity.RoomEquipment;

public class GetOrderServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8");  
		PrintWriter out = response.getWriter();  
		
		int orderId = Integer.parseInt(request.getParameter("OrderId"));
		ICBllFrame icBllFrame = new CBllImpl();
		
		HashMap<String, Object> map = icBllFrame.QueryOrder(orderId);
		JSONObject jsonObject = new JSONObject();
		Room room = (Room) map.get("Room");
		Order order = (Order) map.get("Order");
		RoomEquipment roomEquipment = (RoomEquipment) map.get("RoomEquipment");
		try {
			jsonObject.put("Room",room );
			jsonObject.put("Order", order);
			jsonObject.put("RoomEquipment", roomEquipment);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		String callbackName = request.getParameter("jsonp");
		String jsonpResult = String.format("%s(%s)", callbackName, jsonObject);
		System.out.println(jsonpResult);
		out.println(jsonpResult);
		out.flush(); 
		out.close();  
	}

}
