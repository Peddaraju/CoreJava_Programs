package com.app.programs.executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ProducerConsumerProblem1 {
	private static final List<Integer> queue = new ArrayList();

	public static void main(String[] args) {
		Runnable producer = () -> {
			int counter = 0;
			while(true) {
				synchronized (queue) {
					while(queue.size() == 5) {
						System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + queue.size());
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					queue.add(counter++);
					System.out.println("Produced:" +counter);
					queue.notifyAll();
					Thread.yield();
				}
			}
		};
		
		Runnable consumer = () -> {
			while(true) {
				synchronized (queue) {
					while(queue.isEmpty()) {
						System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + queue.size());
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					Integer val = queue.remove(0);
					System.out.println("Consumed:"+val);
					queue.notifyAll();
				}
			}
		};
		
		new Thread(producer).start();
		new Thread(consumer).start();
	}

}
