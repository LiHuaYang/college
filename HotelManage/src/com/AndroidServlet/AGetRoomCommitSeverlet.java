package com.AndroidServlet;

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

public class AGetRoomCommitSeverlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        
        // ����RoomId
        String ID = new String(request.getParameter(OperationCode.Room.RoomId).getBytes("ISO-8859-1"),"utf-8");
        int   roomid = Integer.parseInt(ID);
        
        // 1. ������������ List<RoomCommit> QueryRoomCommitByRoom
        // 2. ���۵ȼ�	
        // 3. ���������� 	
        // 4. ������ͷ��
        IFrame interfaceOfBllFrame = new Impl();
        List<HashMap<String, Object>> CommmitdetailList = null;
        CommmitdetailList = interfaceOfBllFrame.GetRoomCommitDetail(roomid);
        JSONArray jsonArray  = new JSONArray().fromObject(CommmitdetailList);
        PrintWriter out = response.getWriter();  
        String jsonpResult = String.format("%s", jsonArray);
        System.out.println("�������ݣ�"+jsonpResult);
       	out.println(jsonpResult);
        out.flush(); 
	}
}
