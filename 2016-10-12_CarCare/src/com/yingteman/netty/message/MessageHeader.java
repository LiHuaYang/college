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
 * 消息头
 * 
 * @author ariclee
 */
public class MessageHeader {
	private byte[] zhenTou = MessageConstant.zhen_tou;
	
	private short zhenChang; // short 2 字节
	private byte shuJuBiaoShi; // byte 1 字节
	private int xiaoXiBiaoShi; // int 4 字节
	private int kuoZhangZiDuan; // int 4 字节
	
	public short getZhenChang() {
		return zhenChang;
	}
	public void setZhenChang(short zhenChang) {
		this.zhenChang = zhenChang;
	}
	public byte getShuJuBiaoShi() {
		return shuJuBiaoShi;
	}
	public void setShuJuBiaoShi(byte shuJuBiaoShi) {
		this.shuJuBiaoShi = shuJuBiaoShi;
	}
	public int getXiaoXiBiaoShi() {
		return xiaoXiBiaoShi;
	}
	public void setXiaoXiBiaoShi(int xiaoXiBiaoShi) {
		this.xiaoXiBiaoShi = xiaoXiBiaoShi;
	}
	public int getKuoZhangZiDuan() {
		return kuoZhangZiDuan;
	}
	public void setKuoZhangZiDuan(int kuoZhangZiDuan) {
		this.kuoZhangZiDuan = kuoZhangZiDuan;
	}
	public byte[] getZhenTou() {
		return zhenTou;
	}
	@Override
	public String toString() {
		return "MessageHeader [zhenTou=" + Arrays.toString(zhenTou) + ", zhenChang=" + zhenChang + ", shuJuBiaoShi="
				+ shuJuBiaoShi + ", xiaoXiBiaoShi=" + xiaoXiBiaoShi + ", kuoZhangZiDuan=" + kuoZhangZiDuan + "]";
	}
	
}
