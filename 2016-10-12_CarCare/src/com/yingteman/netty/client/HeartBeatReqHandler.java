package com.yingteman.netty.client;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yingteman.netty.message.HeartBeatMessage;
import com.yingteman.netty.message.Message;
import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.MessageHeader;
import com.yingteman.netty.message.MessageTail;
import com.yingteman.netty.message.MessageType;
import com.yingteman.netty.message.response.CfgXiaFaMessageContent;
import com.yingteman.netty.message.response.LoginRespMessageContent;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class HeartBeatReqHandler extends ChannelHandlerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(HeartBeatReqHandler.class);

	private volatile ScheduledFuture<?> heartBeat;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object in) throws Exception {
		Message requestMsg = (Message) in;
		MessageContent requestContent = requestMsg.getContent();

		logger.debug("HeartBeatReqHandler channelRead() ҵ�� id Ϊ��{}", requestContent.getYeWuId());

		if (requestContent.getYeWuId().equals(MessageType.MESSAGE_XIAFA.value())) {
			logger.debug("HeartBeatReqHandler �յ����������·����ã���ʼȡ����ʱ����");
			heartBeat.cancel(true); // ����ǰҵ��Ϊ�����ļ��·�����ȡ���Ѿ���ʼִ�е�����
			
			CfgXiaFaMessageContent loginMsg = (CfgXiaFaMessageContent) requestContent;
			long period = loginMsg.getItem() * 1000; // TODO Ĭ�����޸���������
			
			heartBeat = ctx.executor().scheduleAtFixedRate(new HeartBeatReqHandler.HeartBeatTask(ctx), 0, period,
					TimeUnit.MILLISECONDS);
		}
		
		/**
		 * ֻ�е���ϢΪ��������½��Ӧʱ���ſ�ʼ��������
		 * 
		 * requestContent.getYeWuId().equals(Message)
		 */
		if (requestContent.getYeWuId().equals(MessageType.MESSAGE_LOGIN_RESP.value())) {
			logger.debug("HeartBeatReqHandler �յ��������ĵ�½��Ӧ����ʼִ�ж�ʱ����");
			LoginRespMessageContent loginMsg = (LoginRespMessageContent) requestContent;
			long period = loginMsg.getHeartCycle() * 1000;
			
			heartBeat = ctx.executor().scheduleAtFixedRate(new HeartBeatReqHandler.HeartBeatTask(ctx), 0, period,
					TimeUnit.MILLISECONDS);
			
		} else if (requestContent.getYeWuId().equals(MessageType.MESSAGE_HEART_RESP.value())) {
			logger.debug("HeartBeatReqHandler �յ���������������Ӧ��");
		}

		ctx.fireChannelRead(in);
	}

	/**
	 * ��������ʱ����
	 * 
	 * @author ariclee
	 */
	private class HeartBeatTask implements Runnable {
		private final ChannelHandlerContext ctx;

		public HeartBeatTask(final ChannelHandlerContext ctx) {
			this.ctx = ctx;
		}

		@Override
		public void run() {
			Message request = buildHeartBeatReq();
			System.out.println("Client send heart beat messsage to server : ---> " + request);
			ctx.writeAndFlush(request);
		}
	}

	private Message buildHeartBeatReq() {
		// ��װ��Ϣͷ����β��
		MessageHeader header = new MessageHeader();
		int kuoZhangZiDuan = 0;
		header.setKuoZhangZiDuan(kuoZhangZiDuan);
		byte shuJuBiaoShi = 1;
		header.setShuJuBiaoShi(shuJuBiaoShi);
		int xiaoXiBiaoShi = 31;
		header.setXiaoXiBiaoShi(xiaoXiBiaoShi);
		short zhenChang = 20;
		header.setZhenChang(zhenChang);

		MessageTail tail = new MessageTail();
		short jiaoJianMa = (short) 62804;
		tail.setJiaoJianMa(jiaoJianMa);
		int shiJianCuo = 28;
		tail.setShiJianCuo(shiJianCuo);

		return new Message(header, HeartBeatMessage.createDefaultReqMsg(), tail, null);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		if (heartBeat != null) {
			heartBeat.cancel(true);
			heartBeat = null;
		}
		ctx.fireExceptionCaught(cause);
	}

	public static void main(String[] args) throws Exception {

		final ScheduledThreadPoolExecutor EXECUTOR = 
				(ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);
		ScheduledFuture f1 = EXECUTOR.scheduleAtFixedRate(new Runnable() {
				@Override
				public void run() {
					System.out.println("Im alive 1");
				}
		}, 0, 1, TimeUnit.SECONDS);
		
//		ScheduledFuture f2 = EXECUTOR.scheduleAtFixedRate(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("Im alive 2");
//			}
//		}, 0, 2, TimeUnit.SECONDS);

		Thread.sleep(10000);
		f1.cancel(true);
		
		EXECUTOR.shutdown();
		System.out.println("f1 cancel");
		System.out.println("is done��  " + f1.isDone());
		
		for (int i = 0; i < 10; i++) {
			System.out.println("i am main function");
		}
		
		return ;
	}
}
