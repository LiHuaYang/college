package com.Wex5Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.AndroidBll.IFrame;
import com.AndroidBll.Impl;
import com.Entity.RoomCommit;

/**
 * PCancelOrderServlet
 * 概述：客户房间评价
 * 输入：1. userid	2. roomid  3.usercommitrank  4.usercommitcontent
 * 输出：boolean （是否评论成功的消息）
 * @author Aric
 *
 */
public class PUserCommitServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        
        String callbackName = request.getParameter("jsonp");
        
        String str_userid = new String(request.getParameter("userid").getBytes("ISO-8859-1"),"utf-8");
        String str_roomid = new String(request.getParameter("roomid").getBytes("ISO-8859-1"),"utf-8");
        String str_commit_rank = new String(request.getParameter("usercommitrank").getBytes("ISO-8859-1"),"utf-8");
        String str_commit = new String(request.getParameter("usercommitcontent").getBytes("ISO-8859-1"),"utf-8");
        
        int    userid = Integer.parseInt(str_userid);
        int    roomid = Integer.parseInt(str_roomid);
        int	   commit_rank=Integer.parseInt(str_commit_rank);
        
        IFrame interfaceOfBllFrame = new Impl();
        
        RoomCommit rommcommit=new RoomCommit(roomid, userid, str_commit, commit_rank);
        
        boolean result1 = interfaceOfBllFrame.CreateRoomCommit(rommcommit);

        JSONArray jsonArray = new JSONArray().fromObject(result1);
        
        PrintWriter out = response.getWriter();  
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        System.out.println("返回数据："+jsonpResult);
       	out.println(jsonpResult);
        out.flush(); 
        out.close(); 
	}
}
