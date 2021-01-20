package com.yingteman.httpservice;

import org.apache.commons.dbutils.QueryRunner;

import com.yingteman.database.JdbcUtils;
import com.yingteman.netty.message.Message;

import io.netty.channel.EventLoopGroup;

public class UnBindService extends HttpService {
	private static final QueryRunner runerUpdate = new QueryRunner();
	private static final QueryRunner runerQuery  = new QueryRunner(JdbcUtils.getDataSource());
	
	private String xlh; 
	
	public UnBindService(EventLoopGroup eventLoopGroup, String xlh) {
		super(eventLoopGroup, xlh);
		this.xlh = xlh;
	}
	
	@Override
	protected Message service() {
		// 根据指定的盒子序列号，读取数据库中的最新配置文件
		
		// 更新 Redis 中的数据
		
		// 组装消息
		return null;
	}
}
