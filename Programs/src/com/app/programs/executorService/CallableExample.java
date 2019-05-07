package com.app.programs.executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class FactorialCalaculator implements Callable<Integer> {
	
	private Integer number;
	
	public FactorialCalaculator(Integer number) {
		this.number = number;
	}
	
	@Override
	public Integer call() throws Exception {
		int result = 1;
		if (number == 0 || number == 1) {
			System.out.println("Result for number - " + number + " -> " + result);
			return result;
		} else {
			for(int i = 2; i<=number; i++) {
				result *=i;
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Result for number - " + number + " -> " + result);
				
			}
			return result;
		}
	}
}
 
public class CallableExample {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		List<Future<Integer>> resultList = new ArrayList<>();
		
		Random random = new Random();
		
		for(int i=0; i<4; i++) {
			Integer number = random.nextInt(10);
			FactorialCalaculator cal = new FactorialCalaculator(number);
			Future<Integer> result = executor.submit(cal);
			resultList.add(result);
		}
		for(Future<Integer> future : resultList)
        {
              try
              {
                  System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
              }
              catch (InterruptedException | ExecutionException e)
              {
                  e.printStackTrace();
              }
          }
          //shut down the executor service now
          executor.shutdown();
	}
}
