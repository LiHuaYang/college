package com.Servlet.V2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.Dao.DaoCompetition;
import com.Entity.V2.BriefCompetitionSet;
import com.Tool.MyOpecode;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetRecentCompetitionServlet extends HttpServlet {

	private static final String CharacterEncoding = "UTF-8";
	private static final long serialVersionUID = 1L;

        /**
         * 业务逻辑方法：决定调用doGet还是doPost方法
         */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 将请求转向doGet或者doPost方法
		req.setCharacterEncoding(CharacterEncoding);//设置编码
		resp.setCharacterEncoding(CharacterEncoding);
		super.service(req, resp);       //判断调用doGet还是doPost
	}

	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		IBllFrame iBllFrame = CBllFrame.getInstance();
		
		BriefCompetitionSet competitionSet = iBllFrame.getRecentCompetition();
		
		JSONArray jsonArray = competitionSet.toJson(MyOpecode.competition.tojsonOfAndroidHome);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", jsonArray);
		jsonObject.put("msg", true);
		
		System.out.println("GetRecentCompetitionServlet:" + jsonObject);
		out.println(jsonObject);
		out.flush();
		out.close();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 接收Get类型的请求
		// super.doGet(req, resp);
		doPost(req, resp);
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// 接收受保护的请求
		super.service(req, res);
	}

}
