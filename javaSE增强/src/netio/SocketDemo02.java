package netio;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemo02 {

}


class Client2 {
	public static void main(String[] args) throws Exception {
		
		String host = "192.168.1.154";
		int port = 10001;
		Socket client = new Socket(host, port);
		
		// 为了发送数据，应该获取socket流中的输出流
		OutputStream out = client.getOutputStream();
		out.write("hello server!!!".getBytes());
		
		//  
		InputStream in = client.getInputStream();
		byte[] buf = new byte[1024];
		in.read(buf); // 阻塞式方法，若是没有收到服务端的回送数据，则会一直等待
		System.out.println(new String(buf, 0, buf.length));
		
		client.close();
	}
}



class Server2 {
	public static void main(String[] args) throws Exception {
		int port = 10001;
		ServerSocket server = new ServerSocket(port);
		
		Socket client = server.accept();
		InputStream in = client.getInputStream(); // 获取输入流

		byte[] buf = new byte[1024];
		int len = in.read(buf);
		
		System.out.println(new String(buf, 0, buf.length));
		
		OutputStream out = client.getOutputStream();
		out.write("ni hao client!!".getBytes());
		
		client.close();
		server.close();
	}
}









