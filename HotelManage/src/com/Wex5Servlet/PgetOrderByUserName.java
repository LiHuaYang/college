package com.Wex5Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.AndroidBll.IFrame;
import com.AndroidBll.Impl;

/**
 * PgetOrderByUserName
 * ������ͨ�������ŷ��ض���
 * ���룺1. userid
 * �����OrderTable��������
 * ��ע��
 * @author Aric
 *
 */
public class PgetOrderByUserName extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        
        String callbackName = request.getParameter("jsonp");
        
        String ID = new String(request.getParameter("userid").getBytes("ISO-8859-1"),"utf-8");
        int    roomid = Integer.parseInt(ID);
        
        IFrame interfaceOfBllFrame = new Impl();
        
        List<HashMap<String, Object>> result1 = new ArrayList<HashMap<String, Object>>();
        result1 = interfaceOfBllFrame.GetOrderAndRoomByOrderId(roomid);
        
        JSONArray jsonArray = null; 
        jsonArray = new JSONArray().fromObject(result1);
        
        PrintWriter out = response.getWriter();  
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        System.out.println("�������ݣ�"+jsonpResult);
       	out.println(jsonpResult);
        out.flush(); 
        out.close(); 
	}
}
