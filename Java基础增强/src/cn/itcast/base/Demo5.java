package cn.itcast.base;

import java.util.Arrays;
import java.util.List;

public class Demo5 {

	public static void main(String[] args) {
		sum(1,2,3,4,5);
		
		Integer arr[] = {1,2,3,4,5};
		sum(arr);  //如果一个方法接收可变参数，那向里面传数组也是可以的
		
		List list = Arrays.asList(1,2,3);
		System.out.println(list);
		
		Integer arr2[] = {1,2,3,4,5};
		list = Arrays.asList(arr2);  //5
		System.out.println(list);
		
		//注意的问题
		int a[] = {1,2,3};
		list = Arrays.asList(a);  //1
		System.out.println(list);
		
		sum2(1,2,3,4,5);
	}
	
	public static void sum(Integer ... args){
		//可变参数在编程时当成数组即可
		int sum = 0;
		for(int arg : args){
			sum += arg;
		}
		System.out.println(sum);
	}
	
	//注意
	public static void sum2(Integer num,Integer ... args){
		//可变参数在编程时当成数组即可
		int sum = 0;
		for(int arg : args){
			sum += arg;
		}
		System.out.println(sum);
	}
	
	
}
