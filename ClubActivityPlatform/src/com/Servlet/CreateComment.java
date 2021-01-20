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
import com.Entity.Comment;
/**
 * 
 *作者：movie
 *时间：2015-10-19上午09:24:28
 *函数名：CreateComment
 *功能：创建评论
 *参数：@param comment
 *参数：@return 
 *返回值：boolean
 */
public class CreateComment extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//获取参数
		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		int userId=jsonObject.getInt("userId");
		String commentContent=jsonObject.getString("commentContent");
		int noticeId=jsonObject.getInt("noticeId");
		Comment comment=new Comment(userId, commentContent, noticeId);
		IBllFrame bllFrame = new BllFame();
		boolean result=bllFrame.CreateComment(comment);
		JSONObject json = new JSONObject();
		json.put("result", result);
		System.out.println(json);

		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

}
