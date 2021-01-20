package com.Servlet.V2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.Entity.V2.Report;
import com.EntityAndroid.SearchScord;

public class SearchScoreByInfoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		super.service(req, resp);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   	
		 JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		 System.out.println("查询成绩--客户端数据：" + jsonObject);

		 Report report = new Report(jsonObject);           //1.封装成类
		 
         IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
         
         long startTime = System.nanoTime();  //開始時間
         
         Report result=interfaceOfBllFrame.searchScoreByInfo(report);     //2.查询
         
         long consumingTime = System.nanoTime() - startTime; //消耗時間
         
         System.out.println(consumingTime);
         
         JSONObject data = result.toJSON();           //3.转换格式
         
         JSONObject json = new JSONObject();          //4.put
         json.put("data", data);
         json.put("msg", true);
        
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
