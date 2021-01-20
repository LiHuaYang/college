package filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.zip.GZIPOutputStream;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * ��̬����ʽʵ��ȫվʽѹ��������
 *
 * ���ߣ�ariclee		ʱ�䣺2016��9��8������10:00:17
 */
public class GzipFilterProxy implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) resp;

		ResponseProxy proxy = new ResponseProxy(response);
		ServletResponse procyResponse = proxy.createProxy();
		chain.doFilter(request, procyResponse); // ResponseProxy.get...

		byte[] out = proxy.getBuffer();

		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		GZIPOutputStream gOut = new GZIPOutputStream(bOut);
		gOut.write(out);
		gOut.close();

		byte[] gzip = bOut.toByteArray();

		response.setHeader("content-encoding", "gzip");
		response.setContentLength(gzip.length);
		response.getOutputStream().write(gzip);
	}

	class ResponseProxy {
		private ByteArrayOutputStream bout = new ByteArrayOutputStream();
		private PrintWriter pw = null;
		private HttpServletResponse response;

		public byte[] getBuffer() {
			if (pw != null) {
				pw.close();
			}
			return bout.toByteArray();
		}

		public ResponseProxy(HttpServletResponse response) {
			this.response = response;
		}

		public ServletResponse createProxy() {
			return (ServletResponse) Proxy.newProxyInstance(GzipFilterProxy.class.getClassLoader(),
					response.getClass().getInterfaces(), new InvocationHandler() {
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							if (method.getName().equals("getWriter")) {
								pw = new PrintWriter(new OutputStreamWriter(bout, "UTF-8"));
								return pw;
							} else if (method.getName().equals("getOutputStream")) {
								return new ServletOutputStream() {
									@Override
									public void write(int b) throws IOException {
										bout.write(b);
									}
								};
							} else {
								return method.invoke(response, args);
							}
						}
					});
		}
	}

	public void destroy() {

	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
