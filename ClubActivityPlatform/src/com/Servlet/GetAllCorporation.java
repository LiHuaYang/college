package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.Bll.BllFame;
import com.Bll.IBllFrame;
import com.Entity.Corporation;

/**
 * 
 *���ߣ�movie 
 *ʱ�䣺2015-10-13����07:09:32 
 *��������QueryAllCorporation 
 *���ܣ���ѯ�������� ������
 * ����ֵ��List<Corporation>
 */
public class GetAllCorporation extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		List<Corporation> corporations = bllFrame.QueryAllCorporation();
		JSONArray json = null;
		try {
			json = JSONArray.fromObject(corporations);
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
