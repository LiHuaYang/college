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
import com.Entity.Plan;
/**
 * 
 *���ߣ�movie
 *ʱ�䣺2015-10-19����07:48:27
 *��������CreatePlan
 *���ܣ��������񷽰�
 *������@param plan
 *������@return 
 *����ֵ��boolean
 */
public class CreatePlan extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//��ȡ����
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int planCreatorId=jsonObject.getInt("planCreatorId");
		String planName=jsonObject.getString("planName");
		String planContent=jsonObject.getString("planContent");
		Plan plan=new Plan(0, planName, 0, planCreatorId, planContent);
		IBllFrame bllFrame = new BllFame();
		boolean result=bllFrame.CreatePlan(plan);
		JSONObject json = new JSONObject();
		json.put("result", result);
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
