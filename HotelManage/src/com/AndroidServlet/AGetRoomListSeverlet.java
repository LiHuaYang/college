package com.AndroidServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.AndroidBll.IFrame;
import com.AndroidBll.Impl;
import com.AndroidTool.OperationCode;
import com.Entity.Room;

public class AGetRoomListSeverlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		// 接收地区信息
		String addressVillage = new String(request.getParameter(
				OperationCode.Address.AddressVillage).getBytes("ISO-8859-1"),
				"utf-8");

		// 查询房间列表：给我该地区房间总数、剩余房间数、 房间信息
		// 房间总数：
		IFrame interfaceOfBllFrame = new Impl();
		List<HashMap<String, Object>> ResultlList = interfaceOfBllFrame
				.GetRoomList(addressVillage);

		String serverAddressStr = "http://10.20.4.128:8080/HotelManage/";
		// 添加服务器头部地址
		for (int i = 0; i < ResultlList.size(); i++) {

			HashMap<String, Object> has = ResultlList.get(i);
			Room room = (Room) has.get(OperationCode.Room.RoomList);

			StringBuffer addressBuffer = new StringBuffer(room.getRoomPicture());

			String addressPicture = addressBuffer.insert(0, serverAddressStr)
					.toString();
			System.out.println(addressPicture);
			room.setRoomPicture(addressPicture);
		}

		JSONArray jsonArray = new JSONArray().fromObject(ResultlList);

		PrintWriter out = response.getWriter();

		String jsonpResult = String.format("%s", jsonArray);

		System.out.println("返回数据：" + jsonpResult);
		out.println(jsonpResult);
		out.flush();
	}

}
