package netio;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemo01 {

}


class Client {
	public static void main(String[] args) throws Exception {
		
//		String host = "192.168.1.154";
		String host = "localhost";
		int port = 8080;
		Socket client = new Socket(host, port);
		
		
		// 为了发送数据，应该获取socket流中的输出流
		OutputStream out = client.getOutputStream();
		out.write(null);
		client.close();
	}
}



class Server {
	public static void main(String[] args) throws Exception {
		int port = 10001;
		ServerSocket server = new ServerSocket(port);
		
		Socket client = server.accept();
		InputStream in = client.getInputStream();

		DataInputStream datain = new DataInputStream(in);
		
		System.out.println(datain.readByte());
//		System.out.println(datain.readInt());
		
//		byte[] buf = new byte[1024];
//		int len = in.read(buf);
//		System.out.println(new String(buf, 0, buf.length));
		client.close();
		server.close();
	}
}









