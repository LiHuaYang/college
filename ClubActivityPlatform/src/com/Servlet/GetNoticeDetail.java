package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.BllFame;
import com.Bll.IBllFrame;
/**
 * 
 *���ߣ�movie
 *ʱ�䣺2015-10-18����10:18:12
 *��������QueryNoticeDetail
 *���ܣ���ѯ��������
 *������@param noticeId
 *������@return 
 *����ֵ��HashMap<String,Object>
 */
public class GetNoticeDetail extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

response.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");
IBllFrame bllFrame = new BllFame();
// ��ȡ����
JSONObject jsonObject = JSONObject.fromObject(new String(request
		.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
int noticeId = jsonObject.getInt("noticeId");
HashMap<String, Object> notice = bllFrame.QueryNoticeDetail(noticeId);
JSONObject json = null;
try {
	json = JSONObject.fromObject(notice);
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
