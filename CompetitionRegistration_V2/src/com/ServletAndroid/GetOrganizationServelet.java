package com.ServletAndroid;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.EntityWeb.Organization;

public class GetOrganizationServelet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		super.service(req, resp);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			int contestId = Integer.parseInt(request.getParameter("contestId"));
			IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonObject2 = new JSONObject();
			List<Organization> newsInfo = interfaceOfBllFrame.GetOrganization(contestId);
			
			int length = newsInfo.size();
			for (int i=0; i<length; i++) {
				JSONObject jsonObject = new JSONObject();
				
				jsonObject.put("OrganizationName", newsInfo.get(i).getOrganizationName());
				jsonObject.put("OrganizationId", newsInfo.get(i).getOrganizationId());
				
				jsonArr.add(jsonObject);
			}
			
			if(jsonArr.size()!=0){
				jsonObject2.put("flag", true);
				jsonObject2.element("result", jsonArr); // 添加竞赛列表至JSON对象
			}
			else{
				jsonObject2.put("flag", false);
				jsonObject2.put("message","搜索为空");
			}
			
			System.out.println(jsonObject2);
			PrintWriter out = response.getWriter();
			out.println(jsonObject2);
			out.flush();
			out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
	}
}
