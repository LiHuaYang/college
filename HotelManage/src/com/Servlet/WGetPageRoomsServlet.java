package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.LinkedMap;
import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.Address;
import com.Entity.Room;

public class WGetPageRoomsServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		int page = Integer.parseInt(request.getParameter("page"));
		
		ICBllFrame icBllFrame = new CBllImpl();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		LinkedMap maps = icBllFrame.GetPageRoomInfo(page);
		Iterator ite = maps.entrySet().iterator();
		while (ite.hasNext()) {
			Map.Entry entry = (Map.Entry) ite.next();
			Object value = entry.getValue();
			LinkedMap map = (LinkedMap) value;
			Room room = (Room) map.get("Room");
			Address address = (Address) map.get("Address");
			jsonArray.add(toJSON(room, address));
		}

		try {
			jsonObject.put("RoomInfo", jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();

	}

	public JSONObject toJSON(Room room, Address address) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("RoomId", room.getRoomId());
		jsonObject.put("RoomPrice", room.getRoomUnitPrice());
		jsonObject.put("RoomLockState", room.getRoomLockState());
		jsonObject.put("RoomType", room.getRoomType());
		jsonObject.put("RoomUsingState", room.getRoomUsingState());
		if (address != null) {
			jsonObject.put("AddressProvince", address.getAddressProvince());
			jsonObject.put("AddressCity", address.getAddressCity());
			jsonObject.put("AddressVillage", address.getAddressVillage());
		} else {
			jsonObject.put("AddressProvince", "");
			jsonObject.put("AddressCity", "");
			jsonObject.put("AddressVillage", "");
		}
		return jsonObject;
	}
}
