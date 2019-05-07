package com.app.programs.executorService;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// this class is to create using wait and notify
public class MyBlockingQueue2<E> {

	private Queue<E> queue;
	private int max = 16;

	private ReentrantLock lock = new ReentrantLock(true);

	private Object notEmpty = new Object();
	private Object notFull = new Object();

	public MyBlockingQueue2(int size) {
		this.max = size;
		queue = new LinkedList<>();
	}

	public synchronized boolean put(E e) {
		if (queue.size() == max) {
			try {
				notFull.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		queue.add(e);
		notEmpty.notifyAll();
		return true;
	}

	public synchronized E take() {
		try {
			while (queue.size() == 0) {
				notEmpty.wait();
			}
			E item = queue.remove();
			notFull.notifyAll();
			return item;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return null;
	}
}
