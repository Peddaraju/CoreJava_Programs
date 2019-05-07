package com.app.programs.executorService;

import java.lang.Thread.UncaughtExceptionHandler;

class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("An exception has been captured\n");
		System.out.printf("Thread: %s\n", t.getId());
		System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
		System.out.printf("Stack Trace: \n");
		e.printStackTrace(System.out);
		System.out.printf("Thread status: %s\n", t.getState());
		//new Thread(new Task()).start();

	}
}

class Task implements Runnable {
	@Override
	public void run() {
		Thread.currentThread().setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println(Integer.parseInt("123"));
		System.out.println(Integer.parseInt("234"));
		System.out.println(Integer.parseInt("345"));
		System.out.println(Integer.parseInt("XYZ")); // This will cause NumberFormatException
		System.out.println(Integer.parseInt("456"));
	}
}

public class ExceptionDemoThreadExample {

	public static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.start();
	}
}
