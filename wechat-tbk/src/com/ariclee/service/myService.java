package com.ariclee.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariclee.main.ShangPing;
import com.ariclee.weixin_codec.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * 
 * 
 * @author ariclee
 */
public class myService {
	private static HttpRequest req;
	private static Gson gson = new Gson();
	private static final Logger logger = LoggerFactory.getLogger(myService.class);

	/* 请求获取淘口令的地址 */
//	private static final String postUrl = "http://tool.chaozhi.hk/api/tb/GetTkl_wx.php";
	private static final String postUrl = "http://tool.chaozhi.hk/api/tb/GetTkl_wxxx.php";
	/* 请求获取商品信息的地址 */
	private static final String getUrl = "http://tool.chaozhi.hk/api/tb2/GetNumiid_auto.php";
	/* cookie信息 */
	private static String cookies = "665uns9qh62smt0jmb5a55get4";
	
	/**
	 * 对外提供的方法
	 * 
	 * @param list
	 *            存放商品链接和优惠券链接的List
	 * @return 淘口令 + 商品名字 组成的字符串
	 * @throws Exception
	 * @author ariclee
	 */
	public static String service(List<String> list) throws Exception {
		HttpRequest.setPostCookies(cookies);
		String yuj = list.get(0).trim();// 优惠券链接
		String splj = list.get(1).trim();// 商品链接

		ShangPing sp = getShangPingInfo(splj);
		String getActivityId = getActivityId(yuj);
		String tkl = getTkl(sp, getActivityId); // 淘口令
		return "复制这条信息，打开「手机淘宝」即可看到 【" + sp.getName() + "】  " + tkl;
	}
	
	/**
	 * 获取淘口令
	 * 
	 * @param sp
	 *            商品信息
	 * @param activityId
	 *            优惠券的活动id
	 * @return String 淘口令字符串
	 * @throws Exception
	 * @author ariclee
	 * @throws Exception 
	 */
	private static String getTkl(ShangPing sp, String activityId) throws Exception {
		String _text = null;
		String model = null;
		_text = URLEncoder.encode(sp.getName(), "utf-8");

		String _logo = URLEncoder.encode(sp.getPicture(), "utf-8");

		String _id = sp.getNum_iid();

		String _url = "http://uland.taobao.com/coupon/edetail?activityId=" + activityId + "&itemId=" + _id
				+ "&pid=mm_54813744_18500192_65502047&src=czhk_cztkl";
		String url = URLEncoder.encode(_url, "utf-8");

		String res = req.sendPost(postUrl, "text=" + _text + "&url=" + url + "&logo=" + _logo + "&action=refresh");

		JsonObject json = new Gson().fromJson(res, JsonObject.class);
		
//		logger.debug("获取淘口令 -- {}", json);
		System.out.println("获取淘口令 -- " + json);
		model = json.get("model").getAsString();

		return model;
	}

	/**
	 * 根据商品链接，获取商品信息
	 * 
	 * @param shangPingLianJie
	 *            商品链接
	 * @return 商品信息
	 * @author ariclee
	 */
	private static ShangPing getShangPingInfo(String shangPingLianJie) {
		String res = req.sendGet(getUrl, "url=" + shangPingLianJie);

		JsonObject json = (JsonObject) gson.fromJson(res, JsonObject.class);
		JsonObject data = json.getAsJsonObject("data");
		JsonObject el = data.getAsJsonObject("item_info");

		ShangPing sp = new ShangPing();
		sp.setName(el.get("title").getAsString());
		sp.setNum_iid(json.get("num_iid").getAsString());
		sp.setPicture(el.getAsJsonObject("pics").getAsJsonArray("string").get(0).getAsString());

		return sp;
	}
	/**
	 * 
	 * @param youhuiquanlianjie
	 * @return
	 * @author ariclee
	 */
	private static String getActivityId(String youhuiquanlianjie) {
		List<NameValuePair> lists = null;
		String acticityIdValue = null;

		try {
			lists = URLEncodedUtils.parse(new URI(youhuiquanlianjie), "utf-8");
			for (Iterator iterator = lists.iterator(); iterator.hasNext();) {
				NameValuePair nameValuePair = (NameValuePair) iterator.next();
				String name = nameValuePair.getName();
				if (name.equalsIgnoreCase("activity_Id") || name.equalsIgnoreCase("activityId")) {
					acticityIdValue = nameValuePair.getValue();
				}
			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return acticityIdValue;
	}
}
