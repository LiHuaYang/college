package com.Wex5Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.User;

/**
 * PUserLoginServlet
 * �������û���¼
 * ���룺1. UserPhone	2. UserPassword
 * ������ɹ���List<User>
 * 		ʧ�ܣ�check    reason
 * ��ע��
 * @author Aric
 *
 */
public class PUserLoginServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String callbackName = request.getParameter("jsonp");
        
        // Requst����������ݣ�����ʼ����
        //  UserPhone    UserPassword
        String userinfo   = new String(request.getParameter("UserPhone").getBytes("ISO-8859-1"),"utf-8");
        String password   = new String(request.getParameter("UserPassword").getBytes("ISO-8859-1"),"utf-8");
        
        // ����BLL��ķ����������õ��ַ��������в���
        ICBllFrame interfaceOfBllFrame = new CBllImpl();
        JSONArray jsonArray = null; 
//        List<User> result1 = interfaceOfBllFrame.UserLoginEmail(userinfo, password);
        
    	List<HashMap<String, Object>> result1 = interfaceOfBllFrame.QueryPhonuserother( userinfo, password);
        System.out.println("Before!!!!");
        if(result1 == null)
        {
            System.out.println("��ѯû���������");
            PrintWriter out = response.getWriter();  
            JSONObject js = new JSONObject();
            js.put("check", "false");
            js.put("reason", "wrong password!");
            String jsonpResult = String.format("%s(%s)", callbackName, js);
            System.out.println("�������ݣ�"+jsonpResult);
           	out.println(jsonpResult);
            out.flush(); 
            out.close();  
        }
        else{
            try {
            	// ���������ص��б�ת��ΪJSON����
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
