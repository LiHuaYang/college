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
import com.Entity.Organization;
/**
 * 
 *作者：movie
 *时间：2015-10-19下午02:05:12
 *函数名：QueryOrganizationDetail
 *功能：根据组织ID查询组织
 *参数：@param organizationId
 *参数：@return 
 *返回值：Organization
 */
public class GetOrganizationDetail extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//获取参数
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int organizeid=jsonObject.getInt("organizationId");
	
		IBllFrame bllFrame=new BllFame();
		Organization organization=bllFrame.QueryOrganizationDetail(organizeid);
		JSONObject json=null;
		try {
			json=JSONObject.fromObject(organization);
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
