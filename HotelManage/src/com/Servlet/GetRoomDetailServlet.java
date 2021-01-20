package com.Servlet;

import java.io.IOException;
import java.io.InputStream;
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
import com.Entity.OrderTable;
import com.Entity.Room;
import com.Entity.RoomEquipment;
import com.Test.HttpUtils;

public class GetRoomDetailServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		JSONObject jsonObject = JSONObject.fromObject(new String(request
				.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int roomId = jsonObject.getInt("RoomId");

		ICBllFrame interfaceOfBllFrame = new CBllImpl();
		JSONObject json = new JSONObject();
		HashMap<String, Object> result = interfaceOfBllFrame
				.QueryRoomDetail(roomId);

		// String URL_PATH =
		// "http://plh-pc:8080/HotelManage/img/address-img/beilun.jpg";
		//        
		// InputStream inputStream = HttpUtils.getInputStream(URL_PATH);
		// HttpUtils.saveInputStream(inputStream,"D:\\beilun.jpg");

		json.put("result", result);

		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
}
