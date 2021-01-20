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
//			Configuration cfg = new Configuration().configure();//加载HIberian配置文件
//			sf = cfg.buildSessionFactory();//会话工厂创建
		}catch(Exception e){
			System.err.println("创建会话工厂失败");
			e.printStackTrace();
		}
	}
	//获取session
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
	//重建会话工厂
	private static void rebuildSessionFactory() {
		// TODO Auto-generated method stub
		try {
			Configuration cfg = new AnnotationConfiguration().configure();
			sf = cfg.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("创建会话工厂失败");
			e.printStackTrace();
		}
	}
	//获取SessionFactory对象
	public static SessionFactory getSessionFactory(){
		return sf;
	}
	//关闭session
	public static void closeSession(){
		Session session = threadLocal.get();
		threadLocal.set(null);
		if(session!=null){
			session.close();
		}
	}
}
