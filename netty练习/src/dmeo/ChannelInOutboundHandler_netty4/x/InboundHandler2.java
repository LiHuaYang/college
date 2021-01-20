package dmeo.ChannelInOutboundHandler_netty4.x;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class InboundHandler2 extends ChannelInboundHandlerAdapter {

	private static Logger logger =  LoggerFactory.getLogger(InboundHandler2.class);
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		logger.info("InboundHandler2.channelRead: ctx :" + ctx);
		System.out.println("InboundHandler2.channelRead");
		ByteBuf result = (ByteBuf) msg;
		byte[] result1 = new byte[result.readableBytes()];
		result.readBytes(result1);
		String resultStr = new String(result1);
		System.out.println("Client said:" + resultStr);
		result.release();

		ctx.write(msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		logger.info("InboundHandler2.channelReadComplete");  
		System.out.println("InboundHandler2.channelReadComplete");
        ctx.flush(); 
	}

}
