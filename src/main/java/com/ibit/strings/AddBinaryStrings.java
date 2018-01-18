package com.ibit.strings;

public class AddBinaryStrings {

	public static void main(String[] args) {
		System.out.println(addBinaryMethod1("100","11"));
	}
	
	public static String addBinaryMethod1(String A, String B) {
		return String.valueOf(Integer.toBinaryString(Integer.parseInt(A, 2)+Integer.parseInt(B, 2)));
	}
}