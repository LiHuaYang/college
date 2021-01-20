package com.yingteman.netty.codec.decoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yingteman.database.RedisKeyHelper;
import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.request.TourReportReqMessageContent;
import io.netty.buffer.ByteBuf;

public class TourReportMessageContentDecoder extends AbstractMessageContentDecoder {

	private static final Logger logger = LoggerFactory.getLogger(TourReportMessageContentDecoder.class);
	private static final RedisKeyHelper helper = new RedisKeyHelper();
	
	/**
	 * 1. TODO 需要用 AES 密钥解密
	 * 
	 * 如何获取 AES 密钥，在 redis 中根据 ChannelId 获取
	 * ChannelId 保存在 MessageAttach 中
	 * 
	 */
	@Override
	public MessageContent decode(ByteBuf in, String channelid) {
		TourReportReqMessageContent msg = new TourReportReqMessageContent();
		msg.setYeWuId(in.readShort());
		msg.setXieYiHao(in.readByte());
		msg.setKaiShiBiaoJiWei(in.readByte());
		msg.setKaishiXinChengXuHao(in.readInt());
		msg.setKaiShiShiJian(in.readInt());
		msg.setJieShuBiaoJiWei(in.readByte());
		msg.setJieShuXingChengXuHao(in.readInt());
		msg.setJieShuShiJian(in.readInt());
		msg.setKaiShiJingDu(in.readInt());
		msg.setKaiShiWeiDu(in.readInt());
		msg.setJieShuJingDu(in.readInt());
		msg.setJieShuWeiDu(in.readInt());
		msg.setLiCheng(in.readInt());
		msg.setYouHao(in.readShort());
		return msg;
	}
}
