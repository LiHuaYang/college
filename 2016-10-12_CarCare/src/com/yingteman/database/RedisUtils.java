package com.yingteman.database;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
//	private static JedisPool pool = new JedisPool("10.26.230.144", 6379);
	private static JedisPoolConfig poolConfig = new JedisPoolConfig();
	private static JedisPool pool = new JedisPool(poolConfig, "10.26.230.144");
	
	public static JedisPool getPoolInstance() {
		return pool;
	}
	
	public static Jedis getConnection() {
		return pool.getResource();
	}
	
	public static void returnConnection(Jedis connection) {
		pool.returnResource(connection);
	}
	
	static {
		poolConfig.setMaxIdle(100);//最大空闲连接数, 默认8个
		poolConfig.setMaxTotal(100); //最大连接数, 默认8个
		poolConfig.setMaxWaitMillis(15000);
		poolConfig.setMinEvictableIdleTimeMillis(300000);
		poolConfig.setSoftMinEvictableIdleTimeMillis(1800000);//对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数 时直接逐出,不再根据MinEvictableIdleTimeMillis判断  (默认逐出策略)   
		poolConfig.setNumTestsPerEvictionRun(3);
		poolConfig.setTestOnBorrow(false);
		poolConfig.setTestOnReturn(true);
		poolConfig.setTestWhileIdle(false);
		poolConfig.setBlockWhenExhausted(true);//连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
		poolConfig.setTimeBetweenEvictionRunsMillis(-1);//逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
	}
	
	private RedisUtils() {}
}
