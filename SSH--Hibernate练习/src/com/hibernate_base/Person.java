package com.hibernate_base;

import java.io.Serializable;



/**
 * <p>�������л������ã�ʹ��������������ϴ��䣬�����Ƶ���ʽ
 * 
 * <p>Serializable����ʶ�ӿ�
 *
 * <p>���ߣ�ariclee		ʱ�䣺2016��9��19������7:30:45
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
