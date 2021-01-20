package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.BllFame;
import com.Bll.IBllFrame;
import com.Entity.Participants;
/**
 * 
 *���ߣ�movie
 *ʱ�䣺2015-10-18����06:38:27
 *��������enterActivity
 *���ܣ������
 *������@param participants
 *������@return 
 *����ֵ��boolean
 */
public class EnterActivity extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		//��ȡ����
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int activityId=jsonObject.getInt("activityId");
		int participantsId=jsonObject.getInt("participantsId");
		String participantsName=jsonObject.getString("participantsName");
		Participants participants=new Participants(activityId, participantsId, participantsName);
		boolean result = bllFrame.enterActivity(participants);
		JSONObject json = new JSONObject();
		json.put("result", result);
		System.out.println(json);
		PrintWriter out = response.getWriter();	
		out.println(json);
		out.flush();
		out.close();
}

}
