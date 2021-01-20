package com.yingteman.netty.handler;

import java.sql.SQLException;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yingteman.database.JdbcUtils;
import com.yingteman.database.RedisKeyHelper;
import com.yingteman.netty.message.Message;
import com.yingteman.netty.message.MessageAttach;
import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.request.LoginReqMessageContent;
import com.yingteman.netty.message.response.LoginRespMessageContent;
import redis.clients.jedis.Jedis;

/**
 * 
 * 
 * @author ariclee
 */
class LoginMessageContentHandler implements AbstractMessageContentHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginMessageContentHandler.class);
	private static final QueryRunner runerUpdate = new QueryRunner();
	private static final QueryRunner runerQuery  = new QueryRunner(JdbcUtils.getDataSource());
	private static final RedisKeyHelper helper  = new RedisKeyHelper();
	
	@Override
	public MessageContent process(Message in) {
		logger.debug("收到客户端的登陆请求！");

		LoginReqMessageContent request = (LoginReqMessageContent) in.getContent();

		/* 得到数据库中盒子的激活状态 */
		boolean isActived = checkRecoredState(new String(request.getSbxlh()));
		
		/* 生成不同的响应对象 */
		LoginRespMessageContent response = buildAReponse(isActived);
		
		/* 更新在线列表 */
		updateOnlineRecored(in);
		
		/* TODO 更新密钥库，生成新的密钥 ，保存在 redis 中，将 channelid 与 aespwd 之间做映射 */
//		byte[] aesPwd = RandomUtil.getRandomByte(16); // 获取十六字节的 aes 加密密码
//		// TODO 没有使用 redisPool
//		Jedis redis = new Jedis();
//		redis.set(in.getAttch().getChannelId().getBytes(), aesPwd); // 
//		redis.close();
		
		return response;
	}

	/**
	 * 更新内存数据库中的盒子在线列表
	 * 
	 * key：csidmap:channelid:sbxlh value：sbxlh
	 * @param msg
	 * @author ariclee
	 */
	private void updateOnlineRecored(Message msg) {
		Jedis redis = new Jedis();
		LoginReqMessageContent loginMsg = (LoginReqMessageContent) msg.getContent();
		MessageAttach attch = msg.getAttch();
		
		String sbxlh = new String(loginMsg.getSbxlh());
		String sbxlhKey = helper.getKeyPattern("sbxlhKey").formatWith(attch.getChannelId());
		String channelIdKey = helper.getKeyPattern("channelIdKey").formatWith(sbxlh);
		
		/* 存储 ChannelId */
		redis.set(channelIdKey, attch.getChannelId()); 
		/* 存储设备序列号 */
		redis.set(sbxlhKey, sbxlh); 
		
		redis.close();
	}
	
	/**
	 * 生成响应内容对象
	 * 
	 * @param isActived ： 数据库中盒子的激活状态
	 * @return 响应内容对象
	 * @author ariclee
	 */
	private LoginRespMessageContent buildAReponse(boolean isActived) {
		/* TODO 产生一个默认的登陆响应对象，以后可能要改，是否应该将默认的配置文件持久化 */
		LoginRespMessageContent resp = LoginRespMessageContent.createDefaultMsg();
		byte actived = (byte) (isActived ? 1 : 0);
		resp.setIsActive(actived);
		return resp;
	}
	
	private static final Integer ACTIVED  = 1; // 已经激活
	private static final Integer NOACTIVE = 0; // 没有激活
	
	/**
	 * 核对MySQL的盒子激活状态
	 * 
	 * @param sbXlh ； 设备序列号
	 * @return 激活为真，未激活为假
	 * @author ariclee
	 */
	private boolean checkRecoredState(String sbXlh) {
		String sql = "select activate from box where sn_num=?";
		Object[] param = { sbXlh };

		Map<String, Object> map = null;
		Integer res = null;
		try {
			map = runerQuery.query(sql, new MapHandler(), param);
			res = (Integer) map.get("activate");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res.equals(ACTIVED);
	}
}

