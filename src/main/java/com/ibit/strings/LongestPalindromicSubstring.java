package com.ibit.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LongestPalindromicSubstring {

	private static boolean debug =false;
	private static boolean printTime=true;
	
	public static void main(String[] args) {
		//String str1="aaaabaaa";
		//String str1="azcbczzaabaab";
		String str1="baabaazzcbcza";
		long startTime=System.currentTimeMillis();
		System.out.println(longestPalindromeMethod1(str1));
		if(printTime)
			System.out.println("elapsedTime: "+(System.currentTimeMillis()-startTime));
	}

	public static String longestPalindromeMethod1(String a) {
		int maxSize=0;
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<a.length();i++) {
			for(int j=i+1;j<=a.length();j++) {
				if(debug)
					System.out.println("string: "+a+", subString: "+a.substring(i, j));
				if(isPalindrome(a.substring(i, j))&&a.substring(i, j).length()>maxSize) {
					maxSize=a.substring(i, j).length();
					list.add(a.substring(i, j));
				}
			}
		}
		Collections.sort(list,new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				if(arg1.length()>arg0.length())
					return 1;
				else if(arg1.length()<arg0.length())
					return -1;
				else 
					return 0;
			}
		});

		if(debug)
			printElemets(list);
		return list.get(0);
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

	public static void printElemets(ArrayList<String> list) {
		list.forEach((str)->{
			System.out.println(str);
		});
	}
}
