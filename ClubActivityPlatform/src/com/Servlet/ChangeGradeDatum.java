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
/**
 * 
 *���ߣ�movie
 *ʱ�䣺2015-10-22����01:42:55
 *��������changeGradeDatum
 *���ܣ��޸�ְλ����
 *������@param gradeId
 *������@param gradeContent
 *������@param gradePic
 *������@return 
 *����ֵ��boolean
 */
public class ChangeGradeDatum extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		//��ȡ����
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int gradeId=jsonObject.getInt("gradeId");
		String gradeContent=jsonObject.getString("gradeContent");
		String gradePic=jsonObject.getString("gradePic");
		boolean result=bllFrame.ChangeGradeDatum(gradeId, gradeContent, gradePic);
		JSONObject json = new JSONObject();
		json.put("result", result);
		System.out.println(json);
		PrintWriter out = response.getWriter();	
		out.println(json);
		out.flush();
		out.close();
}

}
