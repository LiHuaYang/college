package com.yingteman.netty.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yingteman.netty.message.Message;
import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.MessageHeader;
import com.yingteman.netty.message.MessageTail;
import com.yingteman.netty.message.request.LoginReqMessageContent;
import com.yingteman.netty.message.request.TourReportReqMessageContent;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class ClientBasicEncoder extends MessageToByteEncoder<Message> {

	private static final Logger logger = LoggerFactory.getLogger(ClientBasicEncoder.class);
	
	@Override
	protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
		
		/* 组装头部 */
		MessageHeader header = msg.getHeader();
		header2byte(header, out);
		
		/* 组装业务数据 */
		content2byte(msg.getContent(), out);
		
		/* 组装尾部 */
		MessageTail tail = msg.getTail();
		tail2byte(tail, out);
	}
	
	private void header2byte(MessageHeader in, ByteBuf out) {
		out.writeBytes(in.getZhenTou());
		out.writeShort(in.getZhenChang());
		out.writeByte(in.getShuJuBiaoShi());
		out.writeInt(in.getXiaoXiBiaoShi());
		out.writeInt(in.getKuoZhangZiDuan());
	}
	
	private void tail2byte(MessageTail in, ByteBuf out) {
		out.writeInt(in.getShiJianCuo());
		out.writeShort(in.getJiaoJianMa());
		out.writeBytes(in.getZhenWei());
	}
	
	private void content2byte(MessageContent in, ByteBuf out) {
		/**
		 * 出去的消息，业务 id 为 000* 格式
		 */
		if (in.getYeWuId() == (short) 1) { // 心跳请求
			out.writeShort(in.getYeWuId());
			out.writeByte(in.getXieYiHao());
		} if (in.getYeWuId() == (short) 2) { // 登陆请求
			LoginReqMessageContent msg = (LoginReqMessageContent)in;

			out.writeShort(msg.getYeWuId());
			out.writeByte(msg.getXieYiHao());
			
			out.writeBytes(msg.getKfzak());
			out.writeBytes(msg.getSbxlh());
			out.writeShort(msg.getSbmycd());
			out.writeBytes(msg.getSbmyz());
			out.writeBytes(msg.getImei());
			out.writeBytes(msg.getSim());
			out.writeBytes(msg.getSbyjbbh());
			out.writeBytes(msg.getSbrjbbh());
		} if(in.getYeWuId() == (short) 8) { // 行程数据传输
			TourReportReqMessageContent msg = (TourReportReqMessageContent)in;
			
			out.writeShort(msg.getYeWuId());
			out.writeByte(msg.getXieYiHao());

			out.writeByte(msg.getKaiShiBiaoJiWei());
			out.writeInt(msg.getKaishiXinChengXuHao());
			out.writeInt(msg.getKaiShiShiJian());
			out.writeByte(msg.getJieShuBiaoJiWei());
			out.writeInt(msg.getJieShuXingChengXuHao());
			out.writeInt(msg.getJieShuShiJian());
			out.writeInt(msg.getKaiShiJingDu());
			out.writeInt(msg.getKaiShiWeiDu());
			out.writeInt(msg.getJieShuJingDu());
			out.writeInt(msg.getJieShuWeiDu());
			out.writeInt(msg.getLiCheng());
			out.writeShort(msg.getYouHao());
		}
	}
}
