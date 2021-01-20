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

import com.Bll.BllFame;
import com.Bll.IBllFrame;
import com.Bll.RegistrationHandle.Registration;
import com.Entity.Participants;
/**
 * 
 *���ߣ�movie
 *ʱ�䣺2015-10-18����06:43:37
 *��������QueryActivityEnter
 *���ܣ��鿴�������Ա
 *������@param activityId
 *������@return 
 *����ֵ��List<Participants>
 */
public class GetActivityEnter extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		//��ȡ����
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int activityId=jsonObject.getInt("activityId");

	
		List<Participants> registrations=bllFrame.QueryActivityEnter(activityId);
		JSONArray json=JSONArray.fromObject(registrations);
		System.out.println(json);
		PrintWriter out = response.getWriter();	
		out.println(json);
		out.flush();
		out.close();
	}

	
}
