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
import com.Entity.UserCommit;
/**
 * PcreateUesrCommit
 * �������½��û�
 * ���룺1. cleanerid	2. Userid
 * 		3. UserCommitContent	4. UserCommitRank
 * �����boolean���½�����Ա�����Ƿ�ɹ�����Ϣ��
 * ��ע���ڱ���Ա����ύ�Ժ����ݿ����һ�����ۼ�¼
 * @author Aric
 *
 */
public class PcreateUesrCommit extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");  
        
        String callbackName = request.getParameter("jsonp");
        
        // String RoomCommitTime 		= new String(request.getParameter("RoomCommitTime").getBytes("ISO-8859-1"),"utf-8");
        // String RoomCommitContent	= new String(request.getParameter("RoomCommitContent").getBytes("ISO-8859-1"),"utf-8");
        // String RoomCommitRank	    = new String(request.getParameter("RoomCommitRank").getBytes("ISO-8859-1"),"utf-8");
        String str_userid = new String(request.getParameter("userid ").getBytes("ISO-8859-1"),"utf-8");
        String str_cleanerid = new String(request.getParameter("cleanerid").getBytes("ISO-8859-1"),"utf-8");
        String str_UserCommitContent = new String(request.getParameter("UserCommitContent").getBytes("ISO-8859-1"),"utf-8");
        String str_UserCommitRank = new String(request.getParameter("UserCommitRank").getBytes("ISO-8859-1"),"utf-8");
        
        int userCommitRank = Integer.parseInt(str_UserCommitRank);
        int userid = Integer.parseInt(str_userid);
        int cleanerid = Integer.parseInt(str_cleanerid);
        
        UserCommit uc = new UserCommit(str_UserCommitContent,userCommitRank,cleanerid,userid);
        //int roomrank = Integer.parseInt(RoomCommitRank);
        IFrame interfaceOfBllFrame = new Impl();
        
        //RoomCommit rc = new RoomCommit(roomid,  userid,  RoomCommitContent,  roomrank);
        boolean result1 = interfaceOfBllFrame.CleanerCommitUser(uc);
        
        // JSONObject json1 = new JSONObject().fromObject(result1);
        // json1.put("result", result1);        
        JSONArray jsonArray = new JSONArray().fromObject(result1);
        
        PrintWriter out = response.getWriter();  
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        System.out.println("�������ݣ�"+jsonpResult);
       	out.println(jsonpResult);
        out.flush(); 
        out.close(); 
	}
}
