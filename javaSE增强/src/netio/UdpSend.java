package netio;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * �˿ں� �����̵��߼���ַ����ͬ�Ľ��̵ı�ʶ���� 
 * 0 -> 65535, 0 -> 1024Ϊϵͳ��ʹ�û����˿�
 *
 * 192.168.1.0
 * 
 * 192.168.1.255���㲥��ַ
 * 
 * 
 * ���ߣ�ariclee		ʱ�䣺2016��9��8������9:36:59
 */
public class UdpSend {
	
	public static void main(String[] args) throws Exception {
		// 1. ����UDP����ͨ��DatagramSocket
		DatagramSocket ds = new DatagramSocket();
		
		// 2. ȷ����Ҫ���͵����ݣ���װ�����ݰ�
		byte [] by = "HelloWorld".getBytes();
		DatagramPacket dp = new DatagramPacket(by, by.length, InetAddress.getByName("192.168.31.1"), 10000);
		
		// 3. ͨ��socket���񣬽����ݰ����ͳ�ȥ��ͨ��send����
		ds.send(dp);
		
		// 4. �ر���Դ
		ds.close();
	}
}
 

class UdpRev {
	public static void main(String[] args) throws Exception {
		// 1. ����udp socket�������˵�
		DatagramSocket ds = new DatagramSocket(10000);

		// 2. �������ݰ������ڴ洢����
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		// 3. ͨ�������receive�������յ������ݴ������ݰ��У�����ʽ������û���ݾ͵ȣ�
		ds.receive(dp);
		
		// 4. ͨ�����ݰ��ķ�����ȡ���е�����
		String ip = dp.getAddress().getHostAddress();
		String data = new String(dp.getData(), 0, dp.getLength());
		int port = dp.getPort();
		
		System.out.println("ip:" + ip);
		System.out.println("data:" + data);
		System.out.println("port:" + port);
		
		// 5. �ر���Դ
		ds.close();
	}
}








