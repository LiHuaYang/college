package upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
			
			//1.�õ�����������
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			//2.�õ�������
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//3.�ж��ϴ���������
			if(!upload.isMultipartContent(request)){
				//�ϴ���Ϊ��ͨ�������մ�ͳ��ʽ��ȡ���ݼ���
				return;
			}
			
			//Ϊ�ϴ���������ý����������ϴ�����
			List<FileItem> list = upload.parseRequest(request);  //FileItem
			
			//����list���õ����ڷ�װ��һ���ϴ�����������fileItem����
			for(FileItem item : list){
				
				if(item.isFormField()){
					//�õ�������ͨ������
					String name = item.getFieldName();  //�õ������������
					String value = item.getString();
					System.out.println(name + "=" + value);
				}else{
					//�õ��ϴ�������
					String filename = item.getName();  //�õ��ϴ��ļ���  C:\Documents and Settings\ThinkPad\����\1.txt
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					InputStream in = item.getInputStream();   //�õ��ϴ�����
					int len = 0;
					byte buffer[]= new byte[1024];
					
					//���ڱ����ϴ��ļ���Ŀ¼Ӧ�ý�ֹ���ֱ�ӷ���
					String savepath = this.getServletContext().getRealPath("/WEB-INF/upload");
					System.out.println(savepath);
					
					FileOutputStream out = new FileOutputStream(savepath + "\\" + filename);  //��uploadĿ¼��д���ļ�
					while((len=in.read(buffer))>0){
						out.write(buffer, 0, len);
					}
					
					in.close();
					out.close();
				}
			}
			
			
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
