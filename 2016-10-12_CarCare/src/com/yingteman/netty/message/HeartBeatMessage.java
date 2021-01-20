package com.yingteman.netty.message;


/************************

+-----------+-----------+
|	业务 Id	|	协议号	|	
|	2 字节	|	1 字节	|
+-----------+-----------+

*************************/
/**
 * 心跳消息。业务数据部分为空。
 * @author ariclee
 * 
 */
public class HeartBeatMessage extends MessageContent {
	
	
	/**
	 * 生成一个默认的心跳请求业务数据实体（测试）
	 * 
	 * @return
	 * @author ariclee
	 */
	public static HeartBeatMessage createDefaultReqMsg() {
		HeartBeatMessage request = new HeartBeatMessage();
		request.setYeWuId(MessageType.MESSAGE_HEART_REQ.value());
		request.setXieYiHao((byte) 1);
		return request;
	}
	/**
	 * 生成一个默认的心跳响应业务数据实体（测试）
	 * 
	 * @return
	 * @author ariclee
	 */
	public static HeartBeatMessage createDefaultRespMsg() {
		HeartBeatMessage request = new HeartBeatMessage();
		request.setYeWuId(MessageType.MESSAGE_HEART_RESP.value());
		request.setXieYiHao((byte) 1);
		return request;
	}
	
}
