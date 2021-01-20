package car_care_dem01;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 一个字节有八位，一个十六进制的数字需要四位来表示 
 * 一个字节 = 两个十六进制的数字
 * 
 * @author ariclee
 */
public class MsgHandler01 extends ChannelHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);

		// System.out.println("MsgHandler01--channelRead--body--" +
		// buf.readInt());
		// System.out.println("MsgHandler01--channelRead--body--" +
		// buf.readByte());
		// System.out.println("MsgHandler01--channelRead--body--" +
		// buf.toString());
		// System.out.println("MsgHandler01--channelRead--body--" +
		// buf.array());

//		for (int i = 0; i < buf.capacity(); i++) {
//			byte b = buf.getByte(i);
//			System.out.println(b);
//		}

		System.out.println(bytesToHexString(req));
		// String body = new String(req, "UTF-8");
		// System.out.println("MsgHandler01--channelRead--body--" + body);

	}

	public static String bytesToHexString(byte[] src){   
	    StringBuilder stringBuilder = new StringBuilder("");   
	    if (src == null || src.length <= 0) {   
	        return null;   
	    }   
	    for (int i = 0; i < src.length; i++) {   
	        int v = src[i] & 0xFF;   
	        String hv = Integer.toHexString(v);   
	        if (hv.length() < 2) {   
	            stringBuilder.append(0);   
	        }   
	        stringBuilder.append(hv);   
	    }   
	    return stringBuilder.toString();   
	}  
	// private NettyMessage buildHeatBeat() {
	// NettyMessage message = new NettyMessage();
	// Header header = new Header();
	// header.setType(MessageType.HEARTBEAT_RESP.value());
	// message.setHeader(header);
	// return message;
	// }
}
