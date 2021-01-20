package com.fenye.domain;

import java.util.List;

public class Page {

	private List pageData; // 一页的数据
	private int totalRecord;
	private int pageSize = 10;
	private int totalPage;
	private int currentPage;// 当前请求页数，目标页数
	private int startIndex; // 数据库中开始记录
	private int startPage;  // 页面上显示的起始页码
	private int endPage;    // 页面上显示的终止页码

	public Page(int currentPage, int totalRecord) {
		this.totalRecord = totalRecord;
		this.currentPage = currentPage;

		// 1. 使用总记录数算出总页数
		totalPage = totalRecord % pageSize == 0 ? 
				totalRecord / pageSize : totalRecord / pageSize + 1;
		// 2. 计算数据库中起始记录
		this.startIndex = (currentPage - 1) * this.pageSize; 
		
		// 3. 计算需要显示的起始页码和终止页码
		if (this.totalPage < 10) {
			this.startPage = 1;
			this.endPage = this.totalPage;
		} else {
			this.startPage = this.currentPage - 4;
			this.endPage = this.currentPage + 5;

			if (this.startPage < 1) { // 起始页码小于1
				this.startPage = 1;
				this.endPage = 10;
			}
			if (this.endPage > this.totalPage) { // 终止页数大于总页数
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

