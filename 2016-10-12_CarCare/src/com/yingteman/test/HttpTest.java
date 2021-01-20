package com.yingteman.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.yingteman.database.JdbcUtils;
import com.yingteman.httpservice.HttpRequest;
import com.yingteman.netty.message.Message;
import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.MessageHeader;
import com.yingteman.netty.message.MessageTail;
import com.yingteman.netty.message.response.CfgXiaFaMessageContent;

public class HttpTest {
	
	private static final QueryRunner runerUpdate = new QueryRunner();
	private static final QueryRunner runerQuery  = new QueryRunner(JdbcUtils.getDataSource());
	
	
	// http://localhost:10001?xlh=969490001316&opt=unbind
	public static void main(String[] args) {
		String url = "http://localhost:10001";
		String param = "xlh=969490001316&opt=unbind";
		Object response = HttpRequest.sendGet(url, param);
		System.out.println(response.toString());
	}
	@org.junit.Test
	public void test1() {
		// 1. 发送 HTTP 请求
		String url = "http://localhost:10001";
		String param = "xlh=969490001316&opt=modify&col=heart_cycle";
		Object response = HttpRequest.sendGet(url, param);
		// 2. 
	}
	
	@org.junit.Test
	public void test2() {
		String column = "heart_cycle";
		String xlh = "969490001316";
		String sql = "select " + column + " as item from box where sn_num=?";
		CfgXiaFaMessageContent boxContent = null;
		Object[] param = {xlh};
		try {
			boxContent = runerQuery.query(sql, param,new BeanHandler<>(CfgXiaFaMessageContent.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 组装消息
		MessageHeader header = new MessageHeader();
		MessageContent messageContent = boxContent.setId(column);
		Message message = new Message(header,messageContent , new MessageTail(), null);
		System.out.println(message);
	}
	
}
