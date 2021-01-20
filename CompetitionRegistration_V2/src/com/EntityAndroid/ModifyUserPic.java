package com.EntityAndroid;

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


public class ModifyUserPic extends HttpServlet {

	private static final long serialVersionUID = 479397380558821730L;

	private static final String FILE_DIR = "C:\\images";

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
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory); 
		resp.setCharacterEncoding("UTF-8");
		try{
			List<FileItem> items = upload.parseRequest(req);
			
			Iterator<FileItem> iterator = items.iterator();
			while(iterator.hasNext())
			{
				FileItem item = iterator.next();
				
				if (item.isFormField())
				{
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
						
					} else
					{
						// req.setAttribute("upload.message", "没有选择上传文件！");
					}
				}
			}
			resp.getWriter().write("上传文成功！");
			resp.getWriter().flush();
		}catch(Exception ex){}
		
	}

}
