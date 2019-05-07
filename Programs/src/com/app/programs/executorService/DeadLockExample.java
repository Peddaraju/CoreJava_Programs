package com.app.programs.executorService;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class DeadLockExample {

	public static void main(String[] args) {
		final Object obj1 = new Object();
		final Object obj2 = new Object();
		
		Runnable thread1 = () -> {
			synchronized (obj1) {
				try {
					TimeUnit.MICROSECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				synchronized (obj2) {
					System.out.println("In block 1");
				}
				
			}
		};
		
		Runnable thread2 = () -> {
			synchronized (obj2) {
				synchronized (obj1) {
					System.out.println("In Block 2");
				}
			}
		};
		
		new Thread(thread1).start();
		new Thread(thread2).start();
	}
}
