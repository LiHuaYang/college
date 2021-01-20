package demo;

import java.io.OutputStream;
import java.net.Socket;


public class SocketClient {
	public static void main(String[] args) throws Exception {
		
//		String host = "192.168.1.154";
		String host = "localhost";
		int port = 8080;
		Socket client = new Socket(host, port);
		
		OutputStream out = client.getOutputStream();
		
		out.write("你好，世界！".getBytes());
		client.close();
		
//		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}



