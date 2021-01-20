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
import com.Entity.OrderTable;
import com.Entity.Room;
import com.Entity.RoomEquipment;

public class GetRoomByAddressServlet extends HttpServlet {

	@SuppressWarnings("static-access")
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
		
		JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		String AddressVillage=jsonObject.getString("AddressVillage");
		
		ICBllFrame interfaceOfBllFrame=new CBllImpl();
		JSONArray json = null;
		
		
		List<Room> result=interfaceOfBllFrame.GetRoomByAddressViilage(AddressVillage);
		try {
			json=new JSONArray().fromObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();

	}
}
