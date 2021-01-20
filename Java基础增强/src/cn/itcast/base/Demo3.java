package cn.itcast.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

public class Demo3 {

	/**
	 * ��ǿforѭ��
	 */

	@Test
	public void testArray() {
		Integer arr[] = { 1, 2, 3, 4 };

		// ��ͳ����
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		// jdk5������
		for (int temp : arr) {
			System.out.println(temp);
		}
	}

	@Test
	public  void testList() {
		// ����-------Collection(list set) Map
		/***********************************************************************
		 * 
		 * Collection
		 * 		---set :���� ���������ظ�  HashSet LinkedHashSet
		 * 		---list������ �������ظ�  ArrayList LinkedList vector
		 * 
		 * Map 
		 * 		HashMap
		 * 		HashTable
		 * 
		 **********************************************************************/
		
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			int temp = (Integer)it.next();
			System.out.println(temp);
		}
		
		
		System.out.println("--------------------");
		
		for(Object temp : list){
			int num = (Integer)temp;
			System.out.println(num);
		}
	}
	
	@Test
	public void testMap(){
		Map map = new HashMap();
		map.put("a", "aaaa");
		map.put("b", "bbbb");
		map.put("c", "cccc");
		
		//��ͳ����1
		Set set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			String value = (String) map.get(key);
			System.out.println(key + "=" + value);
		}
		
		System.out.println("---------------------");
		
		//��ͳ����2
		Set set2 = map.entrySet();
		it = set2.iterator();
		while(it.hasNext()){
			Map.Entry me = (Map.Entry) it.next();
			String key = (String) me.getKey();
			String value = (String) me.getValue();
			System.out.println(key + "=" + value);
		}
		
		System.out.println("---------------------");
		
		//��ǿforȡmap����
		for(Object obj : map.entrySet()){
			Map.Entry me = (Map.Entry) obj;
			String key = (String) me.getKey();
			String value = (String) me.getValue();
			System.out.println(key + "=" + value);
		}
		
		
	}

}
