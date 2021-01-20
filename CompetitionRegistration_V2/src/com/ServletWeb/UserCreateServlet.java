package com.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.EntityWeb.User;

public class UserCreateServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

//		JSONObject jsonObject = JSONObject.fromObject(new String(request
//				.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		String UserPhone = jsonObject.getString("UserPhone");
		String UserName = jsonObject.getString("UserName");
		String UserIDNumber = jsonObject.getString("UserIDNumber");
		String UserSex = jsonObject.getString("UserSex");
		String UserSchool = jsonObject.getString("UserSchool");
		String UserYear1 = jsonObject.getString("UserYear");
		String UserContactsMan = jsonObject.getString("UserContactsMan");
		String UserContactsPhon = jsonObject.getString("UserContactsPhon");
		String UserAddress = jsonObject.getString("UserAddress");
		String UserTeacher = jsonObject.getString("UserTeacher");
		String UserTeacherPhon = jsonObject.getString("UserTeacherPhon");
		
		int UserYear = Integer.parseInt(UserYear1);
		
		String UserPicture = "picturePath";
		int UserState = 1;
		int UserGrade = 6;

		IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
		JSONObject json = new JSONObject();
		User user = new User(UserPhone, UserName, UserSex, UserIDNumber,
				UserSchool, UserYear, UserContactsMan, UserContactsPhon,
				UserAddress, UserTeacher, UserTeacherPhon, UserPicture,
				UserState, UserGrade);

		boolean result = interfaceOfBllFrame.UserCreate(user);
		json.put("result", result);

		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
