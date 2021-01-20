package com.ningbobw.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponseWrapper extends HttpServletResponseWrapper {

	// 需要增强的对象1
	private HttpServletResponse response;
	// 需要增谦的对象2
	private PrintWriter pw;

	public MyResponseWrapper(HttpServletResponse response) {
		super(response);
		this.response = response;
	}

	// 定义一个缓冲区，每当用户调用write时候，都往此处写数据
	private ByteArrayOutputStream bout = new ByteArrayOutputStream();

	// 需要增强的方法1：只是拿到一个流对象，想要返回出自己的流对象，需要实现ServletOutputStream
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return new MyServletOutputStream(this.bout);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		pw = new PrintWriter(new OutputStreamWriter(this.bout, this.response.getCharacterEncoding()));
		return pw;
	}

	// 自定义方法
	public byte[] getBuffer() {
		try {
			if (pw != null) {
				pw.close();
			}
			if (bout != null) {
				bout.flush();
				return bout.toByteArray();
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

//复写子类
class MyServletOutputStream extends ServletOutputStream {
	
	private ByteArrayOutputStream out;
	// ...
	public MyServletOutputStream (ByteArrayOutputStream out) {
//		super();
		this.out = out;
	}
	
	// 需要增强的方法1
	@Override
	public void write(int b) throws IOException {
		this.out.write(b);
	}
}
