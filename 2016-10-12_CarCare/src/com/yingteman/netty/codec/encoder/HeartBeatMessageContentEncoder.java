package com.yingteman.netty.codec.encoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yingteman.netty.message.HeartBeatMessage;
import com.yingteman.netty.message.MessageContent;
import io.netty.buffer.ByteBuf;


/************************

+-----------+-----------+
|	业务 Id	|	协议号	|	
|	2 字节	|	1 字节	|
+-----------+-----------+

心跳响应报文的业务数据部分字节总和为：3 字节

*************************/

/**
 * 心跳消息编码类，它包含将消息业务数据实体 HeartBeatMessage 写入 ByteBuf 的一系列方法，包括：
 * 
 * <li>编码
 * <li>加密
 * 
 * @see com.yingteman.netty.message.MessageContent HeartBeatMessage
 * @see io.netty.buffer.ByteBuf ByteBuf
 * 
 * @author ariclee
 */
class HeartBeatMessageContentEncoder extends AbstractMessageContentEncoder {

	private static final Logger logger = LoggerFactory.getLogger(HeartBeatMessageContentEncoder.class);

	/**
	 * 将消息写入目标 Bytebuf 心跳消息无须加密。设置业务 id 和 协议号即可
	 * 
	 * @param msg
	 *            待编码的消息实体
	 * @param aesPwd
	 *            算法密钥
	 * @param out
	 *            目标 ByteBuf
	 * 
	 * @author ariclee
	 */
	@Override
	public void encode(MessageContent msg, String aesPwd, ByteBuf out) {
		HeartBeatMessage request = (HeartBeatMessage) msg;
		out.writeShort(request.getYeWuId());
		out.writeByte(request.getXieYiHao());
	}
}
