package com.yingteman.netty.server;

import java.util.concurrent.ConcurrentHashMap;
import io.netty.channel.Channel;


/**
 * 盒子序列号和
 * 
 * channelid 和 channel 之间的映射表
 * 
 * @author ariclee
 */
public class OnlineObdDevice {
	private static ConcurrentHashMap<String, Channel> sessionChannelMap = new ConcurrentHashMap<String, Channel>();
	
	public static ConcurrentHashMap getOnlineMap() {
		return sessionChannelMap;
	}
	
	private OnlineObdDevice(){}
	
}
