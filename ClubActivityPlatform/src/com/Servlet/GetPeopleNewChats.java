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
import com.Bll.ChatHandle.Chat;
/**
 * 
 *作者：movie
 *时间：2015-10-21下午02:45:55
 *函数名：QueryPeopleNewChats
 *功能：查询有无最新聊天消息，返回1,2,3,4的发送者Id
 *参数：@param ReciverId
 *参数：@return 
 *返回值：String
 */
public class GetPeopleNewChats extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		// 获取参数
		JSONObject jsonObject = JSONObject.fromObject(new String(request
				.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int ReciverId=jsonObject.getInt("reciverId");
		String  friendId= bllFrame.QueryPeopleNewChats(ReciverId);
		JSONObject json = new JSONObject();
		json.put("friendId", friendId);
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
