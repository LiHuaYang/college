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

public class GetCompetitionNameByCompetitionState extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
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
