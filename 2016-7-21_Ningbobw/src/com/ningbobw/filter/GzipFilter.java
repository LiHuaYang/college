package com.ningbobw.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 实现全站的数据压缩
public class GzipFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
//		response.setContentType("text/html;charset=" + "UTF-8");
		
		MyResponseWrapper myResponse = new MyResponseWrapper(response);
		chain.doFilter(request, myResponse);
		
		// 获得用户数据,开始压缩
		byte[] out = myResponse.getBuffer();
//		System.out.println("原始数据的大小为: " + out.length);
		
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		GZIPOutputStream gOut = new GZIPOutputStream(bOut);
		gOut.write(out);
		gOut.close();
		
		byte[] gzip = bOut.toByteArray();
//		System.out.println("压缩数据的大小为: " + gzip.length);
		
		response.setHeader("content-encoding", "gzip");
		response.setContentLength(gzip.length);
		response.getOutputStream().write(gzip);
	}

	
	public void init(FilterConfig arg0) throws ServletException {
	}
	public void destroy() {
	}
}

/**
 * 1. 定义一个类继承或者实现和被增强对象接口或者是父类
 * 2. 定义一个变量记住被增强对象
 * 3. 
 * 
 */
//class BufferResponse extends HttpServletResponseWrapper {
//	
//	// 需要增强的对象1
//	private HttpServletResponse response ;
//	// 需要增谦的对象2
//	private PrintWriter pw ;
//	
//	// 定义一个缓冲区，每当用户调用write时候，都往此处写数据
//	private ByteArrayOutputStream bout = new ByteArrayOutputStream();
//	
//	public BufferResponse (HttpServletResponse res) {
//		super(res); // 先构造父类的，在构造子类的
//		response = res;
//	}
//	
//	// 需要增强的方法1：只是拿到一个流对象，想要返回出自己的流对象，需要实现ServletOutputStream
//	@Override
//	public ServletOutputStream getOutputStream() throws IOException {
//		
//		return new MyServletOutputStream(this.bout);
//	}
//	@Override
//	public PrintWriter getWriter() throws IOException {
////		pw = new PrintWriter(new OutputStreamWriter(bout,this.response.getCharacterEncoding()));  //PrintWriter.write(ÖÐ¹ú) <br>
////		return pw;
//		
////		return new PrintWriter(this.bout); // 临时变量！！！！！！！
//		pw = new PrintWriter(new OutputStreamWriter(this.bout, this.response.getCharacterEncoding()));
//		return pw;
//	}
//	
//	// 自定义方法
//	public byte[] getBuffer () {
//		try {
//				if(pw!=null){
//					pw.close();
//				}
//				if (bout!=null) {
//					bout.flush();
//					return bout.toByteArray();
//				} 
//				return null;
//			} catch (Exception e) {
//				throw new RuntimeException(e);
//		}
//	}
//}









