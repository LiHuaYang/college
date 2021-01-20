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
 * 消息业务数据。作为具体业务数据实体类的父类
 * 
 * 
 * @author ariclee
 */
public class MessageContent {
	/*业务ID*/
	private short yeWuId;
	/*协议号*/
	private byte xieYiHao;
	
	public Short getYeWuId() {
		return yeWuId;
	}
	public void setYeWuId(short yeWuId) {
		this.yeWuId = yeWuId;
	}
	public byte getXieYiHao() {
		return xieYiHao;
	}
	public void setXieYiHao(byte xieYiHao) {
		this.xieYiHao = xieYiHao;
	}
	
	@Override
	public String toString() {
		return "MessageContent [yeWuId=" + yeWuId + ", xieYiHao=" + xieYiHao + "]";
	}
}
