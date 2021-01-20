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

	/* �����ȡ�Կ���ĵ�ַ */
//	private static final String postUrl = "http://tool.chaozhi.hk/api/tb/GetTkl_wx.php";
	private static final String postUrl = "http://tool.chaozhi.hk/api/tb/GetTkl_wxxx.php";
	/* �����ȡ��Ʒ��Ϣ�ĵ�ַ */
	private static final String getUrl = "http://tool.chaozhi.hk/api/tb2/GetNumiid_auto.php";
	/* cookie��Ϣ */
	private static String cookies = "665uns9qh62smt0jmb5a55get4";
	
	/**
	 * �����ṩ�ķ���
	 * 
	 * @param list
	 *            �����Ʒ���Ӻ��Ż�ȯ���ӵ�List
	 * @return �Կ��� + ��Ʒ���� ��ɵ��ַ���
	 * @throws Exception
	 * @author ariclee
	 */
	public static String service(List<String> list) throws Exception {
		HttpRequest.setPostCookies(cookies);
		String yuj = list.get(0).trim();// �Ż�ȯ����
		String splj = list.get(1).trim();// ��Ʒ����

		ShangPing sp = getShangPingInfo(splj);
		String getActivityId = getActivityId(yuj);
		String tkl = getTkl(sp, getActivityId); // �Կ���
		return "����������Ϣ���򿪡��ֻ��Ա������ɿ��� ��" + sp.getName() + "��  " + tkl;
	}
	
	/**
	 * ��ȡ�Կ���
	 * 
	 * @param sp
	 *            ��Ʒ��Ϣ
	 * @param activityId
	 *            �Ż�ȯ�Ļid
	 * @return String �Կ����ַ���
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
		
//		logger.debug("��ȡ�Կ��� -- {}", json);
		System.out.println("��ȡ�Կ��� -- " + json);
		model = json.get("model").getAsString();

		return model;
	}

	/**
	 * ������Ʒ���ӣ���ȡ��Ʒ��Ϣ
	 * 
	 * @param shangPingLianJie
	 *            ��Ʒ����
	 * @return ��Ʒ��Ϣ
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
