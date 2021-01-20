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
	 * ����΢�ŷ���������
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		// try {
		// Ĭ�Ϸ��ص��ı���Ϣ����
		String respContent = "�������쳣�����Ժ��ԣ�";
		// xml��������� ������Ϣ������MessageUtil����΢�ŷ�����xml��ʽ����Ϣ�������Ľ������HashMap�
		Map<String, String> requestMap = null;
		try {
			requestMap = MessageUtil.parseXml(request);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ���ͷ��ʺţ�open_id��
		String fromUserName = requestMap.get("FromUserName");
		// �����ʺ�
		String toUserName = requestMap.get("ToUserName");
		// ��Ϣ����
		String msgType = requestMap.get("MsgType");

		// �ظ��ı���Ϣ
		TextMessage_resp textMessage = new TextMessage_resp();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);

		// �ı���Ϣ
		if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
			String text = requestMap.get("Content");
			logger.info("��Ϣ����Ϊ��{}", text);

			lianJies.add(text);
			if (lianJies.size() == 1) {
				respContent = "����Ż�ȯ�ɹ������������Ʒ���ӣ�";
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
		// ͼƬ��Ϣ
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
			respContent = "�����͵���ͼƬ��Ϣ��";
		}
		// ����λ����Ϣ
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
			respContent = "�����͵��ǵ���λ����Ϣ��";
		}
		// ������Ϣ
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
			respContent = "�����͵���������Ϣ��";
		}
		// ��Ƶ��Ϣ
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
			respContent = "�����͵�����Ƶ��Ϣ��";
		} else if (msgType.equals((MessageUtil.REQ_MESSAGE_TYPE_VIDEO))) {
			respContent = "�����͵�����Ƶ��Ϣ��";
		}
		// �¼�����
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
			// �¼�����
			String eventType = requestMap.get("Event");
			// ����
			if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
				respContent = "лл���Ĺ�ע��";
			}
			// ȡ������
			else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
				// TODO ȡ�����ĺ��û����ղ������ںŷ��͵���Ϣ����˲���Ҫ�ظ���Ϣ
			}
			// �Զ���˵�����¼�
			else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
				// TODO �Զ���˵�Ȩû�п��ţ��ݲ����������Ϣ
			}
		}
		textMessage.setContent(respContent);
		respMessage = MessageUtil.textMessageToXml(textMessage);
		return respMessage;
	}
}
