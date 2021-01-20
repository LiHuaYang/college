package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class File {
	
	private int fileId;// 文档ID
	private int fileType;// 文档类型
	private int fileBelongId;// 文档所属Id
	private String fileUrl;// 文档路径
	
	public File(){};
	public File(int fileId,int fileType,int fileBelongId,String fileUrl){
		this.fileId=fileId;
		this.fileType=fileType;
		this.fileBelongId=fileBelongId;
		this.fileUrl=fileUrl;
	}
	@Id
	@GeneratedValue
	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	public int getFileBelongId() {
		return fileBelongId;
	}

	public void setFileBelongId(int fileBelongId) {
		this.fileBelongId = fileBelongId;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	@Override
	public String toString() {
		return "File [fileBelongId=" + fileBelongId + ", fileId=" + fileId
				+ ", fileType=" + fileType + ", fileUrl=" + fileUrl + "]";
	}

}
