package com.ibit.stacksandqueues;

import java.util.Stack;

public class RedundantBraces {

	private static final boolean debug=true;

	public static void main(String[] args) {
		System.out.println("isRedundant: "+findRidundantMethod1("((a+b)+(c+d))"));
		System.out.println("isRedundant: "+findRidundantMethod1("((a+b))"));
	}

	public static boolean findRidundantMethod1(String expr) {
		Stack<Character> stack=new Stack<Character>();
		for(char ch:expr.toCharArray()) {
			if(ch==')'&& !stack.isEmpty()) {
					ch=stack.pop();
					if(!stack.isEmpty() && stack.peek()=='(') {
						return true;
					}else {
						while(stack.peek()!='(' && !stack.isEmpty()) {
							ch=stack.pop();
					}
				}
			}else {
				stack.push(ch);
			}
		}//for loop
		return false;
	}

	public static boolean findRidundantMethod2() {
		return true;
	}

}
