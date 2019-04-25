package com.app.programs.executorService;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPool_Example {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//create the pool
		ExecutorService service = Executors.newFixedThreadPool(100);
		Runnable task = () -> System.out.println(Thread.currentThread().getName());
		
		/*for(int i=0; i<=1000; i++) {
			service.execute(new Thread(task));
		}*/
		
		for(int i=0; i<=1000; i++) {
			Future<Integer> future = service.submit(new Task1());
			System.out.println(future.get().intValue());
		}
		System.out.println(Thread.currentThread().getName());
	}
	
	static class Task1 implements Callable<Integer>{
		public Integer call () {
			System.out.println("Thread Name:" + Thread.currentThread().getName());
			return new Random().nextInt();
		}
	}
}
