package com.yingteman.netty.codec.encoder;

import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.response.CfgXiaFaMessageContent;

import io.netty.buffer.ByteBuf;

public class CfgXiaFaMessageEncoder extends AbstractMessageContentEncoder {

	@Override
	public void encode(MessageContent msg, String aesPwd, ByteBuf out) {
		CfgXiaFaMessageContent message = (CfgXiaFaMessageContent) msg;
		out.writeShort(message.getYeWuId()); //  2
		out.writeByte(message.getXieYiHao()); // 1
		
		out.writeByte(message.getId()); // 1
		out.writeByte(message.getItem()); // 1
	}
}
