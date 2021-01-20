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
	 * �ṩ����Ա��½����
	 * @return
	 * @author ariclee
	 */
	public String login() {
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
		
		String email = request.getParameter("email");
		String pswd = request.getParameter("pswd");

		boolean loginRes = service.login(email, pswd);
		
		if(loginRes) {/*��½�ɹ�*/
			Map<String, Object> map = context.getSession();
			map.put("isLogin", "true");
			return "success";
			
		} else { /*��¼ʧ��*/
			request.setAttribute("msg", "��¼ʧ��");
			return "login_fail";
		}
	}
	
	/**
	 * �ṩ�û�ע�Ṧ��
	 * @return
	 * @author ariclee
	 */
	public String register() {
		return "";
	}
	
	
}
