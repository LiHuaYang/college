package com.Wex5Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.Address;
/**
 * PGetAddresssServlet
 * ��������ȡ�����б�
 * ���룺��
 * �����List<Address>�������б�
 * ��ע�����û���¼�Ժ󣬷��ظ��û������б�
 * @author Aric
 *
 */
public class PGetAddresssServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");        
        String callbackName = request.getParameter("jsonp");
        
        ICBllFrame interfaceOfBllFrame = new CBllImpl();
        List<Address> result1 = new ArrayList<Address>();
        result1 = interfaceOfBllFrame.GetAllAddress();
        
        JSONArray jsonArray;
        jsonArray = new JSONArray().fromObject(result1);
        
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        
        System.out.println("���ؿͻ������ݣ�"+jsonpResult);
        
        PrintWriter out = response.getWriter();  
       	out.println(jsonpResult);
        out.flush(); 
        out.close();  
	}
}
