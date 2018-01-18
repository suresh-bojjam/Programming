package com.ibit.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidNumber {

	public static void main(String[] args) {

		System.out.println("1: 0:"+isNumberMethod1("0"));
		System.out.println("2: 0.1:"+isNumberMethod1(" 0.1"));
		System.out.println("3: abc:"+isNumberMethod1("abc"));
		System.out.println("4: 1 a:"+isNumberMethod1("1 a"));
		System.out.println("5: 22e10:"+isNumberMethod1("2e10"));
		System.out.println("6: 0.1e10:"+isNumberMethod1("0.1e10"));
		System.out.println("7: -01.1e-10:"+isNumberMethod1("-01.1e-10"));
		System.out.println("8: 3.:"+isNumberMethod1("3."));
		System.out.println("9:  3e0.1:"+isNumberMethod1(" 3e0.1"));
		System.out.println("10: 1f :"+isNumberMethod1("1f "));
		System.out.println("11: 1000LL :"+isNumberMethod1("1000LL"));
		System.out.println("12: 008 :"+isNumberMethod1("008"));
	}

	//Brute force
	public static int isNumberMethod1(final String A) {
		String str=A.trim();
		boolean flag1=true;
		if(str.charAt(str.length()-1)=='.') {
			return -1;
		}else {
			for(int i=0;i<str.length()&&flag1;i++) {

				if((Character.getNumericValue(str.charAt(i))>=0&&Character.getNumericValue(str.charAt(i))<=9)) {
					continue;
				}else if(str.charAt(i)=='-'){
					continue;
				} if(str.charAt(i)=='.') {
					flag1=false;
					boolean flag2=true;
					for(int j=i+1;j<str.length()&&flag2;j++) {
						if((Character.getNumericValue(str.charAt(j))>=0&&Character.getNumericValue(str.charAt(j))<=9)) {
							continue;
						}else if(str.charAt(j)=='.') {
							return -1; //dot should not repeat.
						}else if(str.charAt(j)=='e') {
							flag2=false;
							boolean flag3=true;
							for(int k=j;k<str.length()&&flag3;k++) {
								if((Character.getNumericValue(str.charAt(j))>=0&&Character.getNumericValue(str.charAt(j))<=9)) {
									continue;
								}else if(str.charAt(j)=='.') {
									return -1; //dot should not come after e for this problem
								}else if(str.charAt(j)=='-') {
									continue;
								}
							}
						}
					}
				}else if(str.charAt(i)=='e') {
					for(int j=i+1;j<str.length();j++) {
						if((Character.getNumericValue(str.charAt(j))>=0&&Character.getNumericValue(str.charAt(j))<=9)) {
							continue;
						}else if(str.charAt(j)=='.') {
							return -1; //dot should not repeat.
						}else if(str.charAt(j)=='e') {
							return -1; //e should not repeat
						}else if(str.charAt(j)=='-') {
							continue;
						}
					}
				}else{
					//when character is not matching with the 0-9,e,-,.
					return -1;
				}
			}
		}

		return 0;
	}


	//regex method not working
	public static int isNumberMethod2(final String A) {
		Pattern p=Pattern.compile("[0-9\\.0-9e0-9]");
		Matcher m=p.matcher(A.trim());
		if(m.find()) {
			return 1;
		}else {
			return 0;
		}
	}
}