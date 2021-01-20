package com.Servlet.V2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import com.Bll.CBllEnrollment;

public class GetEnrollmentDetail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String userid = request.getParameter("userId");
		
		System.out.println(userid);
		
		CBllEnrollment bllEnrollment = CBllEnrollment.getInstance();
		
		JSONObject json = bllEnrollment.queryEnrollmentOrder(userid);
		
		request.setAttribute("localuserid", json.get("localuserid"));
		request.setAttribute("openid", json.get("openid"));
		request.setAttribute("total_fee", json.get("total_fee"));
		request.setAttribute("transaction_id",json.get("transaction_id"));
		request.setAttribute("out_trade_no", json.get("out_trade_no"));
		request.setAttribute("time_end", json.get("time_end"));
		request.setAttribute("attach", json.get("attach"));
		
		// 请求转发
		request.getRequestDispatcher("/Admin/CompetitionManage/jsp/EnrollmentDetail.jsp").forward(request, response);
	}
	
}
