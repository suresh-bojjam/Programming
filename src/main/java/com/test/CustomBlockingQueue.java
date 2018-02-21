package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

interface BlockingQueue<E>{
	 /**
     * Inserts the specified element into this queue
     * only if space is available else
     * waits for space to become available.
     */
	void put(E item)  throws InterruptedException ;


    /**
     * Retrieves and removes the head of this queue
     * only if elements are available else
     * waits for element to become available.
     */
    E take()  throws InterruptedException;
}

public class CustomBlockingQueue<E> implements BlockingQueue<E>{
	
	private AtomicInteger count;
	
	private List<E> list;
	
	private int maxSize;
	
	public static void main(String[] args) {
		
	}

	CustomBlockingQueue(int maxSize){
		this.maxSize=maxSize;
		this.list=new ArrayList<E>(maxSize);
		count=new AtomicInteger(0);
	}
	
	@Override
	public synchronized void put(E item) throws InterruptedException {
		if(list.size()==maxSize) {
			count.incrementAndGet();
			System.out.println("witing new thread for PUT, noOfThreadsBlocked: "+count);
			this.wait();	
		}
		list.add(item);
		this.notifyAll();
	}

	@Override
	public synchronized E take() throws InterruptedException {
		if(list.size()==0) {
			System.out.println("waiting new thread for TAKE, noOfThreadsBlocked: "+count);
			this.wait();
		}
		this.notifyAll();
		return list.remove(0);
	}
}
