package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.BllFame;
import com.Bll.IBllFrame;
import com.Entity.Mission;
/**
 * 
 *���ߣ�movie
 *ʱ�䣺2015-10-19����07:56:04
 *��������CreateMission
 *���ܣ�����������������
 *������@param mission
 *������@return 
 *����ֵ��boolean
 */
public class CreateMission extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//��ȡ����
		JSONArray jsonArray = JSONArray.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		List<Mission> missions=new ArrayList<Mission>();
		for (int i = 0; i < jsonArray.size(); i++) {
			Mission mission=new Mission(jsonArray.getJSONObject(i));
			missions.add(mission);
		}
		IBllFrame bllFrame = new BllFame();
		boolean result=bllFrame.CreateMission(missions);
		JSONObject json = new JSONObject();
		json.put("result", result);
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
