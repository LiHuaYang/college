package com.yingteman.netty.bytebuf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;

/**
 * 
 * 
 * @time 2016年11月17日
 * @author ariclee
 */
public class ByteBufTools {

	private ByteBufTools(){}
	private static final ByteBufTools tool = new ByteBufTools();
	
	private static final Logger logger = LoggerFactory.getLogger(ByteBufTools.class);
	
	public static final ByteBufTools getInstance() {
		return tool;
	}
	
	public static String byte2hex(byte[] buffer) {
		String h = "";

		for (int i = 0; i < buffer.length; i++) {
			String temp = Integer.toHexString(buffer[i] & 0xFF);
			if (temp.length() == 1) {
				temp = "0" + temp;
			}
			h = h + " " + temp;
		}
		return h;
	}

	public static byte[] hexString2Bytes(String src) {
		int l = src.length() / 2;
		byte[] ret = new byte[l];
		for (int i = 0; i < l; i++) {
			ret[i] = (byte) Integer.valueOf(src.substring(i * 2, i * 2 + 2), 16).byteValue();
		}
		return ret;
	}

	public static void printMsg(ByteBuf byteBuf) {
		byteBuf.markReaderIndex();
		int length = byteBuf.capacity() - 22;
		
		logger.info("============================================================================");
		
		logger.info("当前执行线程名 【" + Thread.currentThread().getName() + "】" + "当前可读字节数--" + byteBuf.readableBytes() );
		
		logger.info("当前执行线程名 【" + Thread.currentThread().getName() + "】" + "数据标识--" + ByteBufUtil.hexDump(byteBuf.readBytes(1)));
		logger.info("当前执行线程名 【" + Thread.currentThread().getName() + "】" + "消息标识--" + ByteBufUtil.hexDump(byteBuf.readBytes(4)));
		logger.info("当前执行线程名 【" + Thread.currentThread().getName() + "】" + "扩展字段--" + ByteBufUtil.hexDump(byteBuf.readBytes(4)));
		
		// 业务数据开始
		logger.info("当前执行线程名 【" + Thread.currentThread().getName() + "】" + "业务ID--" + ByteBufUtil.hexDump(byteBuf.readBytes(2).array())); // 0002
		logger.info("当前执行线程名 【" + Thread.currentThread().getName() + "】" + "协议号--" + ByteBufUtil.hexDump(byteBuf.readBytes(1).array())); // 01
		logger.info("当前执行线程名 【" + Thread.currentThread().getName() + "】" + "业务数据--" + ByteBufUtil.hexDump(byteBuf.readBytes(length).array())); // 01
		// 业务数据结束
		
		logger.info("当前执行线程名 【" + Thread.currentThread().getName() + "】" + "时间戳--" + ByteBufUtil.hexDump(byteBuf.readBytes(4).array())); // 01
		logger.info("当前执行线程名 【" + Thread.currentThread().getName() + "】" + "校验码--" + ByteBufUtil.hexDump(byteBuf.readBytes(2).array())); // 01
		logger.info("当前执行线程名 【" + Thread.currentThread().getName() + "】" + "帧尾--" + ByteBufUtil.hexDump(byteBuf.readBytes(4).array())); // 01
		logger.info("当前执行线程名 【" + Thread.currentThread().getName() + "】" + "当前可读字节数--" + byteBuf.readableBytes());
		
		logger.info("============================================================================");

		byteBuf.resetReaderIndex();
	}
	
    /** 
     * 16进制字符串转换为字符串 
     *  
     * @param s 
     * @return 
     */  
    public static String hexStringToString(String s) {  
        if (s == null || s.equals("")) {  
            return null;  
        }  
        s = s.replace(" ", "");  
        byte[] baKeyword = new byte[s.length() / 2];  
        for (int i = 0; i < baKeyword.length; i++) {  
            try {  
                baKeyword[i] = (byte) (0xff & Integer.parseInt(  
                        s.substring(i * 2, i * 2 + 2), 16));  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        try {  
            s = new String(baKeyword, "gbk");  
            new String();  
        } catch (Exception e1) {  
            e1.printStackTrace();  
        }  
        return s;  
    } 
    
    /**
     *
     * @author ariclee
     */
    public static String byteBuf2HexString(ByteBuf byteBuf) {
    	return ByteBufUtil.hexDump(byteBuf);
    }
	
}
