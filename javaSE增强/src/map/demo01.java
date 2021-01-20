package map;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


/**
 * 
 * 
 * 
 * 
 *
 * 作者：ariclee		时间：2016年8月27日下午9:12:01
 */
public class demo01 {
	
	@Test
	public void demo01() {
//		Map map = new HashMap<String, String>();
//		System.out.println("h".hashCode()); // 104
//		System.out.println("h".hashCode()); // 104
//		map.put("h", "1");
//		map.put("h", "2");
//		System.out.println(map.get("h")); // 2
		
//		Map map = new HashMap<Object, String>();
//		key key1 = new key();
//		System.out.println(key1.hashCode()); // 1208673552
//		System.out.println(key1.hashCode()); // 1208673552
//		map.put(key1, "1");
//		map.put(key1, "2");
//		System.out.println(map.get(key1)); // 2

		key key1 = new key();
		System.out.println(key1.hashCode()); // 31
		System.out.println(key1.hashCode()); // 31
		
		Map map = new HashMap<Object, String>();
		map.put(key1, "1");
		map.put(key1, "2");
		System.out.println(map.get(key1)); // 2
	}
}


class key {
	String id;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		key other = (key) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}






