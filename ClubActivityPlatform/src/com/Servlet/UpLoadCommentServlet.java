package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Tool.MyConstant.UploadType;
import com.Tool.MyConstant.UploadUrl;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UpLoadCommentServlet extends HttpServlet {


	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String HeadUrl="";
	
		//实例化上传组件
		SmartUpload upload = new SmartUpload();
		//初始化上传组件


		String urlString=UploadUrl.NOTICEURL;
		try {
			upload.initialize(this.getServletConfig(), request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//开始上传
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
		//获取上传的文件列表对象
		SmartFiles f = upload.getFiles();
		
		//获取文件对象
		SmartFile fil = f.getFile(0);
		//去掉文件后缀
		String ext = fil.getFileExt();
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy_MM_ss_HHmmss");
		String time=sdf2.format(new java.util.Date());
		//路径
		String  strurl=this.getServletContext().getRealPath("/")+urlString;
		System.out.println(strurl);
		HeadUrl=strurl +time+"."+ext;
		try {
			fil.saveAs(HeadUrl);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json=new JSONObject();
		json.put("result", "./"+urlString+time+"."+ext);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
	
	
	private String getPicUrl(int uploadtype){
		String url="";
		switch (uploadtype) {
		case UploadType.USER:
			url=UploadUrl.USERURL;
			break;
		case UploadType.ACTIVITY:
			url=UploadUrl.ACTIVITYURL;
			break;
		case UploadType.CORPORATION:
			url=UploadUrl.CORPORATIONURL;
			break;
		case UploadType.DEPARTMENT:
			url=UploadUrl.DEPARTMENTURL;
			break;
		case UploadType.GRADE:
			url=UploadUrl.GRADEURL;
			break;
		case UploadType.NOTICE:
			url=UploadUrl.NOTICEURL;
			break;
		case UploadType.ORGANIZE:
			url=UploadUrl.ORGANIZEURL;
			break;
		default:
			break;
		}
		return url;
	}
}
