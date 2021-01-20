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
import com.Entity.User;

/**
 * PCancelOrderServlet
 * �������û�ע��
 * ���룺1. username	2. userphone  3.userpassword  4.useremail
 * �����boolean ���Ƿ�ע��ɹ�����Ϣ��
 * @author Aric
 *
 */
public class PCreateUserServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        
        String callbackName = request.getParameter("jsonp");
        
        String str_username = new String(request.getParameter("username").getBytes("ISO-8859-1"),"utf-8");
        String str_userphone = new String(request.getParameter("userphone").getBytes("ISO-8859-1"),"utf-8");
        String str_userpassword = new String(request.getParameter("userpassword").getBytes("ISO-8859-1"),"utf-8");
        String str_useremail = new String(request.getParameter("useremail").getBytes("ISO-8859-1"),"utf-8");
        
        System.out.println(str_username+str_userphone+str_userpassword+str_useremail);
        IFrame interfaceOfBllFrame = new Impl();
        User user=new User(str_username,str_userpassword,str_userphone,str_useremail);
        
        boolean result1 = interfaceOfBllFrame.CreateUser(user);

        JSONArray jsonArray = new JSONArray().fromObject(result1);
        
        PrintWriter out = response.getWriter();  
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        System.out.println("�������ݣ�"+jsonpResult);
       	out.println(jsonpResult);
        out.flush(); 
        out.close(); 
	}
}
