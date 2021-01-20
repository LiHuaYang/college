package com.ariclee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.RequestFacade;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariclee.service.CoreService;
import com.ariclee.weixin_codec.SignUtil;

/**
 * ��½��ʱ����
 * 
 * @author ariclee
 */
class LoginTask extends TimerTask {
	private static String cookie = "user_name=ariclee; user_pass=330683; PHPSESSID=665uns9qh62smt0jmb5a55get4; UM_distinctid=15ab8169dff18f-077af8311fdedc-514f291e-100200-15ab8169e009c; CNZZDATA1255591768=1649299090-1478575341-%7C1489142474";
	private static final Logger logger = LoggerFactory.getLogger(LoginTask.class);
	
	public void run() {
		URI uri = null;
		try {
			uri = new URI("http://tool.chaozhi.hk/wxlink/");
			CloseableHttpClient client = HttpClients.createDefault();
			HttpUriRequest request = new HttpGet(uri);
			request.addHeader("Cookie", cookie);
			HttpResponse response = client.execute(request);

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				logger.info("login success!");
			}

		} catch (Exception e) {
			logger.error(e.toString());
		}
	}
}


@WebServlet("/wiXinServlet")
public class wiXinServlet extends HttpServlet {
	private static final long serialVersionUID = 4440739483644821986L;  
	
	/**
	 * ִֻ��һ��
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		int time = 10 * 60 *2; // 20 ����
		new Timer().schedule(new LoginTask(), 10, time * 1000);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestFacade rep = null;
		
		ServletRequest ss = null;
		 // ΢�ż���ǩ��  
        String signature = request.getParameter("signature");  
        // ʱ���  
        String timestamp = request.getParameter("timestamp");  
        // �����  
        String nonce = request.getParameter("nonce");  
        // ����ַ���  
        String echostr = request.getParameter("echostr");  
  
        PrintWriter out = response.getWriter();  
        // ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
            out.print(echostr);  
        }  
        out.close();  
        out = null;  
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException{
		// ��������Ӧ�ı��������ΪUTF-8����ֹ�������룩  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
  
        // ���ú���ҵ���������Ϣ��������Ϣ  
        String respMessage = CoreService.processRequest(request);  
          
        // ��Ӧ��Ϣ  
        PrintWriter out = response.getWriter();  
        out.print(respMessage);  
        out.close();  
	}
}


