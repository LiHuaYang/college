package com.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.processors.JsonVerifier;

import com.Dao.DaoCompetition;
import com.EntityWeb.Enrollment;


/**
 * 
 * 后台参赛人员列表
 * 
 * @author ariclee
 *
 */
public class ContenderList extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");  
		response.setCharacterEncoding("utf-8"); 
		List<Enrollment> enrollments = null;
		JSONArray array = new JSONArray();
		
		DaoCompetition daocompetition = new DaoCompetition();
//		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));

		int page = jsonObject.getInt("page"); // 页数
		int type = jsonObject.getInt("type"); // 类型
		
		enrollments = daocompetition.ContenderList(page);	
		
		for (Enrollment enrollment : enrollments) {
			JSONObject json = JSONObject.fromObject(enrollment);
			json.put("url", "/CompetitionRegistration_V2/GetEnrollmentDetail?userId="+enrollment.getUserId());
			array.add(json);
		}
		
		PrintWriter out = response.getWriter();
		out.println(array);
		out.flush();
		out.close();
	}
	
	@Test
	public void test1 () {
		DaoCompetition daocompetition = new DaoCompetition();
//		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
//		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));

		List<Enrollment> list = null;
		list = daocompetition.ContenderList(1);
		JSONArray array = new JSONArray();
		
		for (Enrollment enrollment : list) {
			JSONObject json = JSONObject.fromObject(enrollment);
			json.put("url", "/CompetitionRegistration_V2/GetEnrollmentDetail?userId="+enrollment.getUserId());
			array.add(json);
		}

		System.out.println("Juint测试：" + array);
	}
	
	
	
	

}
