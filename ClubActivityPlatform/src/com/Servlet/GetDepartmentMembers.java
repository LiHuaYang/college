package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.BllFame;
import com.Bll.IBllFrame;

/**
 * 
 *���ߣ�movie
 *ʱ�䣺2015-10-19����03:23:07
 *��������QueryDepartmentMembers
 *���ܣ���ѯ���ų�Ա
 *������@param departmentId
 *������@return 
 *����ֵ��List<HashMap<String,Object>>
 */
public class GetDepartmentMembers extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		//��ȡ����
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int departmentId=jsonObject.getInt("departmentId");	
		List<HashMap<String, Object>> member = bllFrame.QueryDepartmentMembers(departmentId);
		JSONArray json = null;
		try {
			json = JSONArray.fromObject(member);
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
