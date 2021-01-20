package com.yingteman.netty.message;

/**
 * 消息附加信息。属性 channelId 用来标识每个客户端，在数据库中做与盒子序列号的映射
 * 
 * @author ariclee
 */
public class MessageAttach {
	private String channelId; // 

	public MessageAttach(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
}
