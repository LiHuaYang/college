package com.yingteman.netty.codec.encoder;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yingteman.netty.message.MessageType;

/**
 * 编码类工厂
 * 
 * @author ariclee
 */
public abstract class MessageContentEncoderFactory {
	private static final Map<Short, AbstractMessageContentEncoder> encoder_pool = new HashMap<>();
	
	private static final Logger logger = LoggerFactory.getLogger(MessageContentEncoderFactory.class);

	static {
		encoder_pool.put(MessageType.MESSAGE_HEART_RESP.value(), new HeartBeatMessageContentEncoder());
		encoder_pool.put(MessageType.MESSAGE_LOGIN_RESP.value(), new LoginMessageContentEncoder());
		encoder_pool.put(MessageType.MESSAGE_TOUR_REPORt_RESP.value(), new TourReportMessageContentEncoder());
		encoder_pool.put(MessageType.MESSAGE_XIAFA.value(), new CfgXiaFaMessageEncoder());
	}
	
	private MessageContentEncoderFactory() {}
	
	public static AbstractMessageContentEncoder createEncoder(short type) {
		if (encoder_pool.get((Short)type) == null) {
			logger.debug("在 encoder-pool 中，获取不到指定 type {} 的 encoder", type);
			return new LoginMessageContentEncoder();
		}
		return encoder_pool.get((Short)type);
	}
}
