package com.yingteman.netty.codec.decoder;

import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.request.ObdDataReqMessageContent;

import io.netty.buffer.ByteBuf;

public class ObdDataContentDecoder extends AbstractMessageContentDecoder {

	@Override
	public MessageContent decode(ByteBuf in, String channelid) {
		ObdDataReqMessageContent msg = new ObdDataReqMessageContent();
		msg.setTaiYa(in.readBytes(10).array());
		msg.setYouLiang(in.readBytes(10).array());
		return msg;
	}
}
