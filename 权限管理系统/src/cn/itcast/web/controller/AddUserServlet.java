package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.service.SecurityService;
import cn.itcast.utils.WebUtils;

//添加用户
public class AddUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setId(WebUtils.makeUUID());
		user.setUsername(username);
		user.setPassword(password);
		
		SecurityService serivce = new SecurityService();
		serivce.addUser(user);
		request.setAttribute("message", "添加成功！！");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败！！");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
