package com.yingteman.netty.message.request;

import com.yingteman.netty.message.MessageContent;

public class ObdDataReqMessageContent extends MessageContent {
	private byte[] taiYa;
	private byte[] youLiang;
	
	public byte[] getTaiYa() {
		return taiYa;
	}
	public void setTaiYa(byte[] taiYa) {
		this.taiYa = taiYa;
	}
	public byte[] getYouLiang() {
		return youLiang;
	}
	public void setYouLiang(byte[] youLiang) {
		this.youLiang = youLiang;
	}
}
