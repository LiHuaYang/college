package com.yingteman.netty.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yingteman.netty.message.Message;
import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.MessageHeader;
import com.yingteman.netty.message.MessageTail;
import com.yingteman.netty.message.MessageType;
import com.yingteman.netty.server.OnlineObdDevice;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.ReadTimeoutException;

/**
 * 不进行具体的业务操作，此类只负责分发业务消息，并将业务处理的结果
 * 组装成响应对象，并写入 Encoder
 * 
 * @author ariclee
 */
public class MessageHandler  extends ChannelHandlerAdapter  {
	private static final Logger logger = LoggerFactory.getLogger(MessageHandler.class);
	private static final ConcurrentHashMap<String, Channel> onlineMap = OnlineObdDevice.getOnlineMap();
	
	/**
	 * 响应报文业务 id 和帧长之间的映射表
	 */
	private static final Map<Short, Short> reponseMsgByteLengthMap = new HashMap<>();
	
	/**
	 * 登陆响应报文业务数据部分字节长度
	 * 12 + 2 + 4 + 128 = 146
	 * 
	 * @see com.yingteman.netty.message.response.LoginRespMessageContent LoginRespMessageContent
	 * @see com.yingteman.netty.message.Message Message
	 */
	private static final short LoginRespMessageByteLength = 146 + 17;
	
	/**
	 * 心跳响应报文业务数据部分字节长度
	 * 1 + 2 = 3
	 */
	private static final short HeartBeatRespMessageByteLength = 3 + 17;
	
	static {
		reponseMsgByteLengthMap.put(MessageType.MESSAGE_HEART_RESP.value(), Short.valueOf(HeartBeatRespMessageByteLength));
		reponseMsgByteLengthMap.put(MessageType.MESSAGE_LOGIN_RESP.value(), Short.valueOf(LoginRespMessageByteLength));
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object _msg) throws Exception {
		Message requestMsg = (Message) _msg;
		MessageContent requestContent = requestMsg.getContent();

		// 1. 分发请求，得到消息内容  
		// TODO Handler 处理的到底的是 Message 还是 MessageContent 即，分发请求的时候参数是 Message 还是 Messagecontent
		MessageContent responseContent = MessageContentHandlerFactory //
				.createHandler(requestContent.getYeWuId())  // 创建 handlder
				.process(requestMsg); // 处理

		// 2.1.  组装消息头部，尾部
		MessageHeader header = buildRespHeader(responseContent.getYeWuId());
		MessageTail tail = buildRespTail();
		
		// 2.2.  组装整个消息
		Message responseMsg = new Message(header, responseContent, tail, null);
		
		// 3. 写入 Encoder
		ctx.writeAndFlush(responseMsg);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	/**
	 * 创建一个响应消息头
	 * @param yewuid
	 * @return 响应消息头
	 * @author ariclee
	 */
	private MessageHeader buildRespHeader(Short yewuid) {
		MessageHeader header = new MessageHeader();
		int kuoZhangZiDuan = 0;
		header.setKuoZhangZiDuan(kuoZhangZiDuan);
		byte shuJuBiaoShi = 1;
		header.setShuJuBiaoShi(shuJuBiaoShi);
		int xiaoXiBiaoShi = 3;
		header.setXiaoXiBiaoShi(xiaoXiBiaoShi);
		
		header.setZhenChang(reponseMsgByteLengthMap.get(yewuid));
		return header;
	}
	
	/**
	 * 创建一个响应消息尾部
	 * @return 响应消息尾
	 * @author ariclee
	 */
	private MessageTail buildRespTail() {
		MessageTail tail = new MessageTail();
		short jiaoJianMa = 31861;
		tail.setJiaoJianMa(jiaoJianMa);
		int shiJianCuo = 1448617161;
		tail.setShiJianCuo(shiJianCuo);
		
		return tail;
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		if(cause instanceof ReadTimeoutException){  
			logger.debug("捕获链路超时异常，断开连接 {}", cause.toString());
			ctx.channel().close(); // 关闭链路
        }  
		/**
		 * 捕获异常时，删除在线列表的记录
		 */
		onlineMap.remove(ctx.channel().id().asLongText()); // 删除记录
	}
}
