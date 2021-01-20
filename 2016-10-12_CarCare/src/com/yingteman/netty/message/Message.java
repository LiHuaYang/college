package com.yingteman.netty.message;


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
 * 整个消息实体，包含三部分，具体看上图。请求消息和响应消息共用。<br>
 * 
 * 请求消息：消息从客户端发送，服务器接收<br>
 * 响应消息：消息从服务器发送，客户端接收<br>
 * 
 * 
 * @see com.yingteman.netty.message Message
 * @see com.yingteman.netty.message MessageHeader
 * @see com.yingteman.netty.message MessageContent
 * @see com.yingteman.netty.message MessageTail
 * @see com.yingteman.netty.message MessageAttach
 *  
 * @author ariclee
 */
public class Message {
	
	private MessageHeader header;
	private MessageContent content;
	private MessageTail tail;
	
	private MessageAttach attch;

	public Message(MessageHeader header, MessageContent content, MessageTail tail, MessageAttach attach) {
		this.header = header;
		this.content = content;
		this.tail = tail;
		this.attch = attach;
	}

	public MessageHeader getHeader() {
		return header;
	}

	public MessageAttach getAttch() {
		return attch;
	}

	public void setAttch(MessageAttach attch) {
		this.attch = attch;
	}

	public void setHeader(MessageHeader header) {
		this.header = header;
	}

	public MessageContent getContent() {
		return content;
	}

	public void setContent(MessageContent content) {
		this.content = content;
	}
	
	public MessageTail getTail() {
		return tail;
	}

	public void setTail(MessageTail tail) {
		this.tail = tail;
	}

	@Override
	public String toString() {
		return "Message [header=" + header + ", content=" + content + ", tail=" + tail + "]";
	}
}
