package com.jiqiren.interceptor;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	private static final String LOGIN = "login";
	@Override
	public String doIntercept(ActionInvocation actionInvocation) throws Exception {
		// 获取session对象(经过struts2包装过)
		Map session = ActionContext.getContext().getSession();
		// 获取session作用域内是否有值
		String loginFlag = (String)session.get("isLogin");
		

		if(loginFlag == null) {
			return "to_login";
		}
		if (loginFlag.equals("true")) {// 合法访问
			return actionInvocation.invoke();
		} else {// user为空说明未经过登陆,保存错误提示信息,跳到登陆页面
			return "to_login";
		}
	}
}
