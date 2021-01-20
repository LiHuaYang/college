package com.Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class upload extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String HeadUrl = "";
		// ʵ�����ϴ����
		SmartUpload upload = new SmartUpload();
		// ��ʼ���ϴ����
		try {
			upload.initialize(this.getServletConfig(), request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
		// ��ʼ�ϴ�
		try {
			upload.upload();

		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		// ��ȡ�ϴ����ļ��б����
		SmartFiles f = upload.getFiles();
		// ��ȡ�ļ�����
		SmartFile fil = f.getFile(0);
		// ȥ���ļ���׺
		String ext = fil.getFileExt();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
		String time = sdf2.format(new java.util.Date());
		HeadUrl = "e:\\" + time + "." + ext;
		try {
			fil.saveAs(HeadUrl);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
