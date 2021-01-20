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
		//�õ�request�е�Room����
		int RoomId = Integer.parseInt(request.getParameter("RoomId"));//�����
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
		//�õ�request�е�Room����
		json.put("RoomNumber", room.getRoomNumber());//�����
		json.put("RoomPassWord", room.getRoomPassword());//��������
		json.put("RoomUnitPrice",room.getRoomUnitPrice()); //���䵥��
		json.put("RoomType",room.getRoomType());//	��������
		json.put("RoomUsingState",room.getRoomUsingState());//	����ʹ��״̬
		json.put("RoomLockState",room.getRoomLockState());//	������״̬
		json.put("RoomLongitude",room.getRoomLongitude());//	���侭��
		json.put("RoomLatitude",room.getRoomLatitude());//	����γ��
		json.put("RoomMassage",room.getRoomMassage());//	��������
		json.put("RoomPassword",room.getRoomPassword())	;//	��������
		json.put("RoomPicture",room.getRoomPicture());//����ͼƬ·��
		json.put("RoomDetailAddress",room.getRoomDetailAddress());//������ϸ��ַ
		json.put("RoomId", room.getRoomId());//����Id
		json.put("RoomEquipmentId",room.getRoomEquipmentId());//�����豸Id
		json.put("AddressId", room.getAddressId());//��ַ����Ϣ
		//�õ�request�е�RoomEquipment����
		json.put("Necessities",roomEquipment.getNecessities());//	�������Ʒ
		json.put("TV",roomEquipment.getTV());//	����
		json.put("AirConditioner",roomEquipment.getAirConditioner());//	�յ�
		json.put("Heating",roomEquipment.getHeating());//	ů��
		json.put("Kitchen",roomEquipment.getKitchen());//	����
		json.put("Network",roomEquipment.getNetwork());//	����
		json.put("HotTub",roomEquipment.getHotTub());//	��ˮԡ��
		json.put("WashingMachine",roomEquipment.getWashingMachine());//	ϴ�»�
		json.put("SwimmingPool",roomEquipment.getSwimmingPool());//	��Ӿ��
		json.put("DryingMachine",roomEquipment.getDryingMachine());//	��ɻ�
		json.put("Breakfast",roomEquipment.getBreakfast());//	���
		json.put("CoatHanger",roomEquipment.getCoatHanger());//	�¼�
		json.put("Iron",roomEquipment.getIron());//	�ٶ�
		json.put("IndoorFirePlace",roomEquipment.getIndoorFirePlace());//	���ڱ�¯
		json.put("WheelchairAccessible",roomEquipment.getWheelchairAccessible());//	���ϰ���ʩ
		json.put("PETFacilities",roomEquipment.getPETFacilities());//	������ʩ
		json.put("WorkingSpace",roomEquipment.getWorkingSpace());//	��������
		
		//�����ַ
		json.put("AddressProvince",address.getAddressProvince());//	ʡ
		json.put("AddressCity",address.getAddressCity());//	��
		json.put("AddressVillage",address.getAddressVillage());//	��
		json.put("AddressPicture", address.getAddressPicture());//����ͼƬ
		return json;
	}
}
