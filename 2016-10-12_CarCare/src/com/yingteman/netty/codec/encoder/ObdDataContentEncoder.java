package com.yingteman.netty.codec.encoder;

import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.response.ObdDataRespMessageContent;

import io.netty.buffer.ByteBuf;

public class ObdDataContentEncoder extends AbstractMessageContentEncoder {

	@Override
	public void encode(MessageContent msg, String aesPwd, ByteBuf out) {
		ObdDataRespMessageContent message = (ObdDataRespMessageContent) msg;
		out.writeShort(message.getYeWuId()); //  2
		out.writeByte(message.getXieYiHao()); // 1
	}
}
