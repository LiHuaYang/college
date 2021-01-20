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
import com.Entity.Corporation;
/**
 * 
 *���ߣ�movie
 *ʱ�䣺2015-10-19����11:02:38
 *��������QueryCorporationDetailById
 *���ܣ���ѯ��������
 *������@param corporationId
 *������@return 
 *����ֵ��Corporation
 */
public class GetCorporationDetailById extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		//��ȡ����
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int corporationId=jsonObject.getInt("corporationId");	
		Corporation corporation = bllFrame.QueryCorporationDetailById(corporationId);
		JSONObject json = null;
		try {
			json = JSONObject.fromObject(corporation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}



}
