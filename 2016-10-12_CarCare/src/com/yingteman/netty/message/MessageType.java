package com.yingteman.netty.message;

/*
	0x0001	心跳请求	客户端	传输心跳帧，定时发送
	0x0002	登录请求	客户端	用于与服务器连接
	0x0003	位置信息数据传输	客户端	传输位置信息数据，包括GPS、WIFI、基站、蓝牙数据
	0x0004	OBD（总线）数据传输	客户端	传输OBD（总线）数据
	0x0005	故障码数据传输	客户端	传输故障码
	0x0006	配置信息数据接收响应	客户端	响应服务端下发的配置信息数据
	0x0007	报警信息数据传输	客户端	传输报警信息数据
	0x0008	行程统计信息数据传输	客户端	传输行程统计信息数据
	0x0009	打包数据传输	客户端	将位置信息数据和OBD数据打包传输
	
	0x1001	心跳响应	服务端	心跳帧响应
	0x1002	登录响应	服务端	响应终端的登录请求
	0x1005	故障码数据接收响应	服务端	响应故障码数据接收，0成功，1~255错误，错误码长1Byte，无符号整型
	0x1006	配置信息数据传输	服务端	服务器下发配置信息数据
	0x1007	报警信息数据接收响应	服务端	响应报警信息数据接收
	0x1008	行程统计信息数据接收响应	服务端	响应行程统计信息数据接收
	0x1009	打包数据接收响应	服务端	响应打包数据接收
 */



/**
 * 消息业务类型
 * 
 * @author ariclee
 */
public enum MessageType {
	
	MESSAGE_HEART_REQ((short) 1), // 心跳请求
	MESSAGE_LOGIN_REQ((short) 2), // 登录请求
	MESSAGE_TOUR_REPORt_REQ((short) 8), // 行程数据传输请求
	MESSAGE_HEART_RESP((short) 1001), // 心跳请求
	MESSAGE_LOGIN_RESP((short) 1002), // 登陆响应
	MESSAGE_TOUR_REPORt_RESP((short) 1008), // 行程数据传输响应
	MESSAGE_OBD_REPORt_RESP((short) 1009),
	
	MESSAGE_XIAFA_RESP((short) 6), // 配置信息下发响应（客户端发出，服务器接收）
	MESSAGE_XIAFA((short) 1006);// 配置信息下发（服务器发出，客户端接收）
	
	private short value;
	
	private MessageType(short _value) {
		this.value = _value;
	}
	
	public Short value() {
		return this.value;
	}
}
