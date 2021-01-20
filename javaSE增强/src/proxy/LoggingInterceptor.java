package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 *	�Զ�����������ʵ��InvocationHandle�ӿ�
 *
 */
public class LoggingInterceptor implements InvocationHandler{
	
	private Object target; // Ŀ����󣨱��������
	
	public void logging() {
		System.out.println("Logging Start!!!");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		logging();
		
		System.out.println(proxy.getClass().getName());// com.sun.proxy.$Proxy4
		
		System.out.println(method.getName()); // save 
		
		method.invoke(target, args); // 
		return null;
	}

	public Object getObj() {
		return target;
	}

	public void setObj(Object obj) {
		this.target = obj;
	}
}
