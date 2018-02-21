package com.test;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomBlockingQueueTestManager {

	
	public static void main(String[] args) {
		CustomBlockingQueue<Integer> queue=new CustomBlockingQueue<Integer>(3);
		CustomBlockingQueueTestManager testManager=new CustomBlockingQueueTestManager();
		
		
		ExecutorService readThreads=Executors.newFixedThreadPool(10);
		ExecutorService writeThreads=Executors.newFixedThreadPool(10);
		
		
		Scanner in=new Scanner(System.in);

		int i=1;

		while(10>=i) {
			System.out.println("r - read \nw - write");
			String str=in.next();
			switch(str) {
			case "w": 
				System.out.println("write the value to insert");
				testManager.write(queue,in.next());
				break;

			case "r": 
				System.out.println("reading the value");
				
				new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							System.out.println("read value: "+queue.take());
						} catch (NumberFormatException | InterruptedException e) {
							e.printStackTrace();
						}
					}
				}).start();
				break;
			}
			
			i++;
		}
	
	in.close();
	}
	
	
	private <E> void write(CustomBlockingQueue<Integer> queue,String str) {
		
		Integer val= Integer.valueOf(str);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					queue.put(val);
				} catch (NumberFormatException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
