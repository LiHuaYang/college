package test;

import org.junit.Test;

public class Stringtest {

	@Test
	public void test1() {

		String str = "abc";
		String str1 = "abc";
		String str2 = new String("abc");

		System.out.println(str == str1); // true
		System.out.println(str1 == "abc"); // true
		System.out.println(str2 == "abc"); // false
		System.out.println(str1 == str2); // false
		System.out.println(str1.equals(str2)); // true
		System.out.println(str1 == str2.intern()); // true
		System.out.println(str2 == str2.intern()); // false
		System.out.println(str1.hashCode() == str2.hashCode()); // true
	}

	private static String str = "abc";

	@Test
	public void test2() {
		String str1 = "a";
		String str2 = "bc";

		String combo = str1 + str2;
		String combo1 = "a" + "bc";

		System.out.println(str == combo); // false
		System.out.println(str == combo.intern()); // true
		System.out.println(str == combo1); // true
		System.out.println(str == combo1.intern()); // true
	}

	@Test
	public void test3() {
		String ss1 = "a" + "bc";
		String ss2 = "abc";
		System.out.println(ss1 == ss2);// true

		String ss3 = ss1 + "def";
		String ss4 = "abc" + "def";
		System.out.println(ss3 == ss4);// false
	}

}
