package com.yingteman.netty.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yingteman.netty.message.HeartBeatMessage;
import com.yingteman.netty.message.Message;
import com.yingteman.netty.message.MessageContent;

/**
 * 心跳请求处理类
 * 
 * 由于心跳请求没有具体的业务数据部分，只需组装部分数据即可
 * 
 * @author ariclee
 */
class HeartBeatMessageContentHandler implements AbstractMessageContentHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(HeartBeatMessageContentHandler.class);
	
	@Override
	public MessageContent process(Message in) {
		MessageContent content = in.getContent();
		logger.debug("收到客户端的心跳请求！");
		return HeartBeatMessage.createDefaultRespMsg();
	}
}
