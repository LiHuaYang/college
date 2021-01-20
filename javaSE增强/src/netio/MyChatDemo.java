package netio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 聊天程序 有收数据的部分，和发数据的部分 这两个部分需要同时进行 需要用到多线程技术
 * 
 * 作者：ariclee 时间：2016年9月9日上午8:41:39
 */
//class Send implements Runnable {
//	private DatagramSocket ds;
//
//	public Send(DatagramSocket ds) {
//		this.ds = ds;
//	}
//
//	@Override
//	public void run() {
//		try {
//			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
//			String line = null;
//			while ((line = bufr.readLine()) != null) {
//				System.out.println("发送端输入的字符串---" + line);
//				byte[] buf = line.getBytes();
//				DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.255"), 10010);
//				ds.send(dp);
//				
//				if("886".equals(line))
//					break;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
//
//class Reve implements Runnable {
//	private DatagramSocket ds;
//
//	public Reve(DatagramSocket ds) {
//		this.ds = ds;
//	}
//
//	@Override
//	public void run() {
//		try {
//			while (true) {
//				byte[] buf = new byte[1024];
//				DatagramPacket dp = new DatagramPacket(buf, buf.length);
//
//				ds.receive(dp);
//				String ip = dp.getAddress().getHostAddress();
//				System.out.println("发送端的IP地址为：" + ip);
//				String data = new String(buf, 0, dp.getLength());
//				System.out.println("ip:" + ip + "data:" + data);
//				
//				if("886".equals(data))
//					System.out.println("退出聊天室");
//			}
//		} catch (Exception e) {
//			System.out.println("接收端出现错误：" + e);
//		}
//	}
//}

public class MyChatDemo {
	public static void main(String[] args) throws Exception {
//		DatagramSocket sendds = new DatagramSocket();
//		DatagramSocket receds = new DatagramSocket(10010);
//		
//		new Thread(new Send(sendds)).start();
//		new Thread(new Reve(receds)).start();
	}
}
