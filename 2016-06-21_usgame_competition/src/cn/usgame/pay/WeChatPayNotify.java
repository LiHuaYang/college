package cn.usgame.pay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.usgame.entity.Applyorder;
import cn.usgame.service.CompetitionService;
import cn.usgame.service.ServiceFactory;
import cn.usgame.utils.WebUtils;

/**
 * 
 * 微信支付回调通知
 * 
 *
 * 作者：ariclee 时间：2016年7月6日上午11:24:21
 */
@WebServlet("/WeChatPayNotify")
public class WeChatPayNotify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private CompetitionService comService = ServiceFactory.getInstance().getProgramManage(); 

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream()));

		response.setContentType("text/xml"); 
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		Map<String, String> hashMap = null;
		try {
			hashMap = WebUtils.doXMLParse(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Applyorder applyOrder = new Applyorder(hashMap);
		
		boolean result = comService.userPay(applyOrder);
		
		System.out.println("WeChatPayNotify----"+result);
		
//		if (hashMap.get("result_code").toString().equalsIgnoreCase("SUCCESS")) {
//			
//			response.getWriter().write(setXML("SUCCESS", "")); // 告诉微信服务器，我收到信息了，不要在调用回调action了
//		}
		
	}

	public static String setXML(String return_code, String return_msg) {
		return "<xml><return_code><![CDATA[" + return_code + "]]></return_code><return_msg><![CDATA[" + return_msg
				+ "]]></return_msg></xml>";
	}
}
