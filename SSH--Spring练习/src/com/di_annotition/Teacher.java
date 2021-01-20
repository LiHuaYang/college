package com.di_annotition;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

public class Teacher {

	private int id;

	@Resource(name="student_annotition")
	private Student ss;
	
	private Long ll;
	private String str;
	private Set set;
	private List list;
	private Map map;
	private Properties pro;
	
	
	
	public Teacher () {
		System.out.println("Teacher Default Constructor!");
	}
	
	public Teacher (int age, String name, Student student) {
		this.id = age;
		this.str = name;
		this.ss = student;
	}
	
	


}
