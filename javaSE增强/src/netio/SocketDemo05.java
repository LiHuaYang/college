package netio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.FileLockInterruptionException;

/**
 * �ϴ�ͼƬ
 * 
 * ���ߣ�ariclee		ʱ�䣺2016��9��13������8:17:56
 */


public class SocketDemo05 {

}


class Client5 {
	public static void main(String[] args) throws Exception {
		String host = "localhost"; // localhost
		int port = 10001;
		Socket client = new Socket(host, port);
		
		// ��ȡ���ص�ͼƬ�ļ�
		FileInputStream picin = new FileInputStream("C:\\test\\silme.jpeg");
		FileOutputStream out = (FileOutputStream)client.getOutputStream();
		
		
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len=picin.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		client.shutdownOutput();
		
		// ��ȡ���������͵�����
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		System.out.println("server -- " + reader.readLine());

		picin.close();
		client.close(); // ��socket��������˽�����ǣ����Ե��ͻ��˽���ʱ�򣬷�������Ҳ���Ž�����
	}
}



class Server5 {
	public static void main(String[] args) throws Exception {
		int port = 10001;
		ServerSocket server = new ServerSocket(port);
		// ��ȡ�ͻ���socket����
		Socket client = server.accept();
		
		String clientip = server.getInetAddress().getHostAddress();
		System.out.println("server: " + clientip + " has connected!");
		
		FileInputStream in = (FileInputStream)client.getInputStream();
		FileOutputStream out = new FileOutputStream("C:\\test\\silmesilme.jpeg");
		
		int len = 0;
		byte[] buf = new byte[1024];
		
		while ((len=in.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		
		// ��������
		BufferedWriter bufw  = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		bufw.write("�ϴ�ͼƬ�ɹ�");
		bufw.flush();
		
		out.close();
		client.close();
	}
}









