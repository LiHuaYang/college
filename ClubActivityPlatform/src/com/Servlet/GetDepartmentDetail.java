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
import com.Entity.Department;

/**
 * 
 *���ߣ�movie 
 *ʱ�䣺2015-10-19����03:29:02 
 *��������queryDepartmentDetail 
 *���ܣ���ѯ��������
 * ������@param departmentId 
 * ������@return 
 * ����ֵ��Department
 */
public class GetDepartmentDetail extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		// ��ȡ����
		JSONObject jsonObject = JSONObject.fromObject(new String(request
				.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int departmentId = jsonObject.getInt("departmentId");
		Department department = bllFrame.QueryDepartmentDetail(departmentId);
		JSONObject json = null;
		try {
			json = JSONObject.fromObject(department);
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
