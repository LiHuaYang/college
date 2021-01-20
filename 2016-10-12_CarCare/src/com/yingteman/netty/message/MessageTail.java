package com.yingteman.netty.message;

import java.util.Arrays;

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
 * 消息尾
 * 
 * @author ariclee
 */
public class MessageTail {
	/*时间戳*/
	private int shiJianCuo;
	/*校检码*/
	private short jiaoJianMa;
	/*帧尾*/
	private byte[] zhenWei = MessageConstant.zhen_wei;
	
	public byte[] getZhenWei() {
		return zhenWei;
	}
	public int getShiJianCuo() {
		return shiJianCuo;
	}
	public void setShiJianCuo(int shiJianCuo) {
		this.shiJianCuo = shiJianCuo;
	}
	public short getJiaoJianMa() {
		return jiaoJianMa;
	}
	public void setJiaoJianMa(short jiaoJianMa) {
		this.jiaoJianMa = jiaoJianMa;
	}
	@Override
	public String toString() {
		return "MessageTail [shiJianCuo=" + shiJianCuo + ", jiaoJianMa=" + jiaoJianMa + ", zhenWei="
				+ Arrays.toString(zhenWei) + "]";
	}
}
