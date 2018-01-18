package com.ibit.strings;

import java.util.ArrayList;

public class ValidIpAddresses {

	private static final boolean debug=false;
	
	public static void main(String[] args) {
		//ArrayList<String> list=restoreIpAddressesMethod1("25525511135");
		ArrayList<String> list1=restoreIpAddressesMethod1("255111256");
		list1.forEach((str)->{
			System.out.println("valid ip: "+str);
		});
		
		ArrayList<String> list2=restoreIpAddressesMethod2("255111256");
		list2.forEach((str)->{
			System.out.println("valid ip: "+str);
		});
	}

	public static ArrayList<String> restoreIpAddressesMethod1(String A) {
		int noOfPossibilites=0;
		ArrayList<String> list=new ArrayList<String>();
		StringBuilder builder1=null;
		StringBuilder builder2=null;
		StringBuilder builder3=null;
		
		int count=0;
		for(int i=0;i<A.length()-3;i++) {
			builder1=new StringBuilder(A);
			builder1.insert(i+1, ".");
			for(int j=i+1;j<A.length()-2;j++) {
				builder2=new StringBuilder(builder1.toString());
				builder2.insert(j+2, ".");
				for(int k=j+1;k<A.length()-1;k++) {
					++count;
					builder3=new StringBuilder(builder2.toString());
					builder3.insert(k+3, ".");
					if(debug) System.out.println(builder3.toString());
					noOfPossibilites++;
					if(isValidIp(builder3.toString())) {
						list.add(builder3.toString());
					}
				}
			}
		}
		
		if(debug) {
			System.out.println("count: "+count);
			System.out.println("noOfPossibilites: "+noOfPossibilites);
		} 
		return list;
	}
	
	
	public static boolean isValidIp(String ip) {
		String[] list=ip.split("\\.");
		if(!(Integer.parseInt(list[0])>=0 && Integer.parseInt(list[0])<=255)) {
			return false;
		}
		if(!(Integer.parseInt(list[1])>=0 && Integer.parseInt(list[1])<=255)) {
			return false;
		}
		if(!(Integer.parseInt(list[2])>=0 && Integer.parseInt(list[2])<=255)) {
			return false;
		}
		if(!(Integer.parseInt(list[3])>=0 && Integer.parseInt(list[3])<=255)) {
			return false;
		}		
		return true;
	}
	
	
	private static ArrayList<String> restoreIpAddressesMethod2(String input) {
		int xC = 1;
		int yC = 3;
		int zC = 5;
		ArrayList<String> list=new ArrayList<String>();
		
		StringBuilder builder = null;
		builder = getBuilder(builder, input, xC, yC, zC);
		int count=0;
		while (xC != builder.length() - 6) {
			++count;
			if (isValidIp(builder.toString())) {
				list.add(builder.toString());
				if(debug) System.out.println(builder);
			}				
			if (yC == builder.length() - 4) {
				xC++;
				yC = xC + 1;
			}

			if ((zC == builder.length() - 2) && (yC != builder.length() - 4)) {
				yC++;
				zC = yC + 1;
			}

			if (zC != builder.length() - 2) {
				zC++;
			}
			builder = getBuilder(builder, input, xC, yC, zC);
		}
		if(debug) System.out.println("count: "+count);
		return list;
	}
	
	private static StringBuilder getBuilder(StringBuilder builder, String input, int xC, int yC, int zC) {
		builder = new StringBuilder(input);
		builder.insert(xC, ".");
		builder.insert(yC, ".");
		builder.insert(zC, ".");

		return builder;
	}
}
