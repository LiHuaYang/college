package com.AndroidServlet;

import java.io.IOException;
import java.io.PrintWriter;
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

public class ABookARoomServelet extends HttpServlet {
//	public void service(HttpServletRequest request, HttpServletResponse response) 
//	throws ServletException, IOException {
//		response.setContentType("text/html");  
//        response.setCharacterEncoding("utf-8");  
//        // ��סʱ��	��ס����	��ס����	�˷�ʱ��	������	�����	�û���
//        String toLiveTime = new String(request.getParameter(OperationCode.Order.OrderCheckinTime).getBytes("ISO-8859-1"),"utf-8");
//        // �뿪ʱ��
//        String livetime = new String(request.getParameter(OperationCode.Order.OrderCheckoutTime).getBytes("ISO-8859-1"),"utf-8");
//        // Ԥ���ˡ������ţ���ס�������������ס������Ԥ��ʱ��
//        String user = new String(request.getParameter(OperationCode.Address.AddressVillage).getBytes("ISO-8859-1"),"utf-8");
//        
//        System.out.println("��׿������--��������" + roomtype);
//        System.out.println("��׿������--��סʱ��" + toLiveTime);
//        System.out.println("��׿������--�˷�ʱ��" + livetime);
//        System.out.println("��׿������--����" + address);
//        
//        IFrame interfaceOfBllFrame = new Impl();
//        List<Room> eligibleRoomList = interfaceOfBllFrame.GetEligibleRoom(roomtype, address);
//        
//        JSONArray jsonArray  = new JSONArray().fromObject(eligibleRoomList);
//        
//        PrintWriter out = response.getWriter();  
//        
//        String jsonpResult = String.format("%s", jsonArray);
//        System.out.println("��������"+jsonpResult);
//       	out.println(jsonpResult);
//        out.flush(); 
//	}
}