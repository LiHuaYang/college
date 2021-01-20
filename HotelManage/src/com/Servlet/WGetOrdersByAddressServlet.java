package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.OrderTable;

public class WGetOrdersByAddressServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8");  

		ICBllFrame interfaceOfBllFrame=new CBllImpl();
		JSONArray json = null;
		String AddressProvince=new String(request.getParameter("AddressProvince").getBytes("ISO-8859-1"),"utf-8");
		String AddressCity=new String(request.getParameter("AddressCity").getBytes("ISO-8859-1"),"utf-8");
		String AddressVillage=new String(request.getParameter("AddressVillage").getBytes("ISO-8859-1"),"utf-8");
		String DetatilAddress=new String(request.getParameter("DetatilAddress").getBytes("ISO-8859-1"),"utf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		List<OrderTable> result=interfaceOfBllFrame.getOrdersByAddress(AddressProvince, AddressCity, AddressVillage, DetatilAddress, page);
		try {
			json=new JSONArray().fromObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
