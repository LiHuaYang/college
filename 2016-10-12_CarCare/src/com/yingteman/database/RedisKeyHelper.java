package com.yingteman.database;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;
import redis.clients.jedis.Jedis;

/**
 * 
 * 
 * @author ariclee
 */
public class RedisKeyHelper {

	private static final String sbxlhKey = "csidmap:?:sbxlh"; // attch.getChannelId()
	private static final String channelIdKey = "csidmap:?:channelid"; // sbxlh

	private String tempString;

	private static Properties keyMap;

	static {
		keyMap = new Properties();
		InputStream in = RedisKeyHelper.class.getClassLoader().getResourceAsStream("redis-key.properties");
		try {
			keyMap.load(in);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param strings
	 * @return
	 * @author ariclee
	 */
	public String formatWith(String... strings) {
		return MessageFormat.format(this.tempString, strings);
	}

	/**
	 * 获取指定字段在 redis 中存储的 key
	 * 
	 * @param key
	 * @return
	 * @author ariclee
	 */
	public RedisKeyHelper getKeyPattern(String key) {
		this.tempString = keyMap.getProperty(key);
		return this;
	}
	
	// 通过设备序列号获取 ChannelId TODO 没有使用 redisPool
	// 1. key：csidmap: 设备序列号 :channelid
	// 2. value：channelid
	public String getSbxlh(String channelid) {
		Jedis redis = new Jedis();
		String res = redis.get(sbxlhKey.replace("?", channelid));
		redis.close();
		return res;
	}

	// 通过 ChannelId 获取设备序列号  TODO 没有使用 redisPool
	// 1. key：csidmap: channelid: sbxlh
	// 2. value：设备序列号
	public String getChanneid(String sbxlh) {
		Jedis redis = new Jedis();
		String res = redis.get(channelIdKey.replace("?", sbxlh));
		redis.close();
		return res;
	}
	
	/**
	 * 获取 aes 算法密码	TODO 没有使用 redisPool
	 * @param channelid
	 * @return
	 * @author ariclee
	 */
	public byte[] getAesPwd(String channelid) {
		Jedis redis = new Jedis();
		byte[] res = redis.get(channelid.getBytes());
		redis.close();
		return res;
	}

	public String getTempString() {
		return tempString;
	}
	
	public void setTempString(String tempString) {
		this.tempString = tempString;
	}
}
