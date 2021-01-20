package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

public class UptateRoomServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8");  
		PrintWriter out = response.getWriter();  
		
		ICBllFrame icBllFrame = new CBllImpl();
		
		//得到request中的Room数据
		int RoomId = Integer.parseInt(request.getParameter("RoomId"));
		String RoomName =  new String(request.getParameter("RoomName").getBytes("ISO-8859-1"),"utf-8");//	省//房间名
		int RoomNumber = Integer.parseInt(request.getParameter("RoomNumber"));//房间命名号
		int	RoomUnitPrice = Integer.parseInt(request.getParameter("RoomUnitPrice"));//	单间房间价格
		int	RoomType = Integer.parseInt(request.getParameter("RoomType"));//	房间类型
		int	RoomUsingState = Integer.parseInt(request.getParameter("RoomUsingState"));//	房间使用状态
		int	RoomLockState = Integer.parseInt(request.getParameter("RoomLockState"));//	房间锁状态
		//int	RoomLongitude = Integer.parseInt(request.getParameter("RoomLongitude"));//	房间经度
		String	RoomLongitude	=  new String(request.getParameter("RoomLongitude").getBytes("ISO-8859-1"),"utf-8");//	房间经度
		String	RoomLatitude	=  new String(request.getParameter("RoomLatitude").getBytes("ISO-8859-1"),"utf-8");//	房间经度
//		int	RoomLatitude = Integer.parseInt(request.getParameter("RoomLatitude"));//	房间纬度
		String	RoomMassage	=  new String(request.getParameter("RoomMassage").getBytes("ISO-8859-1"),"utf-8");//	房间描述
		String	RoomPassword = new String(request.getParameter("RoomPassword").getBytes("ISO-8859-1"),"utf-8")	;//	房间密码
		String  RoomPicture= new String(request.getParameter("RoomPicture").getBytes("ISO-8859-1"),"utf-8");//房间图片路径
		String RoomDetailAddress = new String(request.getParameter("RoomDetailAddress").getBytes("ISO-8859-1"),"utf-8");//房间详细地址
		
		
		//得到request中的RoomEquipment数据
		int	Necessities	= Integer.parseInt(request.getParameter("Necessities"));//	生活必需品
		int	TV	= Integer.parseInt(request.getParameter("TV"));//	电视
		int	AirConditioner	= Integer.parseInt(request.getParameter("AirConditioner"));//	空调
		int	Heating	= Integer.parseInt(request.getParameter("Heating"));//	暖气
		int	Kitchen	= Integer.parseInt(request.getParameter("Kitchen"));//	厨房
		int	Network	= Integer.parseInt(request.getParameter("Network"));//	网络
		int	HotTub	= Integer.parseInt(request.getParameter("HotTub"));//	热水浴缸
		int	WashingMachine	= Integer.parseInt(request.getParameter("WashingMachine"));//	洗衣机
		int	SwimmingPool	= Integer.parseInt(request.getParameter("SwimmingPool"));//	游泳池
		int	DryingMachine	= Integer.parseInt(request.getParameter("DryingMachine"));//	烘干机
		int	Breakfast	= Integer.parseInt(request.getParameter("Breakfast"));//	早餐
		int	CoatHanger	= Integer.parseInt(request.getParameter("CoatHanger"));//	衣架
		int	Iron = Integer.parseInt(request.getParameter("Iron"));//	熨斗
		int	IndoorFirePlace	= Integer.parseInt(request.getParameter("IndoorFirePlace"));//	室内壁炉
		int	WheelchairAccessible	= Integer.parseInt(request.getParameter("WheelchairAccessible"));//	无障碍设施
		int	PETFacilities = Integer.parseInt(request.getParameter("PETFacilities"));//	宠物设施
		int	WorkingSpace = Integer.parseInt(request.getParameter("WorkingSpace"));//	工作区域

		//房间地址
		String	AddressProvince = new String(request.getParameter("AddressProvince").getBytes("ISO-8859-1"),"utf-8");//	省
		String	AddressCity	= new String(request.getParameter("AddressCity").getBytes("ISO-8859-1"),"utf-8");//	市
		String	AddressVillage	= new String(request.getParameter("AddressVillage").getBytes("ISO-8859-1"),"utf-8");//	村
		
		ICBllFrame ibBllFrame = new CBllImpl();
		RoomEquipment roomEquipment=new RoomEquipment(Breakfast, AirConditioner, CoatHanger, DryingMachine, Heating, HotTub, IndoorFirePlace, Iron, Kitchen, Necessities, Network, PETFacilities, SwimmingPool, TV, WashingMachine, WheelchairAccessible, WorkingSpace);
		int RoomEquipmentId = roomEquipment.getRoomEquipmentId();//房间设备号
		Address address = ibBllFrame.QueryAddressId(AddressProvince, AddressCity, AddressVillage);
		int AddressId = address.getAddressId();//地址号
		
		Room room = new Room(RoomNumber, RoomUnitPrice, RoomType, RoomUsingState, RoomLockState, RoomLongitude, RoomLatitude, RoomMassage, RoomPassword, RoomEquipmentId, RoomPicture, AddressId, RoomDetailAddress);

		JSONObject jsonObject = new JSONObject();
		boolean bisupdate = icBllFrame.UptateRoom(room, roomEquipment,address);
		try {
			jsonObject.put("Check", bisupdate);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		String callbackName = request.getParameter("jsonp");
		String jsonpResult = String.format("%s(%s)", callbackName, jsonObject);
		System.out.println(jsonpResult);
		out.println(jsonpResult);
		out.flush(); 
		out.close();  
	}
}
