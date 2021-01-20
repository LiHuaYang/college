package com.jiqiren.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jiqiren.service.impl.ServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport {
	
	private static final ServiceImpl service = new ServiceImpl();
	
	public String execute() throws Exception {
		return "success";
	}
	
	public String index() throws Exception {
		return "success";
	}
	
	/**
	 * 提供管理员登陆功能
	 * @return
	 * @author ariclee
	 */
	public String login() {
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
		
		String email = request.getParameter("email");
		String pswd = request.getParameter("pswd");

		boolean loginRes = service.login(email, pswd);
		
		if(loginRes) {/*登陆成功*/
			Map<String, Object> map = context.getSession();
			map.put("isLogin", "true");
			return "success";
			
		} else { /*登录失败*/
			request.setAttribute("msg", "登录失败");
			return "login_fail";
		}
	}
	
	/**
	 * 提供用户注册功能
	 * @return
	 * @author ariclee
	 */
	public String register() {
		return "";
	}
	
	
}
