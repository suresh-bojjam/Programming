package com.hello;

public class Test implements Runnable{
	
	public static void main(String args[]) {
		System.out.println("Main");
		Test t=new Test();
		Thread t1=new Thread(new Test());
		t1.start();
	}

	@Override
	public void run() {
		System.out.println("Run");
	}
}
