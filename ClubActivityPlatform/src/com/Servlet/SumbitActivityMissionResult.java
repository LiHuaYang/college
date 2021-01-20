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
 *ʱ�䣺2015-10-20����04:59:38
 *��������SumbitActivityMissionResult
 *���ܣ��ύ�����ܽ�
 *������@param planId
 *������@param missionId
 *������@param missionResult
 *������@return 
 *����ֵ��boolean
 */
public class SumbitActivityMissionResult extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		//��ȡ����
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int planId =jsonObject.getInt("planId");
		int missionId=jsonObject.getInt("missionId");
		String missionResult=jsonObject.getString("missionResult");
	
		boolean result = bllFrame.SumbitActivityMissionResult(planId, missionId, missionResult);
		JSONObject json = new JSONObject();
		json.put("result", result);
		PrintWriter out = response.getWriter();	
		out.println(json);
		out.flush();
		out.close();
}


}
