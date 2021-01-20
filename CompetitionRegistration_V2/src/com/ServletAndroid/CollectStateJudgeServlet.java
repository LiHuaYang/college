package com.ServletAndroid;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;

public class CollectStateJudgeServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int UserId = Integer.parseInt(request.getParameter("UserId"));
		int PaperId = Integer.parseInt(request.getParameter("PaperId"));
		IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();			
		boolean flag = interfaceOfBllFrame.CollectStateJudge(PaperId,UserId);
		
		JSONObject jsonObject  = new JSONObject();
		jsonObject.put("flag", flag);
		
		System.out.println(jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}
}
