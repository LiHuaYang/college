package com.yingteman.netty.client;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.yingteman.netty.server.NettyConstant;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

	private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
	EventLoopGroup group = new NioEventLoopGroup();

	public void connect(int port, String host, final int localport) throws Exception {
		// 配置客户端NIO线程组
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch) throws Exception {
							// 解码
							ch.pipeline().addLast(new ClientBasicDecoder(5, 2, 2, 0)); // 解码
							ch.pipeline().addLast(new ClientBasicEncoder()); // 编码
							
							ch.pipeline().addLast(new LoginReqHandler());
							ch.pipeline().addLast(new HeartBeatReqHandler());
						}
					});
			// 发起异步连接操作
			ChannelFuture future = b.connect(new InetSocketAddress(host, port),
					new InetSocketAddress(NettyConstant.LOCALIP, localport)).sync();
			future.channel().closeFuture().sync();
		} finally {
			// 所有资源释放完成之后，清空资源，再次发起重连操作
			executor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						TimeUnit.SECONDS.sleep(1);
						try {
							connect(11111, "192.168.31.48", localport);// 发起重连操作
						} catch (Exception e) {
							e.printStackTrace();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
//		new NettyClient().connect(NettyConstant.PORT, NettyConstant.REMOTEIP);
		
		new Thread (new Runnable() {
			public void run() {
				try {
					new NettyClient().connect(11111, "192.168.31.48", 8082);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
//		new Thread (new Runnable() {
//			public void run() {
//				try {
//					new NettyClient().connect(8080, NettyConstant.REMOTEIP, 8083);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();
	}
}
















