package com.Wex5Servlet;

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
import com.Entity.Room;

/**
 * PGetRoomByAddressServlet
 * ���������ݴ�ׯ����������۴�ݵ�.�����ط����б�
 * ���룺1. village
 * �����List<Room>
 * ��ע��
 * @author Aric
 *
 */
public class PGetRoomByAddressServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");        
        String callbackName = request.getParameter("jsonp");
        
        String village1  = new String(request.getParameter("village").getBytes("ISO-8859-1"),"utf-8");
        // String village1 = "��ɽ";
        // System.out.println(village1);
        IFrame interfaceOfBllFrame = new Impl();
        List<Room>  result1 = interfaceOfBllFrame.GetRoomByAddressViilage(village1);
      
        JSONArray jsonArray = new JSONArray().fromObject(result1);
        
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        System.out.println("���ؿͻ������ݣ�"+jsonpResult);
        PrintWriter out = response.getWriter();  
       	out.println(jsonpResult);
        out.flush(); 
        out.close();  
	}
}
