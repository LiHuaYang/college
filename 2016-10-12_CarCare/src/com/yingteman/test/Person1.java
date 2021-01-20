package com.yingteman.test;

public class Person1 implements Work {

	private Person2 p2 ;
	
	public Person1(Person2 p2) {
		this.p2 = p2;
	}

	public void askSomeOneDoSomeThing() {
		 this.p2.helpSomeOneDoSomeThing(this, "这是任务附件参数！");
	}
	
	@Override
	public void dosomeThing(String msg) {
		System.out.println("回送的消息是：" + msg);
	}
	
	public static void main(String[] args) {
		Person2 p2 = new Person2(); 
		Person1 p1 = new Person1(p2);
		
		p1.askSomeOneDoSomeThing();
	}
}
