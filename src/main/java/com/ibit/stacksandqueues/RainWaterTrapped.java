package com.ibit.stacksandqueues;

import java.util.List;
import java.util.Stack;

public class RainWaterTrapped {

	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(1);
		stack.push(0);
		stack.push(2);
		
		System.out.println(findNoOfUnits(stack));

	}

	public static int trapMethod1(final List<Integer> A) {
		Stack<Integer> stack=new Stack<Integer>();
		int val=A.get(0);
		int totalUnits=0;
		
		for(int i=1;i<A.size();i++) {
			
		}
		
		for(int i=1,ptr=1;i<A.size();i++) {
			if(val<=A.get(i)) {
				continue;
			}else {
				ptr=i;
				//push the elements to the stack
				for(int j=ptr;j<=i;j++) stack.push(A.get(j));
				//compute units
				totalUnits=totalUnits+findNoOfUnits(stack);
				stack.clear();
			}
		}
		return totalUnits;
	}
	
	public static int findNoOfUnits(Stack<Integer> stack) {/*
		int distance=0, max_height=0, total_units=0;
		
		int 
		
		stack.forEach((val)->{
			val=val*val;
			if(stack.size()==1) {
				
			}
		});*/
		return 0;
	}

	public static int trapMethod2(final List<Integer> A) {
		return 0;
	}
}