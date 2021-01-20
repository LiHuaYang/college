package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.Manager;
import com.Entity.Room;

public class WManagerLoginServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		PrintWriter out = response.getWriter();  
		
		String ManagerAccount = new String(request.getParameter("ManagerAccount").getBytes("ISO-8859-1"),"utf-8");
		String ManagerPassword = new String(request.getParameter("ManagerPassword").getBytes("ISO-8859-1"),"utf-8");
		ICBllFrame icBllFrame = new CBllImpl();
		
		JSONObject jsonObject = new JSONObject();
		Manager manager = icBllFrame.QueryManagerByMessage(ManagerAccount, ManagerPassword);
		boolean bisfind = false;
		if(manager!=null){
			bisfind = true;
		}
		try {
			jsonObject.put("Manager", manager);
			jsonObject.put("Check", bisfind);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObject);
		out.println(jsonObject);
		out.flush(); 
		out.close();  
	}
}
