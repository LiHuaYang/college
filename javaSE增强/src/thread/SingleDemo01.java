package thread;





/**
 * 
 * 
 *
 * ���ߣ�ariclee		ʱ�䣺2016��10��10������10:11:11
 */


// ����ʽ
//class Single {
//	private static final Single s = new Single();
//	private Single() {}
//	public static Single getInstance() {
//		return s;
//	}
//}

// ����ʽv1���̲߳���ȫ
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

//����ʽv2����Ч
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

//����ʽv3���Ż���ʹ��˫���жϣ����ٶ����ķ���
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
