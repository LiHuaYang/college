package com.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;

public class ImportUserInfo extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		JFileChooser fileChooser = new JFileChooser("D:\\");
	    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        int returnVal = fileChooser.showOpenDialog(fileChooser);
	                    if(returnVal == JFileChooser.APPROVE_OPTION){       
	        String filePath= fileChooser.getSelectedFile().getAbsolutePath();//这个就是你选择的文件夹的路径
		
	    System.out.println(filePath);
		
		System.out.println("ModifyUser 返回用户的数据：" + "");
		PrintWriter out = response.getWriter();
		out.println("");
		out.flush();
		out.close();
	                    }
	}
}
