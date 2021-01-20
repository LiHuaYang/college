package cn.usgame.pay;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import com.google.gson.JsonObject;
import cn.usgame.utils.HttpClientConnectionManager;
import cn.usgame.utils.SHA1;
import cn.usgame.utils.WebUtils;

@WebServlet("/WeChatPayMain2")
public class WeChatPayMain2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/******************************************************************************************************/
		String out_trade_no = request.getParameter("out_trade_no");
		int money = Integer.parseInt(request.getParameter("money"));
		money = money * 100;

		// 初始化支付相关参数
		WeChatCount count = initWeChatCount("比赛报名费用", request.getRemoteAddr(), "1", out_trade_no);
		/******************************************************************************************************/
		
		
		/******************************************************************************************************/
		// 获取用于得到openid的code，并组装请求地址
		String code = request.getParameter("code");

		String getOpenIdUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + count.getAppid() + "&secret="
				+ count.getAppsecret() + "&code=" + code + "&grant_type=authorization_code";
		// 发送HTTP请求，获取 openid
		JsonObject jsonObject = WebUtils.httpsRequest(getOpenIdUrl, "GET", null);
		String openid = jsonObject.get("openid").getAsString();
		/******************************************************************************************************/		
		
		
		/******************************************************************************************************/
		// 创建数据签名，得到sign
		String sign = createSign(count, openid);
		/******************************************************************************************************/

		
		/******************************************************************************************************/
		// 组建xml形式字符串
		String xml = "<xml>" + "<appid>" + count.getAppid() + "</appid>" +
				"<body>" + count.getBody() + "</body>" + "<mch_id>" + count.getMch_id() + "</mch_id>" + "<nonce_str>"
				+ count.getNonce_str() + "</nonce_str>" + "<notify_url>" + count.getNotify_url() + "</notify_url>"
				+ "<openid>" + openid + "</openid>" + "<out_trade_no>" + count.getOut_trade_no() + "</out_trade_no>"
				+ "<spbill_create_ip>" + count.getSpbill_create_ip() + "</spbill_create_ip>" + "<total_fee>"
				+ count.getMoney() + "</total_fee>" + "<trade_type>" + count.getTrade_type() + "</trade_type>"
				+ "<sign>" + sign + "</sign>" + "</xml>";

		String prepay_id = this.getPayNo("https://api.mch.weixin.qq.com/pay/unifiedorder", xml);
		/******************************************************************************************************/
		
		
		/******************************************************************************************************/
		SortedMap<String, String> finalpackage = new TreeMap<String, String>();
		String timeStamp = WebUtils.getTimeStamp();
		finalpackage.put("appId", count.getAppid());
		finalpackage.put("timeStamp", timeStamp);
		finalpackage.put("nonceStr", count.getNonce_str());
		finalpackage.put("package", "prepay_id=" + prepay_id);
		finalpackage.put("signType", "MD5");

		String finalsign = WebUtils.createSign(finalpackage, count.getPartnerkey());
		/******************************************************************************************************/
		
		/******************************************************************************************************/
		/**
		 * 1. 获取access_token
		 * 
		 * 2. 获取jsapi_ticket
		 */
		String ticket = getToken(count.getAppid(), count.getAppsecret(), count.getTrade_type());

		String str = "jsapi_ticket=" + ticket + "&noncestr=" + count.getNonce_str() + "&timeStamp=" + timeStamp
				+ "&url=" + "http://aric.tunnel.qydev.com/2016-06-21_usgame_competition/wechat/pay.jsp";

		// 对字符串进行签名
		String signature = new SHA1().getDigestOfString(str.getBytes());
		/******************************************************************************************************/
		
		
		/******************************************************************************************************/
		// 回送数据给页面
		String url = "http://aric.tunnel.qydev.com/2016-06-21_usgame_competition/wechat/pay.jsp?appId="
				+ count.getAppid() + "&timestamp=" + timeStamp + "&nonceStr=" + count.getNonce_str() + "&package="
				+ "prepay_id=" + prepay_id + "&paySign=" + finalsign + "&signature=" + signature;

		response.sendRedirect(url);
		/******************************************************************************************************/
	}


	private WeChatCount initWeChatCount(String body, String ip, String money, String out_trade_no) {
		WeChatCount count = new WeChatCount();
		count.setBody(body);
		count.setNonce_str(WebUtils.getCurrTime() + WebUtils.buildRandom(4));

		count.setOut_trade_no(out_trade_no); //
		// count.setAttach(count.getOut_trade_no());
		count.setSpbill_create_ip(ip);
		count.setMoney(money);
		return count;
	}

	private String createSign(WeChatCount count, String openid) {

		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", count.getAppid());//
		packageParams.put("mch_id", count.getMch_id());//
		packageParams.put("nonce_str", count.getNonce_str());//
		packageParams.put("body", count.getBody()); // 商品主体//
		// packageParams.put("attach", "附加信息");
		packageParams.put("out_trade_no", count.getOut_trade_no()); // 订单编号//

		packageParams.put("total_fee", count.getMoney());//
		packageParams.put("spbill_create_ip", count.getSpbill_create_ip());//
		packageParams.put("notify_url", count.getNotify_url());//

		packageParams.put("trade_type", count.getTrade_type());//
		packageParams.put("openid", openid);//

		// 创建签名
		String sign = WebUtils.createSign(packageParams, count.getPartnerkey());

		return sign;
	}

	public static String getPayNo(String url, String xmlParam) {

		DefaultHttpClient httpclient = new DefaultHttpClient();

		httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient);

		DefaultHttpClient client = new DefaultHttpClient();
		client.getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);
		HttpPost httpost = HttpClientConnectionManager.getPostMethod(url);
		String prepay_id = "";
		try {
			httpost.setEntity(new StringEntity(xmlParam, "UTF-8"));
			HttpResponse response = httpclient.execute(httpost);
			String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");

			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (jsonStr.indexOf("FAIL") != -1) {
				return prepay_id;
			}
			Map<String, String> map = WebUtils.doXMLParse(jsonStr);

			for (Entry<String, String> entry : map.entrySet()) {
				System.out.println("WeChatPayMain--getPayNo--key--" + entry.getKey());
				System.out.println("WeChatPayMain--getPayNo--value--" + entry.getValue());
			}
			// String return_code = (String) map.get("return_code");
			prepay_id = (String) map.get("prepay_id");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prepay_id;
	}

	public static String getToken(String appid, String appsecret, String trade_type) {
		String httpUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid
				+ "&secret=" + appsecret;
		JsonObject jsonObject = WebUtils.httpsRequest(httpUrl, "GET", null);
		String ticket = "";

		if (null != jsonObject) {
			String ticketAccess = jsonObject.get("access_token").getAsString();
			String ticketUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + ticketAccess
					+ "&type=" + trade_type;
			JsonObject jsonObjectTicket = WebUtils.httpsRequest(ticketUrl, "GET", null);
			ticket = jsonObjectTicket.get("ticket").getAsString();
			return ticket;
		}
		return ticket;
	}

}
