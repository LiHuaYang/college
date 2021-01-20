//改变用户信息（昵称，性别，联系号码，学习阶段，用户地址，图片）
package com.ServletAndroid;

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
import com.EntityWeb.User;

public class ChangeUserInfoServlet extends HttpServlet {

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


		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		
			String UserNickName = request.getParameter("UserNickName");//昵称
			String UserSex = request.getParameter("UserSex");//性别
			String UserPhone = request.getParameter("UserPhone");//电话号码
			int UserGrade=Integer.parseInt(request.getParameter("UserGrade"));   //年级
			String UserAddress = request.getParameter("UserAddress");//地址
			String UserPic = request.getParameter("UserPicture");//头像
			int UserId=Integer.parseInt(request.getParameter("UserId"));      //用户id
	        
	        IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
	        JSONObject json = new JSONObject();
	        
	        
	        boolean result=interfaceOfBllFrame.ChangeUserInfo(UserNickName, UserSex, UserPhone, UserGrade, UserAddress, UserPic, UserId);
	        
	        json.put("result", result);
	        System.out.print(json);
	        PrintWriter out = response.getWriter();  
	       	out.println(json);
	        out.flush(); 
	        out.close();  
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String UserNickName = request.getParameter("UserNickName");//昵称
		String UserSex = request.getParameter("UserSex");//性别
		String UserPhone = request.getParameter("UserPhone");//电话号码
		int UserGrade=Integer.parseInt(request.getParameter("UserGrade"));   //年级
		String UserAddress = request.getParameter("UserAddress");//地址
		String UserPic = request.getParameter("UserPicture");//头像
		int UserId=Integer.parseInt(request.getParameter("UserId"));      //用户id
        
        IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
        JSONObject json = new JSONObject();
        
        
        boolean result=interfaceOfBllFrame.ChangeUserInfo(UserNickName, UserSex, UserPhone, UserGrade, UserAddress, UserPic, UserId);
        
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