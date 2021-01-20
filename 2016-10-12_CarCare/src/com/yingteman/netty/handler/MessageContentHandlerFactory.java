package com.yingteman.netty.handler;

import java.util.HashMap;
import java.util.Map;
import com.yingteman.netty.message.MessageType;

public class MessageContentHandlerFactory {

	private static final Map<Short, AbstractMessageContentHandler> handler_pool = new HashMap<Short, AbstractMessageContentHandler>();
	
	static {
		handler_pool.put(MessageType.MESSAGE_HEART_REQ.value(), new HeartBeatMessageContentHandler()); // 心跳请求
		handler_pool.put(MessageType.MESSAGE_LOGIN_REQ.value(), new LoginMessageContentHandler()); // 登陆请求
		handler_pool.put(MessageType.MESSAGE_TOUR_REPORt_REQ.value(), new TourReportMessageContentHandler()); // 行程数据传输
	}
	
	private MessageContentHandlerFactory(){}
	
	public static AbstractMessageContentHandler createHandler(Short yewuid) {
		return handler_pool.get(yewuid);
	}
}