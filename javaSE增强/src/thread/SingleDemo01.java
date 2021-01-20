package thread;





/**
 * 
 * 
 *
 * 作者：ariclee		时间：2016年10月10日上午10:11:11
 */


// 饿汉式
//class Single {
//	private static final Single s = new Single();
//	private Single() {}
//	public static Single getInstance() {
//		return s;
//	}
//}

// 懒汉式v1：线程不安全
//class Single {
//	private static Single s ;
//	private Single() {}
//	
//	public static Single getInstance() {
//		if (s == null) {
//			s = new Single();
//		}
//		return s;
//	}
//}

//懒汉式v2：低效
//class Single {
//	private static Single s ;
//	private Single() {}
//	
//	public static synchronized Single getInstance() {
//		if (s == null) {
//			s = new Single();
//		}
//		return s;
//	}
//}

//懒汉式v3：优化，使用双重判断，减少对锁的访问
class Single {
	private static Single s ;
	private Single() {}
	
	public static Single getInstance() {
		if (s == null) {
			synchronized (Single.class) {
				if (s == null) {
					s = new Single();
				}
			}
		}
		return s;
	}
}
public class SingleDemo01 {

}
