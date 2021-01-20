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
 *作者：movie 
 *时间：2015-10-19下午03:29:02 
 *函数名：queryDepartmentDetail 
 *功能：查询部门详情
 * 参数：@param departmentId 
 * 参数：@return 
 * 返回值：Department
 */
public class GetDepartmentDetail extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		// 获取参数
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
