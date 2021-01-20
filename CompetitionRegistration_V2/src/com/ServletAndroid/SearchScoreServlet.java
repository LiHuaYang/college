package com.ServletAndroid;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.EntityAndroid.SearchScord;

//查询成绩
public class SearchScoreServlet extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		super.service(req, resp);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   	
//		 JSONArray array = JSONArray.fromObject(request.getParameter("json").getBytes("ISO-8859-1"));
		
		 JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		 System.out.println("查询成绩--客户端数据：" + jsonObject);
		 
		 String ContestSubject = jsonObject.getString("ContestSubject");
		 String StudentName=jsonObject.getString("StudentName");
		 String StudentTicket=jsonObject.getString("StudentTicket");
		 String EnrollmentPassword=jsonObject.getString("EnrollmentPassword");
		 
		
		 System.out.print(" 科目-----"+ContestSubject);
		 System.out.print(" 名字-----"+StudentName);
		 System.out.print(" 准考证号-----"+StudentTicket);
		 System.out.println(" 密码-----"+EnrollmentPassword);
		 
        IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
        JSONObject json = new JSONObject();
        
        SearchScord result=interfaceOfBllFrame.searchScord(ContestSubject, StudentName, StudentTicket,EnrollmentPassword);
        
        json.put("result", result);
        System.out.print(json);
        PrintWriter out = response.getWriter();  
       	out.println(json);
        out.flush(); 
        out.close();  
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String ContestSubject=request.getParameter("ContestSubject");//比赛科目
		 String StudentName=request.getParameter("StudentName");//学生姓名
		 String StudentTicket=request.getParameter("StudentTicket");//准考证
		 String EnrollmentPassword=request.getParameter("EnrollmentPassword");
        
		 System.out.println("科目-----"+ContestSubject);
		 System.out.println("名字-----"+StudentName);
		 System.out.println("准考证号-----"+StudentTicket);
		 System.out.println("密码-----"+EnrollmentPassword);
		 
        IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
        JSONObject json = new JSONObject();
        
        
        SearchScord result=interfaceOfBllFrame.searchScord(ContestSubject, StudentName, StudentTicket,EnrollmentPassword);
        
        json.put("result", result);
        System.out.print(json);
        PrintWriter out = response.getWriter();  
       	out.println(json);
        out.flush(); 
        out.close();  
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
	}
}