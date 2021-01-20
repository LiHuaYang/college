package com.yingteman.netty.message.request;


/************************

# 结构
+-----------+---------------+
|	消息 Id	|	消息数据内容	|
|	2 字节	|	n 字节		|
+-----------+---------------+

# 实例
0xEFF7	疲劳驾驶报警		连续驾驶时间(Uint32) 单位：分钟
0xEFFE	怠速报警			怠速时间(Uint32)单位：分钟
0x0517	急加速报警		空
0x0518	急减速报警		空
0x0520	接头失连确认报警	失连类型(Uint8) 0：网络异常  1：插拔接头 取值范围：0~127
0xEFF9	驻车震动报警		空
0xEFF8	低电压休眠报警		电压值(uint32) 单位：0.1V		


*************************/



/**
 * 报警信息业务数据实体
 * 
 * @author ariclee
 */
public class WarningReqMessageContent {
	private short id;
	
}
