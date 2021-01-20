package com.ServletAndroid;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.EntityWeb.GradeBasicData;

public class GetCompetitionObjectbyObjectIdServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
     request.setCharacterEncoding("UTF-8");
     response.setContentType("text/html;charset=UTF-8");
	
     IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();			
     List<GradeBasicData> gradebasicdata = interfaceOfBllFrame.GetCompetitionObjectbyObjectId();
     JSONObject json = new JSONObject();
		JSONArray jsonArray = null;
		
      jsonArray = new JSONArray().fromObject(gradebasicdata);
		
		try {
			json.put("result", jsonArray);
			json.put("flag", true);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("flag", false);
		}
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		
		out.flush();
		out.close();
	
	}
}
