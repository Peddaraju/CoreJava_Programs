package com.app.programs.executorService;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// this class is to create using locks and conditions
public class MyBlockingQueue<E> {

	private Queue<E> queue;
	private int max = 16;
	
	private ReentrantLock lock = new ReentrantLock(true);
	
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();
	
	public MyBlockingQueue (int size) {
		this.max = size;
		queue = new LinkedList<>();
	}
	
	public void put(E e) {
		lock.lock();   
		try {
			if (queue.size() == max) {
				notFull.await();
			}
			queue.add(e);
			notEmpty.signalAll();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}
	
	public E take() {
		lock.lock();
		try {
			while(queue.size() == 0) {
				notEmpty.await();
			}
			E item = queue.remove();
			notFull.signalAll();
			return item;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return null;
	}
}
