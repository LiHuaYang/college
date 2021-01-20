package com.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {
	private int commentId;// 评论ID
	private int userId;// 评论用户ID
	private String commentContent;// 评论内容
	private String commentTime;// 评论时间
	private int noticeId;// 公告ID
	public Comment(){};
	public Comment(int userId,String commentContent,int noticeId){
		this.userId=userId;
		this.commentContent=commentContent;
		this.noticeId=noticeId;
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.commentTime=s.format( new Date());
		
	};
	
	
	
	public HashMap<String,Object> toHashMap(){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("commentId", this.commentId);
		map.put("userId", this.userId);
		map.put("commentContent", this.commentContent);
		map.put("commentTime", this.commentTime);
		map.put("noticeId", this.noticeId);
		return map;
	}
	@Id
	@GeneratedValue
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	

	@Override
	public String toString() {
		return "Comment [commentContent=" + commentContent + ", commentId="
				+ commentId + ", commentTime=" + commentTime + ", noticeId="
				+ noticeId + ", userId=" + userId + "]";
	}

}
