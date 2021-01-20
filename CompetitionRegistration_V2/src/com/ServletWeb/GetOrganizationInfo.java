package com.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.EntityWeb.Organization;

public class GetOrganizationInfo extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");


		IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
		JSONObject json = new JSONObject();
		
		List<Organization> organizations = interfaceOfBllFrame.GetOrganizations();
		
		JSONArray array = new JSONArray();
		
		int length = organizations.size();
		
		for (int i=0; i<length; i++) {
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("organizationName", organizations.get(i).getOrganizationName());
			jsonObject.put("organizationId", organizations.get(i).getOrganizationId());
			jsonObject.put("organizationAddress", organizations.get(i).getOrganizationAddress());
			jsonObject.put("organizationStation", organizations.get(i).getOrganizationStation());
			jsonObject.put("organizationTel", organizations.get(i).getOrganizationTel());
			jsonObject.put("organizationContacts", organizations.get(i).getOrganizationContacts());
			
			array.add(jsonObject);
		}
		
		System.out.println("GetOrganizationInfo 返回客户端的数据: " + array);
		
//		JSONArray array = new DaoCompetition().getAllOrganization();
		
		PrintWriter out = response.getWriter();
		out.println(array);
		out.flush();
		out.close();
	}
}
