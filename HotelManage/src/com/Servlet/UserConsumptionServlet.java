//package com.Servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import net.sf.json.JSONObject;
//
//import com.Bll.CBllImpl;
//import com.Bll.ICBllFrame;
//import com.Entity.ConsumptionRecord;
//import com.Entity.RechargeRecord;
//
//public class UserConsumptionServlet extends HttpServlet {
//
//	
//	public void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		response.setContentType("text/html");  
//        response.setCharacterEncoding("utf-8");  
//        
//        JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
//        int ConsumptionMoney=jsonObject.getInt("ConsumptionMoney");
//        String consumptionAddress=jsonObject.getString("ConsumptionAddress");
//        String ConsumptionName=jsonObject.getString("ConsumptionName");
//        String ConsumptionPhon=jsonObject.getString("ConsumptionPhon");
//        String ConsumptionIDNumber=jsonObject.getString("ConsumptionIDNumber");
//        int userId=jsonObject.getInt("Userid");   
//        
//        
//        ICBllFrame interfaceOfBllFrame=new CBllImpl();
//        JSONObject json = new JSONObject();
//        ConsumptionRecord consumptionRecord=new ConsumptionRecord(ConsumptionMoney,consumptionAddress,ConsumptionName,ConsumptionPhon,ConsumptionIDNumber,userId);
//        boolean result=interfaceOfBllFrame.UserConsumption(consumptionRecord);
//        
//        jsonObject.put("result", result);
//        
//        System.out.println(json);
//        PrintWriter out = response.getWriter();  
//       	out.println(json);
//        out.flush(); 
//        out.close();  
//	}
//
//}
