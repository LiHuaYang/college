package test;

import java.util.List;

public class ListNull {

//	���÷�����ѯһ���б�Ȼ������б�����һ��Ԫ�ؾͰ���ȡ�����������½�һ��
	
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
