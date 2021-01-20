package com.yingteman.test;
import java.util.concurrent.Executors;

public class Person2 {

	public void helpSomeOneDoSomeThing(final Work work, String paras) {

		Executors.newFixedThreadPool(10).execute(new Runnable() {
			public void run() {
				int count = 100;
				 // 为了能看出效果 ，让当前线程阻塞5秒  
				System.out.println( Thread.currentThread().getName() + "拼命的在干活");

				try {  
                    Thread.sleep(1000);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  

				work.dosomeThing("word done!!!");
			}
		});
	}
}

class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("person2 拼命的在干活");

		try {  
            Thread.sleep(2000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }
		
	}
}