package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.BllFame;
import com.Bll.IBllFrame;
import com.Entity.Notice;

/**
 * 
 *���ߣ�movie 
 *ʱ�䣺2015-10-19����09:55:44 
 *��������SearchNotice 
 *���ܣ��������� ������@return
 *����ֵ��List<Notice>
 */
public class SearchNotice  extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		//��ȡ����
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		String noticename =jsonObject.getString("noticeTitle");
		String starttime=jsonObject.getString("noticeStartTime");
		String endtime=jsonObject.getString("noticeEndTime");
		int noticetype=jsonObject.getInt("noticeBelongType");
		List<Notice> maps = bllFrame.SearchNotice(noticename, starttime, endtime,noticetype);
		JSONArray json = null;
		try {
			json = JSONArray.fromObject(maps);
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
