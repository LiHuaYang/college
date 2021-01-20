package com.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notice {
	private int noticeId;// ����ID
	private String noticeTitle;// �������
	private String noticeContent;// ��������
	private String noticeStartTime;// ���淢��ʱ��
	private int noticeBelongType;// ������������
	private int noticeBelongId;// ��������ID
	private String noticePicture;// ����ͼƬ·��
	
	
	public Notice(){};
	public Notice(String noticeTitle, String noticeContent,int noticeBelongType,int noticeBelongId,String noticePicture){
		this.noticeTitle=noticeTitle;
		this.noticeContent=noticeContent;
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.noticeStartTime=s.format( new Date());
		this.noticePicture=noticePicture;
		this.noticeBelongId=noticeBelongId;
		this.noticeBelongType=noticeBelongType;
	}

	@Id
	@GeneratedValue
	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeStartTime() {
		return noticeStartTime;
	}

	public void setNoticeStartTime(String noticeStartTime) {
		this.noticeStartTime = noticeStartTime;
	}

	public int getNoticeBelongType() {
		return noticeBelongType;
	}

	public void setNoticeBelongType(int noticeBelongType) {
		this.noticeBelongType = noticeBelongType;
	}

	public int getNoticeBelongId() {
		return noticeBelongId;
	}

	public void setNoticeBelongId(int noticeBelongId) {
		this.noticeBelongId = noticeBelongId;
	}

	public String getNoticePicture() {
		return noticePicture;
	}

	public void setNoticePicture(String noticePicture) {
		this.noticePicture = noticePicture;
	}

	@Override
	public String toString() {
		return "Notice [noticeBelongId=" + noticeBelongId
				+ ", noticeBelongType=" + noticeBelongType + ", noticeContent="
				+ noticeContent + ", noticeId=" + noticeId + ", noticePicture="
				+ noticePicture + ", noticeStartTime=" + noticeStartTime
				+ ", noticeTitle=" + noticeTitle + "]";
	}

}
