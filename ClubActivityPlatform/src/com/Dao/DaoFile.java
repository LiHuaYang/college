package com.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.File;
import com.Tool.HIbernateSessionFactory;


public class DaoFile {
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����04:42:27
	 *��������CreateFile
	 *���ܣ������ĵ�
	 *������@param file
	 *������@return 
	 *����ֵ��int
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
	 *���ߣ�movie
	 *ʱ�䣺2015-12-14����02:32:45
	 *��������queryFileByBelong
	 *���ܣ������ļ����ͺ�������ѯ�ļ�
	 *������@param fileType
	 *������@param fileBelongId
	 *������@return 
	 *����ֵ��File
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����04:46:39
	 *��������DeleteFile
	 *���ܣ�ɾ���ĵ�
	 *������@param fileId
	 *������@return 
	 *����ֵ��boolean
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
