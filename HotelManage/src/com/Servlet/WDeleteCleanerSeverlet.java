package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.Cleaner;

public class WDeleteCleanerSeverlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int CleanerId = Integer.parseInt(request.getParameter("CleanerId"));
		int CleanerState = Integer.parseInt(request
				.getParameter("CleanerState"));
		String CleanerIDNumber = new String(request.getParameter(
				"CleanerIDNumber").getBytes("ISO-8859-1"), "utf-8");
		String CleanerName = new String(request.getParameter("CleanerName")
				.getBytes("ISO-8859-1"), "utf-8");
		String CleanerPassWord = new String(request.getParameter(
				"CleanerPassWord").getBytes("ISO-8859-1"), "utf-8");
		String CleanerPhoneNumber = new String(request.getParameter(
				"CleanerPhoneNumber").getBytes("ISO-8859-1"), "utf-8");
		String CleanerSex = new String(request.getParameter("CleanerSex")
				.getBytes("ISO-8859-1"), "utf-8");
		Cleaner cleaner = new Cleaner(CleanerId, CleanerName, CleanerSex,
				CleanerPhoneNumber, CleanerState, CleanerIDNumber,
				CleanerPassWord);
		ICBllFrame icBllFrame = new CBllImpl();

		boolean bisupdate = icBllFrame.changeCleaner(cleaner);

		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("Check", bisupdate);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObject);
		out.println(jsonObject);
		out.flush();
		out.close();
	}

}
