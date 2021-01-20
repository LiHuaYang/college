package dmeo.ChannelInOutboundHandler_netty4.x;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class InboundHandler1 extends ChannelInboundHandlerAdapter {

	private static Logger logger =  LoggerFactory.getLogger(InboundHandler1.class);
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		logger.info("InboundHandler1.channelRead: ctx {}", ctx);
		System.out.println("InboundHandler1.channelRead");
		ctx.fireChannelRead(msg);  
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		logger.info("InboundHandler1.channelReadComplete");  
		System.out.println("InboundHandler1.channelReadComplete");
		ctx.flush();
	}
	
}
