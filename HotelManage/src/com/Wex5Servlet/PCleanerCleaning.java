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
import com.Entity.CleaningRecord;

/**
 * PCleanerCleaning
 * ����������Ա��ʼ��ɨ����
 * ���룺1. cleanerid	2. roomid
 * �����boolean���Ƿ����ӳɹ�����Ϣ��
 * ��ע�����û������ʼ��ɨ�Ժ�ϵͳ�Զ�����һ��CleaningRecord
 * @author Aric
 *
 */
public class PCleanerCleaning extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        
        String callbackName = request.getParameter("jsonp");
        String str_userid 	= new String(request.getParameter("cleanerid").getBytes("ISO-8859-1"),"utf-8");
        String str_roomid 	= new String(request.getParameter("roomid").getBytes("ISO-8859-1"),"utf-8");
        int userid = Integer.parseInt(str_userid);
        int roomid = Integer.parseInt(str_roomid);
        IFrame interfaceOfBllFrame = new Impl();
        CleaningRecord rc = new CleaningRecord(userid,  roomid);
        
        boolean result1 = interfaceOfBllFrame.CleanerCleaningStart(rc);
        
        // JSONObject json1 = new JSONObject().fromObject(result1);
        // json1.put("result", result1);        
        JSONArray jsonArray = new JSONArray().fromObject(result1);
        
        PrintWriter out = response.getWriter();  
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        System.out.println("�������ݣ�"+jsonpResult);
       	out.println(jsonpResult);
        out.flush(); 
        out.close(); 
	}
}
