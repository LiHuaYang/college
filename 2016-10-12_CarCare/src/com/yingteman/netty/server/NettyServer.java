
package com.yingteman.netty.server;

import java.io.IOException;

import com.yingteman.httpservice.NanoHttpServer;
import com.yingteman.netty.codec.decoder.MessageDecoder;
import com.yingteman.netty.codec.encoder.MessageEncoder;
import com.yingteman.netty.handler.MessageHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * Netty服务器端
 * 
 * @author ariclee
 */
public class NettyServer {

	public void bind() throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		ServerBootstrap b = new ServerBootstrap();
		b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 100)
				.handler(new LoggingHandler(LogLevel.INFO)).childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					public void initChannel(SocketChannel ch) throws IOException {
						ch.pipeline().addLast(new MessageDecoder(5, 2, 2, 0)); 	 // 解码
						ch.pipeline().addLast(new MessageEncoder()); 			 // 编码
						
						ch.pipeline().addLast("readTimeoutHandler", new ReadTimeoutHandler(10)); // 向后面的 Handler 传递异常信息
						
						ch.pipeline().addLast(new MessageHandler()); 			 // 业务处理
					}
				});
		b.bind(NettyConstant.REMOTEIP, NettyConstant.PORT).sync();
		System.out.println("Netty server start ok : " + (NettyConstant.REMOTEIP + " : " + NettyConstant.PORT));
		
		/**
		 * 此处开启 NanoHTTP Server 
		 */
		NanoHttpServer httpServer = new NanoHttpServer();
		httpServer.start(workerGroup);
	}

	/**
	 * 先启动服务器，再开启客户端
	 * @param args
	 * @throws Exception
	 * @author ariclee
	 */
	public static void main(String[] args) throws Exception {
		new NettyServer().bind();
//		new NettyClient().connect(NettyConstant.PORT, NettyConstant.REMOTEIP);
	}

}
