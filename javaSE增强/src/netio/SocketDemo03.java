package netio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 
 需求：建立一个文本转换服务器。
客户端给服务端发送文本，服务单会将文本转成大写在返回给客户端。
而且客户度可以不断的进行文本转换。当客户端输入over时，转换结束。

分析：
客户端：
既然是操作设备上的数据，那么就可以使用io技术，并按照io的操作规律来思考。
源：键盘录入。
目的：网络设备，网络输出流。
而且操作的是文本数据。可以选择字符流。

步骤
1，建立服务。
2，获取键盘录入。
3，将数据发给服务端。
4，后去服务端返回的大写数据。
5，结束，关资源。

都是文本数据，可以使用字符流进行操作，同时提高效率，加入缓冲。
*/

/**
 * 客户端和服务器端都有阻塞式的方法
 *
 * 作者：ariclee		时间：2016年9月13日下午8:17:56
 */


public class SocketDemo03 {

}


class Client3 {
	public static void main(String[] args) throws Exception {
		
		String host = "192.168.1.154";
		int port = 10001;
		Socket client = new Socket(host, port);
		// 读取键盘流对象
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		// 将数据写入服务器的输出流
//		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		PrintWriter out = new PrintWriter(client.getOutputStream());
		
		BufferedReader bfrin = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String line = null;
		
		while ((line=bfr.readLine()) != null) {
			if (line.equalsIgnoreCase("over")) {
				break;
			}
//			bfw.write(line);
//			bfw.newLine();
//			bfw.flush();
			out.println(line.toUpperCase()); // 自动刷新缓存
			
			System.out.println("client---" + bfrin.readLine());
		}
		// 获取服务器回送流对象
		
		client.close(); // 在socket流里面加了结束标记，所以当客户端结束时候，服务器端也跟着结束了
		bfr.close();
	}
}



class Server3 {
	public static void main(String[] args) throws Exception {
		int port = 10001;
		ServerSocket server = new ServerSocket(port);
		
		// 获取客户端socket对象
		Socket client = server.accept();
		
		String clientip = server.getInetAddress().getHostAddress();
		System.out.println("server: " + clientip + " has connected!");
		// 获取客户端的输出流
		BufferedReader bfr = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		// 
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream())); 
		
		String line = null;
		while ((line=bfr.readLine()) != null) {
			// 将数据转化大写字母以后，回送给客户端
			bfw.write(line.toUpperCase());
			bfw.newLine();
			bfw.flush();
		}
		
		client.close();
		server.close();
	}
}









