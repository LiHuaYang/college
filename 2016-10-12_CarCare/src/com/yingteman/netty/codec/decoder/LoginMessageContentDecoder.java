package com.yingteman.netty.codec.decoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.request.LoginReqMessageContent;
import io.netty.buffer.ByteBuf;

/************************

# 结构

+-----------+---------------+---------------+---------------+---------------+-----------+---------------+---------------+
|	开发者 ak	|	设备序列号	|	设备密钥长度	|	设备密钥值	|	设备 IMEI 码	|	SIM 卡号	|	设备硬件版本号	|	设备软件版本号	|
|	32 字节	|	12 字节		|	2 字节		|	N 字节		|	15 字节		|	20 字节	|	N 字节		|	N 字节		|
------------+---------------+---------------+---------------+---------------+-----------+---------------+---------------+


# 实例

## 开发者 ak	
0000000000000000000000000000000000000000000000000000000000000000

## 设备序列号
393639343930303031333136

## 设备密钥长度
00a2

## 设备密钥值
30819f300d06092a864886f70d010101050003818d0030818902818100cd05ee3053c3018b2e256d90e2809e69d4b60fe4d96519f8a2066b59599b36e822975e246f7a0f43392a8b98290ffba2a1c465027c52aab490cedb7807621530c4ca23e548110bf1e5aa1bb45e16ce6c3112b925fe2029e6e116e379135ca7c4928353f39a74032c9397f589c00ceb83e88aa267b80e052203872b3dcef2cb910203010001

## 设备 IMEI码
303030303030303030303030303030

## SIM 卡号
3839383630313134373935343030383336353634

## 设备硬件版本号
07312e302e302e31

## 设备软件版本号
22342e33302d342e31342d382e31302d31362e30362d312e30312e3036302d312e3135

*************************/

/**
 * 登陆请求消息解码类
 * 
 * @time 2016年11月17日
 * @author ariclee
 */
class LoginMessageContentDecoder extends AbstractMessageContentDecoder {
	private static final Logger logger = LoggerFactory.getLogger(LoginMessageContentDecoder.class);
	
	@Override
	public MessageContent decode(ByteBuf in, String channelid) {
		LoginReqMessageContent lgm = new LoginReqMessageContent();
		lgm.setYeWuId(in.readShort());// 设置业务ID
		lgm.setXieYiHao(in.readByte());// 获取协议版本号
		
		lgm.setKfzak(in.readBytes(32).array()); 
		lgm.setSbxlh(in.readBytes(12).array()); // 设备序列号
		lgm.setSbmycd(in.readShort());
		lgm.setSbmyz(in.readBytes(lgm.getSbmycd()).array());
		lgm.setImei(in.readBytes(15).array());
		lgm.setSim(in.readBytes(20).array());
		
		// TODO：服务器登陆解码器中的设备硬件版本号和设备软件版本号，待解析
		return lgm;
	}
}
