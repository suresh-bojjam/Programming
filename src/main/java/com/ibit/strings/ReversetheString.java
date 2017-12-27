package com.ibit.strings;

import java.util.Arrays;

public class ReversetheString {

	public static void main(String[] args) {
		System.out.println(reverseTheStringMethod2("the   sky is blue "));
		/*String str="    ";
		System.out.println("str: "+str.trim().length());*/
	}

	public static String reverseTheStringMethod1(String str) {
		StringBuilder result=new StringBuilder();
		StringBuilder val=new StringBuilder();
		str=str.trim();
		boolean flag=false;
		for(int i=str.length()-1;i>=0;i--) {
			if(str.charAt(i)==' ') {
				if(flag) {
					continue;
				}
				flag=true;
				//save the reverse string to result
				result.append(val.reverse()+" ");
				val=new StringBuilder();
				continue;
			}else{
				flag=false;
				val.append(str.charAt(i));
			}
		}
		result.append(val.reverse());
		return result.toString();
	}

	public static String reverseTheStringMethod2(String str) {
		String[] list=str.split(" ");
		StringBuilder builder=new StringBuilder();
		for(int i=list.length-1;i>=0;i--) {
			if(list[i].trim().length()==0)
				continue;
			else {
				builder.append(list[i].trim());
				builder.append(" ");
			}
		}
		return builder.toString().trim();
	}

	public static String reverseTheStringMethod3(String str) {
		String[] list=str.split(" ");
		return Arrays.toString(list);
	}
}
