package com.yingteman.netty.handler;

import com.yingteman.netty.message.Message;
import com.yingteman.netty.message.MessageContent;

public interface AbstractMessageContentHandler {
	
	public MessageContent process(Message in);
	
}
