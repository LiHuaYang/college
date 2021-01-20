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

import sun.misc.Perf.GetPerfAction;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.Room;
import com.Entity.RoomCommit;
import com.Entity.RoomEquipment;

public class WGetRoomCommitServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8");  
		PrintWriter out = response.getWriter();  
		int RoomCommitId = Integer.parseInt(request.getParameter("RoomCommitId"));
		ICBllFrame icBllFrame = new CBllImpl();
		JSONObject jsonObject = new JSONObject();
		RoomCommit roomCommit = icBllFrame.getRoomCommit(RoomCommitId);
		try {
			jsonObject.put("RoomCommit",roomCommit );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObject);
		out.println(jsonObject);
		out.flush(); 
		out.close();  
	}
}
