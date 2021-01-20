package com.yingteman.httpservice;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yingteman.database.JdbcUtils;
import com.yingteman.netty.message.Message;
import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.MessageHeader;
import com.yingteman.netty.message.MessageTail;
import com.yingteman.netty.message.response.CfgXiaFaMessageContent;

import io.netty.channel.EventLoopGroup;


public class CfgService extends HttpService {
	private static final QueryRunner runerUpdate = new QueryRunner();
	private static final QueryRunner runerQuery  = new QueryRunner(JdbcUtils.getDataSource());
	private static final Logger logger = LoggerFactory.getLogger(CfgService.class);
	
	private String xlh; 
	private String column;
	
	public CfgService(EventLoopGroup eventLoopGroup, String xlh, String column) {
		super(eventLoopGroup, xlh);
		this.xlh = xlh;
		this.column = column;
	}

	@Override
	protected Message service() {
		// 根据指定的盒子序列号，读取数据库中的最新配置文件
		String sql = "select " + this.column + " as item from box where sn_num=?";
		CfgXiaFaMessageContent boxContent = null;
		Object[] param = {this.xlh};
		try {
			boxContent = runerQuery.query(sql, param, new BeanHandler<>(CfgXiaFaMessageContent.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		logger.debug("数据库操作验证 -- {}", boxContent.toString());
		
		// 组装消息
		MessageHeader header = buildRespHeader();
		MessageTail tail = buildRespTail();
		MessageContent messageContent = boxContent.setId(column);
		Message message = new Message(header, messageContent, tail, null);
		
		return message;
	}
	
	/**
	 * 消息长度
	 */
	private static final short MESSAGELENGTH = 3 + 17 + 2;
	
	/**
	 * 创建一个响应消息头
	 * @param yewuid
	 * @return 响应消息头
	 * @author ariclee
	 */
	private MessageHeader buildRespHeader() {
		MessageHeader header = new MessageHeader();
		int kuoZhangZiDuan = 0;
		header.setKuoZhangZiDuan(kuoZhangZiDuan);
		byte shuJuBiaoShi = 1;
		header.setShuJuBiaoShi(shuJuBiaoShi);
		int xiaoXiBiaoShi = 3;
		header.setXiaoXiBiaoShi(xiaoXiBiaoShi);
		
		header.setZhenChang(MESSAGELENGTH);
		
		return header;
	}
	
	/**
	 * 创建一个响应消息尾部
	 * @return 响应消息尾
	 * @author ariclee
	 */
	private MessageTail buildRespTail() {
		MessageTail tail = new MessageTail();
		short jiaoJianMa = 31861;
		tail.setJiaoJianMa(jiaoJianMa);
		int shiJianCuo = 1448617161;
		tail.setShiJianCuo(shiJianCuo);
		
		return tail;
	}
}