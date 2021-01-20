package com.nbut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.factory.BllFactory;
import com.nbut.bll.UserManage;
import com.nbut.entity.User;
import com.nbut.filter.MyResponseWrapper;
import com.nbut.filter.MyResquestWrapper;

import net.sf.json.JSONObject;

/**
 * 
 *
 * 作者：ariclee		时间：2016年6月5日下午4:10:18
 */
@WebServlet("/UserActionV2")
public class UserActionV2 extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 函数名称：login
	 * 功能描述：
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月5日下午4:06:21
	 */
	public void login(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		String userId = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		JSONObject out_json = new JSONObject();
		PrintWriter out = response.getWriter();
		boolean flag = isLogin(request, response, userId);
		
		if (flag) {// 用户已经登录
			out_json.put("msg", "请不要重复登陆");
			out_json.put("res", "false");
			out_json.put("data", null);
			toCilent(out, out_json);
		} else {  // 用户未登录
			User user = login(userId, passwd);
			if (user==null) {
				out_json.put("msg", "用户验证失败");
				out_json.put("res", "false");
				out_json.put("data", null);
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("user", user); // 设置Session
				session.setMaxInactiveInterval(30 * 60); // 设置session为三十分钟
				out_json.put("msg", "登录成功");
				out_json.put("res", "true");
				out_json.put("data", user);
			}
			toCilent(out, out_json);
		}
	}
	/**
	 * 函数名称：logout
	 * 功能描述：
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月5日下午4:09:32
	 */
	public void logout(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		JSONObject out_json = new JSONObject();
		PrintWriter out = response.getWriter();
		
		if (logoutVa(request, response)) {
			out_json.put("msg", "登出成功");
			out_json.put("res", "true");
			out_json.put("data", null);
		} else {
			out_json.put("msg", "登出失败");
			out_json.put("res", "false");
			out_json.put("data", null);
		}
		toCilent(out, out_json);
	}

	/**
	 * 函数名称：AdminCheck
	 * 功能描述：管理员登陆验证
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月7日上午9:40:06
	 */
	public void AdminCheck(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		JSONObject out_json = new JSONObject();
		PrintWriter out = response.getWriter();
		
		if (us == null) {
			out_json.put("msg", "登陆后再操作");
			out_json.put("res", "false");
			out_json.put("data", null);
		} else {
			out_json.put("msg", "验证成功");
			out_json.put("res", "true");
			request.getSession().setAttribute("user", us);
			
			out_json.put("data", us);
			System.out.println("UserActionV2--AdminCheck--" + us);
		}
		toCilent(out, out_json);
	}
	
	/**
	 * 函数名称：register
	 * 功能描述：
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月7日下午12:45:10
	 */
	public void register(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		JSONObject out_json = new JSONObject();
		PrintWriter out = response.getWriter();
		boolean isOk = true;
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String school = request.getParameter("school");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String msg = "";
		out_json.put("data", null);
		out_json.put("other", null);
		
		if (password==null || password.trim().equals("")) {
			isOk = false;
		} else {
			if (!password.matches("\\d{6,10}")) { // 密码必须是6-8位的数字！！
				msg += "密码必须是6-8位的数字";
				out_json.put("msg", msg);
				isOk = false;
				out_json.put("res", "false");
			}
		}
		if (password2!=null) {
			if (!password2.equals(password)) {
				msg += "两次密码不一致";
				out_json.put("msg", msg);
				isOk = false; // 两次密码不一致
				out_json.put("res", "false");
			}
		}
		if (email!=null && email!=""){
			if (!email.matches("\\w+@\\w+(\\.\\w+)+")) {
				msg += "非法邮箱";
				out_json.put("msg", msg);
				isOk = false; // 非法邮箱
				out_json.put("res", "false");
			}
		}
		UserManage mm = BllFactory.getInstance().getUserManage();
		if (isOk) {
			User uu1 = mm.getUserByUserId(id);
			if (uu1.getUser_id()!=null) {
				msg+="用户已经注册";
				out_json.put("msg", msg);
				isOk = false;
				out_json.put("res", "false");
			}
		}
		// 基础验证通过，开始进行逻辑业务
		if (isOk) {
			User uu2 = new User(id, password, school, nickname, email, request.getRemoteAddr());
			uu2 = mm.register(uu2);
			if (uu2==null) {
				msg+="注册失败（未知错误）";
				out_json.put("msg", msg);
				out_json.put("res", "false");
			}
			else {
				msg+="注册成功";
				out_json.put("msg", msg);
				out_json.put("res", "true");
				HttpSession session = request.getSession(); // 自动登录
				session.setAttribute("user", uu2); // 设置Session
				session.setMaxInactiveInterval(30 * 60); // 设置session为三十分钟
			}
		}
		toCilent(out, out_json);
	}
	
/******************************************************************************************************/	
	/**
	 * 函数名称：isLogin
	 * 功能描述：验证session中是否有已经存在当前登陆用户
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月31日上午9:01:52
	 */
	public boolean isLogin(HttpServletRequest request, HttpServletResponse response, String userId) {
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		boolean flag = false;
		
		if (us!=null && us.getUser_id().equals(userId)) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 函数名称：login
	 * 功能描述：用户登录
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月31日上午9:16:21
	 */
	public User login(String userId, String passwd) {
		UserManage uu = BllFactory.getInstance().getUserManage();
		User user = uu.login(userId, passwd);
		return user;
	}
/******************************************************************************************************/	
	
	/**
	 * 函数名称：logout
	 * 功能描述：
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月31日上午10:21:53
	 */
	public boolean logoutVa(MyResquestWrapper request, MyResponseWrapper response) {
		request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		if (us==null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 函数名称：toCilent
	 * 功能描述：回送数据至客户端
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月31日上午11:53:07
	 */
	public void toCilent(PrintWriter out, JSONObject out_json) {
		out.println(out_json);
		out.flush();
		out.close();
	}
	
}
