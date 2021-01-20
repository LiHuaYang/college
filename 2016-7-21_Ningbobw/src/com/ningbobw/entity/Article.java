package com.ningbobw.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/*
 * 
 */
public class Article {

	private String id; 
	private int board_id;
	private String title ;
	private String source;
	private String introduce;
	private String content; 
	private String attach; // 文章附件地址
	private String time;   // 文章生成时间
	
	public Article(int board_id, String title, String source, String introduce, String content,
			String attach) {
		super();
		this.board_id = board_id;
		this.title = title;
		this.source = source;
		this.introduce = introduce;
		this.content = content;
		this.attach = attach;
		this.time = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
	}
	public Article(){}
	
	


	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", board_id=" + board_id + ", title=" + title + ", source=" + source + ", introduce="
				+ introduce + ", content=" + content + ", attach=" + attach + ", time=" + time + "]";
	}
	public void setTime(String time) {
		this.time = time;
	}
}
