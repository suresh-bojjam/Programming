package com.ibit.strings;

import java.util.ArrayList;

public class PowerOf2 {

	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(8);
		list.add(16);
		list.add(32);
		list.add(64);
		list.add(128);
		list.add(512);
		list.add(1024);
		
		list.add(3);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(11);
		list.add(12);
		list.add(40);
		
		list.forEach((val)->{
			System.out.println("val: "+val+", result: "+power(String.valueOf(val)));
		});
	}
	
	public static int power(String A) {
    double a=Math.log(Integer.valueOf(A))/Math.log(Integer.valueOf(2));
    String[] str=String.valueOf(a).split("\\.");
    if(Double.valueOf(str[1])>0)
    	return -1;
    else
    	return 1;
	}
}
