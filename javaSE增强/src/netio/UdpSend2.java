package netio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 
 * 数据源使用，键盘录入的方式
 *
 * 作者：ariclee		时间：2016年9月8日下午11:40:33
 */
public class UdpSend2 {

	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket();

		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		while ((line=bufr.readLine()) != null) {
			if ("bye".equals(line)) {
				break;
			}
			
			byte [] buf = line.getBytes();
			DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.31.1"), 10003);
			ds.send(dp);
		}
	}
}


class UdpRev2 {
	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket(10003); // 
		
		while (true) {
			byte[] buf = new byte[1024];
			
			DatagramPacket dp = new DatagramPacket(buf, buf.length);

			ds.receive(dp);
			String data = new String(buf, 0, dp.getLength());
			System.out.println("data:" + data);
		}
	}
}














