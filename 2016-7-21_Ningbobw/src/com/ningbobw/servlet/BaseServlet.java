package com.ningbobw.servlet;

import java.lang.reflect.Method;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 基本servlet，实现动态的调用servlet，请求路径后面加�?��调用的方�?(ex: method=list)
 *
 *
 * 作�?：ariclee		时间�?016�?�?日下�?:41:56
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public BaseServlet() {
        super();
    }

    /**
     * 通过反射来实现动态方法的调用
     */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getParameter("m");
		try {
			Method func = this.getClass().getMethod(method, request.getClass(), response.getClass());
			func.invoke(this, request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	protected void send() {
		
	}
}
