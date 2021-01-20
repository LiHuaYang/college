package test;

import java.util.List;

public class ListNull {

//	调用方法查询一个列表，然后如果列表中有一个元素就把它取出来，否则新建一个
	
	public static void main(String[] args) {
		List objectList = null;
		Object object = null;
		
		objectList = queryList();
		object = (objectList == null || objectList.isEmpty()) ? new Object() : objectList.get(0);
	}
	
	public static List queryList() {
		return null;
	}
}
