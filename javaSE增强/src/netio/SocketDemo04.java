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
 * �ϴ��ı��ļ�
 * 
 * ���ߣ�ariclee		ʱ�䣺2016��9��13������8:17:56
 */


public class SocketDemo04 {

}


class Client4 {
	public static void main(String[] args) throws Exception {
		String host = "localhost"; // localhost
		int port = 10001;
		Socket client = new Socket(host, port);
		// ��ȡ����������
		BufferedReader bfr = new BufferedReader(new FileReader("C:\\test\\readme.txt"));
		// ������д��������������
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		
		String line = null;
		while ((line=bfr.readLine()) != null) {
			System.out.println(line);
			out.println(line);
		}
		
		client.shutdownOutput(); // ֪ͨ�����������Ѿ�д��
		
		// ��ȡ����˻��͵�����
		BufferedReader bufin = new BufferedReader(new InputStreamReader(client.getInputStream()));
		System.out.println("server data --- " + bufin.readLine());
		
		
		client.close(); // ��socket��������˽�����ǣ����Ե��ͻ��˽���ʱ�򣬷�������Ҳ���Ž�����
		bfr.close();
	}
}



class Server4 {
	public static void main(String[] args) throws Exception {
		int port = 10001;
		ServerSocket server = new ServerSocket(port);
		// ��ȡ�ͻ���socket����
		Socket client = server.accept();
		
		String clientip = server.getInetAddress().getHostAddress();
		System.out.println("server: " + clientip + " has connected!");
		
		// ��ȡ�ļ���
		BufferedReader bufin = new BufferedReader(new InputStreamReader(client.getInputStream()));
		BufferedWriter bufout = new BufferedWriter(new FileWriter("ReaderMeserver.txt"));
		
		String line = null;
		while ((line=bufin.readLine()) != null ) {
			bufout.write(line);
			bufout.newLine();
			bufout.flush();
		}
		
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		out.write("�ϴ��ɹ�");
		out.flush();
		
		bufout.close();
		client.close();
		server.close();
	}
}









