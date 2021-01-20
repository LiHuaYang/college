package com.yingteman.netty.message.response;

import java.util.HashMap;
import java.util.Map;

import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.MessageType;


/**
 * 配置文件下发实体类
 * 
 * @author ariclee
 */
public class CfgXiaFaMessageContent extends MessageContent {
	
	private byte id;     // 信息ID （映射表）
	private byte item;   // 消息数据内容（值）
	
	private static final Map<String, Object> map = new HashMap<>();
	static {
		map.put("heart_cycle", (byte)0x02);
		map.put("activate", (byte)0x03);
		map.put("location_sampling_cycle", (byte)0x04);
		map.put("obd_sampling_cycle", (byte)0x05);
		map.put("obd_transfer_cycle", (byte)0x06);
		map.put("package_size", (byte)0x07);
		map.put("package_transfer_cycle", (byte)0x08);
		map.put("package_response_need", (byte)0x09);
		map.put("gps_switch", (byte)0x0a);
		map.put("wifi_switch", (byte)0x0b);
		map.put("bluetooth_switch", (byte)0x0c);
		map.put("obd_switch", (byte)0x0d);
		map.put("sersor_switch", (byte)0x0e);
		map.put("huanxing_fazhi", (byte)0x0f);
	}
	
	public byte getItem() {
		return item;
	}
	public void setItem(byte item) {
		this.item = item;
	}
	public byte getId() {
		return id;
	}
	public void setId(byte id) {
		this.id = id;
	}
	
	public MessageContent setId(String col_name) {
		super.setYeWuId(MessageType.MESSAGE_XIAFA.value()); // yewuid
		super.setXieYiHao((byte)1);
		
		this.setId((byte)map.get(col_name));
		return this;
	}

	@Override
	public String toString() {
		return "BoxRespMessageContent [item=" + item + ", id=" + id + "]";
	}
}
