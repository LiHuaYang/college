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
/**
 * 
 *���ߣ�movie
 *ʱ�䣺2015-10-19����07:08:47
 *��������SubmitRegistration
 *���ܣ���׼�����˼��벿��
 *������@param belongType
 *������@param belongId
 *������@param userId
 *������@return 
 *����ֵ��boolean
 */
public class SubmitRegistration extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		//��ȡ����
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int userId =jsonObject.getInt("userId");
		int belongType=jsonObject.getInt("belongType");
		int belongId=jsonObject.getInt("belongId");

		boolean result = bllFrame.SubmitRegistration(belongType, belongId, userId);
		JSONObject json = new JSONObject();
		json.put("result", result);
		PrintWriter out = response.getWriter();	
		out.println(json);
		out.flush();
		out.close();
	}
}
