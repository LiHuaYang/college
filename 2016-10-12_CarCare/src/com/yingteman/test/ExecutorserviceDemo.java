package com.yingteman.test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorserviceDemo {

	
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		pool.execute(null);
	}
}
