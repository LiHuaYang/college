package com.ariclee.test;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.ariclee.main.ShangPing;
import com.ariclee.weixin_codec.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class demo01 {

	private static HttpRequest req; //
	private static Gson gson = new Gson(); //

	public static String getTkl(ShangPing sp, String activityId) throws Exception {
		String _text = URLEncoder.encode(sp.getName(), "utf-8");
		String _logo = URLEncoder.encode(sp.getPicture(), "utf-8");
		;

		String _id = sp.getNum_iid();

		// url=http://uland.taobao.com/coupon/edetail?
		// activityId=9a42c12bb9d149b7bfa0e73c00000cf1& // 需要从优惠券链接中解析出来
		// itemId=538129579780& // 商品ID
		// pid=mm_54813744_18500192_65502047& // 淘宝客PID
		// src=czhk_cztkl //

		String _url = "http://uland.taobao.com/coupon/edetail?activityId=" + activityId + "&itemId=" + _id
				+ "&pid=mm_54813744_18500192_65502047&src=czhk_cztkl";
		String url = URLEncoder.encode(_url, "utf-8");
		;

		String res = req.sendPost("http://tool.chaozhi.hk/api/tb/GetTkl_wx.php",
				"text=" + _text + "&url=" + url + "&logo=" + _logo + "&action=refresh");

		System.out.println("优惠券信息为-----" + res);

		JsonObject json = new Gson().fromJson(res, JsonObject.class);
		String model = json.get("model").getAsString();
		return model;
	}

	// 1. 获取商品信息
	public static ShangPing getShangPingInfo(String shangPingLianJie) {
		String res = req.sendGet("http://tool.chaozhi.hk/api/tb2/GetNumiid_auto.php", "url=" + shangPingLianJie);

		JsonObject json = (JsonObject) gson.fromJson(res, JsonObject.class);
		JsonObject data = json.getAsJsonObject("data");
		JsonObject el = data.getAsJsonObject("item_info");

		ShangPing sp = new ShangPing();
		sp.setName(el.get("title").getAsString());// 纯竹工坊本色手帕纸不漂白纸巾便携式面巾纸小包纸巾抽纸4层60包
		sp.setNum_iid(json.get("num_iid").getAsString());// 538129579780
		sp.setPicture(el.getAsJsonObject("pics").getAsJsonArray("string").get(0).getAsString());// http://img.alicdn.com/bao/uploaded/i3/TB1yCVvOXXXXXadaFXXXXXXXXXX_!!0-item_pic.jpg

		return sp;
	}

	/**
	 * 输入：商品链接 + 优惠券链接
	 * 
	 * 输出：淘口令
	 * 
	 * 处理： 1. 根据商品链接得到商品信息 1.1 商品名字 1.2 商品ID 1.3 商品图片
	 * 
	 * 2. 根据优惠券链接解析出acticityId
	 *
	 *
	 * @author ariclee
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {

		String cookies = "u7j80c11dq375pvv059gfp2g75";
		HttpRequest.setPostCookies(cookies);

		String splj = "https://detail.tmall.com/item.htm?id=540812581993&ali_trackid=2:mm_106948965_14026214_56082041:1478926694_3k2_1451374711&pvid=10_106.114.241.138_36769_1478924447793";
		String yuj = "http://shop.m.taobao.com/shop/coupon.htm?activityId=441599f8058d4d80833e457ae4007e41&sellerId=2448613830";
		ShangPing sp = getShangPingInfo(splj); // 商品信息

		String acticityIdValue = null;

		List<NameValuePair> lists = URLEncodedUtils.parse(new URI(yuj), "utf-8");

		for (Iterator iterator = lists.iterator(); iterator.hasNext();) {
			NameValuePair nameValuePair = (NameValuePair) iterator.next();
			String name = nameValuePair.getName();

			System.out.println();
			if (name.equalsIgnoreCase("activityId")) {
				acticityIdValue = nameValuePair.getValue();
			}
		}

		String tkl = getTkl(sp, acticityIdValue); // 淘口令

		System.out.println(sp);
		System.out.println(tkl);

	}
	
	@Test
	public void test() throws Exception {

		URI uri = new URI("http://tool.chaozhi.hk/wxlink/");
		// user_name=ariclee; user_pass=330683;
		// PHPSESSID=u7j80c11dq375pvv059gfp2g75;
		// CNZZDATA1255591768=1649299090-1478575341-%7C1478946445

		HttpClient client = new DefaultHttpClient();

		HttpUriRequest request = new HttpGet(uri);
		// tt14ad632s9lo158pmn53fs2h2
		request.addHeader("Cookie",
				"user_name=ariclee; user_pass=330683; PHPSESSID=tt14ad632s9lo158pmn53fs2h2; CNZZDATA1255591768=1649299090-1478575341-%7C1479044357");
		HttpResponse response = client.execute(request);

		// response.getStatusLine().getStatusCode()
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			// HttpEntity responseEntity = response.getEntity();
			String html = EntityUtils.toString(response.getEntity(), "utf-8"); // 使用相应编码转换成字符串
			System.out.println("get请求-------" + html);
		}
	}
	
	// http://tool.chaozhi.hk/api/tb2/GetNumiid_auto.php
	// 商品地址：https://s.click.taobao.com/dCvRTOx
	
	// http://tool.chaozhi.hk/api/tb2/GetNumiid_auto.php?url=https://s.click.taobao.com/dCvRTOx
	
	// http://uland.taobao.com/coupon/edetail?activityId=9a42c12bb9d149b7bfa0e73c00000cf1&itemId=538129579780&pid=mm_54813744_18500192_65502047&src=czhk_cztkl"
	
	
	
	// url=http://uland.taobao.com/coupon/edetail?
	// activityId=9a42c12bb9d149b7bfa0e73c00000cf1& // 需要从优惠券链接中解析出来
	// itemId=538129579780& // 商品ID
	// pid=mm_54813744_18500192_65502047& // 淘宝客PID
	// src=czhk_cztkl //
	
	
	@Test
	public void test1() {
		// http://uland.taobao.com/coupon/edetail?
		// activityId=9a42c12bb9d149b7bfa0e73c00000cf1&itemId=538129579780&pid=mm_54813744_18500192_65502047&src=czhk_cztkl
		String postCookies = "u7j80c11dq375pvv059gfp2g75";
		HttpRequest.setPostCookies(postCookies);
		
		// ../../api/tb/GetTkl_wx.php
		// text: a,
//	    url: b,
//	    logo: c,
		// text=纯竹工坊本色手帕纸不漂白纸巾便携式面巾纸小包纸巾抽纸4层60包&url=http://uland.taobao.com/coupon/edetail?activityId=9a42c12bb9d149b7bfa0e73c00000cf1&itemId=538129579780&pid=mm_54813744_18500192_65502047&src=czhk_cztkl&logo=http://img.alicdn.com/bao/uploaded/i3/TB1yCVvOXXXXXadaFXXXXXXXXXX_!!0-item_pic.jpg&action=refresh
		String urlzw = null;
		String urltz = null;
		
		String text = "%E7%BA%AF%E7%AB%B9%E5%B7%A5%E5%9D%8A%E6%9C%AC%E8%89%B2%E6%89%8B%E5%B8%95%E7%BA%B8%E4%B8%8D%E6%BC%82%E7%99%BD%E7%BA%B8%E5%B7%BE%E4%BE%BF%E6%90%BA%E5%BC%8F%E9%9D%A2%E5%B7%BE%E7%BA%B8%E5%B0%8F%E5%8C%85%E7%BA%B8%E5%B7%BE%E6%8A%BD%E7%BA%B84%E5%B1%8260%E5%8C%85";
		String url = "http%3A%2F%2Fuland.taobao.com%2Fcoupon%2Fedetail%3FactivityId%3D9a42c12bb9d149b7bfa0e73c00000cf1%26itemId%3D538129579780%26pid%3Dmm_54813744_18500192_65502047%26src%3Dczhk_cztkl";
		String logo = "http%3A%2F%2Fimg.alicdn.com%2Fbao%2Fuploaded%2Fi1%2FTB1myrROXXXXXcZXpXXXXXXXXXX_!!0-item_pic.jpg_400x400.jpg";
		
		try {
			urlzw = URLEncoder.encode("纯竹工坊本色手帕纸不漂白纸巾便携式面巾纸小包纸巾抽纸4层60包","utf-8");
			urltz = URLEncoder.encode("http://uland.taobao.com/coupon/edetail?activityId=9a42c12bb9d149b7bfa0e73c00000cf1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); //GetTkl_wx.php
		}
		String res = req.sendPost("http://tool.chaozhi.hk/api/tb/GetTkl_wx.php", "text=" + text +"&url=" + url + "&logo=" + logo + "&action=refresh");
		// Cookie:PHPSESSID=7122vaf6d0qk1ldk6g5cfq56m7; CNZZDATA1255591768=303104927-1478575341-%7C1478765261
		// Cookie:PHPSESSID=7122vaf6d0qk1ldk6g5cfq56m7; CNZZDATA1255591768=303104927-1478575341-%7C1478765261
//		System.out.println("res");
		System.out.println(res);
	}
	
	
	/**
	 * 往微信服务器上传图片
	 * 
	 * http请求方式: POST/FORM,需使用https
	 *
	 * url : https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE
	 * 
	 * @author ariclee
	 * @throws Exception 
	 */
	@Test
	public void test2() throws Exception {
		
		String urlPath = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
		URL url = new URL(urlPath);
		URLConnection conn = (URLConnection) url.openConnection();
		OutputStream out = conn.getOutputStream();
		// 
		String name = "http://img.alicdn.com/bao/uploaded/i3/TB1yCVvOXXXXXadaFXXXXXXXXXX_!!0-item_pic.jpg";
 		FileInputStream in = new FileInputStream(name);
		int res = 0;
		
		byte []buf = new byte[1024];
		
		while((res = in.read(buf)) != -1) {
			out.write(buf, 0, res);
		}
		
		out.close();
		in.close();
	}
	
	@Test
	public void test4() throws Exception {
		String url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
//		List<NameValuePair> paras = URLEncodedUtils.parse(url, Charset.forName("UTF-8"));
		
		final URI urlo = new URI(url);
		
		List<NameValuePair> paras = URLEncodedUtils.parse(urlo, "utf-8");

		for (NameValuePair name : paras) {
			System.out.println(name.getName()+ ": " + name.getValue());
		}
	}

}


