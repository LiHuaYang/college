package com.fenye.domain;

import java.util.List;

public class Page {

	private List pageData; // һҳ������
	private int totalRecord;
	private int pageSize = 10;
	private int totalPage;
	private int currentPage;// ��ǰ����ҳ����Ŀ��ҳ��
	private int startIndex; // ���ݿ��п�ʼ��¼
	private int startPage;  // ҳ������ʾ����ʼҳ��
	private int endPage;    // ҳ������ʾ����ֹҳ��

	public Page(int currentPage, int totalRecord) {
		this.totalRecord = totalRecord;
		this.currentPage = currentPage;

		// 1. ʹ���ܼ�¼�������ҳ��
		totalPage = totalRecord % pageSize == 0 ? 
				totalRecord / pageSize : totalRecord / pageSize + 1;
		// 2. �������ݿ�����ʼ��¼
		this.startIndex = (currentPage - 1) * this.pageSize; 
		
		// 3. ������Ҫ��ʾ����ʼҳ�����ֹҳ��
		if (this.totalPage < 10) {
			this.startPage = 1;
			this.endPage = this.totalPage;
		} else {
			this.startPage = this.currentPage - 4;
			this.endPage = this.currentPage + 5;

			if (this.startPage < 1) { // ��ʼҳ��С��1
				this.startPage = 1;
				this.endPage = 10;
			}
			if (this.endPage > this.totalPage) { // ��ֹҳ��������ҳ��
				this.endPage = this.totalPage;
				this.startPage = this.totalPage - 9;
			}
		}
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

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List getPageData() {
		return pageData;
	}

	public void setPageData(List pageData) {
		this.pageData = pageData;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	@Override
	public String toString() {
		return "QueryResult [pageData=" + pageData + ", totalRecord=" + totalRecord + ", pageSize=" + pageSize
				+ ", totalPage=" + totalPage + ", currentPage=" + currentPage + ", startIndex=" + startIndex + "]";
	}

}

