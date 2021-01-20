package netio;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 端口号 （进程的逻辑地址：不同的进程的标识）： 
 * 0 -> 65535, 0 -> 1024为系统化使用或保留端口
 *
 * 192.168.1.0
 * 
 * 192.168.1.255：广播地址
 * 
 * 
 * 作者：ariclee		时间：2016年9月8日下午9:36:59
 */
public class UdpSend {
	
	public static void main(String[] args) throws Exception {
		// 1. 创建UDP服务，通过DatagramSocket
		DatagramSocket ds = new DatagramSocket();
		
		// 2. 确定需要发送的数据，封装成数据包
		byte [] by = "HelloWorld".getBytes();
		DatagramPacket dp = new DatagramPacket(by, by.length, InetAddress.getByName("192.168.31.1"), 10000);
		
		// 3. 通过socket服务，将数据包发送出去，通过send方法
		ds.send(dp);
		
		// 4. 关闭资源
		ds.close();
	}
}
 

class UdpRev {
	public static void main(String[] args) throws Exception {
		// 1. 创建udp socket，建立端点
		DatagramSocket ds = new DatagramSocket(10000);

		// 2. 定义数据包，用于存储数据
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		// 3. 通过服务的receive方法将收到的数据存入数据包中（阻塞式方法，没数据就等）
		ds.receive(dp);
		
		// 4. 通过数据包的方法获取其中的数据
		String ip = dp.getAddress().getHostAddress();
		String data = new String(dp.getData(), 0, dp.getLength());
		int port = dp.getPort();
		
		System.out.println("ip:" + ip);
		System.out.println("data:" + data);
		System.out.println("port:" + port);
		
		// 5. 关闭资源
		ds.close();
	}
}








