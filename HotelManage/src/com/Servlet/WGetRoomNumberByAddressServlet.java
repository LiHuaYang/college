package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.Room;

/**
 * !!修改 WGetRoomNumberByAddressServlet
 * 
 * @Author ariclee
 * @Date 2015-12-26 下午01:41:39
 * @Comment
 */

public class WGetRoomNumberByAddressServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String Address = new String(request.getParameter("Address").getBytes(
				"ISO-8859-1"), "utf-8");// 省

		System.out.println(Address);
		ICBllFrame icBllFrame = new CBllImpl();

		// public List<Room> GetRoomByAddressViilage(String address);
		List<Room> rooms = icBllFrame.GetRoomByAddressViilage(Address);

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("roomnumber", rooms.size());

		System.out.println(jsonObject);

		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}
}

//
// public class WGetRoomNumberByAddressServlet extends HttpServlet {
//
// public void service(HttpServletRequest request, HttpServletResponse response)
// throws ServletException, IOException {
// response.setContentType("text/html");
// response.setCharacterEncoding("utf-8");
// PrintWriter out = response.getWriter();
//
// ICBllFrame icBllFrame = new CBllImpl();
// String AddressProvince = new String(request.getParameter(
// "AddressProvince").getBytes("ISO-8859-1"), "utf-8");// 省
// String AddressCity = new String(request.getParameter("AddressCity")
// .getBytes("ISO-8859-1"), "utf-8");// 市
// String AddressVillage = new String(request.getParameter(
// "AddressVillage").getBytes("ISO-8859-1"), "utf-8");// 村
//		
//		
// Address address = icBllFrame.QueryAddressId(AddressProvince,
// AddressCity, AddressVillage);
// String RoomDetailAddress = new String(request.getParameter(
// "RoomDetailAddress").getBytes("ISO-8859-1"), "utf-8");// 房间详细地址
//		
//		
// int count = icBllFrame.GetRoomNumberByAddress(address.getAddressId(),
// RoomDetailAddress);
//		
// JSONObject jsonObject = new JSONObject();
// jsonObject.put("roomnumber", count);
// System.out.println(jsonObject);
// out.println(jsonObject);
// out.flush();
// out.close();
// }
// }
