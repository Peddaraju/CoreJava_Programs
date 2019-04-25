package com.app.programs.executorService;

import java.util.Random;
import java.util.concurrent.Callable;

public class Test1 {

	public static void main(String[] args) {
		Thread thread = new Thread(new Task());
		thread.start();
		
		/*Thread thread1 = new Thread(new Task1());
		thread1.start();*/
		
		for(int i = 0; i < 10; i++) {
			new Thread(() -> System.out.println("Thread Name:" + Thread.currentThread().getName())).start();
		}
		
		
		System.out.println();
		System.out.println("Thread Name: " + Thread.currentThread().getName());
		
	}
	
	static class Task implements Runnable{
		public void run () {
			System.out.println("Thread Name:" + Thread.currentThread().getName());
		}
	}
	
	static class Task1 implements Callable<Integer>{
		public Integer call () {
			System.out.println("Thread Name:" + Thread.currentThread().getName());
			return new Random().nextInt();
		}
	}
}
