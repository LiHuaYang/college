package cn.usgame.pay;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;




/**
 * 
 * 微信支付账号密码类
 * 
 *
 * 作者：ariclee		时间：2016年7月6日上午11:24:21
 */
public class WeChatCount  {
	
	private static Properties wechatCount = new Properties();
	
	static {
		InputStream in = WeChatPayIndex.class.getClassLoader().getResourceAsStream("wechat.properties");
		try {
			wechatCount.load(in);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private String appid = wechatCount.getProperty("appid");
	private String mch_id = wechatCount.getProperty("mch_id");
	private String appsecret = wechatCount.getProperty("appsecret");
	private String partnerkey = wechatCount.getProperty("partnerkey");
	private String notify_url = wechatCount.getProperty("notify_url");
	private String trade_type = wechatCount.getProperty("trade_type");
	
	private String nonce_str = "";
	private String body = "";
	private String out_trade_no = "";
	private String spbill_create_ip = "";
	private String money = "";
	private String attach = "";
	
	
	
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public String getAppid() {
		return appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public String getAppsecret() {
		return appsecret;
	}
	public String getPartnerkey() {
		return partnerkey;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	
}
