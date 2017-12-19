package com.ibit.strings;

public class MinimumCharactersRequiredToMakeAStringPalindromic {
	
	private static boolean debug=true;
	
/*	public static void main(String args[]) {
		//System.out.println(isPalindrome("bbaaabb"));
		System.out.println(isPalindrome("aaabaaaa"));
	}*/
	
	public static void main(String[] args) {
		
		//String str1="ABC";
		String str1="AACECAAAA";
		//String str2="abccb";
		String str2="abcabc";
		long startTime=System.currentTimeMillis();
		System.out.println(solveMethod1(str1));
		System.out.println("elapsed Time: "+(System.currentTimeMillis()-startTime));
		startTime=System.currentTimeMillis();
		System.out.println(solveMethod1(str2));
		System.out.println("elapsed Time: "+(System.currentTimeMillis()-startTime));
		
		startTime=System.currentTimeMillis();
		System.out.println(solveMethod2(str1));
		System.out.println("elapsed Time: "+(System.currentTimeMillis()-startTime));
		startTime=System.currentTimeMillis();
		System.out.println(solveMethod2(str2));
		System.out.println("elapsed Time: "+(System.currentTimeMillis()-startTime));
		
	}
	
	public static int solveMethod1(String str) {
		
		StringBuilder str2=new StringBuilder(str);
		String str1=new StringBuilder(str).reverse().toString();
		
		for(int i=1;i<=str1.length();i++) {
			str2.insert(i-1, str1.charAt(i-1));
			if(debug)
				System.out.println("str1: "+str1+", "+"str2: "+str2);
			if(isPalindrome(str2.toString()))
				return i;
			/*if(str2.toString().equalsIgnoreCase(str2.reverse().toString())) {
				System.out.println("palindrome: "+str2);
				return i;
			}else {
				str2.reverse();
			}*/
		}
		return 0;
	}
	
	public static int solveMethod2(String str) {
		StringBuilder str2=new StringBuilder(str);
		String str1=new StringBuilder(str).reverse().toString();
		boolean flag=true;
		int i=0;
		for(;flag&&i<str1.length();i++) {
			if(debug)
				System.out.println("str2.charAt(i): "+str2.charAt(i)+", str1.charAt(str1.length()-i-1): "+str1.charAt(str1.length()-i-1));
			if(str2.charAt(0)!=str1.charAt(str1.length()-i-1)) {
				break;
			}
		}
		return i;
	}
	
	public static boolean isPalindrome(String str) {
		boolean isPalindrome=true;
		for(int i=1;i<=str.length()/2;i++) {
			if(str.charAt(i-1)!=str.charAt(str.length()-i)) {
				isPalindrome=false;
				break;
			}
		}
		return isPalindrome;
	}
}