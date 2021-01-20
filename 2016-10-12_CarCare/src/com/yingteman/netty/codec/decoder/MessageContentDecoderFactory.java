package com.yingteman.netty.codec.decoder;

import java.util.HashMap;
import java.util.Map;

import com.yingteman.netty.message.MessageType;

public abstract class MessageContentDecoderFactory {
	// 解码器容器
	private static final Map<Short, AbstractMessageContentDecoder> decoder_pool = new HashMap<>();
	
	static {
		decoder_pool.put(MessageType.MESSAGE_HEART_REQ.value(), new HeartBeatMessageContentDecoder()); // 
		decoder_pool.put(MessageType.MESSAGE_LOGIN_REQ.value(), new LoginMessageContentDecoder());
		decoder_pool.put(MessageType.MESSAGE_TOUR_REPORt_REQ.value(), new TourReportMessageContentDecoder());
	}
	
	public static AbstractMessageContentDecoder createDecoder(Short type) {
		return decoder_pool.get(type);
	}
	
	private MessageContentDecoderFactory() {}
}
