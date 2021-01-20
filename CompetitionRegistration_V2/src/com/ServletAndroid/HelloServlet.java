package com.ServletAndroid;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Dao.DaoUser;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 479397380558821730L;

	private static final String FILE_DIR = "C:\\Project\\apache-tomcat-9.0.0.M3\\webapps\\CompetitionRegistration\\Web\\image";

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("开始初始化...");
		
		File dir = new File(FILE_DIR);
		if(!dir.isDirectory())
		{
			boolean check = dir.mkdirs();
			System.out.println("创建文件夹：" + check);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String uId = req.getParameter("uid");
		// String uName = req.getParameter("uname");
		//
		// resp.getWriter().write("uId:" + uId + "  uName:"+ uName);
		String result = "0";
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory); 
		resp.setCharacterEncoding("UTF-8");
		  int userid = 0;
		  String userPicture = "0";
		try{
			List<FileItem> items = upload.parseRequest(req);
			
			Iterator<FileItem> iterator = items.iterator();
			while(iterator.hasNext())
			{
				FileItem item = iterator.next();
				
				if (item.isFormField())
				{
					userid = Integer.parseInt(item.getString("UTF-8"));
					System.out.println("表单参数名:" + item.getFieldName() + "，表单参数值:" + item.getString("UTF-8"));
					
				} 
				else
				{
					if (item.getName() != null && !item.getName().equals(""))
					{
						System.out.println("上传文件的大小:" + item.getSize());
						System.out.println("上传文件的类型:" + item.getContentType());
						// item.getName()返回上传文件在客户端的完整路径名称
						System.out.println("上传文件的名称:" + item.getName());
						
						File tempFile = new File(item.getName());
						// 上传文件的保存路径
						File file = new File(FILE_DIR, tempFile.getName());
						item.write(file);
						
						
						userPicture = "Web/image/"+item.getName();
						
					     
						// req.setAttribute("upload.message", "上传文件成功！");
						result = "8";
						
					} else
					{
						// req.setAttribute("upload.message", "没有选择上传文件！");
					}
				}
			}
			DaoUser userpic = DaoUser.getInstance();
		    boolean  flag = userpic.ModifyAUserHeadPic(userid, userPicture);
		    
		    System.out.println("HelloServlet--flag:" + flag);
			System.out.println("result---------" + result);
			resp.getWriter().write(result);
			resp.getWriter().flush();
		}catch(Exception ex){}
		
	}

}