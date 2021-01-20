package com.yingteman.netty.message.request;

/************************

# 结构
+--------------------------------------------------------------------------------------------------------------------------------------------
|	行程开始标记位
|	1 字节
+--------------------------------------------------------------------------------------------------------------------------------------------

# 实例
行程开始标记位 	1 byte	0x01
行程序号			4 byte	Uint32
开始时间			4 byte	Uint32
行程结束标记位 	1 byte	0x02
行程序号 			4 bytes	Uint32
结束时间 			4 bytes	Uint32
开始经度 			4 bytes 单位为1/10000 分	Uint32
开始纬度 			4 bytes 单位为1/10000 分	Uint32
结束经度 			4 bytes 单位为1/10000 分	Uint32
结束纬度 			4 bytes 单位为1/10000 分	Uint32
本次行驶里程 		4 byte 	单位:0.01千米		Uint32
本次行驶油耗		2 byte 	单位:0.01升		Uint16			


行程统计信息数据传输业务数据部分报文长度为：
9*4 + 1 + 1 + 2 + 1 + 2 = 43 字节

*************************/

import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.MessageType;


/**
 * 行程统计信息请求业务数据实体 
 * 
 * 行程统计信息数据传输业务数据部分报文长度为：43 字节
 * 
 * @author ariclee
 */
public class TourReportReqMessageContent extends MessageContent {
	/*行程开始标记位*/
	private byte kaiShiBiaoJiWei; 
	/*行程序号*/
	private int kaishiXinChengXuHao;
	/*开始时间*/
	private int kaiShiShiJian;
	/*行程结束标记位*/
	private byte jieShuBiaoJiWei;
	/*行程序号*/
	private int jieShuXingChengXuHao;
	/*结束时间*/
	private int jieShuShiJian;
	/*开始经度	单位为1/10000 分*/
	private int kaiShiJingDu;
	/*开始纬度	单位为1/10000 分*/
	private int kaiShiWeiDu;
	/*结束经度	单位为1/10000 分*/
	private int jieShuJingDu;
	/*结束纬度	单位为1/10000 分*/
	private int jieShuWeiDu;
	/*本次行程里程	单位:0.01千米*/
	private int liCheng;
	/*本次行程油耗	单位:0.01升*/
	private short youHao;
	
	
	public static TourReportReqMessageContent createDefaultReqMsg() {
		TourReportReqMessageContent res = new TourReportReqMessageContent();
		
		res.setYeWuId(MessageType.MESSAGE_TOUR_REPORt_REQ.value());
		res.setXieYiHao((byte) 1);
		
		// 开化	118.39	减0小时6分26秒	29.15
		// 普陀	122.30	加0小时9分12秒	29.97
		res.setKaiShiBiaoJiWei((byte)1);
		res.setKaishiXinChengXuHao(12345); // 行程序号
		res.setKaiShiShiJian(20161219);
		res.setJieShuBiaoJiWei((byte)1);
		res.setJieShuXingChengXuHao(12345);
		res.setJieShuShiJian(20161220);
		res.setKaiShiJingDu(118); // 
		res.setKaiShiWeiDu(29);
		res.setJieShuJingDu(122);
		res.setJieShuWeiDu(29);
		res.setLiCheng(300);
		res.setYouHao((short)10);
		return res;
	}
	
	public byte getKaiShiBiaoJiWei() {
		return kaiShiBiaoJiWei;
	}
	public void setKaiShiBiaoJiWei(byte kaiShiBiaoJiWei) {
		this.kaiShiBiaoJiWei = kaiShiBiaoJiWei;
	}
	public int getKaishiXinChengXuHao() {
		return kaishiXinChengXuHao;
	}
	public void setKaishiXinChengXuHao(int kaishiXinChengXuHao) {
		this.kaishiXinChengXuHao = kaishiXinChengXuHao;
	}
	public int getKaiShiShiJian() {
		return kaiShiShiJian;
	}
	public void setKaiShiShiJian(int kaiShiShiJian) {
		this.kaiShiShiJian = kaiShiShiJian;
	}
	public byte getJieShuBiaoJiWei() {
		return jieShuBiaoJiWei;
	}
	public void setJieShuBiaoJiWei(byte jieShuBiaoJiWei) {
		this.jieShuBiaoJiWei = jieShuBiaoJiWei;
	}
	public int getJieShuXingChengXuHao() {
		return jieShuXingChengXuHao;
	}
	public void setJieShuXingChengXuHao(int jieShuXingChengXuHao) {
		this.jieShuXingChengXuHao = jieShuXingChengXuHao;
	}
	public int getJieShuShiJian() {
		return jieShuShiJian;
	}
	public void setJieShuShiJian(int jieShuShiJian) {
		this.jieShuShiJian = jieShuShiJian;
	}
	public int getKaiShiJingDu() {
		return kaiShiJingDu;
	}
	public void setKaiShiJingDu(int kaiShiJingDu) {
		this.kaiShiJingDu = kaiShiJingDu;
	}
	public int getKaiShiWeiDu() {
		return kaiShiWeiDu;
	}
	public void setKaiShiWeiDu(int kaiShiWeiDu) {
		this.kaiShiWeiDu = kaiShiWeiDu;
	}
	public int getJieShuJingDu() {
		return jieShuJingDu;
	}
	public void setJieShuJingDu(int jieShuJingDu) {
		this.jieShuJingDu = jieShuJingDu;
	}
	public int getJieShuWeiDu() {
		return jieShuWeiDu;
	}
	public void setJieShuWeiDu(int jieShuWeiDu) {
		this.jieShuWeiDu = jieShuWeiDu;
	}
	public int getLiCheng() {
		return liCheng;
	}
	public void setLiCheng(int liCheng) {
		this.liCheng = liCheng;
	}
	public short getYouHao() {
		return youHao;
	}
	public void setYouHao(short youHao) {
		this.youHao = youHao;
	}
	@Override
	public String toString() {
		return "TourReportReqMessageContent [kaiShiBiaoJiWei=" + kaiShiBiaoJiWei + ", kaishiXinChengXuHao="
				+ kaishiXinChengXuHao + ", kaiShiShiJian=" + kaiShiShiJian + ", jieShuBiaoJiWei=" + jieShuBiaoJiWei
				+ ", jieShuXingChengXuHao=" + jieShuXingChengXuHao + ", jieShuShiJian=" + jieShuShiJian
				+ ", kaiShiJingDu=" + kaiShiJingDu + ", kaiShiWeiDu=" + kaiShiWeiDu + ", jieShuJingDu=" + jieShuJingDu
				+ ", jieShuWeiDu=" + jieShuWeiDu + ", liCheng=" + liCheng + ", youHao=" + youHao + "]";
	}
}
