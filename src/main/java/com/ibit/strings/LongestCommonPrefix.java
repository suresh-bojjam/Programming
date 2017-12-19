package com.ibit.strings;

import java.util.ArrayList;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		//test case1
		ArrayList<String> strList1=new ArrayList<String>();
		strList1.add("abcdefgh");
		strList1.add("aefghijk");
		strList1.add("abcefgh");

		//test case2
		ArrayList<String> strList2=new ArrayList<String>();
		strList2.add("abcdefgh");
		strList2.add("abcefgh");
		strList2.add("abc");

		long startTime=System.currentTimeMillis();
		System.out.println("result: "+findLongestPrefixMethod1(strList1));
		System.out.println("elapsed Time: "+(System.currentTimeMillis()-startTime));
		startTime=System.currentTimeMillis();
		System.out.println("result: "+findLongestPrefixMethod1(strList2));
		System.out.println("elapsed Time: "+(System.currentTimeMillis()-startTime));
	}

	public static String findLongestPrefixMethod1(ArrayList<String> list) {
		StringBuilder builder=null;
		if(list.size()>1) {
			builder=new StringBuilder();
			boolean flag=true;
			//skipping the first string
			for(int i=1,j=0;i<list.get(0).length()&&flag;i++) {
				if(j>=i) { //to avoid the all unnecessary iterations & to avoid the index out of bound (first string size may be grater than others)
					flag=false;
					break;
				}else {
					for(j=0;j<list.size();j++) {
						if(list.get(0).charAt(j)==list.get(i).charAt(j)) {
							builder.append(list.get(0).charAt(j));
						}else {
							flag=false;
							break;
						}	
					}	
				}
			}
		}
		return builder.toString();
	}
}