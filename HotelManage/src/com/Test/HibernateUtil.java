package com.Test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static SessionFactory sf = null;
	static{
		try{
			Configuration cfg = new AnnotationConfiguration();
			SessionFactory sf = cfg.configure().buildSessionFactory();
//			Configuration cfg = new Configuration().configure();//����HIberian�����ļ�
//			sf = cfg.buildSessionFactory();//�Ự��������
		}catch(Exception e){
			System.err.println("�����Ự����ʧ��");
			e.printStackTrace();
		}
	}
	//��ȡsession
	public static Session getSession(){
		Session session = threadLocal.get();
		if(session == null||!session.isOpen()){
			if(sf == null){
				rebuildSessionFactory();
			}
			session = (sf!=null)?sf.openSession():null;
			threadLocal.set(session);
		}
		return session;
	}
	//�ؽ��Ự����
	private static void rebuildSessionFactory() {
		// TODO Auto-generated method stub
		try {
			Configuration cfg = new AnnotationConfiguration().configure();
			sf = cfg.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("�����Ự����ʧ��");
			e.printStackTrace();
		}
	}
	//��ȡSessionFactory����
	public static SessionFactory getSessionFactory(){
		return sf;
	}
	//�ر�session
	public static void closeSession(){
		Session session = threadLocal.get();
		threadLocal.set(null);
		if(session!=null){
			session.close();
		}
	}
}
