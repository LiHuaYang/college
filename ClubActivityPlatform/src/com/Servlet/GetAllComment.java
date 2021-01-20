package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.Bll.BllFame;
import com.Bll.IBllFrame;
/**
 * 
 *���ߣ�movie
 *ʱ�䣺2015-10-19����09:50:26
 *��������QueryAllComment
 *���ܣ���ѯ��������
 *������@param noticeId
 *������@return 
 *����ֵ��List<HashMap<String,Object>>
 */
public class GetAllComment extends HttpServlet {
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
List<HashMap<String, Object>> maps=bllFrame.QueryAllComment(noticeId);
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