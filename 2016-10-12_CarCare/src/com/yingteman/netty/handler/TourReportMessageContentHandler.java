package com.yingteman.netty.handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yingteman.database.JdbcUtils;
import com.yingteman.database.RedisKeyHelper;
import com.yingteman.netty.message.Message;
import com.yingteman.netty.message.MessageContent;
import com.yingteman.netty.message.MessageType;
import com.yingteman.netty.message.request.TourReportReqMessageContent;
import com.yingteman.netty.message.response.TourReportRespMessageContent;
import redis.clients.jedis.Jedis;

/**
 * 
 * 
 * @author ariclee
 */
class TourReportMessageContentHandler implements AbstractMessageContentHandler {
	private static final Logger logger = LoggerFactory.getLogger(TourReportMessageContentHandler.class);
	private static final QueryRunner runerUpdate = new QueryRunner();
	private static final QueryRunner runerQuery = new QueryRunner(JdbcUtils.getDataSource());
	private static final SimpleDateFormat formate = new SimpleDateFormat("yyyyMMdd");
	private static final RedisKeyHelper helper = new RedisKeyHelper();

	@Override
	public MessageContent process(Message in) {
		TourReportReqMessageContent report = (TourReportReqMessageContent) in.getContent();
		Jedis redis = new Jedis();// TODO 没有使用 redisPool
		String channelId = in.getAttch().getChannelId();

		// 更新 redis 里面的数据
		/**
		 * 一人一天有很多次的更新 key，Channelid + 日期
		 * 
		 * 每次都是新建记录，不是覆盖记录
		 */
		String time = formate.format(new Date(System.currentTimeMillis())); // 取出当前日期
		String mapkey = "xcmap:?:" + time; // 第一个? 代表 channelId

		String xuhao = report.getKaishiXinChengXuHao() + "";

		// 0. 拿到各个字段在 redis 中存储的 key
		String kaiShiBiaoJiWeiKey = helper.getKeyPattern("kaiShiBiaoJiWei").formatWith(xuhao);
		String kaishiXinChengXuHaoKey = helper.getKeyPattern("kaishiXinChengXuHao").formatWith(xuhao);
		String kaiShiShiJianKey = helper.getKeyPattern("kaiShiShiJian").formatWith(xuhao);
		String jieShuBiaoJiWeiKey = helper.getKeyPattern("jieShuBiaoJiWei").formatWith(xuhao);
		String jieShuXingChengXuHaoKey = helper.getKeyPattern("jieShuXingChengXuHao").formatWith(xuhao);
		String jieShuShiJianKey = helper.getKeyPattern("jieShuShiJian").formatWith(xuhao);
		String kaiShiJingDuKey = helper.getKeyPattern("kaiShiJingDu").formatWith(xuhao);
		String kaiShiWeiDuKey = helper.getKeyPattern("kaiShiWeiDu").formatWith(xuhao);
		String jieShuJingDuKey = helper.getKeyPattern("jieShuJingDu").formatWith(xuhao);
		String jieShuWeiDuKey = helper.getKeyPattern("jieShuWeiDu").formatWith(xuhao);
		String liChengKey = helper.getKeyPattern("liCheng").formatWith(xuhao);
		String youHaoKey = helper.getKeyPattern("youHao").formatWith(xuhao);

		// 1. 设置值，如果不存在则创建，所有值都使用字符串形式来存放
		Map<String, String> map = new HashMap<>();
		map.put(kaiShiBiaoJiWeiKey, report.getKaiShiBiaoJiWei() + "");
		map.put(kaishiXinChengXuHaoKey, report.getKaishiXinChengXuHao() + "");
		map.put(kaiShiShiJianKey, report.getKaiShiShiJian() + "");
		map.put(jieShuBiaoJiWeiKey, report.getJieShuBiaoJiWei() + "");
		map.put(jieShuXingChengXuHaoKey, report.getJieShuXingChengXuHao() + "");
		map.put(jieShuShiJianKey, report.getJieShuShiJian() + "");
		map.put(kaiShiJingDuKey, report.getKaiShiJingDu() + "");
		map.put(kaiShiWeiDuKey, report.getKaiShiWeiDu() + "");
		map.put(jieShuJingDuKey, report.getJieShuJingDu() + "");
		map.put(jieShuWeiDuKey, report.getJieShuWeiDu() + "");
		map.put(liChengKey, report.getLiCheng() + "");
		map.put(youHaoKey, report.getYouHao() + "");
		redis.hmset(mapkey.replace("?", channelId), map);

		// 2. 构造响应对象
		TourReportRespMessageContent response = new TourReportRespMessageContent();
		response.setYeWuId(MessageType.MESSAGE_LOGIN_RESP.value()); // 业务ID
		response.setXieYiHao((byte) 1); // 协议号

		response.setXingChengBiaoZhi(report.getKaiShiBiaoJiWei());
		response.setXingChengXuHao(report.getKaishiXinChengXuHao()); // 行程序号
		response.setJieGuo((byte) 1);
		return response;
	}

}

/**
 * 取出所有的值，写入 MySQL，怎么对应 MySQL 中名字？
 * 
 * 怎么得到MySQL的主键。每次都是新建吗？但是坐标点写入的时候，怎么确定盒子 ID
 * 
 * @param args
 * @author ariclee
 */
// public static void main(String[] args) {
// Jedis jedis = new Jedis();
// String mapkey = "xcmap:?:" + "20161220"; // 第一个? 代表 channelId
// Set<String> keySet = jedis.hkeys(mapkey);
//
// for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
// String string = (String) iterator.next();
// System.out.println(string);
// }

// Map<String, String> res = jedis.hgetAll(mapkey.replace("?",
// "005056c000080000-08fc-00000002-bdc42fbf42f2ac04-d2c4e8df")); //return
// Map<String,String>
// for (Entry entry : res.entrySet()) {
// System.out.println("key ---------- " + entry.getKey());
// System.out.println("val -- " + entry.getValue());
// }
// jedis.close();
// init();
// }



//private static void init() {
//	Jedis jedis = new Jedis();
//	TourReportReqMessageContent report = TourReportReqMessageContent.createDefaultReqMsg();
//
//	String time = formate.format(new Date(System.currentTimeMillis()));
//	String mapkey = "xcmap:?:" + "20161220"; // 第一个? 代表 channelId
//
//	String xuhao = "23456";
//
//	String kaiShiBiaoJiWeiKey = helper.getKeyPattern("kaiShiBiaoJiWei").formatWith(xuhao);
//	String kaishiXinChengXuHaoKey = helper.getKeyPattern("kaishiXinChengXuHao").formatWith(xuhao);
//	String kaiShiShiJianKey = helper.getKeyPattern("kaiShiShiJian").formatWith(xuhao);
//	String jieShuBiaoJiWeiKey = helper.getKeyPattern("jieShuBiaoJiWei").formatWith(xuhao);
//	String jieShuXingChengXuHaoKey = helper.getKeyPattern("jieShuXingChengXuHao").formatWith(xuhao);
//	String jieShuShiJianKey = helper.getKeyPattern("jieShuShiJian").formatWith(xuhao);
//	String kaiShiJingDuKey = helper.getKeyPattern("kaiShiJingDu").formatWith(xuhao);
//	String kaiShiWeiDuKey = helper.getKeyPattern("kaiShiWeiDu").formatWith(xuhao);
//	String jieShuJingDuKey = helper.getKeyPattern("jieShuJingDu").formatWith(xuhao);
//	String jieShuWeiDuKey = helper.getKeyPattern("jieShuWeiDu").formatWith(xuhao);
//	String liChengKey = helper.getKeyPattern("liCheng").formatWith(xuhao);
//	String youHaoKey = helper.getKeyPattern("youHao").formatWith(xuhao);
//
//	// 1. 设置值，如果不存在则创建，所有值都使用字符串形式来存放
//	Map<String, String> map = new HashMap<>();
//	map.put(kaiShiBiaoJiWeiKey, report.getKaiShiBiaoJiWei() + "");
//	map.put(kaishiXinChengXuHaoKey, report.getKaishiXinChengXuHao() + "");
//	map.put(kaiShiShiJianKey, report.getKaiShiShiJian() + "");
//	map.put(jieShuBiaoJiWeiKey, report.getJieShuBiaoJiWei() + "");
//	map.put(jieShuXingChengXuHaoKey, report.getJieShuXingChengXuHao() + "");
//	map.put(jieShuShiJianKey, report.getJieShuShiJian() + "");
//	map.put(kaiShiJingDuKey, report.getKaiShiJingDu() + "");
//	map.put(kaiShiWeiDuKey, report.getKaiShiWeiDu() + "");
//	map.put(jieShuJingDuKey, report.getJieShuJingDu() + "");
//	map.put(jieShuWeiDuKey, report.getJieShuWeiDu() + "");
//	map.put(liChengKey, report.getLiCheng() + "");
//	map.put(youHaoKey, report.getYouHao() + "");
//	jedis.hmset(mapkey.replace("?", "005056c000080000-08fc-00000002-bdc42fbf42f2ac04-d2c4e8df"), map);
//
//	jedis.close();
//}
