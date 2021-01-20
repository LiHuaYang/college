package com.yingteman.httpservice;

import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yingteman.database.RedisKeyHelper;
import com.yingteman.netty.message.Message;
import com.yingteman.netty.server.OnlineObdDevice;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;

public abstract class HttpService {
	/**
	 * Channel 和 ChannelId 之前的映射表
	 */
	private static final ConcurrentHashMap<String, Channel> onlineMap = OnlineObdDevice.getOnlineMap();
	private EventLoopGroup eventLoopGroup;
	private String xlh;  
	
	protected HttpService(EventLoopGroup eventLoopGroup, String xlh) {
		this.eventLoopGroup = eventLoopGroup;
		this.xlh = xlh;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HttpService.class);

	/**
	 * 获取指定盒子序列号所对应的ChannelId
	 * 
	 * @param xlh
	 * @return ChannelId
	 * @author ariclee
	 */
	protected String getChannelId(String xlh) {
		RedisKeyHelper redisWrapper = new RedisKeyHelper();
		String channelid = redisWrapper.getChanneid(xlh);  // 获取 Channelid
		
		logger.debug("根据盒子的序列号找到（Redis）对应的 ChannelId {}", channelid);
		return channelid;
	}
	
	/**
	 * 
	 * @param channelId
	 * @return
	 * @author ariclee
	 */
	protected Channel getChannel(String channelId) {
		return onlineMap.get(channelId);
	}
	
	protected abstract Message service();
	
	protected void doService() {
		final Channel channel = getChannel(getChannelId(xlh));
		final Message message = service();
		
		logger.debug("根据 HTTP 请求参数，生成的响应对象 --- {}", message.toString());
		
//		eventLoopGroup.next().execute(new Runnable() {
//			@Override
//			public void run() {
		channel.writeAndFlush(message); // 《Netty 权威指南》 P425
//			}
//		});
	}
}
