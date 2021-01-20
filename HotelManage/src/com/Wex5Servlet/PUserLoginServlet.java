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
 * 概述：用户登录
 * 输入：1. UserPhone	2. UserPassword
 * 输出：成功：List<User>
 * 		失败：check    reason
 * 备注：
 * @author Aric
 *
 */
public class PUserLoginServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String callbackName = request.getParameter("jsonp");
        
        // Requst对象接收数据，并开始解析
        //  UserPhone    UserPassword
        String userinfo   = new String(request.getParameter("UserPhone").getBytes("ISO-8859-1"),"utf-8");
        String password   = new String(request.getParameter("UserPassword").getBytes("ISO-8859-1"),"utf-8");
        
        // 调用BLL层的方法将解析好的字符串，进行操作
        ICBllFrame interfaceOfBllFrame = new CBllImpl();
        JSONArray jsonArray = null; 
//        List<User> result1 = interfaceOfBllFrame.UserLoginEmail(userinfo, password);
        
    	List<HashMap<String, Object>> result1 = interfaceOfBllFrame.QueryPhonuserother( userinfo, password);
        System.out.println("Before!!!!");
        if(result1 == null)
        {
            System.out.println("查询没结果！！！");
            PrintWriter out = response.getWriter();  
            JSONObject js = new JSONObject();
            js.put("check", "false");
            js.put("reason", "wrong password!");
            String jsonpResult = String.format("%s(%s)", callbackName, js);
            System.out.println("返回数据："+jsonpResult);
           	out.println(jsonpResult);
            out.flush(); 
            out.close();  
        }
        else{
            try {
            	// 将方法返回的列表转化为JSON对象
            	jsonArray = new JSONArray().fromObject(result1);
            	
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		// 将JSON对象转化为字符串
            String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
            // 打印字符串
            System.out.println(jsonpResult);
            
            PrintWriter out = response.getWriter();  
           	out.println(jsonpResult);
            out.flush(); 
            out.close();  
        }
	}
}
