package com.ibit.strings;

public class LengthofLastWord {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWordMethod2("Hello"));
	}

	public static int lengthOfLastWordMethod1(String str) {
		int count=0;
		str=str.trim();
		for(char ch:str.toCharArray()) {
			if(ch==' '){
				count=0;
			}else {
				count++;
			}
		}
		return count;
	}

	public static int lengthOfLastWordMethod2(String str) {
		str=str.trim();
		String[] list=str.split(" ");
		int count=0;
		for(char ch:list[list.length-1].toCharArray()) {
			count++;
		}
		return count;
	}
}