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
 * 登陆定时任务
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
	 * 只执行一次
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		int time = 10 * 60 *2; // 20 分钟
		new Timer().schedule(new LoginTask(), 10, time * 1000);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestFacade rep = null;
		
		ServletRequest ss = null;
		 // 微信加密签名  
        String signature = request.getParameter("signature");  
        // 时间戳  
        String timestamp = request.getParameter("timestamp");  
        // 随机数  
        String nonce = request.getParameter("nonce");  
        // 随机字符串  
        String echostr = request.getParameter("echostr");  
  
        PrintWriter out = response.getWriter();  
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
            out.print(echostr);  
        }  
        out.close();  
        out = null;  
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException{
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
  
        // 调用核心业务类接收消息、处理消息  
        String respMessage = CoreService.processRequest(request);  
          
        // 响应消息  
        PrintWriter out = response.getWriter();  
        out.print(respMessage);  
        out.close();  
	}
}


