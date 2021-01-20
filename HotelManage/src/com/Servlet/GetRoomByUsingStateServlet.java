package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;


import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.Address;
import com.Entity.Room;

public class GetRoomByUsingStateServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8");  
		PrintWriter out = response.getWriter();  
		
		int roomUsingState = Integer.parseInt(request.getParameter("RoomUsingState"));
		ICBllFrame icBllFrame = new CBllImpl();
		
	    List<Room> rooms = icBllFrame.QueryRoomByUsingState(roomUsingState);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(rooms);
		
		try {
			jsonObject.put("rooms", jsonArray);
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
