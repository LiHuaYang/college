package com.yingteman.netty.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yingteman.netty.bytebuf.ByteBufWrapper;
import com.yingteman.netty.message.HeartBeatMessage;
import com.yingteman.netty.message.Message;
import com.yingteman.netty.message.MessageHeader;
import com.yingteman.netty.message.MessageTail;
import com.yingteman.netty.message.MessageType;
import com.yingteman.netty.message.response.CfgXiaFaMessageContent;
import com.yingteman.netty.message.response.LoginRespMessageContent;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 解码类
 * 
 * @author ariclee
 */
public class ClientBasicDecoder extends LengthFieldBasedFrameDecoder {
	private static final Logger logger = LoggerFactory.getLogger(ClientBasicDecoder.class);

	public ClientBasicDecoder(int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
		super(Integer.MAX_VALUE, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
	}

	@Override
	protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		ByteBuf byteBuf = (ByteBuf) super.decode(ctx, in);

		if (byteBuf == null) {
			logger.debug("ClientBasicDecoder byteBuf 为空");
			return null;
		}
		
		ByteBufWrapper wrapper = new ByteBufWrapper(byteBuf);
		Short yewuid = wrapper.getByteMsgContentId();
		
		logger.debug("客户端收到的业务id为 -- {}", yewuid);
		
		if (yewuid.equals(MessageType.MESSAGE_LOGIN_RESP.value())) { // 如果是登陆响应
			return byte2LoginRespMessage(byteBuf);
			
		} else if (yewuid.equals(MessageType.MESSAGE_XIAFA.value())) { // 配置文件下发
			return byte2XiaFaMessage(byteBuf);
			
		} else { // 心跳
			Message afterDeocerMag = buildHeatBeatReq();
			logger.debug("ClientBasicDecoder afterDeocerMag 组装的实体为 -- {}", afterDeocerMag);
			return afterDeocerMag;
		} 
	}

	
	private Message byte2XiaFaMessage(ByteBuf in) {
		MessageHeader header = new MessageHeader();
		header.setZhenChang(in.skipBytes(5).readShort());
		header.setShuJuBiaoShi(in.readByte());
		header.setXiaoXiBiaoShi(in.readInt());
		header.setKuoZhangZiDuan(in.readInt());
		
		CfgXiaFaMessageContent content = new CfgXiaFaMessageContent();
		content.setYeWuId(in.readShort()); //  2
		content.setXieYiHao(in.readByte()); // 1
		content.setId(in.readByte());
		content.setItem(in.readByte());
		
		MessageTail tail = new MessageTail();
		tail.setShiJianCuo(in.readInt());
		tail.setJiaoJianMa(in.readShort());
		
		Message msg = new Message(header, content, tail, null);
		
		return msg;
	}
	
	private Message byte2LoginRespMessage(ByteBuf in) {
		// 组装头部
		MessageHeader header = new MessageHeader();
		header.setZhenChang(in.skipBytes(5).readShort());
		header.setShuJuBiaoShi(in.readByte());
		header.setXiaoXiBiaoShi(in.readInt());
		header.setKuoZhangZiDuan(in.readInt());
		
		LoginRespMessageContent lgm = new LoginRespMessageContent();
		lgm.setYeWuId(in.readShort()); //  2
		lgm.setXieYiHao(in.readByte()); // 1
		lgm.setIsRegister(in.readByte()); // 1
		lgm.setHeartCycle(in.readByte()); // 1
		lgm.setIsActive(in.readByte()); // 1
		lgm.setLocationSamplingCycle(in.readByte()); // 1
		lgm.setObdSamplingCycle(in.readByte()); // 1
		lgm.setObdTransferCycle(in.readByte()); // 1
		lgm.setPackageTransferCycle(in.readByte()); // 1
		lgm.setPackageSize(in.readByte()); // 1
		lgm.setPackageResponseNeed(in.readByte()); // 1
		lgm.setModuleSwitchs(in.readByte()); // 1
		lgm.setHuanXingFaZhi(in.readByte()); // 1
		lgm.setToken(in.readBytes(128).array()); // 128
		lgm.setCarTypeId(in.readInt()); // 4
		
		MessageTail tail = new MessageTail();
		tail.setShiJianCuo(in.readInt());
		tail.setJiaoJianMa(in.readShort());
		
		Message msg = new Message(header, lgm, tail, null);
		return msg;
	}
	
	/**
	 * 组装成服务器端的心跳响应，业务 id 为 1001
	 * 
	 * @return
	 * @author ariclee
	 */
	private Message buildHeatBeatReq() {
		
		// 2. 组装消息头部，尾部
		MessageHeader header = new MessageHeader();
		int kuoZhangZiDuan = 0;
		header.setKuoZhangZiDuan(kuoZhangZiDuan);
		byte shuJuBiaoShi = 1;
		header.setShuJuBiaoShi(shuJuBiaoShi);
		int xiaoXiBiaoShi = 49;
		header.setXiaoXiBiaoShi(xiaoXiBiaoShi);
		short zhenChang = 306;
		header.setZhenChang(zhenChang);
		
		MessageTail tail = new MessageTail();
		short jiaoJianMa = (short) 62804;
		
		tail.setJiaoJianMa(jiaoJianMa);
		int shiJianCuo = 28;
		tail.setShiJianCuo(shiJianCuo);
		
		Message result = new Message(header, HeartBeatMessage.createDefaultRespMsg(), tail, null);
		return result;
	}
}
