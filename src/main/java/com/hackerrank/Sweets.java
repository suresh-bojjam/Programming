package com.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Sweets {

	static String whichSweetShouldIBring(String[] votes) {
		Map<String,Integer> sweets=new HashMap<String,Integer>();
		
		for(String str: votes) {
			if(sweets.containsKey(str)) {
				sweets.put(str, sweets.get(str)+1);
			}else {
				sweets.put(str, 1);
			}
		}
		Set<String> set=sweets.keySet();
		ArrayList<String> list=new ArrayList<String>();
		list.addAll(set);
		
		int count=0;
		String sweet=null;
		
		Collections.sort(list,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		
	/*	Set<String> sorted=new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});*/
		
		
		for(String str:list) {
			if(count<sweets.get(str)) {
				count=sweets.get(str);
				sweet=str;
			}
		}
		return sweet;
	}


	public static void main(String[] args) throws IOException {
		String str[]= {"aaa","aaa","bb","a","rrr","zzz","zzz"};
		System.out.println(whichSweetShouldIBring(str));
	}
}
