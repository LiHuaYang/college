package com.Bll.ChatHandle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Chat {
	private int CreateId;
	private int ReciverId;
	private String Content;
	private int chatbelongType;//0个人，1社团，2组织
	private long chatTime;
	
	public Chat(int CreateId,int ReciverId,String Content,int chatbelongType){
		this.CreateId=CreateId;
		this.ReciverId=ReciverId;
		this.Content=Content;
		this.chatbelongType=chatbelongType;
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		this.chatTime = Long.parseLong(simpleDateFormat.format(date));
		//this.chatTime=chattime;
	}

	public int getCreateId() {
		return CreateId;
	}

	public int getReciverId() {
		return ReciverId;
	}

	public String getContent() {
		return Content;
	}

	public int getChatbelongType() {
		return chatbelongType;
	}

	public long getChatTime() {
		return chatTime;
	}
	@Override
	public String toString() {
		return "Chat [Content=" + Content + ", CreateId=" + CreateId
				+ ", ReciverId=" + ReciverId + ", chatTime=" + chatTime
				+ ", chatbelongType=" + chatbelongType + "]";
	}

}
