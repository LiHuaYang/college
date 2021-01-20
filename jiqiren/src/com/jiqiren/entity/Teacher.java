package com.jiqiren.entity;

import java.io.Serializable;

/**
 * ¿œ ¶
 * 
 * @author ariclee
 */
public class Teacher implements Serializable {

	private String id;
	private String name;
	private String age;
	private String gradulate;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGradulate() {
		return gradulate;
	}
	public void setGradulate(String gradulate) {
		this.gradulate = gradulate;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", age=" + age + ", gradulate=" + gradulate + "]";
	}
}
