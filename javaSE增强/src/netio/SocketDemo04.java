package netio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 上传文本文件
 * 
 * 作者：ariclee		时间：2016年9月13日下午8:17:56
 */


public class SocketDemo04 {

}


class Client4 {
	public static void main(String[] args) throws Exception {
		String host = "localhost"; // localhost
		int port = 10001;
		Socket client = new Socket(host, port);
		// 读取键盘流对象
		BufferedReader bfr = new BufferedReader(new FileReader("C:\\test\\readme.txt"));
		// 将数据写入服务器的输出流
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		
		String line = null;
		while ((line=bfr.readLine()) != null) {
			System.out.println(line);
			out.println(line);
		}
		
		client.shutdownOutput(); // 通知服务器数据已经写完
		
		// 读取服务端回送的数据
		BufferedReader bufin = new BufferedReader(new InputStreamReader(client.getInputStream()));
		System.out.println("server data --- " + bufin.readLine());
		
		
		client.close(); // 在socket流里面加了结束标记，所以当客户端结束时候，服务器端也跟着结束了
		bfr.close();
	}
}



class Server4 {
	public static void main(String[] args) throws Exception {
		int port = 10001;
		ServerSocket server = new ServerSocket(port);
		// 获取客户端socket对象
		Socket client = server.accept();
		
		String clientip = server.getInetAddress().getHostAddress();
		System.out.println("server: " + clientip + " has connected!");
		
		// 读取文件流
		BufferedReader bufin = new BufferedReader(new InputStreamReader(client.getInputStream()));
		BufferedWriter bufout = new BufferedWriter(new FileWriter("ReaderMeserver.txt"));
		
		String line = null;
		while ((line=bufin.readLine()) != null ) {
			bufout.write(line);
			bufout.newLine();
			bufout.flush();
		}
		
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		out.write("上传成功");
		out.flush();
		
		bufout.close();
		client.close();
		server.close();
	}
}









