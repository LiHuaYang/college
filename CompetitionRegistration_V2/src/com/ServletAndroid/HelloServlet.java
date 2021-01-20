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
		System.out.println("��ʼ��ʼ��...");
		
		File dir = new File(FILE_DIR);
		if(!dir.isDirectory())
		{
			boolean check = dir.mkdirs();
			System.out.println("�����ļ��У�" + check);
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
					System.out.println("��������:" + item.getFieldName() + "��������ֵ:" + item.getString("UTF-8"));
					
				} 
				else
				{
					if (item.getName() != null && !item.getName().equals(""))
					{
						System.out.println("�ϴ��ļ��Ĵ�С:" + item.getSize());
						System.out.println("�ϴ��ļ�������:" + item.getContentType());
						// item.getName()�����ϴ��ļ��ڿͻ��˵�����·������
						System.out.println("�ϴ��ļ�������:" + item.getName());
						
						File tempFile = new File(item.getName());
						// �ϴ��ļ��ı���·��
						File file = new File(FILE_DIR, tempFile.getName());
						item.write(file);
						
						
						userPicture = "Web/image/"+item.getName();
						
					     
						// req.setAttribute("upload.message", "�ϴ��ļ��ɹ���");
						result = "8";
						
					} else
					{
						// req.setAttribute("upload.message", "û��ѡ���ϴ��ļ���");
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