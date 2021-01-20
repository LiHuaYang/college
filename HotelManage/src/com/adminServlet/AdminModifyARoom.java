package com.adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.Room;

public class AdminModifyARoom extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String RoomId = new String(request.getParameter("RoomId").getBytes(
				"ISO-8859-1"), "utf-8");
		String RoomPwd = new String(request.getParameter("RoomPwd").getBytes(
		"ISO-8859-1"), "utf-8");
		String RoomPrice = new String(request.getParameter("RoomPrice").getBytes(
		"ISO-8859-1"), "utf-8");
		
		String RoomType = new String(request.getParameter("RoomType").getBytes(
		"ISO-8859-1"), "utf-8");	
		
		System.out.println(RoomPrice);
		System.out.println(RoomType);
		System.out.println(RoomPwd);
		System.out.println(RoomId);
		
		int roomid = Integer.parseInt(RoomId);
		ICBllFrame interfaceOfBllFrame = new CBllImpl();
		Room result1 = interfaceOfBllFrame.GetARoomById(roomid);
		
		 if(RoomPrice != null || RoomPrice.length() > 0) {
			 int roomprice = Integer.parseInt(RoomPrice);
			 result1.setRoomUnitPrice(roomprice);
		 }
		 
		 if(RoomType != null || RoomType.length() > 0) {
			 int roomtype = Integer.parseInt(RoomType);
			 result1.setRoomType(roomtype);
		 }
		 
		 if(RoomPwd != null || RoomPwd.length() > 0) {
			 result1.setRoomPassword(RoomPwd);
		 }
		// TODO:加上Update操作
		JSONObject jsonObject = new JSONObject().fromObject(result1);
		System.out.println("AdminModifyARoom反客户端数据：" + jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}
}
