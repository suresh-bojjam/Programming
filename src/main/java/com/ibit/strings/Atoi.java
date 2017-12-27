package com.ibit.strings;

/**
 * 
 * @author suresh bojjam
 *
 */
public class Atoi {

	private static final boolean debug=false;
	
	public static void main(String[] args) {
		String str1="9 2704";
		str1=str1.replaceAll("[^0-9]", "");
		System.out.println(Integer.parseInt(str1));
		System.out.println(atoiMethod1("9 2704"));
	}
	
	public static int atoiMethod1(String val) {
		val=val.trim();
		int sum=0;
		int position=1;
		boolean flag=true;
		
		for(char ch:val.toCharArray()) {
			if(debug) System.out.println("ch: "+ch);
			if(Character.getNumericValue(ch)>=0&&Character.getNumericValue(ch)<=9) {
				if(debug) System.out.println("integer ch: "+ch);
				sum=sum+Character.getNumericValue(ch)*position;
				if(sum>Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				if(sum<Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
				position=position*10;
				flag=false; //to know even 1 number is not available in given string
				continue;
			}else {
				if(debug) System.out.println("non-integer ch: "+ch);
				break;
			}
		}
		if(!flag)
			return sum;
		else
			return 0;
	}
}
