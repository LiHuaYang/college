package com.ServletAndroid;

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
import com.EntityAndroid.ComBasicAddMoney;

//通过选择年级和报名状态显示大赛列表(包括报名费用信息)
public class ComBasicAddMoneyServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
//		int ContestObject = Integer.parseInt(request.getParameter("ContestObject"));
//		int ContestState = Integer.parseInt(request.getParameter("ContestState"));
		
		IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
		JSONArray json = null;
		JSONObject jsonObject=new JSONObject();
		
		
		List<ComBasicAddMoney> result=interfaceOfBllFrame.SearchCompetitionCludeMoney();
		try {
			json=new JSONArray().fromObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jsonObject.element("result",json);
		
		System.out.println(jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}


}