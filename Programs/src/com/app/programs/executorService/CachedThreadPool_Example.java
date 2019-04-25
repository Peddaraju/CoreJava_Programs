package com.app.programs.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool_Example {

	public static void main(String[] args) {
		
		//create the pool
		ExecutorService service = Executors.newCachedThreadPool();
		
		Runnable task = () -> System.out.println(Thread.currentThread().getName());
		
		for(int i=0; i<=1000; i++) {
			System.out.println("Task:"+i);
			service.execute(new Thread(task));
		}
		
		System.out.println(Thread.currentThread().getName());
		
		if (!service.isTerminated()) {
			System.out.println("going to shoutdown");
			service.shutdown();
		}
	}
}
