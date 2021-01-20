package com.yingteman.netty.codec.decoder;

import com.yingteman.netty.message.HeartBeatMessage;
import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.MessageType;

import io.netty.buffer.ByteBuf;

class HeartBeatMessageContentDecoder extends AbstractMessageContentDecoder {

	@Override
	public MessageContent decode(ByteBuf in, String channelid) {
		HeartBeatMessage msg = new HeartBeatMessage();
		msg.setYeWuId(MessageType.MESSAGE_HEART_REQ.value());
		return msg;
	}
}
