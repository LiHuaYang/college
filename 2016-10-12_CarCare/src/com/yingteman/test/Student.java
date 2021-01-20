package com.yingteman.test;

class Array {
	public static Student[] stus = new Student[10];

	public void add(Student ss) {
		int length = ss.getName().length();

		for (int i = 0; i < stus.length; i++) {
			if (stus[i] == null) {
				stus[i] = ss;
				System.out.println("length--" + stus.length + " index--" + i);
				return;
			}
			if (stus[i].getName().length() == length) {
				return;
			}
		}
	}
}

public class Student {

	private String name;

	public Student() {}

	public Student(String _name) {
		this.name = _name;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {

		Array array = new Array();
		array.add(new Student("zhangsan"));
		array.add(new Student("lidi"));
		array.add(new Student("lisi"));
		array.add(new Student("wangwu"));
		array.add(new Student("zhaoliu"));
		array.add(new Student("xiaohsadaong"));
		array.add(new Student("xiaohasdassdong"));

		printAfterbubbleSortArray(array.stus);
	}

	public static void printAfterbubbleSortArray(Student[] stus) {
		Student temp = null;
		for (int i = 0; i < stus.length - 1; i++) {
			for (int j = 0; j < stus.length - 1 - i; j++) {
				if (stus[j] != null && stus[j + 1] != null) {
					if (stus[j].getName().length() > stus[j + 1].getName().length()) {
						temp = stus[j];
						stus[j] = stus[j + 1];
						stus[j + 1] = temp;
					}
				}
			}
		}
		for (int i = 0; i < stus.length; i++)
			if (stus[i] != null) {
				System.out.println(stus[i].getName());
			}
	}
}
