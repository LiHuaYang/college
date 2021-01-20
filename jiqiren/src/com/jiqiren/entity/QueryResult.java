package com.jiqiren.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 查询结果
 * 
 * @author ariclee
 */
public class QueryResult {

	private int totalPage; // 总页数
	private int pageSize = 10;  // 页面显示记录数， 默认10条
	
	private int totalRecord; // 
	private List<? extends Serializable> pageData; // 查询结果封装	

	private int currentPage; // 当前请求页数，目标页数
	
	private int startIndex; // 数据库中开始记录
	
	private int startPage; // 页面上显示的起始页码
	private int endPage; // 页面上显示的终止页码
	
	
	public QueryResult(int currentPage, int totalRecord) {
		this.totalRecord = totalRecord;
		this.currentPage = currentPage;
		
		if (this.totalRecord % pageSize == 0) {
			this.totalPage = this.totalRecord / pageSize;
		} else {
			this.totalPage = this.totalRecord / pageSize + 1;
		}
		
		this.startIndex = (currentPage - 1) * this.pageSize; // 数据库中起始记录
		
		/**
		 * 构造起始页码和终止页码
		 * 默认显示 10 个页码
		 */
		if (this.totalPage < 10) {
			this.startPage = 1;
			this.endPage = this.totalPage;
		} else {
			this.startPage = this.currentPage - 4;
			this.endPage = this.currentPage + 5;
			
			if(this.startPage < 1) { // 起始页码小于1
				this.startPage = 1;
				this.endPage = 10;
			} 
			if(this.endPage > this.totalPage) { // 终止页面大于总页数
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
