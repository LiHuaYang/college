package cn.itcast.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Demo1 {

	/**class
	 * @param args
	 */
	public static void main(String[] args) {
		
		
	}
	
	
	//����Ӧ��1
	public static void test1() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		
		int i = list.get(0);
	}
	
	//����Ӧ��2 --����
	@Test
	public void test2() {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("aa", 1);
		map.put("bb", 2);
		
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		for(Map.Entry<String, Integer> me : set){
			System.out.println(me.getKey() + "=" + me.getValue());
		}
	}
	
	@Test
	public void test3() {
		//List<int> list = new ArrayList<int>();  //�������
	}
	
	//һ���õ��˷��Σ����ߵ����;�Ӧ��һ�£�������ֻ��һ�߾�û����
	@Test
	public void test4() {
		//ArrayList<Integer> list = new ArrayList<Object>();  //Integer pig dog
		//ArrayList<Object> list = new ArrayList<String>(); 

		ArrayList<String> list = new ArrayList ();

		List<Integer> l  = t1();
		List l11 = t2();
		
	}
	
	public List t1(){
		return new ArrayList();
	}
	
	public List<Integer> t2(){
		return new ArrayList<Integer>();
	}
	
	
	
	

}
