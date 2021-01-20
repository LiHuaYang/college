//package com.Servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import net.sf.json.JSONArray;
//
//import com.Bll.CBllImpl;
//import com.Bll.ICBllFrame;
//import com.Entity.ConsumptionRecord;
//
//public class WGetConsumptionRecordPageServlet extends HttpServlet {
//
//	public void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		response.setContentType("text/html");  
//		response.setCharacterEncoding("utf-8");  
//		int page=Integer.parseInt(request.getParameter("page"));
//		ICBllFrame interfaceOfBllFrame=new CBllImpl();
//		JSONArray json = null;
//
//		List<ConsumptionRecord> result=interfaceOfBllFrame.getConsumptionRecordPage(page);
//		try {
//			json=new JSONArray().fromObject(result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		System.out.println(json);
//		PrintWriter out = response.getWriter();
//		out.println(json);
//		out.flush();
//		out.close();
//	}
//
//	
//}
