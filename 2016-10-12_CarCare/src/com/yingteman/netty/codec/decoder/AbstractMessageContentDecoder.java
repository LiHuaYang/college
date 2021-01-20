package com.yingteman.netty.codec.decoder;

import com.yingteman.netty.codec.emcryptionUtil.AESUtils;
import com.yingteman.netty.message.MessageContent;
import io.netty.buffer.ByteBuf;

public abstract class AbstractMessageContentDecoder {
	
	public abstract MessageContent decode(ByteBuf in, String channelid);
	
	/**
	 * AES解密
	 * 
	 * @author ariclee
	 */
	protected byte[] doAesDecrypt(byte[] content, byte[] pwd) {
		return AESUtils.decrypt(content, pwd);
	}
}
