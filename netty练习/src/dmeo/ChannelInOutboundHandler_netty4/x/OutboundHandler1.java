package dmeo.ChannelInOutboundHandler_netty4.x;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import sun.util.logging.resources.logging;

public class OutboundHandler1 extends ChannelOutboundHandlerAdapter {

	private static Logger logger = LoggerFactory.getLogger(OutboundHandler1.class);
	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
//		logger.info("OutboundHandler1.write");
		System.out.println("OutboundHandler1.write");
        String response = "I am ok!";  
        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());  
        encoded.writeBytes(response.getBytes());  
        ctx.write(encoded);  
        ctx.flush();  
	}
	
}
