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
 *时间：2015-10-21上午11:07:39
 *函数名：QueryPeopleChats
 *功能：查询用户间的聊天
 *参数：@param CreateId
 *参数：@param ReciverId
 *参数：@return 
 *返回值：List<Chat>
 */
public class GetPeopleChats extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame bllFrame = new BllFame();
		// 获取参数
		JSONObject jsonObject = JSONObject.fromObject(new String(request
				.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int CreateId = jsonObject.getInt("createId");
		int ReciverId=jsonObject.getInt("reciverId");
		
		List<Chat>  chats= bllFrame.QueryPeopleChats(CreateId, ReciverId);
		JSONArray json = new JSONArray();
		json=JSONArray.fromObject(chats);
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
