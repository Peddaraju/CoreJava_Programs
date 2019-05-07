package com.app.programs.executorService;

public class YieldProblem {

	public static void main(String[] args) throws InterruptedException {
		
		Runnable producer = () -> {
			for(int i=0; i<=5; i++) {
				System.out.println("I am a Producer: Produced Items:"+i);
				//Thread.yield();
			}
		};
		
		Runnable consumer = () -> {
			for(int i = 0; i<=5; i++) {
				System.out.println("I am a Consumer: Consumed Items:"+i);
				//Thread.yield();
			}
		};
		
		Thread t1 = new Thread(producer, "Producer");
		Thread t2 = new Thread(consumer, "Consumer");
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		//t1.join();
		
		t2.start();
		
	}
	
	
	
	
}
