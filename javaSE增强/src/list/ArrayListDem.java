package list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDem {

	public static void main(String[] args) {
//		ArrayList a1 = new ArrayList();
//		a1.add("java01");
//		a1.add("java02");
//		a1.add("java03");
//		a1.add("java04");
//		a1.add("java05");
//		System.out.println("合并前--a1--" + a1.toString());
//		
//		ArrayList a2 = new ArrayList();
//		a2.add("java01");
//		a2.add("java02");
//		a2.add("java03");
//		a2.add("java04");
//		System.out.println("合并前--a2--" + a2.toString());
//		
//		ArrayList a3 = new ArrayList();
//		a3.add("java01");
//		a3.add("java02");
//		a3.add("java03");
//		System.out.println("合并前--a3--" + a3.toString());
//
//		ArrayList a4 = new ArrayList();
//		a4.add("java01");
//		a4.add("java02");
//		System.out.println("合并前--a4--" + a4.toString());
//		
//		a1.retainAll(a2);
//		a3.retainAll(a4);
//		
//		a1.retainAll(a3);
//		
//		System.out.println("res--" + a1.toString());
		
		
		ArrayList a1 = new ArrayList();
//		a1.add("java01");
//		a1.add("java02");
//		a1.add("java03");
//		a1.add("java04");
//		a1.add("java05");
		
		System.out.println(a1.size());
		
		a1.clear();
		
		System.out.println(a1.size());
		
		if (a1 == null) {
			System.out.println("a1为空！！");
		} else {
			System.out.println("a1不为空！！");
		}
		
	}
}
