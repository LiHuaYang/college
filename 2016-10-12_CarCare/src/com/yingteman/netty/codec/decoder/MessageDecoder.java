package com.yingteman.netty.codec.decoder;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yingteman.netty.bytebuf.ByteBufWrapper;
import com.yingteman.netty.message.Message;
import com.yingteman.netty.message.MessageAttach;
import com.yingteman.netty.message.MessageConstant;
import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.MessageHeader;
import com.yingteman.netty.server.OnlineObdDevice;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 解码类
 * 
 * @author ariclee
 */
public class MessageDecoder extends LengthFieldBasedFrameDecoder {
	private static final Logger logger = LoggerFactory.getLogger(MessageDecoder.class);
	private static final ConcurrentHashMap<String, Channel> onlineMap = OnlineObdDevice.getOnlineMap();
	
	public MessageDecoder(int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
		super(Integer.MAX_VALUE, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		/**
		 * 链路激活时，添加至映射表
		 */
		onlineMap.put(ctx.channel().id().asLongText(), ctx.channel()); // 添加到映射表中
		logger.debug("添加进在线列表以后 -- {}", onlineMap);
		super.channelActive(ctx);
	}
	
	@Override
	protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		ByteBuf byteBuf = (ByteBuf) super.decode(ctx, in);;
		ByteBufWrapper wrapper = new ByteBufWrapper(byteBuf);

		// 1. 接收、验证
		if (!isOurMessage(wrapper.getByteMsgFrameStart(), wrapper.getByteMsgFrameEnd())) {
			logger.debug("帧头、帧尾格式不正确，断开链路");
			ctx.close();
			return null;
		}
		
		// 2. 解码
		MessageHeader header = new MessageHeader();
		Short yewuId = wrapper.getByteMsgContentId();
		
		String channelId = ctx.channel().id().asLongText();
		MessageAttach attach = new MessageAttach(channelId);
		
		ByteBuf msgBodyByeBuf = wrapper.getByteMsgContent();
		MessageContent messageContent = MessageContentDecoderFactory // 
				.createDecoder(yewuId) // 得到解码器
				.decode(msgBodyByeBuf, channelId); // 解码
		Message atferDecode = new Message(header, messageContent, null, attach);
		logger.debug("服务器解码成功 -- {} 业务id为 -- {}", atferDecode, yewuId);
		
		// 2. 返回
		return atferDecode;
	}

	/**
	 * 检验是否是符合标准的协议
	 * 
	 * @param frameStart 帧标识-帧头
	 * @param frameEnd 帧标识-帧尾
	 * @return boolean 若是自己的包，则为 true，反之，false
	 * 
	 * @author ariclee
	 */
	private boolean isOurMessage(ByteBuf frameStart, ByteBuf frameEnd) {
		byte[] zhentouBytes = frameStart.array();
		byte[] zhenweiBytes = frameEnd.array();
		
		String zhentouStr = Arrays.toString(zhentouBytes);
		String zhenweiStr = Arrays.toString(zhenweiBytes);
		
		String zhentouStand = Arrays.toString(MessageConstant.zhen_tou);
		String zhenweiStand = Arrays.toString(MessageConstant.zhen_wei);
		
		return zhentouStr.equals(zhentouStand) && zhenweiStr.equals(zhenweiStand);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.debug("BasicDecoder -- {}", cause.toString());
		/**
		 * 捕获异常时，删除在线列表的记录
		 */
		onlineMap.remove(ctx.channel().id().asLongText()); // 删除记录
		ctx.close();
	}
}

/**
 * 如果解析失败，服务器端需要做什么？需要给客户端回送什么消息？
 * 
 * 为什么会解析失败？
 * 1. 数据包不是我们自己的
 * 2. 
 * 
 * 解析失败后的操作？
 * 1. 断开链接
 * 2. 
 */
