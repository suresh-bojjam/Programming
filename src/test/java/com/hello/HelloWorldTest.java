package com.hello;

import org.junit.Test;

import com.hello.HelloWorld;

public class HelloWorldTest {

	private static HelloWorld obj=null;
	
	static {
		obj=new HelloWorld();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(obj.hello());
	}
	
	@Test
	public void testJUnit() {
		System.out.println(obj.hello());
	}
	
}