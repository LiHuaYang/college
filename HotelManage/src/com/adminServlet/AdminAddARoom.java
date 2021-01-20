package com.adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
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

public class AdminAddARoom extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		//�õ�request�е�Room����
		int RoomNumber = Integer.parseInt(request.getParameter("RoomNumber"));//����������
		int	RoomUnitPrice = Integer.parseInt(request.getParameter("RoomUnitPrice"));//	���䷿��۸�
		int	RoomType = Integer.parseInt(request.getParameter("RoomType"));//	��������
		int	RoomUsingState = Integer.parseInt(request.getParameter("RoomUsingState"));//	����ʹ��״̬
		int	RoomLockState = Integer.parseInt(request.getParameter("RoomLockState"));//	������״̬
		String	RoomLongitude	=  new String(request.getParameter("RoomLongitude").getBytes("ISO-8859-1"),"utf-8");//	���侭��
		String	RoomLatitude	=  new String(request.getParameter("RoomLatitude").getBytes("ISO-8859-1"),"utf-8");//	���侭��
		String	RoomMassage	=  new String(request.getParameter("RoomMassage").getBytes("ISO-8859-1"),"utf-8");//	��������
		String	RoomPassword = new String(request.getParameter("RoomPassword").getBytes("ISO-8859-1"),"utf-8")	;//	��������
		String  RoomPicture= new String(request.getParameter("RoomPicture").getBytes("ISO-8859-1"),"utf-8");//����ͼƬ·��
		String RoomDetailAddress = new String(request.getParameter("RoomDetailAddress").getBytes("ISO-8859-1"),"utf-8");//������ϸ��ַ
		
		//�õ�request�е�RoomEquipment����
		int	Necessities	= Integer.parseInt(request.getParameter("Necessities"));//	�������Ʒ
		int	TV	= Integer.parseInt(request.getParameter("TV"));//	����
		int	AirConditioner	= Integer.parseInt(request.getParameter("AirConditioner"));//	�յ�
		int	Heating	= Integer.parseInt(request.getParameter("Heating"));//	ů��
		int	Kitchen	= Integer.parseInt(request.getParameter("Kitchen"));//	����
		int	Network	= Integer.parseInt(request.getParameter("Network"));//	����
		int	HotTub	= Integer.parseInt(request.getParameter("HotTub"));//	��ˮԡ��
		int	WashingMachine	= Integer.parseInt(request.getParameter("WashingMachine"));//	ϴ�»�
		int	SwimmingPool	= Integer.parseInt(request.getParameter("SwimmingPool"));//	��Ӿ��
		int	DryingMachine	= Integer.parseInt(request.getParameter("DryingMachine"));//	��ɻ�
		int	Breakfast	= Integer.parseInt(request.getParameter("Breakfast"));//	���
		int	CoatHanger	= Integer.parseInt(request.getParameter("CoatHanger"));//	�¼�
		int	Iron = Integer.parseInt(request.getParameter("Iron"));//	�ٶ�
		int	IndoorFirePlace	= Integer.parseInt(request.getParameter("IndoorFirePlace"));//	���ڱ�¯
		int	WheelchairAccessible	= Integer.parseInt(request.getParameter("WheelchairAccessible"));//	���ϰ���ʩ
		int	PETFacilities = Integer.parseInt(request.getParameter("PETFacilities"));//	������ʩ
		int	WorkingSpace = Integer.parseInt(request.getParameter("WorkingSpace"));//	��������

		//�����ַ
		String	AddressProvince1 = new String(request.getParameter("AddressProvince").getBytes("ISO-8859-1"),"utf-8");//	ʡ
		String	AddressCity1	= new String(request.getParameter("AddressCity").getBytes("ISO-8859-1"),"utf-8");//	��
		String	AddressVillage1	= new String(request.getParameter("AddressVillage").getBytes("ISO-8859-1"),"utf-8");//	��
		
		String AddressProvince = AddressProvince1.replaceAll( "\\s", "" ); // ȥ�����пո񣬰�����β���м� 
		String AddressCity = AddressCity1.replaceAll( "\\s", "" ); // ȥ�����пո񣬰�����β���м� 
		String AddressVillage = AddressVillage1.replaceAll( "\\s", "" ); // ȥ�����пո񣬰�����β���м� 
		
		// str.replaceAll( "\\s", "" )
		
		System.out.println(AddressProvince);
		System.out.println(AddressCity);
		System.out.println(AddressVillage);
		
		ICBllFrame ibBllFrame = new CBllImpl();
		RoomEquipment roomEquipment=new RoomEquipment(Breakfast, AirConditioner, CoatHanger, DryingMachine, Heating, HotTub, IndoorFirePlace, Iron, Kitchen, Necessities, Network, PETFacilities, SwimmingPool, TV, WashingMachine, WheelchairAccessible, WorkingSpace);
		int RoomEquipmentId = roomEquipment.getRoomEquipmentId();//�����豸��
		Address address = ibBllFrame.QueryAddressId(AddressProvince, AddressCity, AddressVillage);
		int AddressId = address.getAddressId();//��ַ��
		
		Room room = new Room(RoomNumber, RoomUnitPrice, RoomType, RoomUsingState, RoomLockState, RoomLongitude, RoomLatitude, RoomMassage, RoomPassword, RoomEquipmentId, RoomPicture, AddressId, RoomDetailAddress);
		boolean bisCreate = ibBllFrame.CreateRoom(room, roomEquipment, address);
		
		/**************************************************************************/
		// �ϴ�����ͼƬ
		// UpLoadPic up = new UpLoadPic();
		// String result2 = up.upLoadPic(this, request, response);
		
		JSONObject jsonObject=new JSONObject();
		try {
			jsonObject.put("Check", bisCreate);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		System.out.println("���ؿͻ��˵����ݣ�" + jsonObject);
		
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}


}