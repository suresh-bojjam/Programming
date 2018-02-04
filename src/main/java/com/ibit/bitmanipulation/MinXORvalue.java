package com.ibit.bitmanipulation;

public class MinXORvalue {
	public static void main(String args[]) {
		
		int arr[]= {0,2,5,7};
		findMinXOR(arr);
	}
	
	public static void findMinXOR(int[] arr) {
		int min=Integer.MAX_VALUE,a=0,b=0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				System.out.println((arr[i]^arr[j]));
				if((arr[i]^arr[j])<min) {
					min=arr[i]^arr[j];
					
					a=i;
					b=j;
				}
			}
		}
		System.out.println(min+" ("+arr[a]+" XOR "+arr[b]+")");
	}
}
