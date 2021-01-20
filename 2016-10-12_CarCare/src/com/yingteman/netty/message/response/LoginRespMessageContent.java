package com.yingteman.netty.message.response;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yingteman.netty.bytebuf.ByteBufTools;
import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.MessageType;

/************************************

+-----------+-----------+-----------+-----------+---------------+-------------------+-----------------------+-----------------------+-------------------+---------------+---------------+-------+---------------+-------------------+-----------+-----------+
|	业务 Id	|	协议号	|	是否注册	|	心跳周期	|	是否已经激活	|	位置信息采集周期	|	OBD(总线)数据采集周期	|	OBD(总线)数据传输周期	|	打包数据传输周期	|	打包数据容量	|	打包数据是否需要应答	|	各模块开关	|	传感器唤醒阀值		|	令牌		|	车型ID	|	
|	2 字节	|	1 字节	|	1 字节	|	1 字节	|	1 字节		|	1 字节			|	1 字节				|	1 字节				|	1 字节			|	1 字节		|	1 字节				|	1 字节		|	1 字节			|	128 字节	|	4 字节	|
+-----------+-----------+-----------+-----------+---------------+-------------------+-----------------------+-----------------------+-------------------+---------------+---------------+-------+---------------+-------------------+-----------+-----------+



是否注册				1Byte  		01			是
心跳周期				1Byte		0f			15 秒
是否已经激活			1Byte		01			是
位置信息采样周期		1Byte		01			1   秒
OBD(总线)数据采集周期	1Byte		0f			15 秒
OBD(总线)数据传输周期	1Byte		0f			15 秒
打包数据传输周期		1Byte		05			5   秒
打包数据容量			1Byte		1e			30 * 32 = 960字节（打包数据的最大字节数 = 打包数据*32）
打包数据是否需要应答	1Byte		01			是
各模块开关			1Byte		3e		‭	001（GPS）1（WIFI）1（蓝牙）1（OBD）1（传感器）0（预留）‬
传感器唤醒阀值			1Byte		05			5 传感器的唤醒级别，类型为Uint8，值为1~10；（用户自己设置风险较高，关闭指令需慎用。）
令牌					128Bytes	84616400124df07b8535df8120ecfeb1b4ec90f95da63a21de1b6c4703c71079d8254cb617b8f04d8e1a160c57e14b8c9b88e655ddab1a9916a535e37e811471104ffa6b82c8b56a918a5f122e65e711b721d783211b3abfe62dd3e3a0e5e8b15e0c48b460fd10751a82cf21febdc0200923ff83c77498cd49507d665e6fc2ea
车型ID				4Bytes		00000001


登陆响应报文业务数据部分字节长度：
12 + 2 + 4 + 128 = 146
************************************/

/**
 * 登陆消息响应实体<p>
 * 
 * 登陆响应报文业务数据部分字节长度：
 * 12 + 2 + 4 + 128 = 146
 * 
 * @author ariclee
 */
public class LoginRespMessageContent extends MessageContent {

	/*是否注册*/
	private byte isRegister;  
	
	/*心跳周期*/
	private byte HeartCycle;  
	
	/*是否已经激活*/
	private byte isActive;  

	/*位置信息采样周期*/
	private byte locationSamplingCycle;  
	
	/*OBD(总线)数据采集周期*/
	private byte obdSamplingCycle;  
	
	/*OBD(总线)数据传输周期*/
	private byte obdTransferCycle;  
	
	/*打包数据传输周期*/
	private byte packageTransferCycle;  
	
	/*打包数据容量*/
	private byte packageSize;  
	
	/*打包数据是否需要应答*/
	private byte packageResponseNeed;  
	
	/*各模块开关*/
	private byte moduleSwitchs;  
	
	/*传感器唤醒阀值*/
	private byte huanXingFaZhi;  
	
	/*令牌*/
	private byte[] token;  
	
	/*车型ID*/
	private int carTypeId;  
	
	/**
	 * 生成一个默认的登陆响应业务数据实体（测试），业务 id 为 1002
	 * 
	 * @return
	 * @author ariclee
	 */
	public static LoginRespMessageContent createDefaultMsg() {
		LoginRespMessageContent msg = new LoginRespMessageContent();
		
		msg.setYeWuId(MessageType.MESSAGE_LOGIN_RESP.value()); // 业务ID
		msg.setXieYiHao((byte) 1); // 协议号
		
		msg.setIsRegister((byte) 1);
		msg.setHeartCycle((byte) 5); // 15 秒 --> 2 秒
		msg.setIsActive((byte) 1);
		msg.setLocationSamplingCycle((byte) 1);
		msg.setObdSamplingCycle((byte) 1);
		msg.setObdTransferCycle((byte) 15);
		msg.setPackageTransferCycle((byte) 5);
		msg.setPackageSize((byte) 30);
		msg.setPackageResponseNeed((byte) 1);
		msg.setModuleSwitchs((byte) 62);
		msg.setHuanXingFaZhi((byte) 5);
		msg.setToken(ByteBufTools.hexString2Bytes("84616400124df07b8535df8120ecfeb1b4ec90f95da63a21de1b6c4703c71079d8254cb617b8f04d8e1a160c57e14b8c9b88e655ddab1a9916a535e37e811471104ffa6b82c8b56a918a5f122e65e711b721d783211b3abfe62dd3e3a0e5e8b15e0c48b460fd10751a82cf21febdc0200923ff83c77498cd49507d665e6fc2ea"));
		msg.setCarTypeId(1);
		return msg;
	}
	
	public byte getIsRegister() {
		return isRegister;
	}


	public void setIsRegister(Byte isRegister) {
		this.isRegister = isRegister;
	}


	public Byte getHeartCycle() {
		return HeartCycle;
	}


	public void setHeartCycle(Byte heartCycle) {
		HeartCycle = heartCycle;
	}


	public Byte getIsActive() {
		return isActive;
	}


	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}


	public Byte getLocationSamplingCycle() {
		return locationSamplingCycle;
	}


	public void setLocationSamplingCycle(Byte locationSamplingCycle) {
		this.locationSamplingCycle = locationSamplingCycle;
	}


	public Byte getObdSamplingCycle() {
		return obdSamplingCycle;
	}


	public void setObdSamplingCycle(Byte obdSamplingCycle) {
		this.obdSamplingCycle = obdSamplingCycle;
	}


	public Byte getObdTransferCycle() {
		return obdTransferCycle;
	}


	public void setObdTransferCycle(Byte obdTransferCycle) {
		this.obdTransferCycle = obdTransferCycle;
	}


	public Byte getPackageTransferCycle() {
		return packageTransferCycle;
	}


	public void setPackageTransferCycle(Byte packageTransferCycle) {
		this.packageTransferCycle = packageTransferCycle;
	}


	public Byte getPackageSize() {
		return packageSize;
	}


	public void setPackageSize(Byte packageSize) {
		this.packageSize = packageSize;
	}


	public Byte getPackageResponseNeed() {
		return packageResponseNeed;
	}


	public void setPackageResponseNeed(Byte packageResponseNeed) {
		this.packageResponseNeed = packageResponseNeed;
	}


	public Byte getModuleSwitchs() {
		return moduleSwitchs;
	}


	public void setModuleSwitchs(Byte moduleSwitchs) {
		this.moduleSwitchs = moduleSwitchs;
	}


	public Byte getHuanXingFaZhi() {
		return huanXingFaZhi;
	}

	public void setHuanXingFaZhi(Byte huanXingFaZhi) {
		this.huanXingFaZhi = huanXingFaZhi;
	}

	public byte[] getToken() {
		return token;
	}

	public void setToken(byte[] token) {
		this.token = token;
	}


	public int getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(int carTypeId) {
		this.carTypeId = carTypeId;
	}

	@Override
	public String toString() {
		return "LoginRespMessage [isRegister=" + isRegister + ", HeartCycle=" + HeartCycle + ", isActive=" + isActive
				+ ", locationSamplingCycle=" + locationSamplingCycle + ", obdSamplingCycle=" + obdSamplingCycle
				+ ", obdTransferCycle=" + obdTransferCycle + ", packageTransferCycle=" + packageTransferCycle
				+ ", packageSize=" + packageSize + ", packageResponseNeed=" + packageResponseNeed + ", moduleSwitchs="
				+ moduleSwitchs + ", huanXingFaZhi=" + huanXingFaZhi + ", token=" + token + ", carTypeId=" + carTypeId
				+ "]";
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		System.out.println(list.size()); // 0
		System.out.println(list.isEmpty()); // true
		list.add(null);
		System.out.println(list.size()); // 1
		System.out.println(list.isEmpty()); // false
		
		
		Set set = new HashSet<String>();
		System.out.println(set.size());
		System.out.println(set.isEmpty());
		set.add(null);
		System.out.println(set.size());
		System.out.println(set.isEmpty());
	}
}
