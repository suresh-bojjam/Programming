package com.ibit.strings;

public class CompareVersionNumbers {

	private static final boolean debug=false;

	public static void main(String[] args) {
		System.out.println(compareVersionNumbersMethod1("1.13.4","1.13"));
		System.out.println(compareVersionNumbersMethod1("1.13","1.13.4"));
		System.out.println(compareVersionNumbersMethod1("0.1","1.1"));
	}

	//assumption version max length would be three digits xx.yy.zz 
	public static int compareVersionNumbersMethod1(String ver1,String ver2){
		String[] version1=ver1.split("\\.");
		String[] version2=ver2.split("\\.");
		boolean flag=false;

		int length=0;
		if(version1.length==version2.length) {
			length=version2.length;
			flag=true;
		}
		else
			length=version1.length<version2.length?version1.length:version2.length;

		if(debug)
			System.out.println("length: "+length);
		int i=0;
		for(i=0;i<length;i++) {
			if(Integer.valueOf(version1[i])>Integer.valueOf(version2[i])) {
				return 1;
			}else if(Integer.valueOf(version1[i])<Integer.valueOf(version2[i])) {
				return -1;
			}if(Integer.valueOf(version1[i])==Integer.valueOf(version2[i])&&i!=length) {
				continue;
			}
		}

		int result=0;
		if(!flag) {
			if(version1.length>version2.length) {
				if(Integer.valueOf(version1[i])>0)
					result=1;
			}else {
				if(Integer.valueOf(version2[i])>0)
					result=-1;				
			}
			return result;
		}else {
			return 0;
		}
	}
}