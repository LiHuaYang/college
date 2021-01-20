package com.Wex5Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.AndroidBll.IFrame;
import com.AndroidBll.Impl;
import com.Entity.Cleaner;

/**
 * PcleanerLoginServlet
 * ����������Ա��¼
 * ���룺1. CleanerPhoneNumber	2. CleanerPassword
 * �����Cleaner
 * ��ע����½�󷵻ؿͻ��˱���Ա�������Ϣ
 * @author Aric
 *
 */
public class PcleanerLoginServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");        
        String callbackName = request.getParameter("jsonp");
        
        // Requst����������ݣ�����ʼ����
        String userinfo   = new String(request.getParameter("CleanerPhoneNumber").getBytes("ISO-8859-1"),"utf-8");
        String password   = new String(request.getParameter("CleanerPassword").getBytes("ISO-8859-1"),"utf-8");
        
        // ����BLL��ķ����������õ��ַ��������в���
        IFrame interfaceOfBllFrame = new Impl();
        JSONArray jsonArray = null; 
        
        // List<Cleaner> result1 = new ArrayList<Cleaner>();
        System.out.println("������ʺ�:"+userinfo+ "����:" + password);
        
        List<Cleaner> result1 = interfaceOfBllFrame.CleanerLoginByPhone(userinfo,password);
        
        if(result1.size() == 0)
        {
            PrintWriter out = response.getWriter();  
            JSONObject js = new JSONObject();
            js.put("check", "false");
            js.put("reason", "wrong password!");
            String jsonpResult = String.format("%s(%s)", callbackName, js);
            System.out.println("���ؿͻ������ݣ�"+jsonpResult);
           	out.println(jsonpResult);
            out.flush(); 
            out.close();  
        }
        else{
        	// List<Cleaner> result = interfaceOfBllFrame.QueryCleanerByPhone(userinfo);
            try {
            	jsonArray = new JSONArray().fromObject(result1);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		// ��JSON����ת��Ϊ�ַ���
            String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
            // ��ӡ�ַ���
            System.out.println(jsonpResult);
            PrintWriter out = response.getWriter();  
           	out.println(jsonpResult);
            out.flush(); 
            out.close();  
        }
	}
}
