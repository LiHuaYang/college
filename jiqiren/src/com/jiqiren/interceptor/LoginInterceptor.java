package com.jiqiren.interceptor;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	private static final String LOGIN = "login";
	@Override
	public String doIntercept(ActionInvocation actionInvocation) throws Exception {
		// ��ȡsession����(����struts2��װ��)
		Map session = ActionContext.getContext().getSession();
		// ��ȡsession���������Ƿ���ֵ
		String loginFlag = (String)session.get("isLogin");
		

		if(loginFlag == null) {
			return "to_login";
		}
		if (loginFlag.equals("true")) {// �Ϸ�����
			return actionInvocation.invoke();
		} else {// userΪ��˵��δ������½,���������ʾ��Ϣ,������½ҳ��
			return "to_login";
		}
	}
}
