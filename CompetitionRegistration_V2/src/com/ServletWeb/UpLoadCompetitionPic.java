package com.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UpLoadCompetitionPic extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String HeadUrl = "";
		// 实例化上传组件
		SmartUpload upload = new SmartUpload();
		// 初始化上传组件
		try {
			upload.initialize(this.getServletConfig(), request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 开始上传
		try {
			upload.upload();

		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取上传的文件列表对象
		SmartFiles f = upload.getFiles();
		// 获取文件对象
		SmartFile fil = f.getFile(0);
		// 去掉文件后缀
		String ext = fil.getFileExt();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
		String time = sdf2.format(new java.util.Date());
		HeadUrl = "C:\\Project\\apache-tomcat-9.0.0.M3\\webapps\\CompetitionRegistration_V2\\Web\\image\\"
				+ time + "." + ext;

		String filename = "Web/image/" + time + "." + ext;

		try {
			fil.saveAs(HeadUrl);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 添加图片信息至数据库

		System.out.println("新添加的文件名为：" + HeadUrl);

		JSONObject jsonobject = new JSONObject();

		jsonobject.put("fileName", filename);
		jsonobject.put("filePath", HeadUrl);

		PrintWriter out = response.getWriter();

		out.println(jsonobject);
		out.flush();
		out.close();
	}
}
