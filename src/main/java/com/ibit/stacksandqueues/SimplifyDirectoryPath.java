package com.ibit.stacksandqueues;

import java.util.Stack;

public class SimplifyDirectoryPath {

	public static void main(String[] args) {
/*		System.out.println("finalPath: "+simplifyPathMethod1("/home/"));
		System.out.println("finalPath: "+simplifyPathMethod1("/a/./b/../../c/"));
		System.out.println("finalPath: "+simplifyPathMethod1("/fic/././iak/../../hgy/blg/../vzt/../tod/.././.././bsc/./krk/../lnb/zhj/./"));*/
		
		System.out.println("finalPath: "+simplifyPathMethod2("/home/"));
		System.out.println("finalPath: "+simplifyPathMethod2("/a/./b/../../c/"));
		System.out.println("finalPath: "+simplifyPathMethod2("/fic/././iak/../../hgy/blg/../vzt/../tod/.././.././bsc/./krk/../lnb/zhj/./"));
		
	}


	public static String simplifyPathMethod1(String A) { 	//TODO have to solve the bug
		Stack<String> stack=new Stack<String>();
		A.substring(A.length()-1,A.length()-1);

		//removing the trailing slash
		if("/".equals(A.substring(A.length()-1,A.length()))){
			A=A.substring(0, A.length()-1);
		}

		StringBuilder finalPath=new StringBuilder();
		String[] list=A.split("\\/");

		for(int i=0;i<list.length;i++) {
			if(list[i]!=null&&!list[i].equals("")) stack.push(list[i]);
		}
		//print(stack);

		String ptr=null;
		boolean flag=false;
		int count=0;
		while(!stack.isEmpty()) {
			ptr=stack.peek();
			count=0;
			if(ptr.equals(".")) {
				stack.pop();
			}else if(ptr.equals("..")) {
				stack.pop();
				count++;
				flag=true;
				while(!stack.isEmpty() && (ptr=stack.peek()).equals("..")) {
					stack.pop();
					count++;	
				}				
			}else {
				finalPath.insert(0,stack.pop()+"/");
			}
			if(flag) {
				while(count>0&& !stack.isEmpty()) stack.pop();
				flag=false;
			}
		}
		finalPath.insert(0, "/");
		return finalPath.toString().substring(0,finalPath.toString().length()-1);
	}


	public static String simplifyPathMethod2(String A) { //TODO have to test the corner cases
		Stack<String> stack=new Stack<String>();
		A.substring(A.length()-1,A.length()-1);

		//removing the trailing slash
		if("/".equals(A.substring(A.length()-1,A.length()))){
			A=A.substring(0, A.length()-1);
		}

		StringBuilder finalPath=new StringBuilder();
		String[] list=A.split("\\/");
		
		for(int i=0;i<list.length;i++) {
			if(list[i]==null || list[i].equals("")) {
				continue;
			}else if(list[i].equals(".")) {
				continue;
			}else if(list[i].equals("..")) {
				if(!stack.isEmpty())
					stack.pop();
			}else {
				stack.push(list[i]);
			}
		}
		//print(stack);
		finalPath.append("/");
		stack.forEach((str)->{
			finalPath.append(str+"/");
		});
		return finalPath.toString().substring(0,finalPath.toString().length()-1);
	}

	public static void print(String[] list) {
		for(int i=list.length-1;i>=0;i--) {
			if(list[i]!=null) System.out.println(list[i]);
		}
	}

	public static <E> void print(Stack<E> stack) {
		stack.forEach((val)->{
			System.out.println(val);
		});
	}
}