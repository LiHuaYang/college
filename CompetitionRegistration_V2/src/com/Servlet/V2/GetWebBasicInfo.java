package com.Servlet.V2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.Dao.DaoCompetition;

/**
 * 
 * 获取网站首页基本信息
 * 
 * @author Administrator
 *
 */
public class GetWebBasicInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		JSONObject jsonData = JSONObject.fromObject(request.getParameter("data"));
		System.out.println(jsonData);
		int state = jsonData.getInt("state");
		
		IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
		
		JSONArray array = interfaceOfBllFrame.getCompetitonNameByState(state);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("res",array);
		jsonObject.put("msg", true);
		
		System.out.println("GetCompetitionNameByCompetitionState:" + jsonObject);
		out.println(jsonObject);
		out.flush();
		out.close();
	}
}
