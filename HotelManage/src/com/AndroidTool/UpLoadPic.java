package com.AndroidTool;

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

public class UpLoadPic {
	
	public String upLoadPic(HttpServlet ss, HttpServletRequest request, HttpServletResponse response) {

		String HeadUrl = "";
		// ʵ�����ϴ����
		SmartUpload upload = new SmartUpload();
		// ��ʼ���ϴ����
		try {
			upload.initialize(ss.getServletConfig(), request, response);
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
		
		HeadUrl = "./img" + time + "." + ext;
		try {
			fil.saveAs(HeadUrl);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
		
		return HeadUrl;
	}
	
	
}
