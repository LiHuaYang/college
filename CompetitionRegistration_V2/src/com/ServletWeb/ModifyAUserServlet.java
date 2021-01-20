package com.ServletWeb;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.CDaoFrame;
import com.Dao.IDaoFrame;
import com.EntityWeb.User;

import net.sf.json.JSONObject;

public class ModifyAUserServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
//		JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		int UserId = jsonObject.getInt("UserId");// 用户ID
		String UserSchool = jsonObject.getString("UserSchool");
		String UserContactsMan = jsonObject.getString("UserContactsMan");
		String UserContactsPhon = jsonObject.getString("UserContactsPhon");
		String UserAddress = jsonObject.getString("UserAddress");
		String UserTeacher = jsonObject.getString("UserTeacher");
		String UserTeacherPhon = jsonObject.getString("UserTeacherPhon");
		String UserName = jsonObject.getString("UserName");
		String UserPicture = jsonObject.getString("UserPic");
		
		int UserGrade = jsonObject.getInt("UserGrade");
		String UserIDNumber= jsonObject.getString("UserIDNumber");
		String UserPhone = jsonObject.getString("UserPhone");
		String UserSex = jsonObject.getString("UserSex");
		int UserYear= jsonObject.getInt("UserYear");
		
		//System.out.println(UserName);
		IDaoFrame icdaoframe=CDaoFrame.getInstance();
		
		JSONObject json = new JSONObject();
		

		User user = new User (UserId,UserPhone, null,UserName, UserSex,UserIDNumber, UserSchool,UserYear,UserContactsMan,
			 UserContactsPhon,UserAddress, UserTeacher,UserTeacherPhon, UserPicture,null, 
			null, 0, 0,UserGrade);
				
		boolean result = icdaoframe.ModifyAUser(user);
		
		json.put("result", result);

		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
		
		
		
	}

}
