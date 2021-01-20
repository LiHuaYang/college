package com.jiqiren.entity;

import java.io.Serializable;
import java.util.List;

/**
 * ��ѯ���
 * 
 * @author ariclee
 */
public class QueryResult {

	private int totalPage; // ��ҳ��
	private int pageSize = 10;  // ҳ����ʾ��¼���� Ĭ��10��
	
	private int totalRecord; // 
	private List<? extends Serializable> pageData; // ��ѯ�����װ	

	private int currentPage; // ��ǰ����ҳ����Ŀ��ҳ��
	
	private int startIndex; // ���ݿ��п�ʼ��¼
	
	private int startPage; // ҳ������ʾ����ʼҳ��
	private int endPage; // ҳ������ʾ����ֹҳ��
	
	
	public QueryResult(int currentPage, int totalRecord) {
		this.totalRecord = totalRecord;
		this.currentPage = currentPage;
		
		if (this.totalRecord % pageSize == 0) {
			this.totalPage = this.totalRecord / pageSize;
		} else {
			this.totalPage = this.totalRecord / pageSize + 1;
		}
		
		this.startIndex = (currentPage - 1) * this.pageSize; // ���ݿ�����ʼ��¼
		
		/**
		 * ������ʼҳ�����ֹҳ��
		 * Ĭ����ʾ 10 ��ҳ��
		 */
		if (this.totalPage < 10) {
			this.startPage = 1;
			this.endPage = this.totalPage;
		} else {
			this.startPage = this.currentPage - 4;
			this.endPage = this.currentPage + 5;
			
			if(this.startPage < 1) { // ��ʼҳ��С��1
				this.startPage = 1;
				this.endPage = 10;
			} 
			if(this.endPage > this.totalPage) { // ��ֹҳ�������ҳ��
				this.endPage = this.totalPage;
				this.startPage = this.totalPage - 9;
			}
		}
	}
	
	
	
	public List<? extends Serializable> getPageData() {
		return pageData;
	}
	public void setPageData(List<? extends Serializable> pageData) {
		this.pageData = pageData;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartIndex() {
		return startIndex;
	}


	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}


	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	@Override
	public String toString() {
		return "QueryResult [totalPage=" + totalPage + ", pageSize=" + pageSize + ", totalRecord=" + totalRecord
				+ ", pageData=" + pageData + "]";
	}
	
}
