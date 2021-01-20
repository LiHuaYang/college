package com.nbut.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 基本servlet，实现动态的调用servlet，请求路径后面加需要调用的方法 (ex: method=list)
 *
 *
 * 作者：ariclee		时间：2016年6月4日下午3:41:56
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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method"); // getJoinerInfo
		try {
			// ContestActionV2
			Method func = this.getClass().getMethod(method, request.getClass(), response.getClass());
			func.invoke(this, request, response);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
	}
}
