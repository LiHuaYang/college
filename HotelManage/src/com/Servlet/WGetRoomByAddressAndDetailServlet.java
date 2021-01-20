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
import com.Dao.CDaoFrameImpl;
import com.Dao.IDaoFrame;
import com.Entity.Address;
import com.Entity.Room;

/**
 * WGetRoomByAddressAndDetailServlet
 * @Author ariclee
 * @Date 2015-12-28 ����06:21:28
 * @Comment�����ܵ�ǰ��ҳ���ʹ�ׯ��ģ����ַ�����ظõ����������Ϣ
 */
public class WGetRoomByAddressAndDetailServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		ICBllFrame interfaceOfBllFrame = new CBllImpl();
		IDaoFrame interfaceOfDaoFrame = new CDaoFrameImpl();
		int page = Integer.parseInt(request.getParameter("page"));

		String RoomDetailAddress = new String(request.getParameter(
				"RoomDetailAddress").getBytes("ISO-8859-1"), "utf-8");// ������ϸ��ַ

		JSONArray jsonArray = new JSONArray();
		// ���ݴ�ׯ��ģ����ѯ����ID
		Address address = interfaceOfDaoFrame.queryAddressByAddressVillage(RoomDetailAddress);
		
		// ģ����ѯ
		// ����ID��ģ���ؼ��֡�ҳ��
		LinkedMap maps = interfaceOfBllFrame.GetRoomByAddress(address
				.getAddressId(), RoomDetailAddress, page);

		Iterator ite = maps.entrySet().iterator();
		while (ite.hasNext()) {
			Map.Entry entry = (Map.Entry) ite.next();
			Object value = entry.getValue();
			LinkedMap map = (LinkedMap) value;
			Room room = (Room) map.get("Room");
			Address address2 = (Address) map.get("Address");
			jsonArray.add(toJSON(room, address2));
		}

		JSONObject jsonObject = new JSONObject();

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
	private Object toJSON(Room room, Address address2) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("RoomId", room.getRoomId());
		jsonObject.put("RoomPrice", room.getRoomUnitPrice());
		jsonObject.put("RoomLockState", room.getRoomLockState());
		jsonObject.put("RoomType", room.getRoomType());
		jsonObject.put("RoomUsingState", room.getRoomUsingState());
		if (address2 != null) {
			jsonObject.put("AddressProvince", address2.getAddressProvince());
			jsonObject.put("AddressCity", address2.getAddressCity());
			jsonObject.put("AddressVillage", address2.getAddressVillage());
		} else {
			jsonObject.put("AddressProvince", "");
			jsonObject.put("AddressCity", "");
			jsonObject.put("AddressVillage", "");
		}
		return jsonObject;
	}
}

//
// public class WGetRoomByAddressAndDetailServlet extends HttpServlet {
// public void service(HttpServletRequest request, HttpServletResponse response)
// throws ServletException, IOException {
//
// response.setContentType("text/html");
// response.setCharacterEncoding("utf-8");
// ICBllFrame interfaceOfBllFrame = new CBllImpl();
//
// int page = Integer.parseInt(request.getParameter("page"));
// String RoomDetailAddress = new String(request.getParameter(
// "RoomDetailAddress").getBytes("ISO-8859-1"), "utf-8");// ������ϸ��ַ
//
// String AddressProvince = new String(request.getParameter(
// "AddressProvince").getBytes("ISO-8859-1"), "utf-8");// ʡ
// String AddressCity = new String(request.getParameter("AddressCity")
// .getBytes("ISO-8859-1"), "utf-8");// ��
// String AddressVillage = new String(request.getParameter(
// "AddressVillage").getBytes("ISO-8859-1"), "utf-8");// ��
//
// Address address = interfaceOfBllFrame.QueryAddressId(AddressProvince,
// AddressCity, AddressVillage);
//
// JSONArray jsonArray = new JSONArray();
//
// LinkedMap maps = interfaceOfBllFrame.GetRoomByAddress(address
// .getAddressId(), RoomDetailAddress, page);
// Iterator ite = maps.entrySet().iterator();
// while (ite.hasNext()) {
// Map.Entry entry = (Map.Entry) ite.next();
// Object value = entry.getValue();
// LinkedMap map = (LinkedMap) value;
// Room room = (Room) map.get("Room");
// Address address2 = (Address) map.get("Address");
// jsonArray.add(toJSON(room, address2));
// }
//
// JSONObject jsonObject = new JSONObject();
//
// try {
// jsonObject.put("RoomInfo", jsonArray);
// } catch (Exception e) {
// e.printStackTrace();
// }
// System.out.println(jsonObject);
// PrintWriter out = response.getWriter();
// out.println(jsonObject);
// out.flush();
// out.close();
// }
//
// private Object toJSON(Room room, Address address2) {
// JSONObject jsonObject = new JSONObject();
// jsonObject.put("RoomId", room.getRoomId());
// jsonObject.put("RoomPrice", room.getRoomUnitPrice());
// jsonObject.put("RoomLockState", room.getRoomLockState());
// jsonObject.put("RoomType", room.getRoomType());
// jsonObject.put("RoomUsingState", room.getRoomUsingState());
// if (address2 != null) {
// jsonObject.put("AddressProvince", address2.getAddressProvince());
// jsonObject.put("AddressCity", address2.getAddressCity());
// jsonObject.put("AddressVillage", address2.getAddressVillage());
// } else {
// jsonObject.put("AddressProvince", "");
// jsonObject.put("AddressCity", "");
// jsonObject.put("AddressVillage", "");
// }
// return jsonObject;
// }
// }
