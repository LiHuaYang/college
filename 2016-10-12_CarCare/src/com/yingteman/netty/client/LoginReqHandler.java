package com.yingteman.netty.client;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yingteman.netty.message.Message;
import com.yingteman.netty.message.MessageHeader;
import com.yingteman.netty.message.MessageTail;
import com.yingteman.netty.message.MessageType;
import com.yingteman.netty.message.request.LoginReqMessageContent;
import com.yingteman.netty.message.request.TourReportReqMessageContent;
import com.yingteman.netty.message.response.LoginRespMessageContent;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class LoginReqHandler extends ChannelHandlerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(LoginReqHandler.class);
	
	private volatile ScheduledFuture<?> tourreport;
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Message loginRequestMessage = buildLoginReq();
		logger.debug("客户端到服务器的链路激活，发送登陆请求！内容为 {}", loginRequestMessage);
		ctx.writeAndFlush(loginRequestMessage); // 创建一个默认的登录请求（这里只是业务数据部分）
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object in) throws Exception {
		Message msg = (Message) in;
		
		if(msg.getContent().getYeWuId().equals(MessageType.MESSAGE_LOGIN_RESP.value())) { // 登陆响应
			LoginRespMessageContent content = (LoginRespMessageContent) msg.getContent();
			logger.debug("客户端-盒子的激活状态为 - {}", content.getIsActive());
			if(content.getIsActive().equals(Byte.valueOf((byte) 0))) {
				logger.debug("客户端-盒子的激活未激活 --{}", content.getIsActive());
			} else {
				// 开始发送加密后的行程数据
				// 1 分钟 = 60 秒 = 60 * 1000 毫秒
				tourreport = ctx.executor().scheduleAtFixedRate(new LoginReqHandler.TourReportTask(ctx), 0, 20*1000,
						TimeUnit.MILLISECONDS);
				logger.debug("客户端-盒子的激活已激活 --{}", content.getIsActive());
			}
		}
		ctx.fireChannelRead(in);
	}
	
	/**
	 * 心跳请求定时任务
	 * 
	 * @author ariclee
	 */
	private class TourReportTask implements Runnable {
		private final ChannelHandlerContext ctx;

		public TourReportTask(final ChannelHandlerContext ctx) {
			this.ctx = ctx;
		}

		@Override
		public void run() {
			Message request = buildTourReportReq();
			ctx.writeAndFlush(request);
		}
	}
	
	
	private static final short TOUR_REPORT_REQ_LENGTH = 43 + 17;
	/**
	 * 创建一个行程报告
	 * 
	 * @return
	 * @author ariclee
	 */
	private Message buildTourReportReq() {
		MessageHeader header = new MessageHeader();
		int kuoZhangZiDuan = 0;
		header.setKuoZhangZiDuan(kuoZhangZiDuan);
		byte shuJuBiaoShi = 1;
		header.setShuJuBiaoShi(shuJuBiaoShi);
		int xiaoXiBiaoShi = 49;
		header.setXiaoXiBiaoShi(xiaoXiBiaoShi);
		short zhenChang = TOUR_REPORT_REQ_LENGTH;
		header.setZhenChang(zhenChang);
		
		TourReportReqMessageContent content = TourReportReqMessageContent.createDefaultReqMsg();
		
		MessageTail tail = new MessageTail();
		short jiaoJianMa = (short) 62804;
		tail.setJiaoJianMa(jiaoJianMa );
		int shiJianCuo = 28;
		tail.setShiJianCuo(shiJianCuo);
		
		return new Message(header, content, tail, null);
	}
	
	
	/**
	 * 客户端生成一个登陆请求实体，业务 id 为 2
	 * 
	 * @return
	 * @author ariclee
	 */
	private Message buildLoginReq() {
		// 组装消息头部，尾部
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
		tail.setJiaoJianMa(jiaoJianMa );
		int shiJianCuo = 28;
		tail.setShiJianCuo(shiJianCuo);
		
		return new Message(header, LoginReqMessageContent.createDefaultMsg(), tail, null);
	}

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
		ctx.fireExceptionCaught(cause);
	}
}
