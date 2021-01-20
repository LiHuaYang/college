package com.Tool;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HIbernateSessionFactory {
	private volatile static SessionFactory sf= null;

	public static SessionFactory beforeClass() {
		if (sf==null) {
			synchronized (SessionFactory.class) {
				if (sf==null) {
					sf=new AnnotationConfiguration().configure().buildSessionFactory();
				}
			}
		}
		
		return sf;
	}
	
	

}
