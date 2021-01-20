package com.yingteman.netty.handler;

import com.yingteman.database.RedisKeyHelper;
import com.yingteman.netty.message.Message;
import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.MessageType;
import com.yingteman.netty.message.request.ObdDataReqMessageContent;
import com.yingteman.netty.message.response.ObdDataRespMessageContent;

import redis.clients.jedis.Jedis;

public class ObdDataContentHandler implements AbstractMessageContentHandler {
	@Override
	public MessageContent process(Message in) {
		ObdDataReqMessageContent request = (ObdDataReqMessageContent) in.getContent();
		RedisKeyHelper helper = new RedisKeyHelper();
		String channelId = in.getAttch().getChannelId();
		Jedis jedis = new Jedis();
		String sbxlhKey = helper.getKeyPattern("sbxlhKey").formatWith(channelId);
		helper.getKeyPattern("TaiYaKey").formatWith(sbxlhKey);
		
		/* 存储 ChannelId */
		jedis.set(helper.getKeyPattern("TaiYaKey").formatWith(sbxlhKey).getBytes(), request.getTaiYa());
		jedis.set(helper.getKeyPattern("YouLiangKey").formatWith(sbxlhKey).getBytes(), request.getYouLiang());
		// 
		ObdDataRespMessageContent response = new ObdDataRespMessageContent();
		response.setYeWuId(MessageType.MESSAGE_OBD_REPORt_RESP.value());
		
		return response;
	}
}
