package demo;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class ByteBufToPojoHandlerDemo01 extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
//		byte[] req = new byte[in.readableBytes()];
//		in.readBytes(req);
//		String body = new String(req, "UTF-8");
		
		
		
	}

	
}
