package proxy;

import java.lang.reflect.Proxy;
import org.junit.Test;

public class test {
	/**
	 * 业务场景：
	 * 		当调用Dao层的函数时候，需要在每个方法面前增加日志操作，
	 * 		若是Dao层函数的数量庞大的时候，如何解决？
	 * 
	 * --》动态代理
	 * 		当调用
	 */
	@Test // 模拟客户端
	public void testMyProxy () {
		// 1. 被代理的对象
		// 2. 
		StudentDao dao = new StudentDaoImpl();
		LoggingInterceptor loger = new LoggingInterceptor();
		loger.setObj(dao); // 将被增强对象注入拦截器
		// 强转成为接口
//		StudentDao proxy = (StudentDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[]{StudentDao.class}, loger);
//		StudentDao proxy = (StudentDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), StudentDao.class.getClasses(), loger);
		// 1. 被代理对象的classLoader	2. 被代理对象所实现的接口	3.	调用处理程序
		StudentDao proxy = (StudentDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), loger);
		proxy.save(new Student());
	}

}
