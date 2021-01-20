package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.RoomCommit;

public class WGetRoomCommintNumberServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8");  
		PrintWriter out = response.getWriter();  
		
		ICBllFrame icBllFrame = new CBllImpl();
		int count =icBllFrame.getRoomCommunitNumber();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("roomcommunitnumber", count);
		System.out.println(jsonObject);
		out.println(jsonObject);
		out.flush(); 
		out.close();  
	}

}
