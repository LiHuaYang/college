package cn.usgame.pay;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * 
 * 微信支付
 * 
 *
 * 作者：ariclee		时间：2016年7月6日上午11:24:21
 */
@WebServlet("/WeChatPayIndex")
public class WeChatPayIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * 1. 请求微信获取用户的openid
	 * 
	 * 2. 用算法生成sign签名
	 * 
	 * 3. 组装数据发送
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String out_trade_no = request.getParameter("out_trade_no");
		String money = request.getParameter("money");
		
		String backCallUrl = URLEncoder.encode("http://aric.tunnel.qydev.com/2016-06-21_usgame_competition/WeChatPayMain?money="+money+"&out_trade_no="+out_trade_no);
				
		
		// 1. 请求微信获取用户的openid
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" + 
				"appid=" + new WeChatCount().getAppid() +
				"&redirect_uri=" + backCallUrl + 
				"&response_type=code"+ 
				"&scope=snsapi_userinfo"+ 
				"&state=123#wechat_redirect";
		 // 
		response.sendRedirect(url);
	}
}
