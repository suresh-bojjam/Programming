package com.ibit.strings;

public class ImplementStrStr {

	private static boolean debug =true;
	private static boolean printTime=true;

	public static void main(String[] args) {
		String str1="aaaabaaa";
		String str2="ba";

		long startTime=System.currentTimeMillis();
		System.out.println(strStrMethod1(str1,str2));
		if(printTime)
			System.out.println("elapsedTime: "+(System.currentTimeMillis()-startTime));
	}

	public static int strStrMethod1(final String haystack, final String needle) {

		for(int i=0;i<haystack.length();i++) {
			for(int j=i+1;j<=haystack.length();j++) {
				if(debug)
					System.out.println("string: "+haystack+", subString: "+haystack.substring(i, j));
				if(needle.equalsIgnoreCase(haystack.substring(i, j))){
					return i;
				}
			}
		}
		return -1;
	}	

	public static int strStrMethod2(final String haystack, final String needle) {
		return 0;
	}
}