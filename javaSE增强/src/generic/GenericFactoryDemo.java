package generic;

public class GenericFactoryDemo {
	
	private static GenericFactoryDemo instance = new GenericFactoryDemo();
	private GenericFactoryDemo () {}

	public static GenericFactoryDemo getInstance() {
		return instance;
	}
	
	/**
	 * 函数名称：get
	 * 功能描述：
	 * 参数说明：
	 * 		String className：包括包名的完整类名称
	 * 		Class<T> classs：需要创建类的实例的接口类型
	 * 返回值：T
	 * 		返回接口类型
	 * 备注：
	 * 	实例：
	 * 	DepartmentDao ddao = DaoFactory.getInstance().
	 *   get("cn.itcast.dao.impl.DepartmentDaoImpl",DepartmentDao.class);
	 * 
	 * 作者：ariclee		时间：2016年8月27日下午8:51:24
	 */
	public <T> T get(String className, Class<T> classs) {
		try {
			return (T)Class.forName(className).newInstance();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// 泛型限定--返回的类型必须是Animal的子类
	public <T extends Animal> T get_qualifier(String className, Class<T> classs) {
		try {
			return (T)Class.forName(className).newInstance();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
