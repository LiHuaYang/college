package com.yingteman.netty.bytebuf;

import com.yingteman.netty.message.MessageConstant;

import io.netty.buffer.ByteBuf;

/************************

+--------+----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+
|  帧标识  |  帧长		|  数据标识	|  消息标识	|  扩展字段	|  业务ID	|  协议号	|  业务数据	|  时间戳	|  校检码	|  帧尾		|
|  5 字节	 |  2 字节  	|  1 字节		|  4 字节		|  4 字节		|  2 字节  	|  1 字节  	|  n 字节	|  4 字节		|  2 字节  	|  4 字节  	|
+--------+----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+
														|--------------业务数据------	--------|
														|------------MessageContent---------|
|--------------------- 帧头 -----------------------------|			            			|---------------- 帧尾 --------------|
|------------------ MessageHeader ----------------------|									|---------- MessageTail ------------|


|---------------------------------------------------------- Message ------------------------------------------------------------|

*************************/

/**
 * 包装类
 *  
 * @author ariclee
 */
public class ByteBufWrapper {

	private ByteBuf byteBuf;
	private short length;  // 帧长，除掉帧标识后的长度

	public ByteBufWrapper(ByteBuf _byteBuf) {
		if (_byteBuf != null) {
			this.byteBuf = _byteBuf.copy(); // 复制一份
			this.byteBuf.markReaderIndex();
			this.length = this.byteBuf.skipBytes(MessageConstant.lengthFieldOffset).readShort();
			this.byteBuf.resetReaderIndex();
		}
	}
	
	/**
	 * 获取业务ID
	 *
	 * @author ariclee
	 */
	public Short getByteMsgContentId() {
		Short yewuid = this.byteBuf.skipBytes(MessageConstant.msgContentOffset).readShort();
		this.byteBuf.resetReaderIndex();
		return yewuid;
	}
	/**
	 * 获取业务内容
	 *
	 * @author ariclee
	 */
	public ByteBuf getByteMsgContent() {
		int length = getByteMsgContentlength();
		ByteBuf bytes = this.byteBuf.skipBytes(MessageConstant.msgContentOffset).readBytes(length);
		this.byteBuf.resetReaderIndex();
		return bytes;
	}
	/**
	 * 获取业务内容的长度
	 *
	 * @author ariclee
	 */
	public int getByteMsgContentlength() {
//		System.out.println("这是业务数据的长度---" + (this.length - MessageConstant.ZHEN_CHANG - MessageConstant.SHU_JU_BIAO_SHI - MessageConstant.XIAO_XI_BIAO_SHI - 
//				MessageConstant.KUO_ZHAN_ZI_DUAN - MessageConstant.SHI_JIAN_CUO - MessageConstant.JIAO_JIAN_MA));
		return this.length - MessageConstant.ZHEN_CHANG - MessageConstant.SHU_JU_BIAO_SHI - MessageConstant.XIAO_XI_BIAO_SHI - 
				MessageConstant.KUO_ZHAN_ZI_DUAN - MessageConstant.SHI_JIAN_CUO - MessageConstant.JIAO_JIAN_MA;
	}
	
	/**
	 * 获取帧标识
	 *
	 * @author ariclee
	 */
	public ByteBuf getByteMsgFrameStart() {
		ByteBuf buf = this.byteBuf.readBytes(MessageConstant.ZHEN_TOU);
		this.byteBuf.resetReaderIndex();
		return buf;
	}
	
	/**
	 * 获取帧尾
	 *
	 * @author ariclee
	 */
	public ByteBuf getByteMsgFrameEnd() {
		ByteBuf buf = this.byteBuf.skipBytes(5 + this.length).readBytes(MessageConstant.ZHEN_WEI);
		this.byteBuf.resetReaderIndex();
		return buf;
	}
}
