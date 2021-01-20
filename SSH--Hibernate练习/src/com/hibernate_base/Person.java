package com.hibernate_base;

import java.io.Serializable;



/**
 * <p>对象序列化的作用：使对象可以在网络上传输，二进制的形式
 * 
 * <p>Serializable，标识接口
 *
 * <p>作者：ariclee		时间：2016年9月19日下午7:30:45
 */
public class Person implements Serializable {

	private long pid;
	private String name;
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
