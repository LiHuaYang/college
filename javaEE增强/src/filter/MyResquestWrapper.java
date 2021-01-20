package filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyResquestWrapper extends HttpServletRequestWrapper {

	HttpServletRequest request = null;
	
	public MyResquestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		try {
			if (!request.getMethod().equalsIgnoreCase("get")) {
				return value;
			}
			byte[] bytes = value.getBytes("ISO8859-1");
			value = new String(bytes, "UTF-8");
			return value;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
}
