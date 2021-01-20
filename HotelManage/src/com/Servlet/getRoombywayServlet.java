package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.Room;

public class getRoombywayServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        
        
        
        JSONObject jsonObject=JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
       
        String village=jsonObject.getString("AddressVillage");
        String indata=jsonObject.getString("OrderCheckinTime");
        String outdata=jsonObject.getString("OrderCheckoutTime");
        int minprice=jsonObject.getInt("minprice");
        int maxprice=jsonObject.getInt("maxprice");
        
        
        ICBllFrame interfaceOfBllFrame=new CBllImpl();
        JSONArray json =null;
        
        List<Room> result=interfaceOfBllFrame.QueryRoomselectcondition(village, indata, outdata, minprice, maxprice);
        
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
