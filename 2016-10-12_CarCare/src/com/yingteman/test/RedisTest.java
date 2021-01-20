package com.yingteman.test;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import com.yingteman.database.RedisUtils;
import redis.clients.jedis.Jedis;

public class RedisTest {

	private static final Jedis redis = RedisUtils.getConnection();
	
	@Test
	public void test1() {
		System.out.println(redis.get("csidmap:0f5fc1be:sbxlh")); // 通过channelId获取盒子序列号
		redis.close();
	}
	
	@Test
	public void test2() {
		byte[] bytes = {12, 13, 14};
		
		redis.set("12121".getBytes(), bytes); // 键是字符串，值是 byte 数组
		byte[] bs = redis.get("12121".getBytes());
		for (byte b : bs) {
			System.out.println("当前字节为 -- " + b);
		}
		redis.close();
	}
	@Test
	public void test3() {
		Map<String, String> map = redis.hgetAll("xcmap:005056c000080000-08fc-00000001-07e993bf42f2ac01-0d30129b:20161220");	//return Map<String,String>
		for (Entry b : map.entrySet()) {
			System.out.println("key -- " + b.getKey());
			System.out.println("value ---- " + b.getValue());
		}
		
		redis.close();
	}
	
	public static void main(String[] args) {
	}
}
