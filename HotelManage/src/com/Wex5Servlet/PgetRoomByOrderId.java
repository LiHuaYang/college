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
 * PgetRoomByCleanerId
 * ������������๤��ŷ��ط����б�
 * ���룺1. orderid
 * �����List<Room>
 * ��ע��ÿ������Ա�����Լ�����ķ��䣬���صĲ������Ǵ���ɨ�ķ���
 * @author Aric
 *
 */
public class PgetRoomByOrderId extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        
        String callbackName = request.getParameter("jsonp");
        
        String ID = new String(request.getParameter("orderid").getBytes("ISO-8859-1"),"utf-8");
        int    orderid = Integer.parseInt(ID);
        
        IFrame interfaceOfBllFrame = new Impl();
        
        List<HashMap<String, Object>> result1 = new ArrayList<HashMap<String,Object>>();
        result1 = interfaceOfBllFrame.GetOrderAndRoomByOrderId(orderid);
       
        // JSONObject json1 = new JSONObject().fromObject(result1);
        // json1.put("result", result1);        
        JSONArray jsonArray = null; 
        jsonArray = new JSONArray().fromObject(result1);
        
        PrintWriter out = response.getWriter();  
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        System.out.println("�������ݣ�"+jsonpResult);
       	out.println(jsonpResult);
        out.flush(); 
	}
}
