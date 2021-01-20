package com.yingteman.database;

import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.dbutils.QueryRunner;
import com.yingteman.netty.message.response.TourReportRespMessageContent;
import com.yingteman.netty.server.OnlineObdDevice;
import io.netty.channel.Channel;


//public static void main(String[] args) {
//	int time = 10 * 60 * 1; // 10 分钟
//	new Timer().schedule(new DBTask().new PersistentTourReportTask1(), 10, time * 1000);
//}
public class PersistentTourReportTask extends TimerTask {
	private static final QueryRunner runerUpdate = new QueryRunner();
	private static final QueryRunner runerQuery  = new QueryRunner(JdbcUtils.getDataSource());
	static ConcurrentHashMap<String, Channel> deviceChannelIdmap = OnlineObdDevice.getOnlineMap();
	
	public PersistentTourReportTask(){}

	public void run() {
		// 拿出需要更新到 MySQL 中的数据
		TourReportRespMessageContent tour = getTourInfo2BePersistent();
		// 更新到 MySQL
		createTourReportToDay(tour);
	}
	
	private TourReportRespMessageContent getTourInfo2BePersistent() {
		return new TourReportRespMessageContent();	
	}

	/**
	 * 在 MySQL 中生成 ChannelId 所对应的盒子所记录的当天的行程记录
	 * 
	 * @author ariclee
	 */
	public void createTourReportToDay(TourReportRespMessageContent tour) {
		String sql = "INSERT INTO table_name('','','') VALUES(?,?,?)";
		
		return ;
	}
}
