package com.nbut.entity;

/**
 * 权限枚举类
 *
 * 作者：ariclee		时间：2016年5月26日下午1:52:21
 */
public enum Privilege {
	contest_creator, 
	administrator, 
	problem_editor,
	source_browser,
	http_judge,
	password_setter;
	
	/**
	 * 函数名称：contain
	 * 功能描述：
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月26日下午2:58:02
	 */
	public static Privilege contain(String name) {
		Privilege pp = Privilege.valueOf(Privilege.class, name);
		return pp;
	}
}
/*
从String到enum
BookType type = (BookType)Enum.Parse(typeof(BookType),"Ticket");
从enum到String
方法一：ToString();
方法二：s = Enum.GetName(typeof(BookType), BookType.Ticket);

*/

/*
class MyPrivilege {
	
	private static MyPrivilege contest_creator = new MyPrivilege();
	private static MyPrivilege administrator = new MyPrivilege();
	private static MyPrivilege problem_editor = new MyPrivilege();
	private static MyPrivilege source_browser = new MyPrivilege();
	private static MyPrivilege http_judge = new MyPrivilege();
	private static MyPrivilege password_setter = new MyPrivilege();
	
	private MyPrivilege() {}
	
}
*/