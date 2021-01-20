package proxy;

import java.lang.reflect.Proxy;
import org.junit.Test;

public class test {
	/**
	 * ҵ�񳡾���
	 * 		������Dao��ĺ���ʱ����Ҫ��ÿ��������ǰ������־������
	 * 		����Dao�㺯���������Ӵ��ʱ����ν����
	 * 
	 * --����̬����
	 * 		������
	 */
	@Test // ģ��ͻ���
	public void testMyProxy () {
		// 1. ������Ķ���
		// 2. 
		StudentDao dao = new StudentDaoImpl();
		LoggingInterceptor loger = new LoggingInterceptor();
		loger.setObj(dao); // ������ǿ����ע��������
		// ǿת��Ϊ�ӿ�
//		StudentDao proxy = (StudentDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[]{StudentDao.class}, loger);
//		StudentDao proxy = (StudentDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), StudentDao.class.getClasses(), loger);
		// 1. ����������classLoader	2. �����������ʵ�ֵĽӿ�	3.	���ô������
		StudentDao proxy = (StudentDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), loger);
		proxy.save(new Student());
	}

}
