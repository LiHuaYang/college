package com.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.File;
import com.Tool.HIbernateSessionFactory;


public class DaoFile {
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午04:42:27
	 *函数名：CreateFile
	 *功能：创建文档
	 *参数：@param file
	 *参数：@return 
	 *返回值：int
	 */
	public int CreateFile(File file){
		int FileId=0;
		try {
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			session.save(file);
			//FileId= Integer.parseInt(session.getIdentifier(file).toString());
			FileId=file.getFileId();
			session.getTransaction().commit();
			session.close();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FileId;

	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-14下午02:32:45
	 *函数名：queryFileByBelong
	 *功能：根据文件类型和所属查询文件
	 *参数：@param fileType
	 *参数：@param fileBelongId
	 *参数：@return 
	 *返回值：File
	 */
	public File queryFileByBelong(int fileType,int fileBelongId){
		File file=new File();
		try {	
		Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
		session.beginTransaction();
		String hql="from File where fileType="+fileType+"and fileBelongId="+fileBelongId;
		Query query=session.createQuery(hql);
		List<File> files=query.list();
		if (files.size()!=0) {
			file=files.get(0);
		}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午04:46:39
	 *函数名：DeleteFile
	 *功能：删除文档
	 *参数：@param fileId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteFile(int fileId){
		boolean result = false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			String hql="delete File where fileId="+fileId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			query.executeUpdate();
			session.beginTransaction().commit();
			session.close();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
