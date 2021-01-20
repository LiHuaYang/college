package com.yingteman.netty.message.request;

import com.yingteman.netty.bytebuf.ByteBufTools;
import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.MessageType;

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
 * 登陆请求消息实体
 * 
 * 
 * @author ariclee
 */
public class LoginReqMessageContent extends MessageContent {
	/*开发者 ak*/
	private byte[] kfzak;

	/*设备序列号*/
	private byte[] sbxlh;

	/*设备密钥长度*/
	private short sbmycd;
	
	/*设备密钥值*/
	private byte[] sbmyz; 
	
	/*设备 IMEI码*/
	private byte[] imei; 
	
	/*SIM 卡号*/
	private byte[] sim; 
	
	/*设备硬件版本号*/
	private byte[] sbyjbbh; 
	
	/*设备软件版本号*/
	private byte[] sbrjbbh; 
	
	/**
	 * 生成一个默认的登陆请求业务数据实体（测试），业务 id 为 2
	 * 
	 * @return
	 * @author ariclee
	 */
	public static LoginReqMessageContent createDefaultMsg() {
		LoginReqMessageContent msg = new LoginReqMessageContent();

		msg.setYeWuId((short) MessageType.MESSAGE_LOGIN_REQ.value()); // 
		msg.setXieYiHao((byte) 1); // 
		
		msg.setKfzak(ByteBufTools.hexString2Bytes("0000000000000000000000000000000000000000000000000000000000000000"));
		msg.setSbxlh(ByteBufTools.hexString2Bytes("393639343930303031333136"));
		msg.setSbmycd((short) 2);
		msg.setSbmyz(ByteBufTools.hexString2Bytes("30819f300d06092a864886f70d010101050003818d0030818902818100cd05ee3053c3018b2e256d90e2809e69d4b60fe4d96519f8a2066b59599b36e822975e246f7a0f43392a8b98290ffba2a1c465027c52aab490cedb7807621530c4ca23e548110bf1e5aa1bb45e16ce6c3112b925fe2029e6e116e379135ca7c4928353f39a74032c9397f589c00ceb83e88aa267b80e052203872b3dcef2cb910203010001"));
		msg.setImei(ByteBufTools.hexString2Bytes("303030303030303030303030303030"));
		msg.setSim(ByteBufTools.hexString2Bytes("3839383630313134373935343030383336353634"));
		msg.setSbyjbbh(ByteBufTools.hexString2Bytes("07312e302e302e31"));
		msg.setSbrjbbh(ByteBufTools.hexString2Bytes("22342e33302d342e31342d382e31302d31362e30362d312e30312e3036302d312e3135"));
		
		return msg;
	}
	
	
	public byte[] getKfzak() {
		return kfzak;
	}
	public void setKfzak(byte[] fkzak) {
		this.kfzak = fkzak;
	}
	public byte[] getSbxlh() {
		return sbxlh;
	}
	public void setSbxlh(byte[] sbxlh) {
		this.sbxlh = sbxlh;
	}
	public short getSbmycd() {
		return sbmycd;
	}
	public void setSbmycd(short sbmycd) {
		this.sbmycd = sbmycd;
	}
	public byte[] getSbmyz() {
		return sbmyz;
	}
	public void setSbmyz(byte[] sbmyz) {
		this.sbmyz = sbmyz;
	}
	public byte[] getImei() {
		return imei;
	}
	public void setImei(byte[] imei) {
		this.imei = imei;
	}
	public byte[] getSim() {
		return sim;
	}
	public void setSim(byte[] sim) {
		this.sim = sim;
	}
	public byte[] getSbyjbbh() {
		return sbyjbbh;
	}
	public void setSbyjbbh(byte[] sbyjbbh) {
		this.sbyjbbh = sbyjbbh;
	}
	public byte[] getSbrjbbh() {
		return sbrjbbh;
	}
	public void setSbrjbbh(byte[] sbrjbbh) {
		this.sbrjbbh = sbrjbbh;
	}
	
	@Override
	public String toString() {
		return "LoginReqMessage [kfzak=" + kfzak + ", sbxlh=" + sbxlh + ", sbmycd=" + sbmycd + ", sbmyz=" + sbmyz
				+ ", imei=" + imei + ", sim=" + sim + ", sbyjbbh=" + sbyjbbh + ", sbrjbbh=" + sbrjbbh + "]";
	}
	
}
