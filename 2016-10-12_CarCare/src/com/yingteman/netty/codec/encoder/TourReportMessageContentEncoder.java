package com.yingteman.netty.codec.encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.response.TourReportRespMessageContent;

import io.netty.buffer.ByteBuf;


class TourReportMessageContentEncoder extends AbstractMessageContentEncoder {

	private static final Logger logger = LoggerFactory.getLogger(TourReportMessageContentEncoder.class);
	
	@Override
	public void encode(MessageContent msg, String aesPwd, ByteBuf out) {
		TourReportRespMessageContent response = (TourReportRespMessageContent) msg;
		out.writeShort(response.getYeWuId()); //  2
		out.writeByte(response.getXieYiHao()); // 1
		
		out.writeByte(response.getXingChengBiaoZhi());
		out.writeInt(response.getXingChengXuHao());
		out.writeByte(response.getJieGuo());
	}
}
