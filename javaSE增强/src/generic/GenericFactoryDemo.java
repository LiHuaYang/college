package generic;

public class GenericFactoryDemo {
	
	private static GenericFactoryDemo instance = new GenericFactoryDemo();
	private GenericFactoryDemo () {}

	public static GenericFactoryDemo getInstance() {
		return instance;
	}
	
	/**
	 * �������ƣ�get
	 * ����������
	 * ����˵����
	 * 		String className����������������������
	 * 		Class<T> classs����Ҫ�������ʵ���Ľӿ�����
	 * ����ֵ��T
	 * 		���ؽӿ�����
	 * ��ע��
	 * 	ʵ����
	 * 	DepartmentDao ddao = DaoFactory.getInstance().
	 *   get("cn.itcast.dao.impl.DepartmentDaoImpl",DepartmentDao.class);
	 * 
	 * ���ߣ�ariclee		ʱ�䣺2016��8��27������8:51:24
	 */
	public <T> T get(String className, Class<T> classs) {
		try {
			return (T)Class.forName(className).newInstance();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// �����޶�--���ص����ͱ�����Animal������
	public <T extends Animal> T get_qualifier(String className, Class<T> classs) {
		try {
			return (T)Class.forName(className).newInstance();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
