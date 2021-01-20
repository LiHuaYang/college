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
import com.Entity.Friend;
/**
 * 
 *���ߣ�movie
 *ʱ�䣺2015-12-27����04:16:07
 *��������applyFriend
 *���ܣ������������
 *������@param friend
 *������@return 
 *����ֵ��boolean
 */
public class ApplyFriend extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		// ��ȡ����
		JSONObject jsonObject = JSONObject.fromObject(new String(request
				.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int userId = jsonObject.getInt("userId");
		int friendId=jsonObject.getInt("friendId");
		Friend friend=new Friend(userId, friendId);
		boolean result = bllFrame.applyFriend(friend);
		JSONObject json = new JSONObject();
		json.put("result", result);
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
