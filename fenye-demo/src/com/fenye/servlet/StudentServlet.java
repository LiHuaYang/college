package com.fenye.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenye.service.StudentService;

public class StudentServlet extends HttpServlet {
	
	private static final StudentService service = new StudentService();
	private static final int FIRST_PAGE = 1;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageStr = req.getParameter("page");
		int page = 1;
		
		if(pageStr == null || pageStr == "") { // 第一次访问
			req.setAttribute("result", service.getPage(page));
			req.getRequestDispatcher("/students.jsp").forward(req, resp);
			return ;
		}
		
		if(!pageStr.matches("[0-9]+") && pageStr != null) { // 错误情况
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
			return ;
		}
		page = Integer.valueOf(pageStr);
		
		if(page < 0) { // 错误情况
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		} 

		req.setAttribute("result", service.getPage(page));
		req.getRequestDispatcher("/students.jsp").forward(req, resp);
	}
	
	public static void main(String[] args) {
		String pageStr = null;
		int page = Integer.valueOf(pageStr);
		System.out.println(page);
	}
}



