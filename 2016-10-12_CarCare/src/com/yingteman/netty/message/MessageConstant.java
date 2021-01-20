package com.yingteman.netty.message;

/************************

+--------+----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+
|  帧标识  |  帧长		|  数据标识	|  消息标识	|  扩展字段	|  业务ID	|  协议号	|  业务数据	|  时间戳	|  校检码	|  帧尾		|
|  5 字节	 |  2 字节  	|  1 字节		|  4 字节		|  4 字节		|  2 字节  	|  1 字节  	|  n 字节	|  4 字节		|  2 字节  	|  4 字节  	|
+--------+----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+
														|--------------业务数据------	--------|
														|------------MessageContent---------|
|--------------------- 帧头 -----------------------------|			            			|---------------- 帧尾 --------------|
|------------------ MessageHeader ----------------------|									|---------- MessageTail ------------|


|---------------------------------------------------------- Message ------------------------------------------------------------|

*************************/

/**
 * 消息常量类，存放报文中个字段的长度（占几位）
 * 
 * 
 * @author ariclee
 */
	/* 帧头长度：5 字节*/
public class MessageConstant {
	public static final byte[] zhen_tou = { (byte) 0xff, 0x49, 0x43, 0x41, 0x52 };
	/* 帧尾长度：4 字节*/
	public static final byte[] zhen_wei = { (byte) 0xAA, (byte) 0xBB, 0x5c, 0x6e };
	
	/* 帧长长度 */
	public static final short  ZHEN_CHANG = 2;
	/* 数据标识长度 */
	public static final short  SHU_JU_BIAO_SHI  = 1;
	/* 消息标识长度 */
	public static final short  XIAO_XI_BIAO_SHI = 4;
	/* 扩展字段长度 */
	public static final short  KUO_ZHAN_ZI_DUAN = 4;
	/* 时间戳长度 */
	public static final short  SHI_JIAN_CUO = 4;
	/* 校检码长度 */
	public static final short  JIAO_JIAN_MA = 2;
	/* 帧头长度 */
	public static final short  ZHEN_TOU = 5;
	/* 帧尾长度 */
	public static final short  ZHEN_WEI = 4;
	/* 业务ID长度 */
	public static final short  YE_WU_ID = 2;
	
	public static final short lengthFieldOffset = 5; // 帧中长度字段（帧长）偏移量
	public static final short lengthFieldLength = 2; // 帧中长度字段（帧长）长度
	public static final short msgContentOffset = 16; // 帧中业务数据读取字段偏移量
	
	
	private MessageConstant(){}
}
