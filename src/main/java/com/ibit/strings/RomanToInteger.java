package com.ibit.strings;

/**
 * 
 * @author suresh bojjam
 * examples: 
 * Input : "XIV" Return : 14
 * Input : "XX" Output : 20
 */
public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInteger("XIV"));
		System.out.println(romanToInteger("XX"));
		System.out.println(romanToInteger("XVI"));
		System.out.println(romanToInteger("CD"));
		System.out.println(romanToInteger("MMMCMXCIX"));
		System.out.println(romanToInteger("MMIII"));
		System.out.println(romanToInteger("MMMCMXCVI"));
		System.out.println(romanToInteger("MXIII"));
		System.out.println(romanToInteger("MXVI"));
		System.out.println(romanToInteger("CMLXXXVIII"));
	}

	
	public static int romanToInteger(String str) {
		int result=0;
		for(int i=0;i<str.length();i++) {
			switch(str.charAt(i)) {
			case 'I':
				result=result+1;
				if(i+1<str.length()&&str.charAt(i+1)=='V') {
					result=result+5;
					result=result-2;
					i++;
				}
				if(i+1<str.length()&&str.charAt(i+1)=='X') {
					result=result+10;
					result=result-2;
					i++;
				}
				break;
			case 'V':
				result=result+5;
				if(i+1<str.length()&&str.charAt(i+1)=='X') {
					result=result+10;
					result=result-10;
					i++;
				}				
				break;
			case 'X':
				result=result+10;
				if(i+1<str.length()&&str.charAt(i+1)=='L') {
					result=result+50;
					result=result-20;
					i++;
				}
				if(i+1<str.length()&&str.charAt(i+1)=='C') {
					result=result+100;
					result=result-20;
					i++;
				}
				break;
			case 'L':
				result=result+50;
				if(i+1<str.length()&&str.charAt(i+1)=='C') {
					return -1;
				}
				break;
			case 'C':
				result=result+100;
				if(i+1<str.length()&&str.charAt(i+1)=='D') {
					result=result+500;
					result=result-200;
					i++;
				}
				if(i+1<str.length()&&str.charAt(i+1)=='M') {
					result=result+1000;
					result=result-200;
					i++;
				}
				break;
			case 'D':
				result=result+500;
				if(i+1<str.length()&&str.charAt(i+1)=='M') {
					return -1;
				}
				break;
			case 'M':
				result=result+1000;
				break;
			}
		}
		return result;
	}
}
