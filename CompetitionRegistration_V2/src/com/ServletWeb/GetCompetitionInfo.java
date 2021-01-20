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
import com.EntityWeb.CompetitionInfo;

public class GetCompetitionInfo extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
		JSONObject json = new JSONObject();

		// 查询所有正在进行中的比赛
		List<CompetitionInfo> organizations = interfaceOfBllFrame.ContestSearchByState(3);
		
		JSONArray array = JSONArray.fromObject(organizations);

		System.out.println("GetCompetitionInfo 返回客户端的数据: " + array);
		PrintWriter out = response.getWriter();
		out.println(array);
		out.flush();
		out.close();
	}
}
