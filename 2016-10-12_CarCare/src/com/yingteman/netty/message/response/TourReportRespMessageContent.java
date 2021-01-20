package com.yingteman.netty.message.response;

/************************

# 结构
+-----------+-----------+-----------+
|	行程标志	|	行程序号	|	结果		|
|	1 字节	|	4 字节	|	1 字节	|
+-----------+-----------+-----------+

# 实例

行程标志(1 byte)	0x01或0x02
行程序号（4 byte） Uint32	
结果(1 byte)	响应结果‘1’或者’0’ 
(响应结果：uint8类型，1表示成功，0表示失败)
	
*************************/

import com.yingteman.netty.message.MessageContent;


/**
 * 行程统计信息业务响应数据实体 
 * 
 * @author ariclee
 */
public class TourReportRespMessageContent extends MessageContent {
	/*行程标志*/
	private byte xingChengBiaoZhi;
	/*行程序号*/
	private int xingChengXuHao;
	/*结果*/
	private byte jieGuo;
	
	public byte getXingChengBiaoZhi() {
		return xingChengBiaoZhi;
	}
	public void setXingChengBiaoZhi(byte xingChengBiaoZhi) {
		this.xingChengBiaoZhi = xingChengBiaoZhi;
	}
	public int getXingChengXuHao() {
		return xingChengXuHao;
	}
	public void setXingChengXuHao(int xingChengXuHao) {
		this.xingChengXuHao = xingChengXuHao;
	}
	public byte getJieGuo() {
		return jieGuo;
	}
	public void setJieGuo(byte jieGuo) {
		this.jieGuo = jieGuo;
	}
	@Override
	public String toString() {
		return "TourReportRespMessageContent [xingChengBiaoZhi=" + xingChengBiaoZhi + ", xingChengXuHao="
				+ xingChengXuHao + ", jieGuo=" + jieGuo + "]";
	}
}
