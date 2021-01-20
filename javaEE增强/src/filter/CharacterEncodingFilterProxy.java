package filter;

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
 * ��̬����ʵ��ȫվʽ���������
 *
 * ���ߣ�ariclee		ʱ�䣺2016��9��8������10:01:10
 */
public class CharacterEncodingFilterProxy implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		final HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		request.setCharacterEncoding("UTF-8"); // post get
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/htmll;charset=UTF-8");

		chain.doFilter((ServletRequest) Proxy.newProxyInstance(this.getClass().getClassLoader(),
				request.getClass().getInterfaces(), new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						String methodname = method.getName(); 
						if (methodname.equals("getParameter")) {
							String value = (String) method.invoke(request, args);
							if (value == null) {
								return null;
							}
							if (!request.getMethod().equalsIgnoreCase("get")) { 
								return value;
							}
							value = new String(value.getBytes("iso8859-1"), request.getCharacterEncoding());
							return value;
						}
						return method.invoke(request, args);
					}
				}), response);
	}

	public void destroy() {

	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}
}
