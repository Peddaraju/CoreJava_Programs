package com.app.programs.executorService;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable {
	private final List<Integer> taskQueue;
	private final int MAX_CAPACITY;

	public Producer(List<Integer> sharedQueue, int size) {
		this.taskQueue = sharedQueue;
		this.MAX_CAPACITY = size;
	}

	@Override
	public void run() {
		int counter = 0;
		while (true) {
			try {
				produce(counter++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	private void produce(int counter) throws InterruptedException {
		synchronized (taskQueue) {
			while (taskQueue.size() == MAX_CAPACITY) {
				System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
	            taskQueue.wait();
			}
			Thread.sleep(1000);
			taskQueue.add(counter);
			System.out.println("Produced: " + counter);
			taskQueue.notifyAll();
		}
	}
}

class Consumer implements Runnable {

	private final List<Integer> taskQueue;

	public Consumer(List<Integer> sharedQueue) {
		this.taskQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException {
		synchronized (taskQueue) {
			while (taskQueue.isEmpty()) {
				System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
	            taskQueue.wait();
			}
			Thread.sleep(1000);
			System.out.println("Consumed:" + taskQueue.remove(0));
			taskQueue.notifyAll();
		}
	}
}

public class ProducerConsumerProblem2 {

	public static void main(String[] args) {
		List<Integer> queue = new ArrayList<>();
		Thread t1 = new Thread(new Producer(queue, 5), "Producer");
		Thread t2 = new Thread(new Consumer(queue), "Consumer");
		t1.start();
		t2.start();
	}

}
