package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.BllFame;
import com.Bll.IBllFrame;
import com.Entity.Department;
/**
 * 
 *作者：movie
 *时间：2015-10-19下午03:05:28
 *函数名：queryDepartmentsByorganizationId
 *功能：查询组织部门
 *参数：@param organizationId
 *参数：@return 
 *返回值：List<Department>
 */
public class GetDepartmentsByorganizationId extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//获取参数
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int organizeid=jsonObject.getInt("organizationId");
		IBllFrame bllFrame=new BllFame();
		List<Department> departments=bllFrame.QueryDepartmentsByorganizationId(organizeid);
		JSONArray json=null;
		try {
			json=JSONArray.fromObject(departments);
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
