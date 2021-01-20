package com.Wex5Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import com.AndroidBll.IFrame;
import com.AndroidBll.Impl;
import com.AndroidTool.OperationCode;

public class PGetRoomCommitSeverlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        
        String callbackName = request.getParameter("jsonp");
        
        String ID = new String(request.getParameter(OperationCode.Room.RoomId).getBytes("ISO-8859-1"),"utf-8");
        int   roomid = Integer.parseInt(ID);
        
        IFrame interfaceOfBllFrame = new Impl();
        List<HashMap<String, Object>> CommmitdetailList = null;
        CommmitdetailList = interfaceOfBllFrame.GetRoomCommitDetail(roomid);
        JSONArray jsonArray  = new JSONArray().fromObject(CommmitdetailList);
        
        PrintWriter out = response.getWriter();  
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        System.out.println("·µ»ØÊý¾Ý£º"+jsonpResult);
       	out.println(jsonpResult);
        out.flush(); 
	}
}
