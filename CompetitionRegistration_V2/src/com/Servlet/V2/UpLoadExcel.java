package com.Servlet.V2;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * 
 * 上传Excel并更新数据库中的记录
 * 
 * 上传路径为
 * 		C:\competition_excel
 * 
 * 格式为： 
 *  大赛名	                             身份证号	                      查询成绩时候的密码	学生成绩		学生准考证号码
	浙江省中小学生数学竞赛	111111111111111111	10001				123
	浙江省中小学生数学竞赛	111111111111111112	10002				124
	浙江省中小学生数学竞赛	111111111111111113	10003				125
 *
 * @author Administrator
 *
 */
public class UpLoadExcel extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
		JSONObject jsonobject = new JSONObject();
		
		String excelpath = uploadExcel(request, response);
		if ( excelpath != null) {
			if (interfaceOfBllFrame.updateScore(excelpath)) {
				jsonobject.put("msg", true);
			}
			else {
				jsonobject.put("msg", false);
			}
		} 
		else {
			jsonobject.put("msg", false);
		}
		
		PrintWriter out = response.getWriter();
		out.println(jsonobject);
		out.flush();
		out.close();
	}
	
	
	public String uploadExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 实例化上传组件
		SmartUpload upload = new SmartUpload();
		String HeadUrl = "";
		// 初始化上传组件
		try {
			upload.initialize(this.getServletConfig(), request, response);
		} catch (ServletException e) {
			HeadUrl = null;
			e.printStackTrace();
		}
		// 开始上传
		try {
			upload.upload();
		} catch (ServletException e) {
			HeadUrl = null;
			e.printStackTrace();
		} catch (IOException e) {
			HeadUrl = null;
			e.printStackTrace();
		} catch (SmartUploadException e) {
			HeadUrl = null;
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
		HeadUrl = "C:\\competition_excel\\" + time + "." + ext;

		try {
			fil.saveAs(HeadUrl);
		} catch (SmartUploadException e) {
			HeadUrl = null;
			e.printStackTrace();
		}
		return HeadUrl;
	}
}
