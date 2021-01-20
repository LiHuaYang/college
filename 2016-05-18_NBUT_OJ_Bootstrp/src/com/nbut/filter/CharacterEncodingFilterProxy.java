package com.nbut.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 *
 * 作者：ariclee		时间：2016年6月5日下午12:41:33
 */
public class CharacterEncodingFilterProxy implements Filter {
	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		final HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		request.setCharacterEncoding("UTF-8");   //post  get   request.getParameter()
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/htmll;charset=UTF-8");
		
		chain.doFilter((ServletRequest) Proxy.newProxyInstance(this.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler(){
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			String methodname = method.getName();  //拿到当前的方法
			if(methodname.equals("getParameter")){
				//执行request.getparameter获取结果
				String value = (String) method.invoke(request, args);
				if(value==null){
					return null;
				}
				if(!request.getMethod().equalsIgnoreCase("get")){ //判断是为get请求
					return value;
				}
				//转换编码返回
				value = new String(value.getBytes("iso8859-1"),request.getCharacterEncoding());
				return value;
			}
			//交给request执行请求
			return method.invoke(request, args);
			}
		}), response);   
	}
	

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}
}
