package cn.itcast.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

public class Demo4 {

	// 增强for的注意事项
	/*
	 * 增强for只适合取数据，不能操作数组或集合
	 * 
	 */

	@Test
	public void test1() {

		Integer arr[] = { 1, 2, 3 };

		for (int i : arr) {
			i = 10;
		}

		System.out.println(arr[0]);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = 10;
		}
	}

	public void test2() {
		List list = new ArrayList();
		list.add(1);

		for (Object obj : list) {
			obj = 3;
		}
	}

	@Test
	public void test3() {

		/***********************************************************************
		 *以下代码会抛：
		 *java.util.ConcurrentModificationException
		 * 
		 **********************************************************************/
		List list = new ArrayList();
		list.add(1);
		list.add(2);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			int temp = (Integer) it.next();
			System.out.println(temp);
			list.add(3);

		}
	}
	
	
	//在对集合进行迭代的过程中，默认情况下是不能对集合进行增删改操作的，如果想执行此类操作，请调用迭代器的方法
	@Test
	public void test4(){
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		
		ListIterator it = list.listIterator();
		while(it.hasNext()){
			int temp = (Integer) it.next();
			System.out.println(temp);
			it.add(3);
		}
		
		System.out.println(list.size());
	}
	
}
