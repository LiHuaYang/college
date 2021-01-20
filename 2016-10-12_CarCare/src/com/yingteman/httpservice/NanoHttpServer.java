package com.yingteman.httpservice;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.ServerRunner;
import io.netty.channel.EventLoopGroup;

/**
 * 功能一：注销盒子
 * 
 * 功能二：修改配置文件
 * 
 * http://localhost:10001?xlh=969490001316&opt=unbind
 * 
 * @author ariclee
 */
public class NanoHttpServer extends NanoHTTPD {
	private static final Logger logger = LoggerFactory.getLogger(NanoHttpServer.class);
	private EventLoopGroup eventLoopGroup = null;
	
	public NanoHttpServer() {
		super(10001);
	}
	
	public void start(EventLoopGroup eventLoopGroup) {
		this.eventLoopGroup = eventLoopGroup;
		ServerRunner.run(NanoHttpServer.class);
	}
	
	@Override
	public Response serve(IHTTPSession session) {
		NanoRequest request = new NanoRequest(session);
		dispatchService(request).doService(); // 执行业务操作
		Response response = new Response("Hello i am Nano");
		return response;
	}
	
	
	/**
	 * 给 Web 端提供的服务类型
	 */
	private static final String OPT_MODIFY= "modify";
	private static final String OPT_UNBIND = "unbind";
	
	private HttpService dispatchService(NanoRequest request) {
		HttpService service = null;
		String xlh = request.xlh;
		String opt = request.opt;
		
		if(opt.equalsIgnoreCase(OPT_MODIFY)) {
			service = new CfgService(eventLoopGroup, xlh, request.column);
			
		} else if (opt.equalsIgnoreCase(OPT_UNBIND)) {
//			service = new UnBindService(eventLoopGroup, xlh);
		}
		return service;
	}
	private class NanoRequest {
		public String xlh; // xuliehao
		public String opt; // caozuo
		public String column; // lieming
		
		public NanoRequest(IHTTPSession session) {
			this.xlh = getParamter(session, PARA_XLH);
			this.opt = getParamter(session, PARA_OPT);
			this.column = getParamter(session, PARA_COL);
		}
		@Override
		public String toString() {
			return "NanoRequest [xlh=" + xlh + ", opt=" + opt + ", column=" + column + "]";
		}
	}
	
	private static final String PARA_XLH = "xlh";
	private static final String PARA_OPT = "opt";
	private static final String PARA_COL = "col";
	
	/**
	 * 获取指定 key 的值
	 * 
	 * @param session
	 * @param key
	 * @return 参数value
	 * @author ariclee
	 */
	private String getParamter(IHTTPSession session, String key) {
		String uri = session.getUri();
		String filename = uri.substring(uri.lastIndexOf("/") + 1); // 取出文件名
		if (filename.equals("favicon.ico")) {
			return null;
		}
		Map<String, String> parms = session.getParms();
		String xlh = parms.get(key); // obd 盒子的序列号
		return xlh;
	}
}






