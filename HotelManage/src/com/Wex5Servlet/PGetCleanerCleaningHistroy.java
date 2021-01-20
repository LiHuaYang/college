package com.Wex5Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.AndroidBll.IFrame;
import com.AndroidBll.Impl;
import com.Entity.CleaningRecord;
/**
 * PGetCleanerCleaningHistroy
 * 概述：返回保洁员的清洁历史
 * 输入：1. cleanerid
 * 输出：List<CleaningRecord> （清洁记录列表）
 * 备注：保洁员点击查询，返回保洁历史记录
 * @author Aric
 *
 */
public class PGetCleanerCleaningHistroy extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");        
        String callbackName = request.getParameter("jsonp");
        
        String cleanerid  = new String(request.getParameter("cleanerid").getBytes("ISO-8859-1"),"utf-8");
        int    cleaner_id = Integer.parseInt(cleanerid);
        
        IFrame interfaceOfBllFrame = new Impl();
        List<CleaningRecord> result1 = new ArrayList<CleaningRecord>();
        
        result1 = interfaceOfBllFrame.CleanerQueryCleaningHistroy(cleaner_id);
        
        JSONArray jsonArray;
        jsonArray = new JSONArray().fromObject(result1);
        
        String jsonpResult = String.format("%s(%s)", callbackName, jsonArray);
        
        System.out.println("反回客户端数据："+jsonpResult);
        
        PrintWriter out = response.getWriter();  
       	out.println(jsonpResult);
        out.flush(); 
        out.close();  
	}
}
