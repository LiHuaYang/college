package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.BllFame;
import com.Bll.IBllFrame;
import com.Entity.Activity;
import com.Entity.Notice;
/**
 * 
 *���ߣ�movie
 *ʱ�䣺2015-10-15����10:45:11
 *��������SaveNotice
 *���ܣ���������
 *������@param notice
 *������@return 
 *����ֵ��boolean
 */
public class CreateNotice extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//��ȡ����
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		String noticeTitle=jsonObject.getString("noticeTitle");
		String noticeContent=jsonObject.getString("noticeContent");
		int noticeBelongType=jsonObject.getInt("noticeBelongType");
		int noticeBelongId=jsonObject.getInt("noticeBelongId");
		String noticePicture=jsonObject.getString("noticePicture");
		Notice notice=new Notice(noticeTitle, noticeContent, noticeBelongType, noticeBelongId, noticePicture);
		IBllFrame bllFrame = new BllFame();
		boolean result=bllFrame.SaveNotice(notice);
		JSONObject json = new JSONObject();
		json.put("result", result);
		System.out.println(json);

		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
