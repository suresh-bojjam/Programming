package com.ibit.strings;

public class PalindromeString {

	private static boolean debug=true;
	
	public static void main(String[] args) {
		//String str="A man, a plan, a canal: Panama";
		String str="race a car";
		long startTime=System.currentTimeMillis();
		System.out.println(checkPalindromeMethod1(str));
		System.out.println("elapsed Time: "+(System.currentTimeMillis()-startTime));
		startTime=System.currentTimeMillis();
		System.out.println(checkPalindromeMethod2(str));
		System.out.println("elapsed Time: "+(System.currentTimeMillis()-startTime));
	}

	public static int checkPalindromeMethod1(String str) {
		StringBuilder b=new StringBuilder();
		char[] chars=str.toCharArray();
		int val;
		for(int i=0;i<chars.length;i++) {
			boolean isAlphaNumeric=false;
			val=(int)chars[i];
			if(val>=97&&val<=122) {
				isAlphaNumeric=true;
			}else if(val>=65&&val<=90) {
				isAlphaNumeric=true;
			}if(val>=48&&val<=57) {
				isAlphaNumeric=true;
			}

			if(isAlphaNumeric) {
				b.append(chars[i]);
			}
		}
		
		if(b.toString().equalsIgnoreCase(b.reverse().toString()))
			return 1;
		else
			return 0;
	}

	public static int checkPalindromeMethod2(String str) {
		StringBuilder builder=new StringBuilder(str.replaceAll("[^a-zA-Z0-9]", ""));
		if(debug) {
			System.out.println(builder.toString());
			System.out.println(builder.reverse().toString());
		}
		if(builder.toString().equalsIgnoreCase(builder.reverse().toString()))
			return 1;
		else
			return 0;
	}

	public static void printLimits() {
		System.out.println((int)'a');
		System.out.println((int)'z');
		System.out.println((int)'A');
		System.out.println((int)'Z');
		System.out.println((int)'0');
		System.out.println((int)'9');
	}
}
