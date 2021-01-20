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



import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.Address;
import com.Entity.Room;
import com.Entity.RoomEquipment;

public class LockCheckRoomServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8");  
		PrintWriter out = response.getWriter();  
		
		int roomId = Integer.parseInt(request.getParameter("RoomId"));
		int RoomLockState = Integer.parseInt(request.getParameter("RoomLockState"));
		
		ICBllFrame icBllFrame = new CBllImpl();
		boolean bisLock = icBllFrame.LockCheckRoom(roomId, RoomLockState);
		
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("Check", bisLock);
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
