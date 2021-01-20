package com.di_set;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Teacher {

	private int id;
	private Student ss;
	private Long ll;
	private String str;
	private Set set;
	private List list;
	private Map map;
	private Properties pro;
	
	
	
	public Teacher () {
		
	}
	
	public Teacher (int age, String name, Student student) {
		this.id = age;
		this.str = name;
		this.ss = student;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getSs() {
		return ss;
	}
	public void setSs(Student ss) {
		this.ss = ss;
	}
	public Long getLl() {
		return ll;
	}
	public void setLl(Long ll) {
		this.ll = ll;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public Set getSet() {
		return set;
	}
	public void setSet(Set set) {
		this.set = set;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Properties getPro() {
		return pro;
	}
	public void setPro(Properties pro) {
		this.pro = pro;
	}


}
