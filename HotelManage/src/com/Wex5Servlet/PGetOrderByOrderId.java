package com.Wex5Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.AndroidBll.IFrame;
import com.AndroidBll.Impl;
import com.Entity.OrderTable;
/**
 * PGetOrderByOrderId
 * ������ͨ�������ŷ��ض���
 * ���룺1. orderid
 * �����OrderTable��������
 * ��ע��
 * @author Aric
 *
 */
public class PGetOrderByOrderId extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        
        String callbackName = request.getParameter("jsonp");
        
        // ����CleanerId���ط����б�
        // select * from Room where Roomid = (select RoomId from CleanerWorkArrange where CleanerId = ?)
        // select * from room , CleanerWorkArrange where CleanerWorkArrange.roomid = room.roomId and Cleanerid = ?
        String ID = new String(request.getParameter("orderid").getBytes("ISO-8859-1"),"utf-8");
        int   orderid = Integer.parseInt(ID);
        
        IFrame interfaceOfBllFrame = new Impl();
        
        OrderTable result1 = interfaceOfBllFrame.GetOrderByOrderId(orderid);
       
        // JSONObject json1 = new JSONObject().fromObject(result1);
        // json1.put("result", result1);        
        JSONArray jsonArray  = new JSONArray().fromObject(result1);
        
        PrintWriter out = response.getWriter();  
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        System.out.println("�������ݣ�"+jsonpResult);
       	out.println(jsonpResult);
        out.flush(); 
	}
}
