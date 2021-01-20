package com.ningbobw.filter;

import java.io.IOException;
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
 * 作者：ariclee		时间：2016年6月5日下午12:41:22
 */
public class CharacterEncodingFilter implements Filter {
	private FilterConfig filterConfig = null;
	private String defaultCharset = "UTF-8";

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String charset = filterConfig.getInitParameter("charset");
		if (charset == null) {
			charset = defaultCharset;
		}
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		response.setContentType("text/html;charset=" + charset);
		MyResquestWrapper myRequest = new MyResquestWrapper(request);
//		MyResponseWrapper myResponse = new MyResponseWrapper(response);
		
		chain.doFilter(myRequest, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	@Override
	public void destroy() {
	}
}

/**
 * 
 *
 * 作者：ariclee		时间：2016年6月5日下午12:41:27
 */
//class MyRequest extends HttpServletRequestWrapper {
//	HttpServletRequest request = null;
//	/**
//	 * 
//	 * @param request
//	 */
//	public MyRequest(HttpServletRequest request) {
//		super(request);
//		this.request = request;
//	}
//
//	@Override
//	public String getParameter(String name) {
//		String value = request.getParameter(name);
//		try {
//			if (!request.getMethod().equalsIgnoreCase("get")) {
//				return value;
//			}
//			byte[] bytes = value.getBytes("ISO8859-1");
//			value = new String(bytes, "UTF-8");
//			return value;
//		} catch (UnsupportedEncodingException e) {
//			throw new RuntimeException(e);
//		}
//	}
//}
