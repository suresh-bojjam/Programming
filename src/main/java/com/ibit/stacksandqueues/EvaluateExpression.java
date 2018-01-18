package com.ibit.stacksandqueues;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {

	private static final boolean debug=false;
	
	public static void main(String[] args) {

		ArrayList<String> list=new ArrayList<String>();
		list.add("2");
		list.add("1");
		list.add("+");
		list.add("3");
		list.add("*");
		
		ArrayList<String> list2=new ArrayList<String>();
		list2.add("4");
		list2.add("13");
		list2.add("5");
		list2.add("/");
		list2.add("+");
		//test(list);
		System.out.println(evalRPNMethod1(list));
		System.out.println(evalRPNMethod1(list2));
		
		System.out.println(evalRPNMethod2(list));
		System.out.println(evalRPNMethod2(list2));
	}

	
	public static int evalRPNMethod2(ArrayList<String> A) { //TODO use only one stack for operations
		Stack<String> stack2=new Stack<String>();
		String str;
		for(int i=0;i<A.size();i++) {
			str=A.get(i);
			if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
				stack2.push(String.valueOf(eval(Integer.valueOf(stack2.pop()),Integer.valueOf(stack2.pop()),str)));
			}else {
				stack2.push(str);
			}
		}
		return Integer.valueOf(stack2.peek());
	}
	
	public static int evalRPNMethod1(ArrayList<String> A) {
		Stack<String> stack1=new Stack<String>();
		Stack<Integer> stack2=new Stack<Integer>();
		
		String str;
		for(int i=0;i<A.size();i++) {
			str=A.get(i);
			if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
				stack1.push(str);
			}else {
				stack2.push(Integer.valueOf(str));
			}
			if(stack1.size()>0 && stack2.size()>=2) {
				stack2.push(eval(stack2.pop(),stack2.pop(),stack1.pop()));
			}
		}
		return stack2.pop();
	}
	
	public static int eval(int a, int b,String op) {
		int result=0;
		switch(op) {
			case "+":
				result=a+b;
				break;
			case "-":
				result=a-b;
				break;
			case "*":
				result=a*b;
				break;
			case "/":
				result=(int) Math.ceil(b/a);
				break;
		}
		return result;
	}
	
	public static void test(ArrayList<String> list ) {
		Stack<Integer> stack2=new Stack<Integer>();
		list.forEach((val)->{
			if(!(val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/"))) {
				stack2.push(Integer.valueOf(val));	
			}
		});
		
		stack2.forEach((val)->{
			System.out.println(val);
		});
	}
}
