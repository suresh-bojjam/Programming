package com.java8;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {
	public static void main(String args[]) {
		String[] arr= {"a","b","c","d"};
		String result=String.join(":", arr);

		Map<Character,Integer> map=new HashMap<>();

/*		result
		.chars()
		.distinct()
		.mapToObj(mapper)*/
	}
}