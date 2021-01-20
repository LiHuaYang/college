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
 ���󣺽���һ���ı�ת����������
�ͻ��˸�����˷����ı������񵥻Ὣ�ı�ת�ɴ�д�ڷ��ظ��ͻ��ˡ�
���ҿͻ��ȿ��Բ��ϵĽ����ı�ת�������ͻ�������overʱ��ת��������

������
�ͻ��ˣ�
��Ȼ�ǲ����豸�ϵ����ݣ���ô�Ϳ���ʹ��io������������io�Ĳ���������˼����
Դ������¼�롣
Ŀ�ģ������豸�������������
���Ҳ��������ı����ݡ�����ѡ���ַ�����

����
1����������
2����ȡ����¼�롣
3�������ݷ�������ˡ�
4����ȥ����˷��صĴ�д���ݡ�
5������������Դ��

�����ı����ݣ�����ʹ���ַ������в�����ͬʱ���Ч�ʣ����뻺�塣
*/

/**
 * �ͻ��˺ͷ������˶�������ʽ�ķ���
 *
 * ���ߣ�ariclee		ʱ�䣺2016��9��13������8:17:56
 */


public class SocketDemo03 {

}


class Client3 {
	public static void main(String[] args) throws Exception {
		
		String host = "192.168.1.154";
		int port = 10001;
		Socket client = new Socket(host, port);
		// ��ȡ����������
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		// ������д��������������
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
			out.println(line.toUpperCase()); // �Զ�ˢ�»���
			
			System.out.println("client---" + bfrin.readLine());
		}
		// ��ȡ����������������
		
		client.close(); // ��socket��������˽�����ǣ����Ե��ͻ��˽���ʱ�򣬷�������Ҳ���Ž�����
		bfr.close();
	}
}



class Server3 {
	public static void main(String[] args) throws Exception {
		int port = 10001;
		ServerSocket server = new ServerSocket(port);
		
		// ��ȡ�ͻ���socket����
		Socket client = server.accept();
		
		String clientip = server.getInetAddress().getHostAddress();
		System.out.println("server: " + clientip + " has connected!");
		// ��ȡ�ͻ��˵������
		BufferedReader bfr = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		// 
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream())); 
		
		String line = null;
		while ((line=bfr.readLine()) != null) {
			// ������ת����д��ĸ�Ժ󣬻��͸��ͻ���
			bfw.write(line.toUpperCase());
			bfw.newLine();
			bfw.flush();
		}
		
		client.close();
		server.close();
	}
}









