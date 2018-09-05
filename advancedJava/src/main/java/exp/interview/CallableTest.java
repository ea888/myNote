package com.chandler.exp.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class TaskWithResult implements Callable<String> {
	private int id;

	public TaskWithResult(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(2000);
		double a = Math.sqrt((4*50+6-6-8-7));
		return "result of TaskWithResult " + id;
	}
}

public class CallableTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<String>> results = new ArrayList<Future<String>>();
		
		//lambda callable
		String a = "abc";
		Callable<String> c = () -> {Thread.sleep(5000);return a.substring(1);};
		try {
			System.out.println(exec.submit(c).get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//this is NOT multithreading
		try {
			System.out.println(new TaskWithResult(10).call());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//traditional usage
		for (int i = 0; i < 10; i++) {
			results.add(exec.submit(new TaskWithResult(i)));
		}

		for (Future<String> fs : results) {
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		
		// close thread pool
		exec.shutdown();
		
		
		AtomicInteger ai = new AtomicInteger();
	}

}
