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
 *ʱ�䣺2015-10-19����02:59:03
 *��������QueryNoticeByBelong
 *���ܣ���ѯ����ͨ������
 *������@param noticeBelongType
 *������@param noticeBelongId
 *������@return 
 *����ֵ��List<Notice>
 */
public class GetNoticeByBelong extends HttpServlet {


	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//��ȡ����
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int noticeBelongId=jsonObject.getInt("noticeBelongId");
		int noticeBelongType=jsonObject.getInt("noticeBelongType");


		IBllFrame bllFrame=new BllFame();
		List<Notice> notices=bllFrame.QueryNoticeByBelong(noticeBelongType, noticeBelongId);
		JSONArray json=null;
		try {
			json=JSONArray.fromObject(notices);
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
