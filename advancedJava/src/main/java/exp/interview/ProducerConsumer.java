package com.chandler.exp.interview;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

	BlockingQueue<Integer> bq = new LinkedBlockingQueue<>();
	int item = 1;
	int size = 100;
	
	public void produce(){		
		try {
			for(; item < size; item++){	
				System.out.println("I produce item: "+ item);
				bq.put(item);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void consume(){
		try {
			for(int i=1; i<size; i++)
				System.out.println("I consume item: "+ bq.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProducerConsumer pc = new ProducerConsumer();
		
//		Runnable consumer = pc::consume;
		Runnable consumer = ()->pc.consume();
		new Thread(consumer).start();
		Runnable producer = pc::produce;
		new Thread(producer).start();
		
		
		
		

	}

}
