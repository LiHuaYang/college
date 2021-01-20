package cn.itcast.base;

import java.util.Arrays;
import java.util.List;

public class Demo5 {

	public static void main(String[] args) {
		sum(1,2,3,4,5);
		
		Integer arr[] = {1,2,3,4,5};
		sum(arr);  //���һ���������տɱ�������������洫����Ҳ�ǿ��Ե�
		
		List list = Arrays.asList(1,2,3);
		System.out.println(list);
		
		Integer arr2[] = {1,2,3,4,5};
		list = Arrays.asList(arr2);  //5
		System.out.println(list);
		
		//ע�������
		int a[] = {1,2,3};
		list = Arrays.asList(a);  //1
		System.out.println(list);
		
		sum2(1,2,3,4,5);
	}
	
	public static void sum(Integer ... args){
		//�ɱ�����ڱ��ʱ�������鼴��
		int sum = 0;
		for(int arg : args){
			sum += arg;
		}
		System.out.println(sum);
	}
	
	//ע��
	public static void sum2(Integer num,Integer ... args){
		//�ɱ�����ڱ��ʱ�������鼴��
		int sum = 0;
		for(int arg : args){
			sum += arg;
		}
		System.out.println(sum);
	}
	
	
}
