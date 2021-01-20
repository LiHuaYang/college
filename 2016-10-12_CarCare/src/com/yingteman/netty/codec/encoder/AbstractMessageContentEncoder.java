package com.yingteman.netty.codec.encoder;

import com.yingteman.netty.message.MessageContent;

import io.netty.buffer.ByteBuf;
/**
 * 消息编码抽象实体类
 * 
 * 
 * @author ariclee
 */
public abstract class AbstractMessageContentEncoder {

	/**
	 * 将具体的相应内容写入 ByteBuf 中
	 * 
	 * @param msg 消息实体
	 * @param aesPwd AES算法加密密钥
	 * @param out 目标 ByteBuf
	 * 
	 * @author ariclee
	 */
	public abstract void encode(MessageContent msg, String aesPwd, ByteBuf out);
	
	/**
	 * 默认提供AES加密
	 * 
	 * @author ariclee
	 */
	public byte[] doAesEncrypt(String content, String pwd) {
		
		return null;
	}
}
