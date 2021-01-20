package com.ariclee.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ariclee.message_response.TextMessage_resp;
import com.ariclee.weixin_codec.MessageUtil;

public class CoreService {
	private static final Logger logger = LoggerFactory.getLogger(CoreService.class);
	private static List<String> lianJies = new ArrayList<>();

	public static void setLianJies(List<String> lianJies) {
		CoreService.lianJies = lianJies;
	}

	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		// try {
		// 默认返回的文本消息内容
		String respContent = "请求处理异常，请稍候尝试！";
		// xml请求解析。 调用消息工具类MessageUtil解析微信发来的xml格式的消息，解析的结果放在HashMap里；
		Map<String, String> requestMap = null;
		try {
			requestMap = MessageUtil.parseXml(request);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");

		// 回复文本消息
		TextMessage_resp textMessage = new TextMessage_resp();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);

		// 文本消息
		if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
			String text = requestMap.get("Content");
			logger.info("消息内容为：{}", text);

			lianJies.add(text);
			if (lianJies.size() == 1) {
				respContent = "添加优惠券成功！请再添加商品链接！";
			}

			if (lianJies.size() == 2) {
				try {
					respContent = myService.service(lianJies);
					
				} catch (Exception e) {
					lianJies.clear();
					e.printStackTrace();
				}
				logger.info(respContent);
				lianJies.clear();
			}
		}
		// 图片消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
			respContent = "您发送的是图片消息！";
		}
		// 地理位置消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
			respContent = "您发送的是地理位置消息！";
		}
		// 链接消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
			respContent = "您发送的是链接消息！";
		}
		// 音频消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
			respContent = "您发送的是音频消息！";
		} else if (msgType.equals((MessageUtil.REQ_MESSAGE_TYPE_VIDEO))) {
			respContent = "您发送的是视频消息！";
		}
		// 事件推送
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
			// 事件类型
			String eventType = requestMap.get("Event");
			// 订阅
			if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
				respContent = "谢谢您的关注！";
			}
			// 取消订阅
			else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
				// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
			}
			// 自定义菜单点击事件
			else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
				// TODO 自定义菜单权没有开放，暂不处理该类消息
			}
		}
		textMessage.setContent(respContent);
		respMessage = MessageUtil.textMessageToXml(textMessage);
		return respMessage;
	}
}
