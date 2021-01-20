package com.yingteman.netty.codec.encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.response.LoginRespMessageContent;
import io.netty.buffer.ByteBuf;

/************************************

+-----------+-----------+-----------+-----------+---------------+-------------------+-----------------------+-----------------------+-------------------+---------------+---------------+-------+---------------+-------------------+-----------+-----------+
|	业务 Id	|	协议号	|	是否注册	|	心跳周期	|	是否已经激活	|	位置信息采集周期	|	OBD(总线)数据采集周期	|	OBD(总线)数据传输周期	|	打包数据传输周期	|	打包数据容量	|	打包数据是否需要应答	|	各模块开关	|	传感器唤醒阀值		|	令牌		|	车型ID	|	
|	2 字节	|	1 字节	|	1 字节	|	1 字节	|	1 字节		|	1 字节			|	1 字节				|	1 字节				|	1 字节			|	1 字节		|	1 字节				|	1 字节		|	1 字节			|	128 字节	|	4 字节	|
+-----------+-----------+-----------+-----------+---------------+-------------------+-----------------------+-----------------------+-------------------+---------------+---------------+-------+---------------+-------------------+-----------+-----------+

登陆响应报文的业务数据部分字节总和为：146 字节
************************************/

/**
 * 登陆消息编码类，它包含将消息业务数据实体 LoginRespMessage 写入 ByteBuf 的一系列方法，包括：
 * 
 * <li>编码
 * <li>加密
 * 
 * @see com.yingteman.netty.message.MessageContent MessageContent
 * @see io.netty.buffer.ByteBuf ByteBuf
 * 
 * @author ariclee
 */
class LoginMessageContentEncoder extends AbstractMessageContentEncoder {

	private static final Logger logger = LoggerFactory.getLogger(LoginMessageContentEncoder.class);
	
	/**
	 * 将消息实体写入目标 Bytebuf，登陆消息无须加密。
	 * 
	 * @param msg
	 *            待编码的消息实体
	 * @param aesPwd
	 *            算法密钥
	 * @param out
	 *            目标 ByteBuf
	 *
	 * @see com.yingteman.netty.message.response LoginRespMessageContent           
	 * 
	 * @author ariclee
	 */
	@Override
	public void encode(MessageContent msg, String aesPwd, ByteBuf out) {
		LoginRespMessageContent response = (LoginRespMessageContent) msg;
		out.writeShort(response.getYeWuId()); //  2
		out.writeByte(response.getXieYiHao()); // 1
		
		out.writeByte(response.getIsRegister()); // 1
		out.writeByte(response.getHeartCycle()); // 1
		out.writeByte(response.getIsActive()); // 1
		out.writeByte(response.getLocationSamplingCycle()); // 1
		out.writeByte(response.getObdSamplingCycle()); // 1
		out.writeByte(response.getObdTransferCycle()); // 1
		out.writeByte(response.getPackageTransferCycle()); // 1
		out.writeByte(response.getPackageSize()); // 1
		out.writeByte(response.getPackageResponseNeed()); // 1
		out.writeByte(response.getModuleSwitchs()); // 1
		out.writeByte(response.getHuanXingFaZhi()); // 1
		out.writeBytes(response.getToken()); // 128
		out.writeInt(response.getCarTypeId()); // 4
	}
}
