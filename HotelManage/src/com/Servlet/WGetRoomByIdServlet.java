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

public class WGetRoomByIdServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8");  
		PrintWriter out = response.getWriter();  
		//得到request中的Room数据
		int RoomId = Integer.parseInt(request.getParameter("RoomId"));//房间号
		ICBllFrame ibBllFrame = new CBllImpl();
		HashMap<String, Object> roominfo= ibBllFrame.QueryRoomDetail(RoomId);
		Room room = (Room) roominfo.get("Room");
		RoomEquipment roomEquipment = (RoomEquipment) roominfo.get("RoomEquipment");
		Address address = (Address) roominfo.get("Address");
		
		JSONObject jsonObject=new JSONObject();
		try {
			jsonObject.put("RoomInfo",tojsonObject(room, roomEquipment, address));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObject);
		out.println(jsonObject);
		out.flush(); 
		out.close();  
	}
	public JSONObject tojsonObject(Room room,RoomEquipment roomEquipment,Address address){
		JSONObject json =new JSONObject();
		//得到request中的Room数据
		json.put("RoomNumber", room.getRoomNumber());//房间号
		json.put("RoomPassWord", room.getRoomPassword());//房间密码
		json.put("RoomUnitPrice",room.getRoomUnitPrice()); //房间单价
		json.put("RoomType",room.getRoomType());//	房间类型
		json.put("RoomUsingState",room.getRoomUsingState());//	房间使用状态
		json.put("RoomLockState",room.getRoomLockState());//	房间锁状态
		json.put("RoomLongitude",room.getRoomLongitude());//	房间经度
		json.put("RoomLatitude",room.getRoomLatitude());//	房间纬度
		json.put("RoomMassage",room.getRoomMassage());//	房间描述
		json.put("RoomPassword",room.getRoomPassword())	;//	房间密码
		json.put("RoomPicture",room.getRoomPicture());//房间图片路径
		json.put("RoomDetailAddress",room.getRoomDetailAddress());//房间详细地址
		json.put("RoomId", room.getRoomId());//房间Id
		json.put("RoomEquipmentId",room.getRoomEquipmentId());//房间设备Id
		json.put("AddressId", room.getAddressId());//地址号信息
		//得到request中的RoomEquipment数据
		json.put("Necessities",roomEquipment.getNecessities());//	生活必需品
		json.put("TV",roomEquipment.getTV());//	电视
		json.put("AirConditioner",roomEquipment.getAirConditioner());//	空调
		json.put("Heating",roomEquipment.getHeating());//	暖气
		json.put("Kitchen",roomEquipment.getKitchen());//	厨房
		json.put("Network",roomEquipment.getNetwork());//	网络
		json.put("HotTub",roomEquipment.getHotTub());//	热水浴缸
		json.put("WashingMachine",roomEquipment.getWashingMachine());//	洗衣机
		json.put("SwimmingPool",roomEquipment.getSwimmingPool());//	游泳池
		json.put("DryingMachine",roomEquipment.getDryingMachine());//	烘干机
		json.put("Breakfast",roomEquipment.getBreakfast());//	早餐
		json.put("CoatHanger",roomEquipment.getCoatHanger());//	衣架
		json.put("Iron",roomEquipment.getIron());//	熨斗
		json.put("IndoorFirePlace",roomEquipment.getIndoorFirePlace());//	室内壁炉
		json.put("WheelchairAccessible",roomEquipment.getWheelchairAccessible());//	无障碍设施
		json.put("PETFacilities",roomEquipment.getPETFacilities());//	宠物设施
		json.put("WorkingSpace",roomEquipment.getWorkingSpace());//	工作区域
		
		//房间地址
		json.put("AddressProvince",address.getAddressProvince());//	省
		json.put("AddressCity",address.getAddressCity());//	市
		json.put("AddressVillage",address.getAddressVillage());//	村
		json.put("AddressPicture", address.getAddressPicture());//地区图片
		return json;
	}
}
