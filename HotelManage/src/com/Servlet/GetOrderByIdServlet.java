package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.OrderTable;
import com.Entity.User;

public class GetOrderByIdServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		JSONObject jsonObject = JSONObject.fromObject(new String(request
				.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int orderId = jsonObject.getInt("orderId");

		ICBllFrame interfaceOfBllFrame = new CBllImpl();
		JSONObject json = new JSONObject();
		OrderTable result = interfaceOfBllFrame.QueryOrderById(orderId);

		jsonObject.put("result", result);

		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
}
