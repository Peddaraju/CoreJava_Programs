package com.app.programs.executorService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		//BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
		
		MyBlockingQueue2<String> queue = new MyBlockingQueue2(10);
		//producer
		final Runnable producer = () -> {
				System.out.println("Produced Prema:" +queue.put("prema"));
		};
		
		new Thread(producer).start();
		new Thread(producer).start();
		
		//consumer
		
		final Runnable consumer = () -> {
			String str = null;
			try {
				str = queue.take();
				System.out.println("Consumed:"+str);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		
		new Thread(consumer).start();
		new Thread(consumer).start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
