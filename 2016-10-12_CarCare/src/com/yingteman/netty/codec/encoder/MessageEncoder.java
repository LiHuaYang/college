package com.yingteman.netty.codec.encoder;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yingteman.netty.message.Message;
import com.yingteman.netty.message.MessageHeader;
import com.yingteman.netty.message.MessageTail;
import com.yingteman.netty.server.OnlineObdDevice;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 消息编码类，提供从实体到 ByteBuf 转变的一系列的方法，包括：
 *
 * <li> 消息头部的编码
 * <li> 消息业务数据部分的编码
 * <li> 消息尾部的编码
 * 
 * @author ariclee
 */
public class MessageEncoder extends MessageToByteEncoder<Message> {

	private static final Logger logger = LoggerFactory.getLogger(MessageEncoder.class);
	private static final ConcurrentHashMap<String, Channel> onlineMap = OnlineObdDevice.getOnlineMap();

	/**
	 * 对消息编码
	 * @author ariclee
	 */
	@Override
	protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
		/* 对头部进行编码*/
		MessageHeader header = msg.getHeader();
		header2byte(header, out);
		
		/* 对业务数据进行编码 */
		MessageContentEncoderFactory
			.createEncoder(msg.getContent().getYeWuId()) // 
			.encode(msg.getContent(), "", out); // 
		
		/* 对尾部进行编码  */
		MessageTail tail = msg.getTail();
		tail2byte(tail, out);
		
//		ByteBufWrapper wrap = new ByteBufWrapper(out);
//		ByteBuf content = wrap.getByteMsgContent();
		
		/*
		 * TODO 如何替换掉帧校验码
		 * 1. 去除校验码，拿到需要 CRC-16 的部分
		 * 2. 
		 */
//		content.skipBytes(content.readableBytes() - 2);
	}
	
	/**
	 * 
	 * @param in
	 * @param out
	 * @author ariclee
	 */
	private void header2byte(MessageHeader in, ByteBuf out) {
		out.writeBytes(in.getZhenTou());
		/* 帧长  */
		out.writeShort(in.getZhenChang());
		out.writeByte(in.getShuJuBiaoShi());
		out.writeInt(in.getXiaoXiBiaoShi());
		out.writeInt(in.getKuoZhangZiDuan());
	}
	
	private void tail2byte(MessageTail in, ByteBuf out) {
		out.writeInt(in.getShiJianCuo());
		/* TODO CRC-16 的校验码是否应该在 Encoder 中生成 */
		out.writeShort(in.getJiaoJianMa());
		out.writeBytes(in.getZhenWei());
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.debug("BasicEncoder -- {}", cause.toString());
		/**
		 * 捕获异常时，删除在线列表的记录
		 */
		onlineMap.remove(ctx.channel().id().asLongText()); // 删除记录
	}
	
}
